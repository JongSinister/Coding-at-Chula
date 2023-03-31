package logic.unit;

public class BaseCompetitor {
	String name;
	private int power;
	private int hp;
	public BaseCompetitor(String name) {
		this.name = name;
		this.hp = 5;
		this.power = 3;
	}
	public BaseCompetitor(String name,int hp,int power) {
		this.name = name;
		if (power < 1) {
			power = 1;
		}
		if (hp < 0) {
			hp = 0;
		}
		this.power = power;
		this.hp = hp;
	}
	public void attack(BaseCompetitor enemy) {
		int remainHp = enemy.hp-this.power;
		if (remainHp < 0) {
			remainHp = 0;
		}
		enemy.hp = remainHp;
	}
	public String getType() {
		//add code
		return "BaseCompetitor";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		if (power < 1) {
			power  = 1;
		}
		this.power = power;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		if (hp < 0) {
			hp = 0;
		}
		this.hp = hp;
	}
	
	
}
