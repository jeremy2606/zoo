package view;

import metier.EnclosManager;
import metier.TypeAnimalManager;
import model.Enclos;
import model.TypeAnimal;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Vector;

import static java.awt.GridBagConstraints.*;

public class CreateAnimalWindow extends JFrame {

    GridBagConstraints constraints;

    public CreateAnimalWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 300, 700, 450);
        setTitle("CREEZ UN NOUVEL ANIMAL");
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        JLabel title = new JLabel("Creation nouvel animal");
        title.setFont(new Font("Arial Bold", Font.BOLD, 25));
        title.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel nameLabel = new JLabel("nom de l'animal");
        JTextField nameValue = new JTextField("");
        nameValue.setBorder((BorderFactory.createLineBorder(Color.black)));
        nameValue.setToolTipText("entrez ici le nom propre de l'animal");

        JLabel typeAnimalLabel = new JLabel("type animal");
        JComboBox<TypeAnimal> typeAnimalValue = new JComboBox(new Vector<TypeAnimal>(new TypeAnimalManager().getAll()));

        JLabel paddockLabel = new JLabel("choix enclos");
        JComboBox<Enclos> paddockValue = new JComboBox(new Vector<Enclos>(new EnclosManager().getAll()));

        JButton addButton = new JButton(("ADD"));
        JButton cancelButton = new JButton(("CANCEL"));

        JLabel commentaryLabel = new JLabel("Commentaires");
        JTextArea commentaryValue = new JTextArea();
        commentaryValue.setToolTipText("Ajoutez vos commentaires ici");
        commentaryValue.setBorder((BorderFactory.createLineBorder(Color.black)));


        constraints.anchor = FIRST_LINE_START;
        constraints.fill = BOTH;
        constraints.weighty = 0.2;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(10, 20, 10, 20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        this.getContentPane().add(title, constraints);
        constraints.weighty = 0.1;
        constraints.weightx = 1.0;
        constraints.anchor = LINE_START;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        this.getContentPane().add(nameLabel, constraints);
        constraints.gridx = 1;
        this.getContentPane().add(nameValue, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.getContentPane().add(typeAnimalLabel, constraints);
        constraints.gridx = 1;
        this.getContentPane().add(typeAnimalValue, constraints);
        constraints.gridy = 3;
        constraints.gridx = 0;
        this.getContentPane().add(paddockLabel, constraints);
        constraints.gridx = 1;
        this.getContentPane().add(paddockValue, constraints);
        constraints.gridx = 3;
        this.getContentPane().add(addButton, constraints);
        constraints.gridy = 4;
        this.getContentPane().add(cancelButton, constraints);
        constraints.gridx=0;
        this.getContentPane().add(commentaryLabel, constraints);
        constraints.gridx=1;
        this.getContentPane().add(commentaryValue, constraints);
    }
}
