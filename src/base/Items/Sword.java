package base.Items;


public class Sword extends GameItem{
	
	protected int swordDmg, swordCoolDown;

	public Sword(String name, ItemID id, int swordDmg) {
		super(name, id);
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
