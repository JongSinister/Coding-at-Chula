package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import entity.base.Cookable;

public class Pan extends Container {

	public Pan() {
		super("Pan", 1);
	}

	@Override
	public boolean verifyContent(Ingredient i) {
		// TODO Auto-generated method stub
		if (i instanceof Cookable) {
			return true;
		}
		return false;
	}

	public void cook() {
		if (isEmpty() == false) {
			for (Ingredient i : getContent()) {
				((Cookable) i).cook();
			}
		}
	}

}
