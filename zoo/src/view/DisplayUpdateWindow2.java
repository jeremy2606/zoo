package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import metier.AnimalManager;
import metier.TypeAnimalManager;
import metier.TypeEnclosManager;
import model.Animal;
import model.Enclos;
import model.TypeAnimal;
import model.TypeEnclos;

public class DisplayUpdateWindow2 extends JFrame {

	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel typeAnimalLabel;
	private JLabel typeAnimalBoxLabel;
	private JComboBox<Animal> typeAnimalComboBox;
	private JLabel enclosLabel;
	private JLabel enclosBoxLabel;
	private JComboBox<String> enclosComboBox;
	private JLabel commentLabel;
	JScrollPane commentScrolPane;
	private JTextField commentJTextField;
	private JButton updateButton;
	private JButton deleteButton;
	private List<TypeAnimal> animalTypeList;
	public DisplayUpdateWindow2() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		this.getContentPane().setLayout(new GridLayout(5, 2, 1, 1));
		this.setTitle("DELETE UPDATE ANIMAL");

		nameLabel = new JLabel("Name");
		String name;
		JTable table = ((JTable) (((JScrollPane) (AppWindow.contentPane.getComponent(0))).getViewport().getView()));
		int index = table.getSelectedRow();
		name = table.getModel().getValueAt(index, 0)
				.toString();
		JTextField nameTextField = new JTextField(name);
		
		TypeAnimalManager animalTypeManager = new TypeAnimalManager();
		animalTypeList = animalTypeManager.getAll();
		ArrayList<String> animalTypeNameList = new ArrayList<String>();
		for (TypeAnimal typeAnimal : animalTypeList ) {
			animalTypeNameList.add(typeAnimal.getName()) ; 
		}
		AnimalManager animalManager = new AnimalManager();
		typeAnimalLabel = new JLabel("Type animal");
		//typeAnimalBoxLabel = new JLabel();
		JComboBox<String> typeAnimalComboBox = new JComboBox<String>(new Vector<String>(animalTypeNameList));
		//typeAnimalBoxLabel.add(typeAnimalComboBox);
		typeAnimalComboBox.setSelectedItem(animalManager.getByName(name).getTypeAnimal());
		enclosLabel = new JLabel("Enclos Type");
        TypeEnclosManager typeEnclosManager = new TypeEnclosManager();
        
        ArrayList<String> typeEnclosTypeNameList = new ArrayList<String>();
        ArrayList<TypeEnclos> typeEnclosList = new ArrayList<TypeEnclos>() ;
        typeEnclosList = (ArrayList<TypeEnclos>) typeEnclosManager.getAll();
        for (TypeEnclos typeEnclos : typeEnclosList ) {
            typeEnclosTypeNameList.add(typeEnclos.getName());
        }
   
        enclosComboBox = new JComboBox<String>(new Vector<String>(typeEnclosTypeNameList));
        enclosComboBox.setSelectedItem(animalManager.getByName(name).getTypeEnclos());
	
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
		commentJTextField.setText(animalManager.getByName(name).getCommentaires());
		this.getContentPane().add(nameLabel);
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
