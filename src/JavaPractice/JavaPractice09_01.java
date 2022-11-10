package JavaPractice;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JavaPractice09_01 {

	@SuppressWarnings("serial")
	public JavaPractice09_01() {

		new JFrame() {{
			setTitle("4 Images");
			setLayout(new GridLayout(1, 0, 10, 0));
			ImageIcon[] images = new ImageIcon[] {
					new ImageIcon("resource/img1.jpg"),
					new ImageIcon("resource/img2.jpg"),
					new ImageIcon("resource/img3.jpg"),
					new ImageIcon("resource/img4.jpg")
			};
			for (int i = 0; i < images.length; i++) {
				add(new JLabel(images[i]));
			}
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(640, 240);
			setVisible(true);
		}};

		new JFrame() {{
			setTitle("파일 저장");
			JTextArea area = new JTextArea();
			JScrollPane scroll = new JScrollPane();
			scroll.setViewportView(area);
			setJMenuBar(new JMenuBar() {{
				add(new JMenu("파일") {{
					add(new JMenuItem("저장") {{
						addActionListener(e -> {
							if (area.getText().length() > 0) {
								String name = JOptionPane.showInputDialog("저장할 파일명을 입력하세요");
								if (name == null) {
									return;
								}
								FileWriter fw = null;
								try {
									fw = new FileWriter(new File(name));
									fw.write(area.getText());
									fw.flush();
								} catch (Exception ex) {
									ex.printStackTrace();
								}
							} else {
								JOptionPane.showMessageDialog(this, "입력한 텍스트가 없습니다.", "에러", JOptionPane.WARNING_MESSAGE);
							}
						});
					}});
				}});
			}});
			add(scroll);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(400, 300);
			setVisible(true);
		}};

	}

	public static void main(String[] args) {

		new JavaPractice09_01();

	}

}
