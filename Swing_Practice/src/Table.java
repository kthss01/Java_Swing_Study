import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Table Prac");
		JPanel panel = new JPanel();

		// JTable에는 두 가지 파라미터가 들어감 (data, heading)
		String[] headings = new String[] {"Id", "Name", "Country"};
		Object[][] data = new Object[][] {
			{"1", "Danniel", "Korea"},
			{"2", "Sunny", "France"},
			{"3", "John", "Japan"}
		};
		
		JTable table = new JTable(data, headings);
		table.setPreferredScrollableViewportSize(new Dimension(700, 600)); // setSize랑 거의 비슷한 거 원하는 사이즈 넣어주면 됨, dimension으로 넣어줘야함
		table.setFillsViewportHeight(true); // setVisible이랑 비슷한 기능이라 보면됨
		
//		panel.add(table);
		panel.add(new JScrollPane(table)); // 스크롤 할 수 있도록 해주는 거
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setSize(800, 640);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // 가운데서 뜨게
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
