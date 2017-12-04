import java.io.FileWriter;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
public class Quiz {
  private ArrayList<Question> questions;
  private String filename;
  public Quiz(String filename){
    questions = new ArrayList<>();
    this.filename = filename;
  }
  public void addQuestion(Question q){
    questions.add(q);
  }
  
  public int size() {
	  return questions.size();
  }
  
  public Question getQuestionObject(int index) {
	  return questions.get(index);
  }
  
  public void printQuiz() {
	  for(int i = 0; i < questions.size(); i++) {
		  System.out.println("Question #" + Integer.toString(i+1) + ": " + questions.get(i).askQuestion());
		  System.out.println("Question #" + Integer.toString(i+1) + " (answer): " + questions.get(i).getAnswer());
	  }
  }
  @Override
  public String toString(){
    String result = "";
    Iterator<Question> it = questions.iterator();
    while(it.hasNext()){
      result += (it.next() + "\n");
    }
    return result;
  }
  public void save(){
	  try {
		  String bytes = "";
		  for(int i = 0; i < questions.size(); i++) {
			  bytes += "Question " + Integer.toString(i+1) + ": " + "\n";
			  bytes += getQuestionObject(i).askQuestion();
			  bytes += "\n";
			  bytes += getQuestionObject(i).getAnswer();
			  if(i != questions.size() - 1)
				  bytes += "\n";
		  }
          byte[] buffer = bytes.getBytes();

          FileOutputStream outputStream =
              new FileOutputStream(filename);

          outputStream.write(buffer);

          // Always close files.
          outputStream.close();       

          System.out.println("Finished saving quiz!");
      }
      catch(IOException ex) {
          System.out.println(
              "Error writing file '"
              + filename + "'");
          // Or we could just do this:
          // ex.printStackTrace();
      }
  }
}
