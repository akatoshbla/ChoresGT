import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dialog;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class Login extends JDialog {
	private JPasswordField passwordField;
	private char[] correctPassword = {'1','2','3','4','5'};

	/**
	 * Create the panel.
	 */
	public Login(int action) {
		setTitle("Login");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblPassword = new JLabel("Enter password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPassword.setBounds(10, 37, 430, 37);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					final char[] password = passwordField.getPassword();
					if (Arrays.equals(password, correctPassword)) {
						//System.out.println("Password is correct!");
						nextModal(action);
					} else {
						JOptionPane.showMessageDialog(null, "The password you have entered is not correct!");
						passwordField.setText("");
					}
				}
			}
		});
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		passwordField.setBounds(134, 113, 191, 37);
		getContentPane().add(passwordField);
	}
	
	private void nextModal(int modal) {
		this.setVisible(false);
		GameTime gameTime;
		AllowanceMoney allowanceMoney;
		switch (modal) {
			case 1: 
				gameTime = new GameTime("add");
				gameTime.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
				gameTime.setVisible(true);
				break;
			case 2: 
				allowanceMoney = new AllowanceMoney("add");
				allowanceMoney.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
				allowanceMoney.setVisible(true);
				break;
			case 3: 
				gameTime = new GameTime("remove");
				gameTime.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
				gameTime.setVisible(true);;
				break;
			case 4: 
				allowanceMoney = new AllowanceMoney("remove");
				allowanceMoney.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
				allowanceMoney.setVisible(true);
				break;
			default: ;
				break;
		}
	}
}
