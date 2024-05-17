package myMavenProjectcontroller;

public class Sample {
	private String name;
	private String address;
	private String city;

	public Sample() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city=city;
	}
	
	
	@Override
	public String toString() {
		return "Sample [name=" + name + ", address=" + address + ", city="+city+"]";
	}

}
