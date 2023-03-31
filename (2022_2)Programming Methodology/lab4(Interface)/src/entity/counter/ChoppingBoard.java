package entity.counter;

import entity.base.Ingredient;
import entity.base.Choppable;
import logic.Player;

public class ChoppingBoard extends Counter{
	public ChoppingBoard() {
		setName("Chopping Board");
	}
	
	public void interact(Player P) {
		if (!isPlacedContentEmpty()) {
			super.interact(P);
		}else {
			if (!P.isHandEmpty() && P.getHoldingItem() instanceof Ingredient) {
				super.interact(P);
				if (getPlacedContent() instanceof Choppable) {
					((Choppable) getPlacedContent()).chop();
				}
			}
		}
	}
}
