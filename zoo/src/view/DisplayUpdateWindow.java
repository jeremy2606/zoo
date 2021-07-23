package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DisplayUpdateWindow extends JFrame {

	private JPanel contentPane;

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;

	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel typeAnimalLabel;
	private JComboBox typeAnimalComboBox;
	private JLabel enclosLabel;
	private JComboBox enclosComboBox;
	private JLabel commentLabel;
	private JTextArea commentTextArea;
	private JButton updateButton;
	private JButton deleteButton;

	public DisplayUpdateWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		this.getContentPane().setLayout(new GridLayout(4, 2, 1, 1));

//		createPanel1();
//		createPanel2();
//		createPanel3();
//		createPanel4();

		this.getContentPane().add(createPanel1());
		this.getContentPane().add(createPanel2());
		this.getContentPane().add(createPanel3());
		this.getContentPane().add(createPanel4());

	}

	public JPanel createPanel1() {
		panel1 = new JPanel();
		nameLabel = new JLabel("Name");
		panel1.add(nameLabel);
		nameTextField = new JTextField("Edit");
		panel1.add(nameTextField);
		return panel1;
	}

	public JPanel createPanel2() {
		panel2 = new JPanel();
		typeAnimalLabel = new JLabel("Type animal");
		panel2.add(typeAnimalLabel);
		typeAnimalComboBox = new JComboBox();
		panel2.add(typeAnimalComboBox);
		return panel2;
	}

	public JPanel createPanel3() {
		panel3 = new JPanel();
		enclosLabel = new JLabel("Enclos");
		panel3.add(enclosLabel);
		enclosComboBox = new JComboBox();
		panel3.add(enclosComboBox);
		return panel3;
	}

	public JPanel createPanel5() {
		panel5 = new JPanel();
		panel5.setLayout(new GridLayout(2, 1));
		return panel5;
	}

	public JPanel createPanel4() {
		panel4 = new JPanel();
		commentLabel = new JLabel("Commentaire");
		panel4.add(commentLabel);
		commentTextArea = new JTextArea();
		// panel4.setLayout(new FlowLayout());
		panel4.add(createPanel5());
		return panel4;
	}

}
