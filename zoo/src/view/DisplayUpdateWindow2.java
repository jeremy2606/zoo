package view;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.Animal;
import model.Enclos;

public class DisplayUpdateWindow2 extends JFrame {

	private JPanel contentPane;

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;

	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel typeAnimalLabel;
	private JLabel typeAnimalBoxLabel;
	private JComboBox<Animal> typeAnimalComboBox;
	private JLabel enclosLabel;
	private JLabel enclosBoxLabel;
	private JComboBox<Enclos> enclosComboBox;
	private JLabel commentLabel;
	JScrollPane commentScrolPane;
	private JTextField commentJTextField;
	private JButton updateButton;
	private JButton deleteButton;

	public DisplayUpdateWindow2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		this.getContentPane().setLayout(new GridLayout(5, 2, 1, 1));
		this.setTitle("DELETE UPDATE ANIMAL");
//		createPanel1();
//		createPanel2();
//		createPanel3();
//		createPanel4();
		nameLabel = new JLabel("Name");
		nameTextField = new JTextField("Edit");
		typeAnimalLabel = new JLabel("Type animal");
		typeAnimalBoxLabel = new JLabel("Ours");
		typeAnimalComboBox = new JComboBox<Animal>(new Vector<Animal>());
		typeAnimalBoxLabel.add(typeAnimalComboBox);
		enclosLabel = new JLabel("Enclos");
		enclosBoxLabel = new JLabel("Aquarium");

		enclosComboBox = new JComboBox<Enclos>(new Vector<Enclos>());
		enclosBoxLabel.add(enclosComboBox);
		commentLabel = new JLabel("Commentaire");
		commentJTextField = new JTextField("Edit");
		updateButton = new JButton("Update");
		deleteButton = new JButton("Delete");
		// panel4.setLayout(new FlowLayout());
		// panel4.add(createPanel5());
//		this.getContentPane().add(createPanel1());
//		this.getContentPane().add(createPanel2());
//		this.getContentPane().add(createPanel3());
//		this.getContentPane().add(createPanel4());
		commentScrolPane = new JScrollPane(commentJTextField);

		this.getContentPane().add(nameLabel);
		nameLabel.setText(getName());
		this.getContentPane().add(nameTextField);
		this.getContentPane().add(typeAnimalLabel);
		this.getContentPane().add(typeAnimalComboBox);
		this.getContentPane().add(enclosLabel);
		this.getContentPane().add(enclosComboBox);
		this.getContentPane().add(commentLabel);
		this.getContentPane().add(commentScrolPane);
		this.getContentPane().add(updateButton);
		this.getContentPane().add(deleteButton);

	}

}
