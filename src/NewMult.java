import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewMult {

	private JFrame frame;
	private JTextField textField;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void newMultScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMult window = new NewMult();
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
	public NewMult() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnHowManyQuestions = new JTextPane();
		txtpnHowManyQuestions.setText("How Many Questions?");
		txtpnHowManyQuestions.setBounds(158, 11, 164, 20);
		frame.getContentPane().add(txtpnHowManyQuestions);
		
		textField = new JTextField();
		textField.setBounds(168, 42, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Questions and Answers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddQMCA.newQMCA(Integer.parseInt(textField.getText())-1);
			}
		});
		btnNewButton.setBounds(103, 73, 219, 70);
		frame.getContentPane().add(btnNewButton);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(168, 154, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
