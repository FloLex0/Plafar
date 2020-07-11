import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseWheelListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.MouseWheelEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;

public class flori {

	private JFrame frame;
	private JTextField DenumireLBL;
	private JTextField CantitateLBL;
	private JTable tlbModel;
	private JTextField PretLBL;
	private JTextField CantitateDoritaLBL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					flori window = new flori();
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
	public flori() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model= (DefaultTableModel) tlbModel.getModel();	
				
				DenumireLBL.setText(model.getValueAt(tlbModel.getSelectedRow(), 0).toString());
				CantitateLBL.setText(model.getValueAt(tlbModel.getSelectedRow(), 1).toString());
				PretLBL.setText(model.getValueAt(tlbModel.getSelectedRow(), 2).toString());
				
			}
		});
		frame.setBounds(100, 100, 1016, 741);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDenumire = new JLabel("Denumire");
		lblDenumire.setBounds(94, 121, 183, 27);
		lblDenumire.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 23));
		
		JLabel lblPret = new JLabel("Pret");
		lblPret.setBounds(101, 161, 147, 42);
		lblPret.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 23));
		
		JLabel lblCantitate = new JLabel("Cantitate");
		lblCantitate.setBounds(89, 216, 164, 45);
		lblCantitate.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 23));
		
		DenumireLBL = new JTextField();
		DenumireLBL.setBounds(259, 127, 288, 22);
		DenumireLBL.setColumns(10);
		
		CantitateLBL = new JTextField();
		CantitateLBL.setBounds(259, 231, 290, 22);
		CantitateLBL.setColumns(10);
		
		
		
		
		JButton btnNewButton = new JButton("Adauga");
		btnNewButton.setBounds(297, 300, 106, 33);
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model= (DefaultTableModel) tlbModel.getModel();	
				if(!DenumireLBL.getText().trim().equals("")) {
				model.addRow(new Object[] {DenumireLBL.getText(),PretLBL.getText(),CantitateLBL.getText()});
				
			}else {
				JOptionPane.showMessageDialog(null, "Continut neintrodus");
			}
			}
		});
		
		JButton btnDelete = new JButton("Sterge");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				DefaultTableModel model= (DefaultTableModel) tlbModel.getModel();	
				
				if(tlbModel.getSelectedRow()==-1) {
					if(tlbModel.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "Tabela este goala");
					}else {
						JOptionPane.showMessageDialog(null, "Trebuie sa alegi ceva !!! ");
					}
				}else {
					model.removeRow(tlbModel.getSelectedRow());
				}
			
				
				
				
		
				
				
			}
		});
		btnDelete.setBounds(425, 301, 138, 31);
		
		tlbModel = new JTable();
		tlbModel.setShowVerticalLines(false);
		tlbModel.setShowHorizontalLines(false);
		tlbModel.setShowGrid(false);
		tlbModel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i= tlbModel.getSelectedRow();
	
			}
		});
		tlbModel.setBounds(139, 392, 475, 165);
		tlbModel.setFont(new Font("Arial Unicode MS", Font.BOLD, 17));
		tlbModel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tlbModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tlbModel.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		
		PretLBL = new JTextField();
		PretLBL.setBounds(259, 175, 290, 22);
		PretLBL.setColumns(10);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblDenumire);
		frame.getContentPane().add(lblCantitate);
		frame.getContentPane().add(lblPret);
		frame.getContentPane().add(PretLBL);
		frame.getContentPane().add(CantitateLBL);
		frame.getContentPane().add(DenumireLBL);
		frame.getContentPane().add(btnDelete);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(tlbModel);
		
		
		tlbModel.setBackground(Color.GRAY);
		tlbModel.setForeground(Color.white);
		Font font = new Font(" ",1,22);
		tlbModel.setRowHeight(30);
		tlbModel.setFont(font);
		JButton btnNewButton_1 = new JButton("Importa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String filePath = "C:\\Users\\Florin\\Desktop\\Myfolder\\tablou.txt";
				
		        try {
		        	
		        	File file= new File(filePath);
		        	BufferedReader br = new BufferedReader(new FileReader(file));
		            
		            
		            // get the first line
		            // get the columns name from the first line
		            // set columns name to the jtable model
		            String firstLine = br.readLine().trim();
		            String[] columnsName = firstLine.split(",");
		            int j= tlbModel.getSelectedRow();
		            DefaultTableModel model = (DefaultTableModel)tlbModel.getModel();
		           
		            model.setColumnIdentifiers(columnsName);
		            // get lines from txt file
		            Object[] tableLines = br.lines().toArray();
		            
		            // extratct data from lines
		            // set data to jtable model
		            for(int i = 0; i < tableLines.length; i++)
		            {
		                String line = tableLines[i].toString().trim();
		                String[] dataRow = line.split("/");
		                model.addRow(dataRow);
		            }
		            
		            
		        } catch (Exception ex) {
		            Logger.getLogger(flori.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        
		    } 

			
		});
		
		
		btnNewButton_1.setBounds(165, 300, 112, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(763, 392, 29, -110);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(scrollPane);
		
		


		
		JButton Export_Rows = new JButton("Vizualizeaza cosul ! ");
		Export_Rows.setFont(new Font("Segoe Print", Font.BOLD, 18));
		Export_Rows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model= (DefaultTableModel) tlbModel.getModel();	
	
				int a = Integer.parseInt(CantitateLBL.getText());
				int b = Integer.parseInt(CantitateDoritaLBL.getText());
				int ans= a-b;
				
				
				CantitateLBL.setText(Integer.toString(ans));
				
				JFrame2 frm2 = new JFrame2();
		        DefaultTableModel elena = (DefaultTableModel)frm2.tableCos.getModel();
				TableModel model1 = tlbModel.getModel();
				   
		        int []indexs = tlbModel.getSelectedRows();
		        
		        Object[] rows = new Object[20];
		        
		        frm2.setVisible(true);
		     
		
		        int j= tlbModel.getSelectedRow();
		       
		        
		        for(int i = 0; i < indexs.length; i++)
		        {
		            rows[0] = model1.getValueAt(j, 0);
		            rows[1] = model1.getValueAt(j,1);
		        
		            
		           elena.addRow(rows);
		        }
		        
		       
			}
			
		});
		Export_Rows.setBounds(259, 570, 227, 73);
		frame.getContentPane().add(Export_Rows);
		
		JLabel lblPlafar = new JLabel("PLAFAR");
		lblPlafar.setForeground(Color.BLACK);
		lblPlafar.setFont(new Font("Pristina", Font.BOLD, 77));
		lblPlafar.setBounds(585, 83, 312, 147);
		frame.getContentPane().add(lblPlafar);
		
		JButton btnUpdate = new JButton(" Vezi Detalii PRODUS");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model= (DefaultTableModel) tlbModel.getModel();	
				int i = tlbModel.getSelectedRow();
				if (i>=0) {
				
			DenumireLBL.setText(model.getValueAt(i,0).toString());
			PretLBL.setText(tlbModel.getValueAt(i,1).toString());
			CantitateLBL.setText(tlbModel.getValueAt(i,2).toString());
				}
				else {
				System.out.println("Error Update");
				}
				}
			
		});
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpdate.setBounds(233, 345, 264, 34);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblCantitateaDorita = new JLabel("Cantitatea dorita: ");
		lblCantitateaDorita.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 24));
		lblCantitateaDorita.setBounds(611, 187, 160, 31);
		frame.getContentPane().add(lblCantitateaDorita);
		
		CantitateDoritaLBL = new JTextField();
		CantitateDoritaLBL.setBounds(621, 231, 137, 22);
		frame.getContentPane().add(CantitateDoritaLBL);
		CantitateDoritaLBL.setColumns(10);
		
		JButton btnAdaugaInCos = new JButton("Adauga in cos ! ");
		btnAdaugaInCos.addActionListener(new ActionListener() {
		       	
				JFrame2 frm2 = new JFrame2();
		        DefaultTableModel elena = (DefaultTableModel)frm2.tableCos.getModel();
			public void actionPerformed(ActionEvent arg0) {
				TableModel model1 = tlbModel.getModel();
				   
		        int []indexs = tlbModel.getSelectedRows();
		        
		        Object[] rows = new Object[5];
		        
		        frm2.setVisible(false);
		     
		
		        int j= tlbModel.getSelectedRow();
		       
		        
		        for(int i = 0; i < indexs.length; i++)
		        {
		            rows[0] = model1.getValueAt(j, 0);
		            rows[1] = model1.getValueAt(j,1);
		        
		            
		           elena.addRow(rows);
		        }
			
			}
			
		     
			  }
		);

		
		 
		btnAdaugaInCos.setBounds(575, 301, 160, 31);
		frame.getContentPane().add(btnAdaugaInCos);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(12, 271, 920, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Florin\\Desktop\\background-farmacia-13.jpg"));
		lblNewLabel.setBounds(0, 0, 932, 694);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
