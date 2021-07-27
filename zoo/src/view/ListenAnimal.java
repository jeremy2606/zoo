package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ListenAnimal implements ActionListener {

	ShowAnimals sA;
	ListenAnimal(ShowAnimals sA) {
		this.sA = sA;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame = new JFrame("Our animal id: " + (sA.animalBox.getSelectedIndex()+1));
		frame.setSize(1200, 200);
		JTextArea textArea = new JTextArea();
		textArea.setText(sA.animalBox.getSelectedItem().toString());
		textArea.setEditable(false);
		textArea.setFont(new Font("Mv Boli", Font.PLAIN, 16));
		JPanel textPanel = new JPanel();
		textPanel.setSize(1200, 200);
		textPanel.add(textArea);
		frame.add(textPanel);
		frame.setVisible(true);
		
	}

}
