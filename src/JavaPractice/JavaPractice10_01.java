package JavaPractice;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JavaPractice10_01 {

	@SuppressWarnings("serial")
	public JavaPractice10_01() {

		JFrame frame = new JFrame() {{
			setBounds(0, 0, 640, 480);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}};

		new Thread(() -> {

			frame.setTitle("Run");
			frame.getContentPane().setBackground(Color.yellow);

			try {
				Thread.sleep(1000 * 10);
			} catch (Exception e) {}

			frame.setTitle("Stop");
			frame.getContentPane().setBackground(Color.blue);

		}).start();

		new JFrame() {{
			add(new WalkingLabel());
			setBounds(640, 0, 640, 480);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}};

		new JFrame() {{
			JLabel label = new JLabel("00:00:00");
			label.setFont(new Font(label.getFont().getName(), Font.ITALIC, 64));
			add(label);
			setBounds(640 * 2, 0, 640, 480);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			new Thread(() -> {
				while(true) {
					label.setText(new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()));
				}
			}).start();
		}};

	}

	public static void main(String[] args) {

		new JavaPractice10_01();

	}

}

@SuppressWarnings("serial")
class WalkingLabel extends JLabel implements Runnable {

	private String text = "혹시 지각이라도 인정되나요ㅠㅠ";

	public WalkingLabel() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		int idx = 0;
		while(true) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
			setText(text.substring(0, idx++));
			if (idx == text.length()) {
				idx = 0;
			}
		}
	}

}