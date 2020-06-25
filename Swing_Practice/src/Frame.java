import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Some text"); // ���̺� ���ڸ� ǥ���ϴµ� ���� ǥ���ϴµ��� �ַ� ����
		JButton btn1 = new JButton("Click me!!");
		JButton btn2 = new JButton("Exit");
		JTextArea txtArea = new JTextArea(); // ���� �ڿ� �ʳ־��൵ ��
		JTextField txtField = new JTextField(200); // �ڿ� ���ڸ� �־������ ���ڸ�ŭ ���ڰ� ��
		// Field�� �� �� ���� Area�� �� �̻� ���� �۾� ���� ��
		JPanel btnPanel = new JPanel();

		panel.setLayout(new BorderLayout()); // �ڱ���ϴ� ��ġ�� ���δ� ���

		btnPanel.add(btn1);
		btnPanel.add(btn2);
		// border layout ���ϴ� ���� ���� �� ����
		panel.add(label, BorderLayout.NORTH);
//		panel.add(btn1, BorderLayout.WEST);
		panel.add(btnPanel, BorderLayout.WEST);
		panel.add(txtArea, BorderLayout.CENTER);

		btn1.addActionListener(new ActionListener() {

			// Ŭ������ �� �ϰԵǴ� ��
			@Override
			public void actionPerformed(ActionEvent e) {
				// txtArea.append("You are amazing\n");
				label.setText(txtArea.getText());
			}

		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // ���α׷� ����
			}

		});

		// �г��� ������ �ȿ� �������̶�� ����� �پ��ϰ� ����
		// panel.add(new JLabel("Welcome this lecture"));

		frame.add(panel); // �̷��� �־������

		frame.setResizable(false); // ũ�� ���� ��������
		frame.setVisible(true); // ������ �ٷ� �Ⱥ��� true����� ����
		frame.setPreferredSize(new Dimension(640, 480)); // ���ϴ� ������ ���
		// �� �� �������� ������ �� �ƴϰ� �� ������� �ִ��� ����ϰ� ����
		frame.setSize(640, 480);
		frame.setLocationRelativeTo(null); // � ��ġ���� ���α׷� ������ null ������ ����� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ȭ�� ���� ���α׷� ����Ǵ� ��
	}
}
