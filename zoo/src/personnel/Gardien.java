package personnel;

public class Gardien extends Personnel {

	public Gardien() {
		super ();
		this.profession = "Gardien";
	}

	
	 void travailler() {
		System.out.println("Je garde les animaux");
	}

	@Override
	public String toString() {
		return "Gardien [nom=" + nom + ", profession=" + profession + "]";
	}


		// TODO Auto-generated constructor stub
	}


