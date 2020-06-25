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
		JLabel label = new JLabel("Some text"); // 레이블 글자를 표시하는데 쓰임 표시하는데로 주로 쓰임
		JButton btn1 = new JButton("Click me!!");
		JButton btn2 = new JButton("Exit");
		JTextArea txtArea = new JTextArea(); // 따로 뒤에 않넣어줘도 됨
		JTextField txtField = new JTextField(200); // 뒤에 숫자를 넣어줘야함 숫자만큼 글자가 들어감
		// Field는 한 줄 정도 Area는 그 이상 많은 글씨 넣을 때
		JPanel btnPanel = new JPanel();

		panel.setLayout(new BorderLayout()); // 자기원하는 위치에 놔두는 기능

		btnPanel.add(btn1);
		btnPanel.add(btn2);
		// border layout 원하는 곳에 놔둘 수 있음
		panel.add(label, BorderLayout.NORTH);
//		panel.add(btn1, BorderLayout.WEST);
		panel.add(btnPanel, BorderLayout.WEST);
		panel.add(txtArea, BorderLayout.CENTER);

		btn1.addActionListener(new ActionListener() {

			// 클릭했을 때 하게되는 거
			@Override
			public void actionPerformed(ActionEvent e) {
				// txtArea.append("You are amazing\n");
				label.setText(txtArea.getText());
			}

		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // 프로그램 종료
			}

		});

		// 패널은 프레임 안에 프레임이라고 보면됨 다양하게 쓰임
		// panel.add(new JLabel("Welcome this lecture"));

		frame.add(panel); // 이렇게 넣어줘야함

		frame.setResizable(false); // 크기 조절 가능한지
		frame.setVisible(true); // 원래는 바로 안보임 true해줘야 보임
		frame.setPreferredSize(new Dimension(640, 480)); // 원하는 사이즈 출력
		// 꼭 이 사이즈대로 나오는 건 아니고 이 사이즈와 최대한 비슷하게 나옴
		frame.setSize(640, 480);
		frame.setLocationRelativeTo(null); // 어떤 위치에서 프로그램 나올지 null 넣으면 가운데서 나옴
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 화면 끄면 프로그램 종료되는 거
	}
}
