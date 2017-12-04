import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddQMA {

	private JFrame frame;
	private int maCounter;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void newQMA(int y) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQMA window = new AddQMA(y);
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
	public AddQMA(int y) {
		maCounter = y;
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
		
		JLabel lblAddQuestion = new JLabel("Add Question");
		lblAddQuestion.setBounds(10, 11, 101, 14);
		frame.getContentPane().add(lblAddQuestion);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 414, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAddAnswer = new JLabel("Add Answer");
		lblAddAnswer.setBounds(10, 86, 101, 14);
		frame.getContentPane().add(lblAddAnswer);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 111, 414, 39);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblWhatAreThe = new JLabel("What Are The Correct Answers?");
		lblWhatAreThe.setBounds(10, 161, 263, 14);
		frame.getContentPane().add(lblWhatAreThe);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 186, 414, 39);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		ArrayList<MultipleChoiceQuestion> myMA = new ArrayList();
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> possibleAnswers =  Arrays.asList(textField_1.getText().split("\\s*,\\s*"));
				List<String> correctAns = Arrays.asList(textField_2.getText());
				MultipleChoiceQuestion tempMultChoice = new MultipleChoiceQuestion(textField.getText(), correctAns, possibleAnswers);
				myMA.add(tempMultChoice);

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				if(maCounter == 0) {
					for(int i = 0; i < myMA.size(); i++) {
						AddQuestions.myQuiz.addQuestion(myMA.get(i));
						//System.out.println(AddQuestions.myQuiz.getQuestionObject(i).askQuestion());
						//System.out.println(AddQuestions.myQuiz.getQuestionObject(i).getMultipleAnswers());
					}
					frame.dispose();
				}
				maCounter --;
			}
		});
		btnNext.setBounds(282, 228, 89, 23);
		frame.getContentPane().add(btnNext);
	}

}
