import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewMultAnswer {

	private JFrame frame;
	private JTextField textField;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void newMultAnsScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMultAnswer window = new NewMultAnswer();
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
	public NewMultAnswer() {
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
		
		JLabel lblHowManyQuestions = new JLabel("How Many Questions?");
		lblHowManyQuestions.setBounds(158, 11, 187, 14);
		frame.getContentPane().add(lblHowManyQuestions);
		
		textField = new JTextField();
		textField.setBounds(168, 36, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAddQuestions = new JButton("Add Questions & Answers");
		btnAddQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddQMA.newQMA(Integer.parseInt(textField.getText())-1);
			}
		});
		btnAddQuestions.setBounds(88, 67, 257, 84);
		frame.getContentPane().add(btnAddQuestions);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(165, 162, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
