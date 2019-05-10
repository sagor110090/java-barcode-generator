
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;


public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField text_1;
	private String br = null;
	private JTextField text_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		text_1 = new JTextField();
		text_1.setBounds(192, 78, 171, 26);
		contentPane.add(text_1);
		text_1.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x =Integer.valueOf(text_2.getText());
				Main main = new Main();
				main.barcode(text_1.getText(),x);
			}
		});
		btnOk.setBounds(186, 181, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblCodeNo = new JLabel("Code No :");
		lblCodeNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCodeNo.setBounds(71, 78, 111, 26);
		contentPane.add(lblCodeNo);
		
		text_2 = new JTextField();
		text_2.setColumns(10);
		text_2.setBounds(192, 119, 171, 26);
		contentPane.add(text_2);
		
		JLabel lblCodeNo_1 = new JLabel("Number of code :");
		lblCodeNo_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCodeNo_1.setBounds(39, 119, 143, 26);
		contentPane.add(lblCodeNo_1);
	}
}
