package hibernateDemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Store {
	
	@Id
	@GeneratedValue
	public int id;
	public String name;
	public String color;
	public String gender;
	public String size;
	public double price;
	public double rating;
	public String availability;
	
	public Store(int id, String name, String color, String gender, String size, double price, double rating,
			String availability) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
	}
	
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id2) {
		this.id = id2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", color=" + color + ", gender=" + gender + ", size=" + size
				+ ", price=" + price + ", rating=" + rating + ", availability=" + availability + "]";
	}
	
	
	

}
