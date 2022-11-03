package JavaPractice;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JavaPractice08_02 {



	@SuppressWarnings("serial")
	public JavaPractice08_02() {

		// #1
		new JFrame("마우스") {{
			JLabel label = new JLabel("자바는", JLabel.CENTER);
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					label.setText("자바는");
				}
				@Override
				public void mouseExited(MouseEvent e) {
					label.setText("재밌다");
				}
			});
			add(label);
			setSize(300, 200);
			setVisible(true);
		}};

		// #2
		new JFrame("드래깅동안 YELLOW로 변경") {{
			getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					getContentPane().setBackground(Color.yellow);
				}

			});
			getContentPane().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					getContentPane().setBackground(Color.green);
				}
			});
			setSize(300, 200);
			setVisible(true);
		}};

		// #3
		new JFrame("클릭 연습") {{
			JLabel label = new JLabel("C", JLabel.CENTER);
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					label.setLocation(new Random().nextInt(300), new Random().nextInt(200));
				}
			});
			getContentPane().setLayout(null);
			label.setBounds(50, 50, 20, 20);
			add(label);
			setSize(300, 200);
			setVisible(true);
		}};

		// #4
		new JFrame("Java") {{
			getContentPane().setLayout(new GridLayout(4, 3));
			JLabel[] labels = new JLabel[12];
			for (int i = 0; i < labels.length; i++) {
				final int idx = i;
				labels[idx] = new JLabel(String.format("%d", i));
				labels[idx].setOpaque(true);
				labels[idx].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						labels[idx].setBackground(new Color(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256)));
					}
				});
				add(labels[idx]);
			}
			setSize(300, 200);
			setVisible(true);
		}};

	}

	public static void main(String[] args) {

		new JavaPractice08_02();

	}

}
