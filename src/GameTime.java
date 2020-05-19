import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameTime extends JDialog {
	private JTextField textField;
	
	public GameTime(String mode) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel;
		JButton btnNewButton;
		if (mode.equals("add")) {
			setTitle("Add Game Time");
			lblNewLabel = new JLabel("Add Game Time");
			btnNewButton = new JButton("Add");
		} else {
			setTitle("Remove Game Time");
			lblNewLabel = new JLabel("Remove Game Time");
			btnNewButton = new JButton("Remove");
		}
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 414, 31);
		getContentPane().add(lblNewLabel);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 26));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Elijah", "Gracie"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 85, 132, 68);
		getContentPane().add(list);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField.setBounds(152, 85, 125, 68);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		//JButton btnNewButton = new JButton("Remove");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (mode.equals("add")) {
					Main main = Main.getSharedApplication();
					Child child = main.getChild(list.getSelectedIndex());
					//System.out.println(Integer.parseInt(child.getTime()) + Integer.parseInt(textField.getText()));
					//default icon, custom title
					int n = JOptionPane.showConfirmDialog(
					    null,
					    "Are you sure you would like to increase " + child.getName() + "'s game time by " + textField.getText(),
					    "Confirmation",
					    JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						child.setTime(Integer.parseInt(child.getTime()) + Integer.parseInt(textField.getText()));
					}
				} else {
					if (mode.equals("remove")) {
						Main main = Main.getSharedApplication();
						Child child = main.getChild(list.getSelectedIndex());
						//System.out.println(Integer.parseInt(child.getTime()) + Integer.parseInt(textField.getText()));
						//default icon, custom title
						int n = JOptionPane.showConfirmDialog(
						    null,
						    "Are you sure you would like to decrease " + child.getName() + "'s game time by " + textField.getText(),
						    "Confirmation",
						    JOptionPane.YES_NO_OPTION);
						if (n == JOptionPane.YES_OPTION) {
							child.setTime(Integer.parseInt(child.getTime()) - Integer.parseInt(textField.getText()));
						}
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.setBounds(287, 85, 137, 68);
		getContentPane().add(btnNewButton);

	}
}
