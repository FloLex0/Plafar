import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frame;
	private JLabel lblUsername;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 726, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.CYAN);
		desktopPane.setForeground(Color.RED);
		
		frame.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);
		
		lblUsername = new JLabel("Username : ");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblUsername.setBounds(96, 147, 204, 78);
		desktopPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblPassword.setBounds(96, 238, 233, 91);
		desktopPane.add(lblPassword);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblLogin.setBounds(290, 81, 204, 68);
		desktopPane.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(329, 172, 204, 42);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 34));
		desktopPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(329, 256, 210, 42);
		desktopPane.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name= textField.getText();
				String psd= passwordField.getText();
				
				if(name.equals("admin") && psd.equals("admin"))
				{
					
					JOptionPane.showMessageDialog(frame, " logat cu succes ! ");
					frame.setFont(new Font("Tahoma", Font.BOLD, 34));
					
					secondBox second= new secondBox();
					
				}
				else {
					
					JOptionPane.showMessageDialog(frame, " Eroare la logare ! ");
					
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnLogin.setBounds(245, 334, 175, 50);
		desktopPane.add(btnLogin);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Florin\\Desktop\\videoblocks-fingerprint-access-video-internet-web-security-digital-technology-background-html-pcb-code_skpvbpswm_thumbnail-full01.png"));
		label.setBounds(0, 0, 708, 449);
		desktopPane.add(label);
		
		label_1 = new JLabel("New label");
		label_1.setBounds(604, 401, 92, 35);
		desktopPane.add(label_1);
	
	}
}
