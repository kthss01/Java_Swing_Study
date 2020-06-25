import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ImageButton {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageButton window = new ImageButton();
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
	public ImageButton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 830, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 814, 439);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setSelectedIcon(new ImageIcon("D:\\eclipse-workspace\\Swing_Practice\\image\\btn.png"));
		btnNewButton.setIcon(new ImageIcon("D:\\eclipse-workspace\\Swing_Practice\\image\\btn.png"));
		btnNewButton.setPressedIcon(new ImageIcon("D:\\eclipse-workspace\\Swing_Practice\\image\\btn2.png"));
		btnNewButton.setBounds(302, 188, 220, 72);
		panel.add(btnNewButton);
	}

}
