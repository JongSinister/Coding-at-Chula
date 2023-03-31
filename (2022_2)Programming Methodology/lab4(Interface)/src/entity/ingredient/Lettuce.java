package entity.ingredient;

import entity.base.Ingredient;
import entity.base.Choppable;
import entity.base.Cookable;

public class Lettuce extends Ingredient implements Choppable {

	private boolean chopState;

	public Lettuce() {
		super("Lettuce");
		// TODO Auto-generated constructor stub
		setEdible(true);
		setChopState(false);
	}

	@Override
	public void chop() {
		// TODO Auto-generated method stub
		if (!isChopped()) {
			setChopState(true);
			setName("Chopped Lettuce");
		}
	}

	@Override
	public boolean isChopped() {
		// TODO Auto-generated method stub
		return getChopState();
	}

	public boolean getChopState() {
		return chopState;
	}

	public void setChopState(boolean chopState) {
		this.chopState = chopState;
	}

}
