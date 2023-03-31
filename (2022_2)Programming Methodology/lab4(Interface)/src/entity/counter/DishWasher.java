package entity.counter;

import entity.base.Updatable;
import entity.container.Dish;
import logic.Player;

public class DishWasher extends Counter implements Updatable {

	public DishWasher() {
		setName("Dish Washer");
	}

	public void interact(Player P) {
		if (!isPlacedContentEmpty()) {
			super.interact(P);
		} else {
			if (P.getHoldingItem() != null && P.getHoldingItem().getName().equals("Dirty Dish")) {
				super.interact(P);
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if ( getPlacedContent()!= null && ( getPlacedContent().getName().equals("Dish") || getPlacedContent().getName().equals("Dirty Dish"))) {
			((Dish) getPlacedContent()).clean(15);
		}
	}

}
