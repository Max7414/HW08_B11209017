package DrinkStore;

public class Item {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int price;
	private String name;
	private String ice;
	private String sugar;
	private int count;
	private int totalPrice;

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	Item(int price, String name, String ice, String sugar, int count) {
		this.price = price;
		this.name = name;
		this.ice = ice;
		this.sugar = sugar;
		this.count = count;
		this.totalPrice = price * count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIce() {
		return ice;
	}

	public void setIce(String ice) {
		this.ice = ice;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
