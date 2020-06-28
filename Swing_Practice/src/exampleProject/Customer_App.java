package exampleProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Customer_App {

	private JFrame frame;
	private JTextField id;
	private JPasswordField password;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField birthday;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Customer customer = new Customer();

		// 파일 체크
//		File f = new File("D:/git/Java_Swing_Study/Swing_Practice/image/Welcome2.jpg");
//		System.out.println(f.exists()?"Exist":"doesn't exists");

		frame = new JFrame();
//		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("./image/Welcome2.jpg").getImage()); // 이렇게하면 design에서 못찾아서 안보여줌 -> 직접 경로 써줘야한다고함
		ImagePanel welcomePanel = new ImagePanel(
				new ImageIcon("D:/git/Java_Swing_Study/Swing_Practice/image/Welcome2.jpg").getImage());
		welcomePanel.setBounds(0, 0, 1018, 649);
		frame.setSize(welcomePanel.getWidth(), welcomePanel.getHeight());
		frame.getContentPane().setLayout(null);
//		String[][] data = new String[][] {{"1","2","3"},{"4","5","6"}};
		String[][] data = customer.getCustomers2();
		String[] headers = new String[] { "Name", "Phone", "Gender", "Age", "Note" };

		ImagePanel tablePanel = new ImagePanel(
				new ImageIcon("D:/git/Java_Swing_Study/Swing_Practice/image/List.png").getImage());
		tablePanel.setBounds(0, 0, 1018, 626);
		tablePanel.setVisible(false);

		ImagePanel mainPanel = new ImagePanel(
				new ImageIcon("D:/git/Java_Swing_Study/Swing_Practice/image/Register.png").getImage());
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 1018, 649);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablePanel.setVisible(false);
				mainPanel.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnNewButton_2.setIcon(new ImageIcon("D:\\git\\Java_Swing_Study\\Swing_Practice\\image\\RegisterButton.png"));
		btnNewButton_2.setBounds(2, 47, 183, 47);
		tablePanel.add(btnNewButton_2);

		tablePanel.setLayout(null);
		JTable table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif", Font.BOLD, 15));
		table.setAlignmentX(0); // 자동 정렬
		table.setSize(800, 450);
		table.setPreferredScrollableViewportSize(new Dimension(800, 500));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(211, 97, 671, 434);
		tablePanel.add(scrollPane);
		frame.getContentPane().add(tablePanel);

		search = new JTextField();
		search.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
		search.setBounds(211, 32, 671, 34);
		tablePanel.add(search);
		search.setColumns(10);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) { // 키 눌렀을 때
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel()); // 칸 비어두면 자동으로 TableModel로 인식함
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});

		TableColumnModel columnModels = table.getColumnModel();



		JLabel lblNewLabel = new JLabel("Welcome This is Main Panel");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.BOLD, 25));
		lblNewLabel.setBounds(304, 33, 391, 44);
		mainPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Leelawadee UI", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(174, 122, 149, 44);
		mainPanel.add(lblNewLabel_1);

		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Leelawadee UI", Font.PLAIN, 21));
		lblAge.setBounds(204, 202, 79, 44);
		mainPanel.add(lblAge);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Leelawadee UI", Font.PLAIN, 21));
		lblGender.setBounds(188, 290, 135, 44);
		mainPanel.add(lblGender);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Leelawadee UI", Font.PLAIN, 21));
		lblPhone.setBounds(500, 122, 149, 44);
		mainPanel.add(lblPhone);

		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setFont(new Font("Leelawadee UI", Font.PLAIN, 21));
		lblBirthday.setBounds(500, 208, 149, 44);
		mainPanel.add(lblBirthday);

		JLabel lblNote = new JLabel("Note");
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setFont(new Font("Leelawadee UI", Font.PLAIN, 21));
		lblNote.setBounds(500, 296, 149, 44);
		mainPanel.add(lblNote);

		name = new JTextField();
		name.setBounds(327, 122, 158, 44);
		mainPanel.add(name);
		name.setColumns(10);

		age = new JTextField();
		age.setColumns(10);
		age.setBounds(327, 208, 158, 44);
		mainPanel.add(age);

		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(683, 122, 185, 44);
		mainPanel.add(phone);

		birthday = new JTextField();
		birthday.setColumns(10);
		birthday.setBounds(683, 208, 185, 44);
		mainPanel.add(birthday);

		JComboBox gender = new JComboBox(new String[] { "Male", "Female" });
		gender.setFont(new Font("Leelawadee UI", Font.PLAIN, 19));
		gender.setBounds(327, 291, 158, 44);
		mainPanel.add(gender);

		JTextArea note = new JTextArea();
		// note.setBackground(new Color(255, 250, 240));
		note.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // 경계선 만들어줌
		note.setBounds(683, 284, 185, 163);
		mainPanel.add(note);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				// String bTxt = birthday.getText(); // 테이블에 모르고 않넣음
				String genderTxt = gender.getSelectedItem().toString();
				String noteTxt = note.getText();
				// Customer 클래스에 데이터를 저장하면 됨

				customer.createCustomer(nameTxt, phoneTxt, genderTxt, ageTxt, noteTxt);
				// JOptionPane.showMessageDialog(null, "Your data has been saved
				// successfully.");
				mainPanel.setVisible(false);
			}
		});
		btnNewButton.setBounds(456, 461, 158, 60);
		mainPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				tablePanel.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\git\\Java_Swing_Study\\Swing_Practice\\image\\ListButton.png"));
		btnNewButton_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnNewButton_1.setBounds(27, 122, 135, 44);
		mainPanel.add(btnNewButton_1);
		columnModels.getColumn(0).setPreferredWidth(100);
		columnModels.getColumn(2).setPreferredWidth(50);
		columnModels.getColumn(3).setPreferredWidth(20);
		frame.getContentPane().add(welcomePanel);

		JLabel lblLogin = new JLabel("Log In");
		lblLogin.setFont(new Font("Leelawadee UI", Font.BOLD, 30));
		lblLogin.setBounds(665, 68, 131, 47);
		welcomePanel.add(lblLogin);

		id = new JTextField();
		id.setFont(new Font("Leelawadee UI", Font.PLAIN, 24));
		id.setToolTipText("Enter ID");
		id.setBounds(665, 120, 260, 47);
		welcomePanel.add(id);
		id.setColumns(10);

		password = new JPasswordField();
		password.setBounds(665, 177, 260, 47);
		welcomePanel.add(password);

		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Leelawadee UI", Font.PLAIN, 30));
		lblId.setBounds(581, 120, 72, 45);
		welcomePanel.add(lblId);

		JLabel lblPwd = new JLabel("Pwd :");
		lblPwd.setFont(new Font("Leelawadee UI", Font.PLAIN, 30));
		lblPwd.setBounds(581, 179, 72, 45);
		welcomePanel.add(lblPwd);

		JButton btnLogin = new JButton("");
		btnLogin.setSelectedIcon(null);
		btnLogin.setIcon(new ImageIcon("D:\\git\\Java_Swing_Study\\Swing_Practice\\image\\login3.png"));
		btnLogin.setPressedIcon(new ImageIcon("D:\\git\\Java_Swing_Study\\Swing_Practice\\image\\login2.png"));
		btnLogin.setBounds(665, 236, 260, 45);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(id.getText());
//				System.out.println(password.getText());
//				System.out.println(String.valueOf(password.getPassword()));

				if (id.getText().equals("Danny") && Arrays.equals(password.getPassword(), "hello".toCharArray())) {
					System.out.println("Welcome Danny");
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
			}
		});

		welcomePanel.add(btnLogin);
		frame.setJMenuBar(menuBar());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");

		bar.add(fileMenu);
		bar.add(aboutMenu);

		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // 시스템 종료
			}
		});

		return bar;
	}
}

class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		// 이거 해줘야 이미지 크기 맞음
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}

	public int getWidth() {
		return img.getWidth(null);
	}

	public int getHeight() {
		return img.getHeight(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
