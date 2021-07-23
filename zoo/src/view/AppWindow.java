package view;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import metier.AnimalManager;
import metier.Manager;
import model.Animal;

public class AppWindow extends JFrame {

	private JPanel contentPane;

	public AppWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setJMenuBar(createMenuBar());
		this.setTitle("AJOUT ANIMAL");
		// sur le mm fonctionnement LIst ?? = new ArrayList() interface a gauche et
		// implemen,tation adroite
		Manager<Animal> animalManager = new AnimalManager();
		// animalManager metier qui demande a la bdd et qui renvoi l info et donne acces
		// a la methode getAll
		ModelAnimal modelAnimal = new ModelAnimal(animalManager.getAll());
		JTable tableAnimals = new JTable(modelAnimal);
		JScrollPane scrollpaneAnimals = new JScrollPane(tableAnimals);
		tableAnimals.setFillsViewportHeight(true);
		this.getContentPane().add(scrollpaneAnimals, BorderLayout.NORTH);
		JPanel panelAddAnimalButton = new JPanel();
		JButton addAnimalButton = new JButton();
		panelAddAnimalButton.add(addAnimalButton);
		this.getContentPane().add(panelAddAnimalButton, BorderLayout.SOUTH);
		// JTable)
		// contentPane.getComponent(1)).setText(selectedAnimal.getFirstName());

	}

	public JMenuBar createMenuBar() {
		JMenuBar menuBarZoo = new JMenuBar();

		JMenu menuEnclos = new JMenu("Enclos");
		menuBarZoo.add(menuEnclos);
		JMenuItem addItemEnclos = new JMenuItem("Ajouter");
		addItemEnclos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
		menuEnclos.add(addItemEnclos);
		addItemEnclos.setIcon(new ImageIcon("zoo/src/icons/cageIcon.png"));
		JMenu menuAnimal = new JMenu("Animal");
		menuBarZoo.add(menuAnimal);

		menuBarZoo.add(menuAnimal);
		JMenuItem addItemAnimal = new JMenuItem("Ajouter");
		addItemAnimal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
		menuAnimal.add(addItemAnimal);
		addItemAnimal.setIcon(new ImageIcon("zoo/src/icons/bearIcon.jpg"));

		return menuBarZoo;
	}
}
