package logic.unit;

public class ToughMan extends BaseCompetitor {

	private int maxHp;

	public ToughMan(String name, int hp, int power) {
		super(name, hp, power);
		this.maxHp = this.getHp();
	}

	public ToughMan(String name) {
		super(name);
		this.setHp(8);
		this.setPower(4);
		this.setMaxHp(8);
	}

	public String getType() {
		return "ToughMan";
	}

	public void attack(BaseCompetitor enemy) {
		int damage = this.getPower();
		if (enemy.getType().equals("Sorcerer")) {
			damage /= 2;
		} else if (enemy.getType().equals("Tiger")) {
			damage *= 1.5;
		}
		int remainHp = enemy.getHp() - damage;
		if (remainHp < 0) {
			remainHp = 0;
		}
		enemy.setHp(remainHp);
	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public void setMaxHp(int maxHp) {
		maxHp = Math.max(0, maxHp);
		if (this.getHp() > maxHp) {
			this.setHp(maxHp);
		}
		this.maxHp = maxHp;
	}

	public void heal(int healHp) {
		this.setHp(Math.min(this.getMaxHp(), this.getHp() + Math.max(0, healHp)));
	}

}
