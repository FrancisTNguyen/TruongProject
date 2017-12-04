import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class MultipleChoiceQuestion extends Question{
  private List<String> possibleAnswers;
  private List<String> correctAns;
  public MultipleChoiceQuestion(String question, String answer, List<String> possibleAnswers){
    super(question, answer);
    this.possibleAnswers = possibleAnswers;
    this.correctAns = Arrays.asList(answer);
  }
 public MultipleChoiceQuestion(String question, List<String> correctAns, List<String> possibleAnswers) {
	 super(question, correctAns);
	 this.correctAns = correctAns;
	 this.possibleAnswers = possibleAnswers;
 }
  //@Override
 //public String askQuestion(){
    //String result = super.askQuestion() + "\n";
    //Iterator<String> it = possibleAnswers.iterator();
    //int ctr = 0;
    //while(it.hasNext()){
      //result += ((++ctr) + "." + it.next() + "\n");
    //}
    //return result;
  //}
  
  public void setPossibleAnswers(List<String> possibleAnswers){
    this.possibleAnswers = possibleAnswers;
  }
  public List<String> getPossibleAnswers(){
    return possibleAnswers;
  }
  
  //Overload of askQuestion method from Question class
  //Displays question, possible answers, and answer with a space in between the possible answers
  public String askQuestion(){
	  String temp = "";
	  for(int i = 0; i < possibleAnswers.size(); i++)
		  if(i != possibleAnswers.size() - 1)
			  temp += possibleAnswers.get(i) + ",";
		  else
			  temp += possibleAnswers.get(i);
	  return super.askQuestion() + "|" + temp;
  }
  
  public String getAnswer() {
	  // if only one correct then return first element
	  if(possibleAnswers.size() == 1) {
		  return possibleAnswers.get(0);
	  }
	  else {	// if multiple then combine all answers into a string
		  String temp = "";
		  for(int i = 0; i < correctAns.size(); i++)
			  if(i != correctAns.size() - 1)
				  temp += correctAns.get(i) + " ";
			  else
				  temp += correctAns.get(i);
		  return temp;
	  }
  }
  
  //Overloads getAnswer from Question class and gets the answer
  public String getOneCorrectAnswer() {
	  return correctAns.get(0);
  }
  
  
  @Override
  public MultipleChoiceQuestion clone(){
   ArrayList<String> tempPossibleAnswers = new ArrayList<>();
   for(String val:possibleAnswers){
     tempPossibleAnswers.add(val);
   }
   MultipleChoiceQuestion temp = new MultipleChoiceQuestion(super.askQuestion(), getAnswer(), tempPossibleAnswers);
   return temp;
  }
  @Override
  public String toString(){
    return askQuestion();
  }
}