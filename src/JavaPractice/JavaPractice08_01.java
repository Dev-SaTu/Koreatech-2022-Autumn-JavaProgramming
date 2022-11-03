package JavaPractice;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JavaPractice08_01 {

	@SuppressWarnings("serial")
	public JavaPractice08_01() {

		// #1
		new JFrame("Let's study Java") {{
			setSize(400, 200);
			setVisible(true);
		}};

		// #2
		new JFrame("FlowLayout Practice") {{
			getContentPane().setLayout(new FlowLayout());
			getContentPane().add(new JLabel("100 + 200"));
			getContentPane().add(new JButton("="));
			getContentPane().add(new JLabel("300"));
			setSize(400, 200);
			setVisible(true);
		}};

		// #3
		new JFrame("4×4 Color Frame") {{
			getContentPane().setLayout(new GridLayout(4, 4));
			Color[] colors = new Color[] {
					Color.black, Color.blue, Color.cyan, Color.darkGray,
					Color.gray, Color.green, Color.lightGray, Color.magenta,
					Color.orange, Color.pink, Color.red, Color.white,
					Color.yellow, Color.black, Color.blue, Color.cyan
			};
			for (int i = 0; i < colors.length; i++) {
				final int idx = i;
				getContentPane().add(new JPanel() {{
					setBackground(colors[idx]);
					add(new JLabel(String.format("%d", idx)));
				}});
			}
			setSize(400, 200);
			setVisible(true);
		}};

	}

	public static void main(String[] args) {

		new JavaPractice08_01();

	}

}
