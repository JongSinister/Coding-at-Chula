package logic;

import java.util.ArrayList;

public class Inventory {
	
	//fields
	private String playerName;
	private int money;
	private ArrayList<ItemCounter> items;
	private Object ArrayList;
	
	//constructors
	public Inventory(String playerName) {
		//FILL CODE
		this.playerName = playerName;
		this.money = 0;
		this.items = new ArrayList<ItemCounter>();
	}
	
	public Inventory(String playerName, int money) {
		//FILL CODE
		this.playerName = playerName;
		if (money < 0 ) {
			money = 0;
		}
		this.money = money;
		this.items = new ArrayList<ItemCounter>();
	}
	
	public Inventory(String playerName, int money, ArrayList<ItemCounter> items) {
		//FILL CODE
		this.playerName = playerName;
		this.money = money;
		this.items = items;
	}
	
	//methods
	public String toString() {
		if (items.size() == 0) {
			return "EMPTY INVENTORY";
		}
		String out = "\n";
		for (int i=0; i<items.size(); i++) {
			out += i+1;
			out += ". ";
			out += items.get(i).toString();
			out += "\n";
		}
		return out;
	}
	public boolean existsInInventory(Item item) {
		//FILL CODE
		for (ItemCounter ic : items) {
			if(ic.getItem().equals(item)) {
				return true;
			}
		}
		return false;
	}

	public void addItem(Item newItem, int count){
		//FILL CODE
		if (count <= 0)
			return;
		boolean existcheck = true;
		for (ItemCounter ic : items) {
			if (ic.getItem().equals(newItem)) {
				ic.setCount(ic.getCount() + count);
				existcheck = false;
				break;
			}
		}
		if (existcheck) {
			ItemCounter newToAdd = new ItemCounter(newItem,count);
			items.add(newToAdd);
			}
		}

	public void removeItem(Item toRemove, int count) {

		// if the amount is zero or negative, just return. nothing is removed.
		if (count <= 0)
			return;

		ItemCounter removeIfNeg = null;

		for (ItemCounter ic : items) {
			if (ic.getItem().equals(toRemove)) {
				// Remove the card equal to count.
				ic.setCount(ic.getCount() - count);
				removeIfNeg = ic;
			}
		}

		// If removeIfNeg isn't null (meaning something got removed) then we need to
		// check if it is negative.
		if (removeIfNeg != null) {
			// If it goes into the negative, then remove this entry from the deck entirely.
			// You cannot modify a for loop while it's inside, so this has to be done
			// outside.
			if (removeIfNeg.getCount() <= 0) {
				items.remove(removeIfNeg);
			}
		}

	}
	

	//getters setters
	//FILL CODE
	// V
	// V
	public String getPlayerName() {
		if (this.playerName.isBlank()) {
			return "Untitled Player";
		}
		return this.playerName;
	}
	public int getMoney() {
		return this.money;
	}
	public ArrayList<ItemCounter> getItems() {
		return this.items;
	}
	public void setPlayerName(String newName) {
		this.playerName = newName;
	}
	public void setMoney(int newMoney) {
		if (newMoney < 0) {
			newMoney = 0;
		}
		this.money = newMoney;		
	}
	public void setItems(ArrayList<ItemCounter> items) {
		this.items = items;
	}
	
}
