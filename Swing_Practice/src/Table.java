import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Table Prac");
		JPanel panel = new JPanel();

		// JTable���� �� ���� �Ķ���Ͱ� �� (data, heading)
		String[] headings = new String[] {"Id", "Name", "Country"};
		Object[][] data = new Object[][] {
			{"1", "Danniel", "Korea"},
			{"2", "Sunny", "France"},
			{"3", "John", "Japan"}
		};
		
		JTable table = new JTable(data, headings);
		table.setPreferredScrollableViewportSize(new Dimension(700, 600)); // setSize�� ���� ����� �� ���ϴ� ������ �־��ָ� ��, dimension���� �־������
		table.setFillsViewportHeight(true); // setVisible�̶� ����� ����̶� �����
		
//		panel.add(table);
		panel.add(new JScrollPane(table)); // ��ũ�� �� �� �ֵ��� ���ִ� ��
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setSize(800, 640);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // ����� �߰�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
