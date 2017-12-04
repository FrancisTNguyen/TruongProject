import java.util.List;

public class Question{
  private String question;
  private String answer;
  public Question(String question, String answer){
    this.question = question;
    this.answer = answer;
  }
  public Question(String question, List<String> answer) {
	  this.question = question;
	  String temp = "";
	  for(int i = 0; i < answer.size(); i++) {
		  temp += answer.get(i);
	  }
	  this.answer = temp;
	  
  }
  public String askQuestion(){
    return question;
  }
  public boolean check(String userAnswer){
    return answer.equals(userAnswer);
  }
  protected String getAnswer(){
    return answer;
  } 
  public void setAnswer(String answer){
    this.answer = answer;
  }
  public void setQuestion(String question){
    this.question = question;
  }
  @Override
  public Question clone(){
    return new Question(question, answer);
  }
  @Override
  public String toString(){
    return askQuestion();
  }
}