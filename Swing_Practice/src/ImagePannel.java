import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		// �̰� ����� �̹��� ũ�� ���� 
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null))); 
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}

public class ImagePannel {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Lesson 4");
		frame.setSize(640, 480);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// �̹��� ���������� �̹��� �ҷ���
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/sample.jpg").getImage()); 
		// ���� üũ
//		File f = new File("./image/sample.jpg");
//		System.out.println(f.exists()?"Exist":"doesn't exists");
		
		frame.add(panel);
		frame.pack(); // panel�� �̹��� �����  �°� ������ ������ ���� 
		
	}
}
