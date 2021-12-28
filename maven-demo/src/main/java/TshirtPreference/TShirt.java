package TshirtPreference;


public class TShirt  {
	
	private String color;
	private String size;
	private String gender;
	private String output_Preference;
	private String price;
	
	
	public String getPrice() {
		return this.price;
	}
	public String setPrice(String price) {
		return this.price = price;
	}
	public TShirt(String color, String size, String gender, String output_Preference) {
		super();
		this.color = color;
		this.size = size;
		this.gender = gender;
		this.output_Preference = output_Preference;
	}
	public String getcolor() {
		return this.color;
	}
	public void setcolor(String color) {
		this.color = color;
	}
	public String getsize() {
		return this.size;
	}
	public void setsize(String size) {
		this.size = size;
	}
	public String getgender() {
		return this.gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
	public String getoutput_Preference() {
		return this.output_Preference;
	}
	public void setoutput_Preference(String output_Preference) {
		this.output_Preference = output_Preference;
	}
	

	

	

}
