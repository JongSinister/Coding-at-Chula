package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import exception.NameBlankException;

public class ItemUtil {

	public static Scanner sc = new Scanner(System.in);

	public static boolean itemNameIsExist(Market market, String itemName) {
		//FILL CODE
		for (Item item : market.allItems) {
			if (item.getItemName().equals(itemName)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasEnoughMoneytoBuy(Inventory toBuy, Item item, int amount) {
		//FILL CODE
		if (toBuy.getMoney() > item.getPrice() * amount) {
			return true;
		}
		return false;
	}

	public static ArrayList<Item> getItemFromFile(String filename) {
		
		File fileToRead = new File(filename);
		ArrayList<Item> itemsFromFile = new ArrayList<Item>();
		//FILL CODE
		try {
			Scanner scan = new Scanner(fileToRead);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				try {
					String[] splt = line.split(" ");
					String itemName = splt[0];
					int itemprice = Integer.parseInt(splt[1]);
					Item itemAdd = new Item(itemName,itemprice);
					itemsFromFile.add(itemAdd);
				}catch (Exception e) {
					System.out.println("Item name cannot be blank! This item will not be added.");
				}
			}
			scan.close();
		}catch(FileNotFoundException e) {
			System.out.println("Cannot find file!");
		}
		return itemsFromFile;
	}

	public static void playerSellplayer(Inventory toSell, Inventory toBuy, Item item, int amount) {
		if (!hasEnoughMoneytoBuy(toBuy, item, amount)) {
			System.out.println(toBuy.getPlayerName() + " dont't have enough money to buy this item.");
		} else {
			System.out.println("=========SELL CONFIRMATION=========");
			System.out.println("    Selling " + item.getItemName() + " x" + amount
					+ " to " + toBuy.getPlayerName());
			System.out.println("            for $" + item.getPrice() * amount
					+ "             ");
			System.out.println(" >> Type \"1\" to confirm selling  ");
			System.out.println(" >> Type anything else to cancel ");
			System.out.println("===================================");
			String input = sc.nextLine();
			switch (input) {
			case "1":
				playerSellPlayerConfirmed(toSell, toBuy, item, amount);
				System.out.println("<<TRANSACTION COMPLETE>>");
				break;
			default:
				System.out.println("<<SELL CANCEL>>");
				break;
			}
		}
	}
	
	public static void playerSellPlayerConfirmed(Inventory toSell, Inventory toBuy, Item item, int amount) {
		//FILL CODE
		int cost = item.getPrice() * amount ;
		toSell.setMoney(toSell.getMoney()+cost);
		toBuy.setMoney(toBuy.getMoney()-cost);
		toSell.removeItem(item, amount);
		toBuy.addItem(item, amount);		
	}

	public static void playerSellMarket(Inventory toSell, Item item, int amount) {
		System.out.println("=========SELL CONFIRMATION=========");
		System.out.println("    Selling " + item.getItemName() + " x" + amount
				+ " to market      ");
		System.out.println(
				"            for $" + item.getPrice() * amount + "             ");
		System.out.println(" >> Type \"1\" to confirm selling  ");
		System.out.println(" >> Type anything else to cancel ");
		System.out.println("===================================");
		String input = sc.nextLine();
		switch (input) {
		case "1":
			playerSellMarketConfirmed(toSell, item, amount);
			System.out.println("<<TRANSACTION COMPLETE>>");
			break;
		default:
			System.out.println("<<SELL CANCEL>>");
			break;
		}
	}
	
	public static void playerSellMarketConfirmed(Inventory toSell, Item item, int amount) {
		//FILL CODE
		int cost = item.getPrice()*amount ;
		toSell.setMoney(toSell.getMoney() + cost);
		toSell.removeItem(item, amount);
	}
	
	public static void playerBuyMarket(Inventory toBuy, Item item, int amount) {
		if (!ItemUtil.hasEnoughMoneytoBuy(toBuy, item, amount)) {
			System.out.println(toBuy.getPlayerName() + " Dont't have enough money\nto buy this item.");
		} else {
			System.out.println("=========BUY CONFIRMATION=========");
			System.out.println("	" + toBuy.getPlayerName() + " is buying ");
			System.out.println("	" + item.getItemName() + " x" + amount + " for $"
					+ item.getPrice() * amount);
			System.out.println(" >> Type \"1\" to confirm buying  ");
			System.out.println(" >> Type anything else to cancel");
			System.out.println("==================================");
			String input = sc.nextLine();
			switch (input) {
			case "1":
				playerBuyMarketConfirmed(toBuy, item, amount);
				System.out.println("TRANSACTION COMPLETE!");
				break;
			default:
				System.out.println("BUY CANCEL!");
				break;
			}
		}
	}
	
	public static void playerBuyMarketConfirmed(Inventory toBuy, Item item, int amount) {
		//FILL CODE
		int cost = item.getPrice() * amount;
		toBuy.setMoney(toBuy.getMoney() - cost);
		toBuy.addItem(item, amount);
	}

}
