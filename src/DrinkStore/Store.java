package DrinkStore;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {

	void order() {

	}

	static Drink drink[] = { new Drink(35, "珍珠紅茶"), new Drink(45, "珍珠奶茶"), new Drink(60, "柳丁綠茶") };
	static Ice ice[] = { new Ice(1, "正常冰"), new Ice(2, "少冰"), new Ice(3, "去冰") };
	static Sugar sugar[] = { new Sugar(1, "正常糖"), new Sugar(2, "少糖"), new Sugar(3, "半糖"), new Sugar(4, "微糖"),
			new Sugar(5, "無糖") };
	static ArrayList<Item> cart = new ArrayList<>();

	public static void main(String[] args) {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("********歡迎來到大台科飲料店********");
			System.out.println("(1)點餐");
			System.out.println("(2)查看購物車");
			System.out.println("(0)結帳並退出系統");
			System.out.println("請選擇功能 [0,1,2]:");

			String sel = sc.nextLine();
			switch (sel) {
			case "1":
				Menu menu = new Menu(drink, sugar, ice, cart);
				menu.showMenu();
				break;

			case "2":
				Menu menu1 = new Menu(drink, sugar, ice, cart);
				menu1.showCart();
				break;

			case "0":
				Menu menu2 = new Menu(drink, sugar, ice, cart);
				menu2.showPerchase();
				break;
			}
		}

	}

}
