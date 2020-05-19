import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

	private JFrame frmChores;
	private Child elijah;
	private Child gracie;
	private JLabel lblTime_1;
	private JLabel lblTime_2;
	private JLabel lblMoney_1;
	private JLabel lblMoney_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmChores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private Main() {
		elijah = new Child("elijah");
		gracie = new Child("gracie");
		initialize();
		Runnable runnable = new Runnable() {

			public void run() {
				while (true) {
					// ------- code for task to run
					System.out.println("Hello !!");
					// ------- ends here
					try {
						update();
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}
	
    private static Main _app;

    public static Main getSharedApplication() 
    {
        if (_app == null)
            _app = new Main();
        return _app;
    }
	
	protected Child getChild(int index) {
		if (index == 0) {
			return elijah;
		}
		else {
			return gracie;
		}
	}
	
	protected void update() {
		try {
			Path filepath = new File("children.dat").toPath();
			List<String> list = Files.readAllLines(filepath);
			
			String[] lines = list.toArray(new String[]{});
			//System.out.println(lines[0]);
			for (String line : lines) {
				if (line.substring(0, line.indexOf(",")).equals("elijah")) {
					String time = line.substring(line.indexOf(",") + 1, line.lastIndexOf(","));
					String money = line.substring(line.lastIndexOf(",") + 1, line.length());
					lblTime_1.setText("Game Time = " + time + " minutes");
					lblMoney_1.setText("Allowance Money = $" + money);
				} else {
					String time = line.substring(line.indexOf(",") + 1, line.lastIndexOf(","));
					String money = line.substring(line.lastIndexOf(",") + 1, line.length());
					lblTime_2.setText("Game Time = " + time + " minutes");
					lblMoney_2.setText("Allowance Money = $" + money);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChores = new JFrame();
		frmChores.setTitle("Chores 1.0");
		frmChores.setBounds(100, 100, 450, 300);
		frmChores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmChores.setJMenuBar(menuBar);
		
		JMenu mnAddTimemoney = new JMenu("Add");
		menuBar.add(mnAddTimemoney);
		
		JMenuItem mntmGameTime = new JMenuItem("Game Time");
		mntmGameTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Login login = new Login(1);
				login.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
				login.setVisible(true);
			}
		});
		mnAddTimemoney.add(mntmGameTime);
		
		JMenuItem mntmAllowanceMoney = new JMenuItem("Allowance Money");
		mntmAllowanceMoney.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Login login = new Login(2);
				login.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
				login.setBounds(100, 100, 450, 300);
				login.setVisible(true);
			}
		});
		mnAddTimemoney.add(mntmAllowanceMoney);
		
		JMenu mnRemove = new JMenu("Remove");
		menuBar.add(mnRemove);
		
		JMenuItem mntmGameTime_1 = new JMenuItem("Game Time");
		mntmGameTime_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Login login = new Login(3);
				login.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
				login.setBounds(100, 100, 450, 300);
				login.setVisible(true);
			}
		});
		mnRemove.add(mntmGameTime_1);
		
		JMenuItem mntmAllowanceMoney_1 = new JMenuItem("Allowance Money");
		mntmAllowanceMoney_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Login login = new Login(4);
				login.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
				login.setBounds(100, 100, 450, 300);
				login.setVisible(true);
			}
		});
		mnRemove.add(mntmAllowanceMoney_1);
		frmChores.getContentPane().setLayout(null);
		
		JLabel lblChild_1 = new JLabel("Elijah");
		lblChild_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblChild_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblChild_1.setBounds(10, 0, 414, 43);
		frmChores.getContentPane().add(lblChild_1);
		
		lblTime_1 = new JLabel("Game Time = " + elijah.getTime() + " minutes");
		lblTime_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime_1.setBounds(10, 49, 414, 22);
		frmChores.getContentPane().add(lblTime_1);
		
		lblMoney_1 = new JLabel("Allowance Money = $" + elijah.getMoney());
		lblMoney_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoney_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMoney_1.setBounds(10, 82, 414, 22);
		frmChores.getContentPane().add(lblMoney_1);
		
		JLabel lblChild_2 = new JLabel("Gracie");
		lblChild_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblChild_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblChild_2.setBounds(10, 115, 414, 27);
		frmChores.getContentPane().add(lblChild_2);
		
		lblTime_2 = new JLabel("Game Time = " + gracie.getTime() + " minutes");
		lblTime_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime_2.setBounds(10, 153, 414, 22);
		frmChores.getContentPane().add(lblTime_2);
		
		lblMoney_2 = new JLabel("Allowance Money = $" + gracie.getMoney());
		lblMoney_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoney_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMoney_2.setBounds(10, 186, 414, 22);
		frmChores.getContentPane().add(lblMoney_2);
	}
}
