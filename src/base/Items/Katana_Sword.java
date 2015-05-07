package base.Items;

public class Katana_Sword extends Sword{

	public Katana_Sword(String name, ItemID id, int swordDmg) {
		super(name, id, swordDmg);
	}
	
	public Katana_Sword(int dmg){
		this("Shadow Fang", ItemID.Sword, dmg);
	}

}
