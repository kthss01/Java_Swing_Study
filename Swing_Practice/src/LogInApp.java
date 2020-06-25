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
		JPasswordField txtPass = new JPasswordField(10); // JPasswordField �Է��� �� �����ȣó�� ���̰�
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

//				String test = txtPass.getPassword().toString(); // �̷����ϸ� char[] -> string���� �ȵ�
				String test = String.valueOf(txtPass.getPassword()); // getText��� �̰� ����
				
				if (id.equals(txtID.getText()) && pass.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "You have loggend in successfully");
				} else {
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
			}

		});
		add(panel);

		setVisible(true); // gui ���̰�
		setSize(600, 400); // ũ�� ����
		setLocationRelativeTo(null); // ����� �߰�
		setResizable(false); // ũ�� ���� �Ұ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ȭ�� ���� ���α׷� ����ǰ�
	}

	public static void main(String[] args) {
		new LogInApp();
	}
}
