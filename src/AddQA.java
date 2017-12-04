import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class AddQA {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private int counter;
	private JButton btnNext;
	private JButton btnNext_1;
	private JLabel lblAddAnswer;

	/**
	 * Launch the application.
	 */
	public static void newQA(int n) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQA window = new AddQA(n);
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
	public AddQA(int n) {
		counter = n;
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
		
		textField = new JTextField();
		textField.setBounds(10, 48, 403, 61);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 159, 403, 61);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDfk = new JLabel("Add Question");
		lblDfk.setBounds(10, 11, 79, 14);
		frame.getContentPane().add(lblDfk);
		
		ArrayList<Question> myFRQ = new ArrayList();
		
		btnNext_1 = new JButton("Next");
		btnNext_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question tempQuestion = new Question(textField.getText(), textField_1.getText());
				myFRQ.add(tempQuestion);
				textField.setText("");
				textField_1.setText("");
				if(counter == 0) {
					for(int i = 0; i < myFRQ.size(); i++) {
						AddQuestions.myQuiz.addQuestion(myFRQ.get(i));
						//System.out.println(AddQuestions.myQuiz.getQuestionObject(i).askQuestion());
						//System.out.println(AddQuestions.myQuiz.getQuestionObject(i).getAnswer());
					}
					frame.dispose();
				}
				counter --;
			}
		});
		btnNext_1.setBounds(278, 231, 89, 23);
		frame.getContentPane().add(btnNext_1);
		
		lblAddAnswer = new JLabel("Add Answer");
		lblAddAnswer.setBounds(10, 134, 99, 14);
		frame.getContentPane().add(lblAddAnswer);
		
		
	}
		
}
