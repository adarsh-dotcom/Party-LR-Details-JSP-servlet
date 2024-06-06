package demoCOM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EWayBillAuth {
	static String folderPath = "C:\\MyWorkspace\\JsonNodeDemo";
	static byte[] appKey;
	static String action = "ACCESSTOKEN";
	static String userName = "<TaxProEnvPON>";
	static String password = "<abc34*>";
	static String gstin = "<34AACCC1596Q002>";
	static String encPayload = "";
	static String authtoken = "1QRbVWOY6J5qArmtlOAXUtEip";
	static String sek = "id415OlTcwcwAlrhIMFRxFdD+QAh+oAzZWJkUtpyeTQ\\u003d";

	public static void main(String[] args) {

		authtoken = "";
		folderPath = getPath();
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			String appKey = Base64.getEncoder().encodeToString(createAESKey());
			String payload = "{\"action\":\"ACCESSTOKEN\",\"username\":\"" + userName + "\",\"password\":\"" + password
					+ "\",\"app_key\":\"" + appKey + "\"}";
			System.out.println("Payload: Plain: " + payload);

			payload = Base64.getEncoder().encodeToString(payload.getBytes());
			payload = "{\"Data\":\"" + encryptAsymmentricKey(payload) + "\"}";
			System.out.println("Payload: Encrypted: " + payload);

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost("<https://gstsandbox.charteredinfo.com/ewaybillapi/dec>/v1.03/auth");
			postRequest.setHeader("client-id", "<Client-id>");
			postRequest.setHeader("client-secret", "Client-Secret");
			postRequest.setHeader("gstin", "<gstin>");
			postRequest.addHeader("KeepAlive", "true");
			postRequest.addHeader("AllowAutoRedirect", "false");
			StringEntity input = new StringEntity(payload);
			input.setContentType("application/json");
			postRequest.setEntity(input);
			HttpResponse response = httpClient.execute(postRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			String responseText = "";
			while ((output = br.readLine()) != null) {
				responseText = output;
			}
			System.out.println("Response:" + responseText);

			String status = objectMapper.readTree(responseText).get(responseText).asText();

			if (status.equals("0")) {
				String errorDesc = "";

				Object rootNode = objectMapper.readTree(responseText);
				errorDesc = objectMapper.readTree(responseText).get("error").asText();
				// errorDesc = new String(Base64.getDecoder().decode(errorDesc), "utf-8");
				System.out.println("Error: " + errorDesc);
			}

			if (status.equals("1")) {

				authtoken = objectMapper.readTree(responseText).get("authtoken").asText();
				sek = objectMapper.readTree(responseText).get("sek").asText();
				System.out.println("Authtoken: " + authtoken);
				System.out.println("Encrypted SEK: " + sek);
				sek = decrptBySymmetricKeySEK(sek);
				System.out.println("Decrypted SEK: " + sek);
			}
			httpClient.getConnectionManager().shutdown();
		} catch (Exception ex) {
			Logger.getLogger(EWayBillAuth.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static PublicKey getPublicKey()
			throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		FileInputStream in = new FileInputStream("<Path to file>/publickey.pem");
		byte[] keyBytes = new byte[in.available()];
		in.read(keyBytes);
		in.close();
		String pubKey = new String(keyBytes, "UTF-8");
		pubKey = pubKey.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");

	    byte[] decodedKeyBytes = Base64.getDecoder().decode(pubKey);
		
		X509EncodedKeySpec spec = new X509EncodedKeySpec(decodedKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(spec);
		return publicKey;
	}

	public static byte[] createAESKey() {
		try {
			KeyGenerator gen = KeyGenerator.getInstance("AES");
			gen.init(128);
			/* 128-bit AES */
			SecretKey secret = gen.generateKey();
			appKey = secret.getEncoded();
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(EWayBillAuth.class.getName()).log(Level.SEVERE, null, ex);
		}
		return appKey;
	}

	private static String encryptAsymmentricKey(String clearText) throws Exception {

		PublicKey publicKeys = getPublicKey();
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
		cipher.init(Cipher.ENCRYPT_MODE, publicKeys);
		byte[] encryptedText = cipher.doFinal(clearText.getBytes());
		String encryptedPassword = Base64.getEncoder().encodeToString(encryptedText);
		return encryptedPassword;
	}

	public static String getPath() {
		String folderPath = "C:\\Users\\LENOVO\\git\\repository2\\qEwayBillApi1";
		
		try {
			File tempFile = new File(
					EWayBillAuth.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
			folderPath = tempFile.getParentFile().getPath()
					+ "EwayBillApi1/src/main/java/comEwayAuth/EWayBillAuth.java";
			return folderPath;
		} catch (URISyntaxException ex) {
			Logger.getLogger(EWayBillAuth.class.getName()).log(Level.SEVERE, null, ex);
		}
		return folderPath;
	}

	public static String decrptBySymmetricKeySEK(String encryptedSek) {
		Key aesKey = new SecretKeySpec(appKey, "AES");

		try {
			Cipher cipher = Cipher.getInstance("e/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			byte[] encryptedSekBytes = Base64.getDecoder().decode(encryptedSek);
			byte[] decryptedSekBytes = cipher.doFinal(encryptedSekBytes);
			byte[] sekBytes = decryptedSekBytes;
			String decryptedSek = Base64.getEncoder().encodeToString(decryptedSekBytes);
			return decryptedSek;
		} catch (Exception e) {
			return "Exception; " + e;
		}
	}

}
