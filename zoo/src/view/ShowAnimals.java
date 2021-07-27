package view;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import metier.AnimalManager;
import model.Animal;


public class ShowAnimals extends JFrame {
	AnimalManager aM = new AnimalManager();
	ModelAnimal mA;
	JComboBox<Animal> animalBox = new JComboBox<Animal>(new Vector<Animal>(aM.getAll()));
	ListenAnimal lA = new ListenAnimal(this);
	ShowAnimals() {
		animalBox.addActionListener(lA);
		this.setTitle("Our Animals");
		this.setSize(1200, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(animalBox);
		this.setVisible(true);
	}
	// Class main only for testing purposes of this part of graphical interface --deletion later
	public static void main(String[] args) {
		new ShowAnimals();
	
	}
}
