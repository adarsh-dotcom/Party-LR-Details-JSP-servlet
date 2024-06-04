package comEwayAuth;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyClass {

	public static void main(String[] args) {
		   String responseText = "{\"status\":\"1\"}";
	        String status = "";
	        String authtoken = "1QRbVWOY6J5qArmtlOAXUtEip";
	        String sek = "id415OlTcwcwAlrhIMFRxFdD+QAh+oAzZWJkUtpyeTQ\\\\u003d";
	        

	        try {
	            ObjectMapper objectMapper = new ObjectMapper();
	            JsonNode responseJson = objectMapper.readTree(responseText);
	            
	            if (responseJson.has("status")) {
	                status = responseJson.get("status").asText();
	            } else {
	                System.out.println("Error: Status field not found in JSON response.");
	                return; 	            }

	            if (status.equals("1")) {
	                System.out.println("Authtoken: " + authtoken);
	                System.out.println("Encrypted SEK: " + sek);
	                
	                
	                System.out.println("Decrypted SEK: " + sek);
	            } else {
	                System.out.println("Error: Status is not '1'.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}

	}
