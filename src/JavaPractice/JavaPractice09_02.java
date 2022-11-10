package JavaPractice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JavaPractice09_02 {

	private double w = 100.0, h = 100.0;
	
	@SuppressWarnings("serial")
	public JavaPractice09_02() {

		/*
		 * #1
		 */

		JPanel panel = new JPanel() {

			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				g.setColor(Color.blue);
				g.drawOval(100, 100, 100, 100);

				g.setColor(Color.black);
				g.drawOval(220, 100, 100, 100);

				g.setColor(Color.red);
				g.drawOval(340, 100, 100, 100);

				g.setColor(Color.yellow);
				g.drawOval(160, 140, 100, 100);

				g.setColor(Color.green);
				g.drawOval(280, 140, 100, 100);

			}

		};

		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		/*
		 * #2
		 */

		new JFrame() {{

			JPanel panel = new JPanel() {
				
				Image image = Toolkit.getDefaultToolkit().getImage("resource/img1.jpg");
				
				@Override
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(image, 10, 10, (int) w, (int) h, this);
				}
			};

			addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 107) {
						System.out.println("+");
						w *= 1.1;
						h *= 1.1;
					} else if (e.getKeyCode() == 109) {
						System.out.println("-");
						w *= 0.9;
						h *= 0.9;
					}
					panel.repaint();
				}
			});

			setContentPane(panel);
			setSize(640, 480);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);

		}};

	}



	public static void main(String[] args) {

		new JavaPractice09_02();

	}

}
