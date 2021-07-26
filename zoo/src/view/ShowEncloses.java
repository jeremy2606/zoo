package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dbaccess.DbEnclos;
import metier.EnclosManager;
import model.Enclos;
import dbaccess.*;


public class ShowEncloses extends JFrame {
	EnclosManager eM = new EnclosManager();
	JTextArea encloseArea = new JTextArea();
	
	public ShowEncloses() {
		JComboBox<Enclos> enclosBox = new JComboBox<Enclos>(new Vector<Enclos>(eM.getAll()));
		//JButton button = new JButton();
		//button.setFocusable(false);
		//button.setText("Show all encloses");
		//button.setBackground(Color.green);
		//button.setFont(new Font("Mv Boli", Font.PLAIN, 11));
		//button.addActionListener(e -> {
		//	for(int i = 0; i < eM.getAll().size(); i++) {
		//		encloseArea.append("\n" + eM.getAll().get(i).toString());
		//	}
		//	button.setEnabled(false);
		//});
		JPanel buttonPanel = new JPanel();
		buttonPanel.setSize(150, 50);
		//buttonPanel.add(button);
		encloseArea.setSize(500, 450);
		encloseArea.setEditable(false);
		encloseArea.setFont(new Font("Mv Boli", Font.PLAIN, 14));
				
		JScrollPane encloseScroll = new JScrollPane(encloseArea);
		encloseScroll.setSize(500, 400);
		
		JPanel encloseAreaPanel = new JPanel();
		encloseAreaPanel.setSize(500, 500);
		encloseAreaPanel.setLayout(new BorderLayout());
		encloseAreaPanel.add(buttonPanel, BorderLayout.NORTH );
		encloseAreaPanel.add(enclosBox, BorderLayout.CENTER);
		
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(encloseAreaPanel);
		this.setVisible(true);
	}
	// Class main only for testing purposes of this part of graphical interface --deletion later
	public static void main(String[] args) {
		
		
		new ShowEncloses();
	}
	
}


