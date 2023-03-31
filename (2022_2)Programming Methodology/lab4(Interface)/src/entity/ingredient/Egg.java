package entity.ingredient;

import entity.base.Ingredient;
import entity.base.Choppable;
import entity.base.Cookable;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable {
	
	private int cookedPercentage;

	public Egg() {
		super("Egg");
		// TODO Auto-generated constructor stub
		setCookedPercentage(0);
	}

	@Override
	public void cook() {
		// TODO Auto-generated method stub
		setCookedPercentage(getCookedPercentage()+12);
		int x = getCookedPercentage();
		if (0<x && x<=50) {
			setName("Raw Egg");
			setEdible(false);
		}else if (50<x && x<=80) {
			setName("Sunny Side Egg");
			setEdible(true);
		}else if (80<x && x<=100) {
			setName("Fried Egg");
			setEdible(true);
		}else if (x>100) {
			setName("Burnt Egg");
			setEdible(false);
		}
	}

	@Override
	public boolean isBurnt() {
		// TODO Auto-generated method stub
		if (getCookedPercentage()>100) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return StringUtil.formatNamePercentage(getName(), cookedPercentage);
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}
	
	
	

}
