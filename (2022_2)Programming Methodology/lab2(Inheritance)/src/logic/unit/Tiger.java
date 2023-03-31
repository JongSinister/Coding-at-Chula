package logic.unit;

public class Tiger extends BaseCompetitor{

	public Tiger(String name, int hp, int power) {
		super(name, hp, power);
	}

	public Tiger(String name) {
		super(name);
		this.setHp(7);
		this.setPower(5);
	}
	public String getType() {
		return "Tiger";
	}
	public void attack(BaseCompetitor enemy) {
		int damage = this.getPower();
		if (enemy.getType().equals("ToughMan")) {
			damage/=2;
		}
		else if (enemy.getType().equals("Sorcerer")) {
			damage*=1.5;
		}
		int remainHp = enemy.getHp()-damage;
		if (remainHp < 0) {
			remainHp = 0;
		}
		enemy.setHp(remainHp);
	}
	public void train(int addPower) {
		if (addPower < 0) {
			addPower = 0;
		}
		this.setPower(this.getPower()+addPower);
	}
}
