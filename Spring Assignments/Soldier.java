package mypack;

public class Soldier {
	private Weapon weapon;

	/**
	 * @param weapon the weapon to set
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	void perform()
	{
		weapon.attack();
	}
}
