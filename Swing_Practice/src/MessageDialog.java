import javax.swing.JOptionPane;

public class MessageDialog {

	public static void main(String[] args) {

//		JOptionPane.showMessageDialog(null, "Hi"); // static이라 바로 쓸 수 있음
//		JOptionPane.showMessageDialog(null, "Hi", "Simple Title", 0); // 마지막 값은 option
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
