package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowFrame extends JFrame {
	
	ShowFrame() {
		
		JButton button = new JButton();
		button.setText("Show Encloses");
		button.setFocusable(false);
		button.addActionListener(e-> {
			new ShowEncloses();
		});
		JPanel panel1 = new JPanel();
		panel1.setSize(150, 50);
		panel1.add(button);
		JButton button2 = new JButton();
		button2.setText("Show Animals");
		button2.setFocusable(false);
		button2.addActionListener(e-> {
			new ShowAnimals();
		});
		
		JPanel panel2 = new JPanel();
		panel2.setSize(150, 50);
		panel2.add(button2);
		
		JButton button3 = new JButton();
		button3.setSize(150, 50);
		button3.setText("Add new Animal");
		button3.addActionListener(e-> {
			new CreateAnimalWindow();
		});
		
		JPanel panel4 = new JPanel();
		panel4.setSize(150, 50);
		panel4.add(button3);
		
		
		
		
		JPanel panel3 = new JPanel();
		panel3.setSize(300, 170);
		panel3.setLayout(new BorderLayout());
		panel3.add(panel1, BorderLayout.NORTH);
		panel3.add(panel2, BorderLayout.CENTER);
		panel3.add(panel4, BorderLayout.SOUTH);
		
		this.setSize(300, 170);
		this.setTitle("Zoo Show");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panel3);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ShowFrame();
	}
}

