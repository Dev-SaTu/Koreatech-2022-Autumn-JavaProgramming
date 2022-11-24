package JavaPractice;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JavaPractice11_02 {

	JFrame frame = null;

	@SuppressWarnings("serial")
	public JavaPractice11_02() {

		frame = new JFrame() {{
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
									fw.close();
								} catch (Exception ex) {
									ex.printStackTrace();
								}
							} else {
								JOptionPane.showMessageDialog(this, "입력한 텍스트가 없습니다.", "에러", JOptionPane.WARNING_MESSAGE);
							}
						});
					}});
					add(new JMenuItem("열기") {{
						addActionListener(e -> {
							FileDialog fileDialog = new FileDialog(frame, "파일 열기", FileDialog.LOAD);
							fileDialog.setVisible(true);
							String filePath = fileDialog.getDirectory() + fileDialog.getFile();
							if (fileDialog.getFile() != null) {
								try {
									FileReader fr = new FileReader(new File(filePath));
									int c = -1;
									while ((c = fr.read()) != -1) {
										area.append(String.format("%c", (char) c));
									}
									fr.close();
								} catch (Exception ex) {
									ex.printStackTrace();
								}
							}
						});
					}});
				}});
			}});
			add(scroll);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(400, 300);
			setLocationRelativeTo(null);
			setVisible(true);
		}};

	}



	public static void main(String[] args) {

		new JavaPractice11_02();

	}

}
