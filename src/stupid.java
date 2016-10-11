import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class stupid {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stupid window = new stupid();
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
	public stupid() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 410, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(112, 0, 284, 33);
		frame.getContentPane().add(panel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 111, 212);
		frame.getContentPane().add(panel_1);
		
		JLabel lblUsername = new JLabel("Username");
		panel_1.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel();
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("H:\\resources\\player1_m.png"));
		
		JScrollPane myScroll = new JScrollPane();
		JTextArea textArea = new JTextArea();
		myScroll.setBounds(122, 36, 262, 163);
		myScroll.add(textArea);
		frame.getContentPane().add(myScroll);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	
	}
}
