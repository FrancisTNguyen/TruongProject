import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddQuestions {

	private JFrame frame;
	static Quiz myQuiz;	// this is the main quiz; the one that you're gonna save onto a file; contains
						// all the questions mc/frq/mca

	/**
	 * Launch the application.
	 */
	public static void QuestionInsert() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestions window = new AddQuestions();
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
	public AddQuestions() {
		myQuiz = new Quiz("Quiz"+Integer.toString(QuizMaker.quizNumber));
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
		
		JButton btnAddFreeResponse = new JButton("Add Free Response Questions");
		btnAddFreeResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewFRQ newScreen = new NewFRQ();
				NewFRQ.newScreen();
			}
		});
		btnAddFreeResponse.setBounds(90, 67, 271, 23);
		frame.getContentPane().add(btnAddFreeResponse);
		
		JButton btnAddMultipleChoice = new JButton("Add Multiple Choice Questions");
		btnAddMultipleChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewMult newMultScreen = new NewMult();
				NewMult.newMultScreen();
			}
		});
		btnAddMultipleChoice.setBounds(90, 101, 271, 23);
		frame.getContentPane().add(btnAddMultipleChoice);
		
		JButton btnAddMultipleAnswers = new JButton("Add Multiple Answers Questions");
		btnAddMultipleAnswers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewMultAnswer newMultAnsScreen = new NewMultAnswer();
				NewMultAnswer.newMultAnsScreen();
			}
		});
		btnAddMultipleAnswers.setBounds(90, 135, 271, 23);
		frame.getContentPane().add(btnAddMultipleAnswers);
		
		JButton btnNewButton = new JButton("Finish Creating Quiz");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < myQuiz.size(); i++) {
					System.out.println(AddQuestions.myQuiz.getQuestionObject(i).askQuestion());
					System.out.println(AddQuestions.myQuiz.getQuestionObject(i).getAnswer());
				}
				myQuiz.save();
			}
		});
		btnNewButton.setBounds(90, 169, 271, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
