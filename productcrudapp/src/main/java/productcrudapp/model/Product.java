package productcrudapp.model;

import org.springframework.stereotype.Component;

@Component
public class Product {

	int id;
	String name;
	String description;
	long price;

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}


	public Product() {
		
	}

	public Product(int id, String name, String description, long price2) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price2;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}
