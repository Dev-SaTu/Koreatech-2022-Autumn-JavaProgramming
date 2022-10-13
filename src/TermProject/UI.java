package TermProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

@SuppressWarnings("serial")
public class UI extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JPanel panel;
	JPanel panel_1;
	JTextField textField;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	JButton btnNewButton_4;
	JComboBox<String> comboBox;
	JButton btnNewButton_5;
	JPanel schedulePanel;
	JPanel panel_3;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	JPanel panel_2;
	JScrollPane scrollPane;
	JPanel panel_5;
	JButton btnNewButton_8;
	JButton btnNewButton_9;
	JLabel lblNewLabel_7;
	JScrollPane scrollPane_2;
	JTable selectedTable;
	JTable allTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		/*
		 * 한표(https://hanpyo.com/) 따라 만들기
		 */

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlatLightLaf.setup();
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setIconImage(new ImageIcon("resource/orange.png").getImage());
		setTitle("Hanpyo (Koreatech-2022-Autumn-JavaProgramming)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 900);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 484, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 645, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		lblNewLabel = new JLabel(new ImageIcon("resource/orange.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEADING);
		lblNewLabel.setText("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		lblNewLabel_1 = new JLabel("데이터 갱신일 : 2022-07-24 00:30");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(20);

		btnNewButton_4 = new JButton("검색");
		panel.add(btnNewButton_4);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"개설학부", "컴공", "디공,건축", "기계", "전전통", "에신화", "산경", "메카", "교양학부", "HRD학과", "융합"}));
		panel.add(comboBox);

		btnNewButton_5 = new JButton("과목담기");
		panel.add(btnNewButton_5);

		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);

		btnNewButton = new JButton("문의/정보");
		btnNewButton.addActionListener(e -> new InquiryDialog());
		panel_1.add(btnNewButton);

		btnNewButton_1 = new JButton("이미지 저장");
		panel_1.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Facebook 공유");
		panel_1.add(btnNewButton_2);

		btnNewButton_3 = new JButton("링크공유");
		panel_1.add(btnNewButton_3);

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_2.add(scrollPane, gbc_scrollPane);

		allTable = new JTable();
		allTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\uCF54\uB4DC", "\uACFC\uBAA9\uBA85", "\uBD84\uBC18", "\uAD50\uC218\uB2D8", "\uB300\uC0C1", "\uD559\uC810", "\uBE44\uACE0", "\uC815\uC6D0", "\uC124\uACC4", "\uAC1C\uC124\uD559\uBD80"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		allTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON1) {
					if (e.getClickCount() >= 2) {

					}
				}

			}

		});
		scrollPane.setViewportView(allTable);

		panel_5 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_2.add(panel_5, gbc_panel_5);

		btnNewButton_8 = new JButton("과목빼기");
		panel_5.add(btnNewButton_8);

		btnNewButton_9 = new JButton("초기화");
		panel_5.add(btnNewButton_9);

		lblNewLabel_7 = new JLabel("수강학점 : 0");
		panel_5.add(lblNewLabel_7);

		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 2;
		panel_2.add(scrollPane_2, gbc_scrollPane_2);

		selectedTable = new JTable();
		selectedTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\uCF54\uB4DC", "\uACFC\uBAA9\uBA85", "\uBD84\uBC18", "\uAD50\uC218\uB2D8", "\uB300\uC0C1", "\uD559\uC810", "\uBE44\uACE0", "\uC815\uC6D0", "\uC124\uACC4", "\uAC1C\uC124\uD559\uBD80"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_2.setViewportView(selectedTable);

		schedulePanel = new JPanel() {
			
			private String[] dayArray = {"월요일", "화요일", "수요일", "목요일", "금요일"};
			private SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm");
			private Calendar calendar = Calendar.getInstance();

			@Override
			public void paintComponent(Graphics g) {

				// Setting
				Graphics2D g2 = (Graphics2D) g;
				super.paintComponent(g2);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				// Base
				g2.setColor(Color.white);
				g2.fillRect(0, 0, getWidth(), getHeight());

				g2.setColor(Color.black);
				g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
				
				for (int i = 1; i < 20; i++) {
					g2.drawLine(0, i * getHeight() / 20, getWidth(), i * getHeight() / 20);
				}
				
				for (int i = 1; i < 19; i++) {
					g2.drawString(String.format("%02d%s", (i + 1) / 2, (i - 1) % 2 == 0 ? "A" : "B"), 9, 22 + i * getHeight() / 20);
					calendar.setTimeInMillis(1800000 * (i - 1));
					g2.drawString(dateFormatter.format(calendar.getTime()), 45, 22 + i * getHeight() / 20);
				}
				
				for (int i = 1; i < 6; i++) {
					g2.drawLine(i * getWidth() / 6, 0, i * getWidth() / 6, getHeight());
					g2.drawString(dayArray[i - 1], 22 + i * getWidth() / 6, 22);
				}
				
				g2.drawLine(getWidth() / 6 / 2, getHeight() / 20, getWidth() / 6 / 2, getHeight() - getHeight() / 20 - 1);
				g2.drawString("이후", 28, getHeight() - 12);

				// Schedule
				g2.setColor(Color.cyan);
				g2.fillRect(81, 34, 80, 65);
				g2.fillRect(162, 34, 80, 32);
				
			}

		};
		GridBagConstraints gbc_schedulePanel_2 = new GridBagConstraints();
		gbc_schedulePanel_2.insets = new Insets(0, 0, 5, 0);
		gbc_schedulePanel_2.fill = GridBagConstraints.BOTH;
		gbc_schedulePanel_2.gridx = 1;
		gbc_schedulePanel_2.gridy = 3;
		contentPane.add(schedulePanel, gbc_schedulePanel_2);

		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 4;
		contentPane.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		lblNewLabel_2 = new JLabel("<html><a href=''>책임의 한계와 법적 고지</a></html>");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblNewLabel_2.setText("<html><a href='' style=\"color: red\">책임의 한계와 법적 고지</a></html>");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel_2.setText("<html><a href=''>책임의 한계와 법적 고지</a></html>");
			}

		});
		panel_3.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("View source code (GNU GPL v3)");
		panel_3.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Powered by Github");
		panel_3.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("About open source license...");
		panel_3.add(lblNewLabel_5);

		init();

	}

	private void init() {

	}

}
