import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GIfTest {

	public static void main(String [] args){
		JFrame window = new JFrame();
		JLabel stand = new JLabel(new ImageIcon(GIfTest.class.getClass().getResource("/stand.gif")));
		JLabel move = new JLabel(new ImageIcon(GIfTest.class.getClass().getResource("/stand.gif")));
		JLabel dead = new JLabel(new ImageIcon(GIfTest.class.getClass().getResource("/stand.gif")));
		JLabel hit = new JLabel(new ImageIcon(GIfTest.class.getClass().getResource("/stand.gif")));

		window.setLayout(new BorderLayout());
		window.setSize(500, 500);
		window.add(stand,BorderLayout.CENTER);
		window.setVisible(true);
	}
}
