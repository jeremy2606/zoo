package animal;
import java.io.*;

public class Ours extends Omnivore {
	
	public Ours(){
		super();
		this.nom = "Ours";
		this.maniereDeManger = "Omnivore";
	}
	
	
    public void seDeplacer() {
	
    }

	
	@Override
	public void manger() {
		
		System.out.println(maniereDeManger); 
	}



	@Override
	public String toString() {
		return "Ours [nom=" + nom + ", maniereDeManger=" + maniereDeManger + ", maniereDeSeDeplacer="
				+ maniereDeSeDeplacer + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	
	}
	
	public void  move () {     
		this.maniereDeSeDeplacer.seDeplacer();
	}



	@Override
	public void seDeplacer(String activite) {
		// TODO Auto-generated method stub
		// String activité car il est decrit ainsi dans anima
	}


	//@Override
	//public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	//}


	//@Override
	//public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}



	

	


	
	
	
	
	


