package view;

import metier.TypeAnimalManager;
import model.TypeAnimal;

import javax.swing.*;
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
        JTextField nameValue = new JTextField("entrez ici le nom propre de l'animal");

        JLabel typeAnimalLabel = new JLabel("type animal");
        JComboBox<TypeAnimal> typeAnimalValue = new JComboBox(new Vector<TypeAnimal>(new TypeAnimalManager().getAll()));

        JLabel paddock = new JLabel("liste deroulante paddocks");
        JLabel buttonAdd = new JLabel("bouton ADD");


        constraints.anchor = FIRST_LINE_START;
        constraints.fill=BOTH;
        constraints.weighty=0.5;
        constraints.weightx=0.5;
        constraints.insets=new Insets(10, 20, 0, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        this.getContentPane().add(title, constraints);
        constraints.weighty=0.1;
        constraints.weightx=1.0;
        constraints.anchor = LINE_START;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        this.getContentPane().add(nameLabel, constraints);
        constraints.gridx = 1;
        this.getContentPane().add(nameValue, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.getContentPane().add(typeAnimalLabel, constraints);
        constraints.gridx=1;
        this.getContentPane().add(typeAnimalValue, constraints);
        constraints.gridy = 3;
        this.getContentPane().add(paddock, constraints);
        constraints.gridx = 3;
        constraints.gridwidth = 1;
        this.getContentPane().add(buttonAdd, constraints);
    }
}
