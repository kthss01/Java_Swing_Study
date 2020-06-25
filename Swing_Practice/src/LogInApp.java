import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInApp extends JFrame {
	public LogInApp() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel pswrd = new JLabel("Password : ");
		JTextField txtID = new JTextField(10);
		JPasswordField txtPass = new JPasswordField(10); // JPasswordField 입력할 때 비빌번호처럼 보이게
		JButton logBtn = new JButton("Log In");

		panel.add(label);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);

		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "Dan";
				String pass = "1234";

//				String test = txtPass.getPassword().toString(); // 이렇게하면 char[] -> string으로 안됨
				String test = String.valueOf(txtPass.getPassword()); // getText대신 이거 쓰자
				
				if (id.equals(txtID.getText()) && pass.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "You have loggend in successfully");
				} else {
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
			}

		});
		add(panel);

		setVisible(true); // gui 보이게
		setSize(600, 400); // 크기 조정
		setLocationRelativeTo(null); // 가운데서 뜨게
		setResizable(false); // 크기 조정 불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 화면 끄면 프로그램 종료되게
	}

	public static void main(String[] args) {
		new LogInApp();
	}
}
