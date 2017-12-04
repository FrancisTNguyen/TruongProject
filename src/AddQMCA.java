import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.String;
import javax.swing.JLabel;

public class AddQMCA {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNext;
	private int mcCounter;
	private JTextField textField_2;
	private List<String> possibleAnswers;


	/**
	 * Launch the application.
	 */
	public static void newQMCA(int x) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQMCA window = new AddQMCA(x);
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
	public AddQMCA(int x) {
		mcCounter = x;
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
		textField.setBounds(10, 115, 414, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 42, 414, 31);
		frame.getContentPane().add(textField_1);
		
		ArrayList<MultipleChoiceQuestion> myMC = new ArrayList();
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> possibleAnswers =  Arrays.asList(textField.getText().split("\\s*,\\s*"));
				List<String> correctAns = Arrays.asList(textField_2.getText());
				MultipleChoiceQuestion tempMultChoice = new MultipleChoiceQuestion(textField_1.getText(), correctAns.get(0), possibleAnswers);
				myMC.add(tempMultChoice);

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				if(mcCounter == 0) {
					for(int i = 0; i < myMC.size(); i++) {
						AddQuestions.myQuiz.addQuestion(myMC.get(i));
						//System.out.println(AddQuestions.myQuiz.getQuestion(i).askQuestion());
						//System.out.println(AddQuestions.myQuiz.getQuestion(i).getAnswer());
					}
					frame.dispose();
				}
				mcCounter --;
			}
		});
		btnNext.setBounds(335, 228, 89, 23);
		frame.getContentPane().add(btnNext);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 189, 414, 39);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddQuestion = new JLabel("Add Question");
		lblAddQuestion.setBounds(10, 11, 71, 14);
		frame.getContentPane().add(lblAddQuestion);
		
		JLabel lblAddAnswers = new JLabel("Add Answers");
		lblAddAnswers.setBounds(10, 84, 71, 14);
		frame.getContentPane().add(lblAddAnswers);
		
		JLabel lblWhatIsThe = new JLabel("What Is The Correct Answer?");
		lblWhatIsThe.setBounds(10, 165, 149, 14);
		frame.getContentPane().add(lblWhatIsThe);
	}
}
