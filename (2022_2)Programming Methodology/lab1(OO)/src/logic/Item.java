package logic;

import exception.NameBlankException;

public class Item {

	private String itemName;
	private int price;

	// constructor
	public Item(String itemName) throws NameBlankException {
		if (itemName.isBlank()) {
			throw new NameBlankException();
		}
		this.itemName = itemName;
		this.price = 0;
	}

	public Item(String itemName, int price) throws NameBlankException{
		if (itemName.isBlank()) {
			throw new NameBlankException();
		}
		this.itemName = itemName;
		if (price < 0) {
			price = 0;
		}
		this.price = price;
	}

	// methods
	public boolean equals(Item other) {
		Item otherItem = (Item) other;
		if (this.getItemName() == otherItem.getItemName())
			return true;
		else
			return false;
	}

	public String toString() {
		return itemName + " $"+price;
	}

	// getter & setter
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) throws NameBlankException {
		//FILL CODE
		if (itemName.isBlank()) {
			throw new NameBlankException();
			}
		this.itemName = itemName;
		}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		if (price < 0) {
			this.price = 0;
		} else {
			this.price = price;
		}
	}

}

