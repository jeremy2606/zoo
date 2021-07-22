package zoo;

import cages.Cage;

import java.util.ArrayList;

public class Zoo1 {

    ArrayList<Cage> listeCg;

    public Zoo1() {
    }

    public Zoo1(ArrayList<Cage> listeCg) {
        this.listeCg = listeCg;
    }

    public ArrayList<Cage> getListeCg() {
        return listeCg;
    }

    public void setListeCg(ArrayList<Cage> listeCg) {
        this.listeCg = listeCg;
    }

    @Override
	public String toString() {
		return "Zoo1 [listeCg=" + listeCg + ", getListeCg()=" + getListeCg() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
