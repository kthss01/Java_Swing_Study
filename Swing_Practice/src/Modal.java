import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Modal extends JDialog {
	public Modal(Window parent, JLabel label) {
		super(parent, "Modal Practice", ModalityType.APPLICATION_MODAL);
		setSize(400, 260);
		setLayout(null); // absolute layout¿Ã∂Û∞Ì ∫∏∏È µ…µÌ
		JLabel lb = new JLabel("Enter Text");
		lb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb.setBounds(100, 30, 100, 50); // x, y, x size, y size
		JTextField field = new JTextField(10);
		field.setBounds(100, 80, 200, 60);

		JButton btn = new JButton("Change");
		btn.setBounds(100, 150, 200, 40);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(field.getText());
				dispose(); // Modal¿Ã ≤®¡¸
			}
		});
		
		add(btn);
		add(field);
		add(lb);
	}
}
