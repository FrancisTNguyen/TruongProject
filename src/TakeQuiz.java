import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class TakeQuiz {

	private JFrame frame;
	private int tempCnt;

	/**
	 * Launch the application.
	 */
	public static void quizFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TakeQuiz window = new TakeQuiz();
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
	public TakeQuiz() {
		tempCnt = 0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblQuestion = new JLabel("Question:");
		lblQuestion.setBounds(10, 11, 114, 14);
		frame.getContentPane().add(lblQuestion);
		
		JLabel lblNewLabel = new JLabel(FileChooser1.QuizTaking.getQuestionObject(tempCnt).askQuestion());
		lblNewLabel.setBounds(10, 30, 400, 110);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(20, 187, 390, 46);
		frame.getContentPane().add(textArea_1);
		
		
		JLabel lblEnterAnswerifMultiple = new JLabel("Enter Answer(If multiple answer separate by comma)");
		lblEnterAnswerifMultiple.setBounds(10, 162, 414, 14);
		frame.getContentPane().add(lblEnterAnswerifMultiple);
		
		JButton btnNextQuestion = new JButton("Next Question");
		btnNextQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check for correctness
				Question tempObj = FileChooser1.QuizTaking.getQuestionObject(tempCnt);
				
				boolean testUserAns = true;
				if(textArea_1.getText().contains(",")) {
					List<String> userAns = Arrays.asList(textArea_1.getText().split("\\s*,\\s*"));
					for(int i = 0; i<userAns.size(); i++) {
						if(!tempObj.getAnswer().toLowerCase().contains(userAns.get(i).toLowerCase())) {
							testUserAns = false;
							System.out.println("Incorrect");
							NotCorrect.IsntCorrect(tempCnt);
						}
					}
					System.out.println("correct");
					CorrectOrNot.isCorrect();
				}
				else if(textArea_1.getText().toLowerCase().contains(tempObj.getAnswer().toLowerCase())){
					if(tempObj.getAnswer().contains(",")) {
						List<String> possibleAnswers = Arrays.asList(tempObj.getAnswer().split("\\s*,\\s*"));
						System.out.println(possibleAnswers);
						boolean correctness = true;	// might need it later
						for(int i = 0; i < possibleAnswers.size(); i++) {
							if(!textArea_1.getText().contains(possibleAnswers.get(i))) {
								System.out.println("Incorrect");
								NotCorrect.IsntCorrect(tempCnt);
							}
						}
						System.out.println("Correct");
						CorrectOrNot.isCorrect();
					}
					else {
						System.out.println("Correct");
						CorrectOrNot.isCorrect();
					}
				}
				else{
					System.out.println("Incorrect");
					NotCorrect.IsntCorrect(tempCnt);
				}

				tempCnt++;
				
				if(tempCnt == FileChooser1.QuizTaking.size()) {
					tempCnt = 1;
					frame.dispose();
				}
				else {
					lblNewLabel.setText(FileChooser1.QuizTaking.getQuestionObject(tempCnt).askQuestion());	//next question
					textArea_1.setText("");
				}
			}
		});
		btnNextQuestion.setBounds(278, 244, 132, 23);
		frame.getContentPane().add(btnNextQuestion);
	}
}
