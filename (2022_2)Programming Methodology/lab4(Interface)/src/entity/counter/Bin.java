package entity.counter;

import entity.base.Container;
import entity.base.Ingredient;
import logic.Player;

public class Bin extends Counter{
	public Bin() {
		setName("Bin");
	}
	public void interact(Player P) {
		if (!P.isHandEmpty()) {
			if (P.getHoldingItem() instanceof Ingredient) {
				P.setHoldingItem(null);
			}
			if (P.getHoldingItem() instanceof Container) {
				((Container) P.getHoldingItem()).clearContent();
			}
		}
	}
}
