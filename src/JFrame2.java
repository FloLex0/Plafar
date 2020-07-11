

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;

public class JFrame2 extends JFrame {

	public JPanel contentPane;
	public JTable tableCos;
	public Object table1;
	public Object table11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame2 frame = new JFrame2();
					frame.setVisible(true);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		tableCos = new JTable();
		tableCos.setSurrendersFocusOnKeystroke(true);
		tableCos.setFillsViewportHeight(true);
		tableCos.setColumnSelectionAllowed(true);
		tableCos.setCellSelectionEnabled(true);
		tableCos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableCos.setToolTipText("\r\n");
		tableCos.setModel(new DefaultTableModel(
			new Object[][] {
				{"Produs", "Pret"},
			},
			new String[] {
				"New column", "New column"
			}
		));
		tableCos.setBounds(59, 50, 322, 128);
		contentPane.add(tableCos);
		
		JLabel lblCheckout = new JLabel("COS DE CUMPARATURI");
		lblCheckout.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 26));
		lblCheckout.setBounds(102, 13, 279, 35);
		contentPane.add(lblCheckout);
		
		JButton btnCumpara = new JButton("Cumpara! ");
		btnCumpara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try{
		                //the file path
		               File file = new File("C:\\Users\\Florin\\Desktop\\Myfolder\\txtfile.txt");
		               //if the file not exist create one
		               if(!file.exists()){
		                   file.createNewFile();
		               }
		               
		               FileWriter fw = new FileWriter(file.getAbsoluteFile());
		               BufferedWriter bw = new BufferedWriter(fw);
		               
		               //loop for jtable rows
		               for(int i = 0; i < tableCos.getRowCount(); i++){
		                   //loop for jtable column
		                   for(int j = 0; j < tableCos.getColumnCount(); j++){
		                       bw.write(tableCos.getModel().getValueAt(i, j)+" ");
		                   }
		                   //break line at the begin 
		                   //break line at the end 
		                   bw.newLine();
		               }
		               //close BufferedWriter
		               bw.close();
		               //close FileWriter 
		               fw.close();
		               JOptionPane.showMessageDialog(null, "Produsul a fost cumparat ! ");
		               
		               }catch(Exception ex){
		                   ex.printStackTrace();
		               }
		           }
		        });
				
				
	
		btnCumpara.setBounds(129, 179, 121, 38);
		contentPane.add(btnCumpara);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Florin\\Desktop\\shopping-cart-1026507_960_720.jpg"));
		label.setBounds(0, 0, 713, 681);
		contentPane.add(label);
		 
	  
		
	}
}
