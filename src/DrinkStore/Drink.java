package DrinkStore;

public class Drink {
	private int price;
	private String name;

	Drink(int price, String name) {
		this.setPrice(price);
		this.setName(name);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
