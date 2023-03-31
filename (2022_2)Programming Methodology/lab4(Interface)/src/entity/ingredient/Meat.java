package entity.ingredient;

import org.junit.platform.commons.util.ToStringBuilder;

import entity.base.Ingredient;
import entity.base.Choppable;
import entity.base.Cookable;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable {

	private boolean chopState;
	private int cookedPercentage;

	public Meat() {
		super("Meat");
		// TODO Auto-generated constructor stub
		setCookedPercentage(0);
		setChopState(false);
	}

	@Override
	public void cook() {
		// TODO Auto-generated method stub
		if (isChopped() == false) {
			setCookedPercentage(getCookedPercentage() + 10);
			int x = getCookedPercentage();
			if (0 < x && x <= 50) {
				setName("Raw Meat");
				setEdible(false);	
			} else if (50 < x && x <= 80) {
				setName("Medium Rare Steak");
				setEdible(true);
			} else if (80 < x && x <= 100) {
				setName("Well Done Steak");
				setEdible(true);
			} else if (x > 100) {
				setName("Burnt Steak");
				setEdible(false);
			}
		} else {
			setCookedPercentage(getCookedPercentage() + 15);
			int x = getCookedPercentage();
			if (0 < x && x <= 80) {
				setName("Raw Burger");
				setEdible(false);
			} else if (80 < x && x <= 100) {
				setName("Cooked Burger");
				setEdible(true);
			} else if (x > 100) {
				setName("Burnt Burger");
				setEdible(false);
			}
		}
	}

	@Override
	public boolean isBurnt() {
		// TODO Auto-generated method stub
		if (getCookedPercentage() > 100) {
			return true;
		}
		return false;
	}

	@Override
	public void chop() {
		// TODO Auto-generated method stub
		setName("Minced Meat");
		setChopState(true);
	}

	@Override
	public boolean isChopped() {
		// TODO Auto-generated method stub
		return this.chopState;
	}
	
	public String toString() {
		return StringUtil.formatNamePercentage(getName(), cookedPercentage);
	}

	public void setChopState(boolean chopState) {
		this.chopState = chopState;
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}

}
