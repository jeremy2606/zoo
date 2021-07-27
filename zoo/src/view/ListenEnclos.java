package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ListenEnclos implements ActionListener{

	ShowEncloses sE;
	
	ListenEnclos(ShowEncloses sE) {
		this.sE = sE;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame = new JFrame("Our enclose id: " + (sE.enclosBox.getSelectedIndex()+1));
		frame.setSize(500, 200);
		JTextArea textArea = new JTextArea();
		textArea.setText(sE.enclosBox.getSelectedItem().toString());
		textArea.setEditable(false);
		textArea.setFont(new Font("Mv Boli", Font.PLAIN, 16));
		JPanel textPanel = new JPanel();
		textPanel.setSize(500, 200);
		textPanel.add(textArea);
		frame.add(textPanel);
		frame.setVisible(true);
	}
}
