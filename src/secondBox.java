import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class secondBox {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					secondBox window = new secondBox();
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
	public secondBox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 616, 475);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(465, 75, -177, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Medicamente");
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 34));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flori flori= new flori();
				
			
			}
		});
		btnNewButton_1.setBounds(162, 161, 243, 65);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnChitanta = new JButton("Chitanta");
		btnChitanta.setBounds(367, 212, -143, 89);
		frame.getContentPane().add(btnChitanta);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Florin\\Desktop\\wave-background-with-electrocardiogram_1017-8766.jpg"));
		label.setBounds(-22, 0, 715, 436);
		frame.getContentPane().add(label);
	    frame.setVisible(true);
	
	
	  
	
	}
}
