package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import metier.EnclosManager;


public class ShowEncloses extends JFrame {
	
	EnclosManager eM;
	public JTextArea encloseArea = new JTextArea();
	
	public ShowEncloses() {
		
		encloseArea.setSize(500, 400);
		encloseArea.setFont(new Font("Mv Boli", Font.PLAIN, 12));
		encloseArea.setEditable(false);
		encloseArea.setForeground(Color.CYAN);
		JScrollPane encloseScroll = new JScrollPane(encloseArea);
		encloseScroll.setSize(500, 400);
		
		JButton button = new JButton();
		button.setFocusable(false);
		button.setText("Show all encloses");
		button.setBackground(Color.green);
		button.setFont(new Font("Mv Boli", Font.PLAIN, 11));
		button.addActionListener(e -> {
			encloseArea.setText(eM.dao.getAll().toString());
		});
		
		JPanel encloseAreaPanel = new JPanel();
		encloseAreaPanel.add(encloseScroll);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setSize(150, 50);
		buttonPanel.add(button);
		
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(encloseAreaPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	/*
	public static void main(String[] args) {
		
		
		new ShowEncloses();
	}
	*/
}


