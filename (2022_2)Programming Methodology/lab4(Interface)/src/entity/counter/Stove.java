package entity.counter;

import entity.base.Item;
import entity.base.Updatable;
import entity.container.Pan;
import logic.Player;

public class Stove extends Counter implements Updatable {

	public Stove() {
		setName("Stove");
	}

	public Stove(Item content) {
		setName("Stove");
		setPlacedContent(content);
	}

	public void interact(Player P) {
		if (!isPlacedContentEmpty()) {
			super.interact(P);
		} else {
			if (P.getHoldingItem() != null && P.getHoldingItem().getName().equals("Pan")) {
				super.interact(P);
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (getPlacedContent().getName().equals("Pan")) {
			((Pan) getPlacedContent()).cook();
		}
	}

}
