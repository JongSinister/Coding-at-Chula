package logic;

public class ItemCounter {
	private Item item;
	private int amount;
	
	//constructor
	public ItemCounter(Item item) {
		this.item = item;
		this.amount = 1;
	}
	public ItemCounter(Item item,int count) {
		this.item = item;
		if (count < 1) {
			count = 1;
		}
		this.amount = count;
	}
	public int getCount() {
		return this.amount;
	}
	public Item getItem() {
		return this.item;
	}
	public String toString() {
		return this.getItem() + " x" + this.getCount();
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void setCount(int count) {
		if (count < 0) {
			count =0;
		}
		this.amount = count;
	}
}
