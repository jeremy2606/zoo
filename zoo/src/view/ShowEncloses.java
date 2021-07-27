package view;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import metier.EnclosManager;
import model.Enclos;

public class ShowEncloses extends JFrame {
	EnclosManager eM = new EnclosManager();
	JComboBox<Enclos> enclosBox = new JComboBox<Enclos>(new Vector<Enclos>(eM.getAll()));
	ListenEnclos lE = new ListenEnclos(this);
	
	public ShowEncloses() {
		
		enclosBox.addActionListener(lE);
		this.setTitle("Our Encloses");
		this.setSize(400, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(enclosBox);
		this.setVisible(true);
	}
	// Class main only for testing purposes of this part of graphical interface --deletion later
	public static void main(String[] args) {
		new ShowEncloses();
	}	
}


