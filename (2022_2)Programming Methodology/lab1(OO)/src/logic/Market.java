package logic;

import java.util.ArrayList;

public class Market {

	// fields
	ArrayList<Item> allItems;
	ArrayList<String> itemExistInMarket;

	// constructors
	public Market() {
		// FILL CODE
		this.allItems = new ArrayList<Item>();
		this.itemExistInMarket = new ArrayList<String>();
	}

	public Market(ArrayList<Item> items) {
		// FILL CODE
		this.allItems = new ArrayList<Item>();
		this.itemExistInMarket = new ArrayList<String>();
		this.addAllItems(items);
	}

	// methods
	public String toString() {
		String out = "\n";
		for (int i = 0; i < allItems.size(); i++) {
			out += i + 1;
			out += ". ";
			out += allItems.get(i).toString();
			out += "\n";
		}
		return out;
	}

	public void addAllItems(ArrayList<Item> items) {
		// FILL CODE
		if (!items.equals(null)) {
			for (Item item : items) {
				if (this.itemExistInMarket.contains(item.getItemName()) || itemNameIsExist(item.getItemName())) {
					System.out.println("\""+item.toString()+"\""+" is duplicated, Item will not be added");
					continue;
				}
				this.allItems.add(item);
				System.out.println("\""+item.toString()+"\""+" Added to the market");
				this.itemExistInMarket.add(item.getItemName());
				}
		}
	}

	// getter setters
	// FILL CODE
	public ArrayList<Item> getAllItems() {
		return this.allItems;
	}
	private boolean itemNameIsExist(String itemName) {
		for (Item item : allItems) {
			if (item.getItemName().equals(itemName)) {
				return true;
			}
		}
		return false;
	}
}
