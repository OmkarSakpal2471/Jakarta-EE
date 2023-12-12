package mypack;

public class Soldier {
	private Weapon weapon;

	/**
	 * @param weapon the weapon to set
	 */

	void perform()
	{
		weapon.attack();
	}

	public Soldier(Weapon weapon) {

		this.weapon = weapon;
	}
}
