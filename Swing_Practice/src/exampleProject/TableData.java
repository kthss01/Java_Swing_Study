package exampleProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

public class TableData extends AbstractTableModel {

	private String[] headers;
	private List<Customer2> list;

	public TableData() {
		headers = new String[5];
		updateList();
	}

	public void updateList() {
		boolean fileExists = new File("./data.csv").exists();
		FileWriter fw;
		try {
			fw = new FileWriter("./data.csv", true);
			if(!fileExists) {
				fw.append("Name,Age,Phone,Gender,Note\r\n");
			}
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		list = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File("./data.csv"));
			for (int i = 0; sc.hasNextLine(); i++) {
				String[] data = sc.nextLine().split(",");
				if (i == 0) {
					headers = data;
					continue;
				}
				Customer2 c = new Customer2();
				CustomerBuilder cb = new CustomerBuilder(c);
				c = cb.name(data[0]).phone(data[1]).gender(data[2]).age(data[3]).note(data[4]).customer();
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] getHeaders() {
		return headers;
	}
	
	public String[][] getCustomers() {
		ArrayList<String[]> temp = new ArrayList<String[]>();
		for (Customer2 c : list) {
			temp.add(c.getCustomer());
		}
		String[][] arr = new String[temp.size()][5];
		return temp.toArray(arr);
	}

	@Override
	public int getRowCount() {
		// 행 갯수 반환
		return list.size();
	}

	@Override
	public int getColumnCount() {
		// 열 갯수 반환
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// x행y열 받아 값 반환
		switch (columnIndex) {
		case 0:
			return list.get(rowIndex).getName();
		case 1:
			return list.get(rowIndex).getPhone();
		case 2:
			return list.get(rowIndex).getGender();
		case 3:
			return list.get(rowIndex).getAge();
		case 4:
			return list.get(rowIndex).getNote();
		}
		return null;
	}

	public void refresh() {
		updateList();
	}
	
}
