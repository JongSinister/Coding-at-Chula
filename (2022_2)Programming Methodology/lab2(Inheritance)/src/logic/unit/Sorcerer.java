package logic.unit;

public class Sorcerer extends BaseCompetitor {

	public Sorcerer(String name) {
		super(name);
		this.setHp(4);
		this.setPower(2);
	}
	public Sorcerer(String name, int hp, int power) {
		super(name, hp, power);
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return "Sorcerer";
	}
	public void attack(BaseCompetitor enemy) {
		int damage = this.getPower();
		if (enemy.getType().equals("Tiger")) {
			damage/=2;
		}
		else if (enemy.getType().equals("ToughMan")) {
			damage*=1.5;
		}
		int remainHp = enemy.getHp()-damage;
		if (remainHp < 0) {
			remainHp = 0;
		}
		enemy.setHp(remainHp);
	}
	public void lowerPower(BaseCompetitor enemy,int powerDown) {
		if (powerDown < 0) {
			powerDown = 0;
		}
		int remainPower = enemy.getPower() - powerDown;
		if (remainPower < 1) {
			remainPower = 1;
		}
		enemy.setPower(remainPower);
	}
	

}
