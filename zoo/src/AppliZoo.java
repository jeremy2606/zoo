import java.awt.EventQueue;

import view.AppWindow;
import view.CreateAnimalWindow;

public class AppliZoo {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow frame = new AppWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
