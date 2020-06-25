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
		JRadioButton chnBtn = new JRadioButton("Chinese"); // �߱��� ��� chn cn

		ButtonGroup group = new ButtonGroup();

		korBtn.setActionCommand("kor"); // ������ ���� �Ͱ� �ٸ� ���� ������ �� ������� �����
		engBtn.setActionCommand("eng");
		chnBtn.setActionCommand("chn");

		// �̰� �׷��θ� ���ذ� �гο��� ���� �߰��������
		group.add(korBtn);
		group.add(engBtn);
		group.add(chnBtn);

		Font font = new Font("Arial", Font.BOLD, 24);
		korBtn.setFont(font);
		engBtn.setFont(font);
		chnBtn.setFont(font);

		engBtn.setSelected(true); // ó���� ���õǰ� �ϴ°�

		korBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("Korea Selected");
				// getSelection�� ���õ� ������ư
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
