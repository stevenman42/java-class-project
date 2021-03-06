package base.Items;

public abstract class Base_Sword extends Item{

	protected int swordDmg, swordCoolDown;

	
	public Base_Sword(String name, ItemID id, String imgName, int swordDmg) {
		super(name, id, imgName);
		this.swordDmg = swordDmg;

	}
	
	public int swingSword(){            
		if(swordCoolDown <= 0){
			swordCoolDown = 100;
			return swordDmg;
		}
		return 0;
	}

	public int getSwordDmg(){
		return swordDmg;
	}
	public int getSwordCoolDown(){
		return swordCoolDown;
	}
	public void setSwordDmg(int swordDmg){
		this.swordDmg = swordDmg;
	}
	public void setSwordCoolDown(int swordCoolDown){
		this.swordCoolDown = swordCoolDown;
	} 

}
