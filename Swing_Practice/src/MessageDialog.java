import javax.swing.JOptionPane;

public class MessageDialog {

	public static void main(String[] args) {

//		JOptionPane.showMessageDialog(null, "Hi"); // static�̶� �ٷ� �� �� ����
//		JOptionPane.showMessageDialog(null, "Hi", "Simple Title", 0); // ������ ���� option
//		JOptionPane.showMessageDialog(null, "Hi", "Simple Title", JOptionPane.INFORMATION_MESSAGE);

//		int res = JOptionPane.showConfirmDialog(null, "Do you confirm?", "Fancy Title", JOptionPane.ERROR_MESSAGE);
//		if (res == JOptionPane.OK_OPTION) {
//			JOptionPane.showMessageDialog(null, "You Clicked OKAY");
//		} else if (res == JOptionPane.CANCEL_OPTION) {
//
//		} else if (res == JOptionPane.CLOSED_OPTION) {
//
//		}
		
		String input = JOptionPane.showInputDialog("What do you want to drink?");
		System.out.println(input);
	}

}
