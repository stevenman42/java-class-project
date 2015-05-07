package base.Items;

public class Katana_Sword extends Base_Sword{

	public Katana_Sword(String name, ItemID id, int swordDmg) {
		super(name, id, swordDmg);
	}
	
	public Katana_Sword(String name, ItemID id, int swordDmg, int code) {
		super(name, id, swordDmg);
		setName("Shadow Fang");
		setSwordDmg(Integer.MAX_VALUE);
	}
	



}
