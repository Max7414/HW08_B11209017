package DrinkStore;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	Drink[] drink;
	Sugar[] sugar;
	Ice[] ice;
	ArrayList<Item> cart;
	Scanner sc = new Scanner(System.in);
	boolean tag = false;

	Menu(Drink drink[], Sugar sugar[], Ice ice[], ArrayList<Item> cart) {
		this.drink = drink;
		this.sugar = sugar;
		this.cart = cart;
		this.ice = ice;
	}

	void showMenu() {
		tag = false;
		System.out.println("********菜單********");
		System.out.printf("編號%5s品名%4s價格%n", "", "");
		int i = 0;
		for (Drink d : drink) {
			i++;
			System.out.printf("%d%10s%5s%n", i, d.getName(), d.getPrice());
		}
		System.out.println("********************");
		System.out.println("請選擇飲料編號:");
		int select;

		while (true) {
			if (sc.hasNextInt()) {
				select = sc.nextInt();
				if (select >= 1 && select <= drink.length) {
					break; // Valid input, exit loop
				} else {
					System.out.println("輸入錯誤，請再次輸入:");
				}
			} else {
				System.out.println("輸入錯誤，請輸入有效的整數:");
				sc.next(); // Discard non-integer input
			}
		}

		System.out.println("(1)正常冰 (2)少冰 (3)去冰");
		System.out.println("請選擇飲料冰量[1,2,3]:");
		int selectIce;

		while (true) {
			if (sc.hasNextInt()) {
				selectIce = sc.nextInt();
				if (selectIce >= 1 && selectIce <= 3) {
					break; // Valid input, exit loop
				} else {
					System.out.println("輸入錯誤，請再次輸入:");
				}
			} else {
				System.out.println("輸入錯誤，請輸入有效的整數:");
				sc.next(); // Discard non-integer input
			}
		}

		System.out.println("(1)正常糖 (2)少糖 (3)半糖 (4)微糖 (5)無糖");
		System.out.println("請選擇飲料甜度[1,2,3,4,5]:");
		
		
		int selectSugar;
		while (true) {
			if (sc.hasNextInt()) {
				selectSugar = sc.nextInt();
				if (selectSugar >= 0) {
					break; // Valid input, exit loop
				} else {
					System.out.println("輸入錯誤，請再次輸入:");
				}
			} else {
				System.out.println("輸入錯誤，請輸入有效的整數:");
				sc.next(); // Discard non-integer input
			}
		}
		
		
		
		

		System.out.println("請輸入數量:");
		int count;

		while (true) {
			if (sc.hasNextInt()) {
				count = sc.nextInt();
				if (count >= 0) {
					break; // Valid input, exit loop
				} else {
					System.out.println("輸入錯誤，請再次輸入:");
				}
			} else {
				System.out.println("輸入錯誤，請輸入有效的整數:");
				sc.next(); // Discard non-integer input
			}
		}

		String name = drink[select - 1].getName();
		String iceS = ice[selectIce - 1].getIce();
		String sugarS = sugar[selectSugar - 1].getSugar();

		verifyRepeat(name, iceS, sugarS, count);

		if (!tag) {
			System.out.printf("已將 %d 杯 %s 加入購物車%n", count, drink[select - 1].getName());

			Item item = new Item(drink[select - 1].getPrice(), drink[select - 1].getName(), ice[selectIce - 1].getIce(),
					sugar[selectSugar - 1].getSugar(), count);

			cart.add(item);
		}

	}

	void verifyRepeat(String name, String ice, String sugar, int count) {
		for (Item carts : cart) {
			if (carts.getName().equals(name) && carts.getIce().equals(ice) && carts.getSugar().equals(sugar)) {
				System.out.println("購物車含有重複品項，因此以合併至同一項目");
				carts.setCount(carts.getCount() + count);
				carts.setTotalPrice(carts.getCount() * carts.getPrice());
				tag = true;
				return;
			}
		}
	}

	void showCart() {
		System.out.println("編號		品名		冰量		甜度		數量		單價		總價");
		int id = 1;
		for (Item carts : cart) {
			System.out.printf("%-10d%10s%-10s%s%-15s%s%15s%15s$%15s$%n", id, carts.getName(), " ", carts.getIce(), " ",
					carts.getSugar(), carts.getCount(), carts.getPrice(), carts.getTotalPrice());
			id++;
		}
		System.out.println("請輸入飲料編號進行修改，輸入0則回到上一層:");
		int sel = sc.nextInt();
		if (sel == 0) {
			Store.main(null);
		}
		while (sel < 1 || sel > cart.size()) {
			System.out.println("無效輸入，輸入0退出");
			sel = sc.nextInt();
			if (sel == 0) {
				Store.main(null);
			}
		}

		System.out.println("(1)編輯 (2)刪除 (0)取消動作 請選擇 [1,2,3]:");
		//int sel2 = sc.nextInt();
		int sel2;
		
		
		while (true) {
			if (sc.hasNextInt()) {
				sel2 = sc.nextInt();
				if (sel2 >= 0) {
					break; // Valid input, exit loop
				} else {
					System.out.println("輸入錯誤，請再次輸入:");
				}
			} else {
				System.out.println("輸入錯誤，請輸入有效的整數:");
				sc.next(); // Discard non-integer input
			}
		}
		
		
		
		
		
		
		
		
		
		
		

		switch (sel2) {
		case 1:
			System.out.println("請選擇要變更的項目(1)數量 (2)冰量 (3)甜度 請選擇 [1,2,3]:");
			int sel3 = sc.nextInt();
			switch (sel3) {
			case 1:
				tag = false;
				System.out.println("請輸入變更後的數量:");
				int count = sc.nextInt();
				while (count < 0)
					count = sc.nextInt();
				cart.get(sel - 1).setCount(count);
				cart.get(sel - 1).setTotalPrice(cart.get(sel - 1).getCount() * cart.get(sel - 1).getPrice());
				break;
			case 2:
				System.out.println("請選擇飲料冰量[1,2,3]:");
				int selIce = sc.nextInt();

				verifyRepeat(cart.get(sel - 1).getName(), ice[selIce - 1].getIce(), cart.get(sel - 1).getSugar(),
						cart.get(sel - 1).getCount());
				if (!tag)
					cart.get(sel - 1).setIce(ice[selIce - 1].getIce());
				else
					cart.remove(sel - 1);

				System.out.println("已成功變更!");
				break;
			case 3:
				System.out.println("請選擇飲料甜度[1,2,3,4,5]:");
				int selSugar = sc.nextInt();
				cart.get(sel - 1).setSugar(sugar[selSugar - 1].getSugar());

				verifyRepeat(cart.get(sel - 1).getName(), cart.get(sel - 1).getIce(), sugar[selSugar - 1].getSugar(),
						cart.get(sel - 1).getCount());
				if (!tag)
					cart.get(sel - 1).setSugar(sugar[selSugar - 1].getSugar());
				else
					cart.remove(sel - 1);

				System.out.println("已成功變更!");
				break;
			}
			break;
		case 2:
			cart.remove(sel - 1);
			System.out.println("已成功變更!");
			showCart();
			break;
		case 0:
			showCart();
			break;

		}
	}

	void showPerchase() {
		int sum = 0;

		for (Item carts : cart) {
			sum = sum + carts.getTotalPrice();
		}
		System.out.printf("謝謝光臨，一共是:%d 元%n", sum);
		System.exit(0);
	}

}
