package TermProject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

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
	JButton btnNewButton_4;
	JComboBox<String> comboBox;
	JButton btnNewButton_5;
	JPanel schedulePanel;
	JPanel panel_2;
	JScrollPane scrollPane;
	JPanel panel_5;
	JButton btnNewButton_8;
	JButton btnNewButton_9;
	JLabel lblNewLabel_7;
	JScrollPane scrollPane_2;
	JTable selectedTable;
	JTable searchedTable;
	JButton btnNewButton_6;

	/** table header */
	final String[] header = { "\uCF54\uB4DC", "\uACFC\uBAA9\uBA85", "\uBD84\uBC18", "\uAD50\uC218\uB2D8",
			"\uB300\uC0C1", "\uD559\uC810", "\uBE44\uACE0", "\uC815\uC6D0", "\uC124\uACC4",
	"\uAC1C\uC124\uD559\uBD80" };

	/** department map */
	final Map<String, String> departmentMap = new HashMap<String, String>() {
		{
			put("컴공", "컴퓨터공학부");
			put("디공,건축", "디자인ㆍ건축공학부");
			put("기계", "기계공학부");
			put("전전통", "전기ㆍ전자ㆍ통신공학부");
			put("에신화", "에너지신소재화학공학부");
			put("산경", "산업경영학부");
			put("메카", "메카트로닉스공학부");
			put("교양학부", "교양학부");
			put("HRD학과", "HRD학과");
			put("융합", "융합학과");
		}
	};

	/** all subject */
	private List<JSONArray> allSubject = new ArrayList<JSONArray>();

	/** searched subject */
	private List<JSONArray> searchedSubject = new ArrayList<JSONArray>();

	/** selected subject */
	private List<JSONArray> selectedSubject = new ArrayList<JSONArray>();

	/** selected subject color */
	private List<Color> selectedSubjectColor = new ArrayList<Color>();

	/** same name subject */
	private List<JSONArray> samenameSubject = new ArrayList<JSONArray>();

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
		gbl_contentPane.columnWidths = new int[] { 0, 484, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 645, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

		lblNewLabel_1 = new JLabel("데이터 갱신일 : 2022-07-24");
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
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnNewButton_4.doClick();
				}
			}

		});
		panel.add(textField);
		textField.setColumns(20);

		btnNewButton_4 = new JButton("검색");
		btnNewButton_4.addActionListener(e -> 코드과목명검색());
		panel.add(btnNewButton_4);

		comboBox = new JComboBox<String>();
		comboBox.addActionListener(e -> 개설학부검색());
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "개설학부", "컴공", "디공,건축", "기계", "전전통", "에신화", "산경", "메카", "교양학부", "HRD학과", "융합" }));
		panel.add(comboBox);

		btnNewButton_5 = new JButton("과목담기");
		btnNewButton_5.addActionListener(e -> 과목담기());
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
		btnNewButton.addActionListener(e -> 문의정보());
		panel_1.add(btnNewButton);

		btnNewButton_1 = new JButton("이미지 저장");
		btnNewButton_1.addActionListener(e -> {
			try {
				이미지저장();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		panel_1.add(btnNewButton_1);

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_2.add(scrollPane, gbc_scrollPane);

		searchedTable = new JTable();
		searchedTable.setShowGrid(true);
		searchedTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchedTable.setModel(new DefaultTableModel(new Object[][] {}, header) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		searchedTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON1) {
					if (e.getClickCount() == 1) {
						schedulePanel.repaint(); // temp
					} else if (e.getClickCount() >= 2) {
						과목담기();
					}
				}

			}

		});
		searchedTable.getTableHeader().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON1) {

				}

			}

		});
		scrollPane.setViewportView(searchedTable);

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
		btnNewButton_8.addActionListener(e -> 과목빼기());
		panel_5.add(btnNewButton_8);

		btnNewButton_9 = new JButton("초기화");
		btnNewButton_9.addActionListener(e -> 초기화());
		panel_5.add(btnNewButton_9);

		lblNewLabel_7 = new JLabel("수강학점 : 0");
		panel_5.add(lblNewLabel_7);

		btnNewButton_6 = new JButton("과목추천");
		btnNewButton_6.addActionListener(e -> 과목추천());
		panel_5.add(btnNewButton_6);

		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 2;
		panel_2.add(scrollPane_2, gbc_scrollPane_2);

		selectedTable = new JTable();
		selectedTable.setShowGrid(true);
		selectedTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectedTable.setModel(new DefaultTableModel(new Object[][] {}, header) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		selectedTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON1) {
					if (e.getClickCount() >= 2) {
						과목빼기();
					}
				}

			}

		});
		selectedTable.getTableHeader().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON1) {

				}

			}

		});
		scrollPane_2.setViewportView(selectedTable);

		schedulePanel = new JPanel() {

			private String[] dayArray = { "월요일", "화요일", "수요일", "목요일", "금요일" };
			private SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm");
			private Calendar calendar = Calendar.getInstance();

			@Override
			public void paintComponent(Graphics g) {

				// Setting
				Graphics2D g2 = (Graphics2D) g;
				super.paintComponent(g2);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				// Background
				g2.setColor(Color.white);
				g2.fillRect(0, 0, getWidth(), getHeight());

				// Grid
				g2.setColor(Color.black);
				g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

				for (int i = 1; i < 20; i++) {
					g2.drawLine(0, i * getHeight() / 20, getWidth(), i * getHeight() / 20);
				}

				for (int i = 1; i < 19; i++) {
					g2.drawString(String.format("%02d%s", (i + 1) / 2, (i - 1) % 2 == 0 ? "A" : "B"), 9,
							22 + i * getHeight() / 20);
					calendar.setTimeInMillis(1800000 * (i - 1));
					g2.drawString(dateFormatter.format(calendar.getTime()), 45, 22 + i * getHeight() / 20);
				}

				for (int i = 1; i < 6; i++) {
					g2.drawLine(i * getWidth() / 6, 0, i * getWidth() / 6, getHeight());
					g2.drawString(dayArray[i - 1], 22 + i * getWidth() / 6, 22);
				}

				g2.drawLine(getWidth() / 6 / 2, getHeight() / 20, getWidth() / 6 / 2,
						getHeight() - getHeight() / 20 - 1);
				g2.drawString("이후", 28, getHeight() - 12);

				// Schedule
				for (JSONArray array : selectedSubject) {
					g2.setColor(selectedSubjectColor.get(selectedSubject.indexOf(array)));
					JSONArray schedule = array.getJSONArray(10);
					Map<Integer, Integer[]> dayMap = new HashMap<Integer, Integer[]>();
					for (int i = 0; i < schedule.length(); i++) {
						int code = schedule.getInt(i);
						int day = code / 100;
						int time = code % 100;
						if (!dayMap.containsKey(day)) {
							dayMap.put(day, new Integer[] {Integer.MAX_VALUE, 0});
						}
						dayMap.put(day, new Integer[] {Math.min(dayMap.get(day)[0], time), Math.max(dayMap.get(day)[1], time)});
						g2.fillRect((day + 1) * getWidth() / 6 + 1, (time + 1) * getHeight() / 20 + 1, getWidth() / 6, getHeight() / 20 + 1);
					}
					g2.setColor(Color.black);
					g2.setStroke(new BasicStroke(2));
					for (int day : dayMap.keySet()) {
						g2.drawRect((day + 1) * getWidth() / 6, (dayMap.get(day)[0] + 1) * getHeight() / 20, getWidth() / 6, (dayMap.get(day)[1] - dayMap.get(day)[0] + 1) * getHeight() / 20 + 1);	
					}
				}

				if (searchedTable.getSelectedRow() != -1) {

					String 과목명 = searchedTable.getValueAt(searchedTable.getSelectedRow(), searchedTable.getColumnModel().getColumnIndex("과목명")).toString();
					String 분반 = searchedTable.getValueAt(searchedTable.getSelectedRow(), searchedTable.getColumnModel().getColumnIndex("분반")).toString();
					// temp 밖으로 옮기기
					
					List<JSONArray> sameNameSubject = new ArrayList<JSONArray>();

					for (JSONArray subject : allSubject) {
						if (subject.getString(1).equals(과목명)) {
							sameNameSubject.add(subject);
						}
					}

					System.out.println();
					
					for (JSONArray array : sameNameSubject) {
						
						JSONArray schedule = array.getJSONArray(10);
						Map<Integer, Integer[]> dayMap = new HashMap<Integer, Integer[]>();
						for (int i = 0; i < schedule.length(); i++) {
							int code = schedule.getInt(i);
							int day = code / 100;
							int time = code % 100;
							if (!dayMap.containsKey(day)) {
								dayMap.put(day, new Integer[] {Integer.MAX_VALUE, 0});
							}
							dayMap.put(day, new Integer[] {Math.min(dayMap.get(day)[0], time), Math.max(dayMap.get(day)[1], time)});
						}
						g2.setColor(Color.red);
						g2.setStroke(new BasicStroke(분반.equals(array.getString(2)) ? 4 : 2));
						for (int day : dayMap.keySet()) {
							g2.drawRect((day + 1) * getWidth() / 6, (dayMap.get(day)[0] + 1) * getHeight() / 20, getWidth() / 6, (dayMap.get(day)[1] - dayMap.get(day)[0] + 1) * getHeight() / 20 + 1);	
						}
						
						System.out.println(schedule);
						
					}

				}

			}

		};
		GridBagConstraints gbc_schedulePanel_2 = new GridBagConstraints();
		gbc_schedulePanel_2.fill = GridBagConstraints.BOTH;
		gbc_schedulePanel_2.gridx = 1;
		gbc_schedulePanel_2.gridy = 3;
		contentPane.add(schedulePanel, gbc_schedulePanel_2);

		try {
			init();
		} catch (JSONException | IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void init() throws JSONException, IOException, InterruptedException {

		/*
		 * get hanpyo data
		 */

		getHanpyoData();

		/*
		 * read file
		 */

		readSubjectDataFile();

		/*
		 * set table data
		 */

		reloadTable(searchedTable, allSubject);
		reloadTable(selectedTable, selectedSubject);

	}

	/**
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws InterruptedException
	 */

	private void getHanpyoData() throws MalformedURLException, IOException, InterruptedException {

		Document doc = Jsoup.parse(new URL("https://github.com/zetagate/hanpyo/tree/gh-pages/dbt"), 0);
		Elements e = doc.getElementsByClass("js-navigation-open Link--primary");
		String jsdName = e.attr("title");
		String date = jsdName.substring(3, jsdName.indexOf('.'));

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(
						String.format("https://raw.githubusercontent.com/zetagate/hanpyo/gh-pages/dbt/%s", jsdName)))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		String body = response.body();

		File file = new File("resource/subject_data");
		OutputStream output = new FileOutputStream(file, false);
		output.write(body.getBytes());
		output.close();

		lblNewLabel_1.setText(String.format("데이터 갱신일 : 20%s-%s-%s", date.substring(0, 2), date.substring(2, 4), date.substring(4, 6)));

	}

	/**
	 * @throws JSONException
	 * @throws IOException
	 */

	private void readSubjectDataFile() throws JSONException, IOException {

		File file = new File("resource/subject_data");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.charAt(0) == '[') {
				JSONArray array = new JSONArray(line);
				allSubject.add(array);
				searchedSubject.add(array);
			}
		}

		br.close();

	}

	/**
	 * @param table
	 * @param data
	 */

	private void reloadTable(JTable table, List<JSONArray> data) {

		String[][] dataMatrix = new String[data.size()][header.length];
		int[] dataSeq = { 0, 1, 2, 8, 3, 5, 4, 9, 6, 7 };

		for (int i = 0; i < dataMatrix.length; i++) {
			JSONArray array = data.get(i);
			for (int j = 0; j < header.length; j++) {
				dataMatrix[i][j] = array.getString(dataSeq[j]);
			}
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				((DefaultTableModel) table.getModel()).setDataVector(dataMatrix, header);
				table.getColumn("과목명").setMinWidth(200);
			}
		});

	}

	/**
	 * @param message
	 */

	private void showMessage(String message) {

		JOptionPane.showMessageDialog(this, message);

	}

	private void 개설학부검색() {

		searchedSubject.clear();

		String item = (String) comboBox.getSelectedItem();

		if (item.equals("개설학부")) {
			for (JSONArray array : allSubject) {
				searchedSubject.add(array);
			}
		} else {
			for (JSONArray array : allSubject) {
				String department = array.getString(7);
				if (department.equals(departmentMap.get(item))) {
					searchedSubject.add(array);
				}
			}
		}

		reloadTable(searchedTable, searchedSubject);

	}

	private void 코드과목명검색() {

		comboBox.setSelectedIndex(0);
		searchedSubject.clear();

		String text = textField.getText().toUpperCase();

		for (JSONArray array : allSubject) {
			String code = array.getString(0);
			String name = array.getString(1);
			if (code.contains(text) || name.contains(text)) {
				searchedSubject.add(array);
			}
		}

		reloadTable(searchedTable, searchedSubject);

	}

	private void 과목담기() {

		if (searchedTable.getSelectedRow() != -1) {

			// temp 오름차순, 내림차순 생각하면 검색해야 함!
			selectedSubject.add(searchedSubject.get(searchedTable.getSelectedRow()));
			selectedSubjectColor.add(new Color(new Random().nextInt(128), new Random().nextInt(128), new Random().nextInt(128)));

			schedulePanel.repaint();
			reloadTable(selectedTable, selectedSubject);
			수강학점계산();

		}

	}

	private void 과목빼기() {

		if (selectedTable.getSelectedRow() != -1) {

			// temp 오름차순, 내림차순 생각하면 검색해야 함!
			selectedSubject.remove(selectedTable.getSelectedRow());
			selectedSubjectColor.remove(selectedTable.getSelectedRow());

			schedulePanel.repaint();
			reloadTable(selectedTable, selectedSubject);
			수강학점계산();

		}

	}

	private void 초기화() {

		selectedSubject.clear();
		selectedSubjectColor.clear();

		schedulePanel.repaint();
		reloadTable(selectedTable, selectedSubject);
		수강학점계산();

	}

	private void 수강학점계산() {

		int sum = 0;

		for (JSONArray array : selectedSubject) {
			sum += Integer.parseInt(array.getString(5));
		}

		lblNewLabel_7.setText(String.format("수강학점 : %d", sum));

	}

	private void 과목추천() {

	}

	private void 문의정보() {

		new InquiryDialog();

	}

	/**
	 * @throws IOException
	 */

	private void 이미지저장() throws IOException {

		BufferedImage bi = new BufferedImage(schedulePanel.getWidth(), schedulePanel.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		schedulePanel.paint(g);
		g.dispose();

		File outputfile = new File(String.format("%s/Desktop/table.png", System.getProperty("user.home")));
		ImageIO.write(bi, "png", outputfile);

	}

}
