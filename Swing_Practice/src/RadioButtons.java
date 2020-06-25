import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtons {

	public static void main(String[] args) {
		JFrame frame = new JFrame("RadioButtons");
		JPanel panel = new JPanel();
		JRadioButton korBtn = new JRadioButton("Korean");
		JRadioButton engBtn = new JRadioButton("English");
		JRadioButton chnBtn = new JRadioButton("Chinese"); // 중국어 약어 chn cn

		ButtonGroup group = new ButtonGroup();

		korBtn.setActionCommand("kor"); // 유저가 보는 것과 다른 실제 눌렀을 때 정보라고 보면됨
		engBtn.setActionCommand("eng");
		chnBtn.setActionCommand("chn");

		// 이건 그룹핑만 해준거 패널에는 따로 추가해줘야함
		group.add(korBtn);
		group.add(engBtn);
		group.add(chnBtn);

		Font font = new Font("Arial", Font.BOLD, 24);
		korBtn.setFont(font);
		engBtn.setFont(font);
		chnBtn.setFont(font);

		engBtn.setSelected(true); // 처음에 선택되게 하는거

		korBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("Korea Selected");
				// getSelection은 선택된 라디오버튼
				System.out.println(group.getSelection().getActionCommand());
			}

		});

		panel.add(korBtn);
		panel.add(engBtn);
		panel.add(chnBtn);

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
