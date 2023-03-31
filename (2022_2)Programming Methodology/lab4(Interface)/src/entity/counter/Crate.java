package entity.counter;

import logic.InvalidIngredientException;
import logic.LogicUtil;
import logic.Player;

public class Crate extends Counter {
	private String myIngredient;

	public Crate(String s) {
		setMyIngredient(s);
		setName(s + " Crate");

	}

	public String getMyIngredient() {
		return myIngredient;
	}

	public void setMyIngredient(String myIngredient) {
		this.myIngredient = myIngredient;
	}

	public void interact(Player P) {
		if (!P.isHandEmpty() || !isPlacedContentEmpty()) {
			super.interact(P);
		} else {
			try {
				P.setHoldingItem(LogicUtil.createIngredientFromName(getMyIngredient()));
			} catch (InvalidIngredientException e) {
				// TODO Auto-generated catch block
				P.setHoldingItem(null);
			}
		}
	}

}
