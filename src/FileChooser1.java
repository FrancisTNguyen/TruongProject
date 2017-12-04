import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JButton;

public class FileChooser1 {

	private JFrame frame;
	
	static Quiz QuizTaking;

	/**
	 * Launch the application.
	 */
	public static void ChooseFile() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileChooser1 window = new FileChooser1();
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
	public FileChooser1() {
		this.QuizTaking = new Quiz("");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 554, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setBounds(-9, 0, 537, 397);
		frame.getContentPane().add(fileChooser);
		
		int returnVal = fileChooser.showOpenDialog(this.frame.getParent());
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = fileChooser.getSelectedFile().toString();
			  try {
	            // Use this for reading the data.
	            byte[] buffer = new byte[1000];

	            FileInputStream inputStream = 
	                new FileInputStream(fileName);
	
	            String tempBuffer = "";
	            // read till end of file
	            while(inputStream.read(buffer) != -1) {
	            	tempBuffer = new String(buffer);
	            }   
	            
	            //parse buffer
	            // get number of lines
	            int startingIndex = 0;
	            ArrayList<String> tempStringList = new ArrayList();
	            
	            // convert tempBuffer (content in file) into an array
	            for(int i = 0; i < tempBuffer.length(); i++) {
	            	if(tempBuffer.charAt(i) == '\n') {
	            		String temp1 = tempBuffer.substring(startingIndex, i);
	            		tempStringList.add(temp1);
	            		startingIndex = i+1;
	            	}
	            	if(i == tempBuffer.length() - 1) {
	            		String temp1 = tempBuffer.substring(startingIndex, tempBuffer.length() - 1);
	            		tempStringList.add(temp1);
	            	}
	            }
            	String tempQuestion = "";
            	String tempAnswer = "";
            	int cint1 = 1;
            	int cint2 = 2;
            	int cint3 = 3;

	            // parse array into questions to add into QuizTaking
	            for(int i = 0; i < tempStringList.size(); i++) {
	            	if(i == cint1) {
	            		cint1 += 3;
	            		tempQuestion = tempStringList.get(i);
	            	}
	            	if(i == cint2) {
	            		cint2 += 3;
	            		tempAnswer = tempStringList.get(i);
	            	}
	            	if(i == cint3 || i == tempStringList.size() - 1) { 
	            		cint3 += 3;
	            		QuizTaking.addQuestion(new Question(tempQuestion, tempAnswer));
	            	}
	            }
	            	            
	            // Always close files.
	            inputStream.close();        
		  }
		        catch(FileNotFoundException ex) {
		            System.out.println(
		                "Unable to open file '" + 
		                fileName + "'");                
		        }
		        catch(IOException ex) {
		            System.out.println(
		                "Error reading file '" 
		                + fileName + "'");                  
		            // Or we could just do this: 
		            // ex.printStackTrace();
		        }
		   TakeQuiz.quizFrame();
		}
	}

}
