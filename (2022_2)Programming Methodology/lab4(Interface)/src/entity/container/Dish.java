package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container {
	private int dirty;

	public Dish() {
		super("Dish", 4);
		setDirty(0);
	}

	public Dish(int dirty) {
		super("Dirty Dish", 4);
		setDirty(dirty);
	}

	public boolean isDirty() {
		if (getDirty() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean verifyContent(Ingredient i) {
		// TODO Auto-generated method stub
		if (!isDirty() && i.isEdible()) {
			return true;
		}
		return false;
	}

	public void clean(int amount) {
		setDirty(getDirty()-amount);
	}
	
	public String toString() {
		if (isDirty()) {
		return StringUtil.formatNamePercentage("Dirty Dish", dirty);
		}
		return super.toString();
	}

	public int getDirty() {
		return dirty;
	}

	public void setDirty(int dirty) {
		dirty = Math.max(0, dirty);
		if (dirty > 0) {
			setName("Dirty Dish");
		}else {
			setName("Dish");
		}
		this.dirty = dirty;
	}

}
