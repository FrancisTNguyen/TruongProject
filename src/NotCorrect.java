import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NotCorrect {

	private JFrame frame;
	private int questionNumber;

	/**
	 * Launch the application.
	 */
	public static void IsntCorrect(int n) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotCorrect window = new NotCorrect(n);
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
	public NotCorrect(int n) {
		questionNumber = n;
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
		
		JLabel lblIncorrect = new JLabel("Incorrect");
		lblIncorrect.setBounds(144, 11, 103, 14);
		frame.getContentPane().add(lblIncorrect);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}

		});
		btnBack.setBounds(307, 228, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblCorrectAnswerIs = new JLabel("Correct Answer Is: " + FileChooser1.QuizTaking.getQuestionObject(questionNumber).getAnswer());
		lblCorrectAnswerIs.setBounds(105, 54, 164, 14);
		frame.getContentPane().add(lblCorrectAnswerIs);
	}

}
