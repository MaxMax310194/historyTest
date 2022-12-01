package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Test {

	@Id
	@GeneratedValue
	@Column(name = "idTest")
	private int idTest;
	@Column(name = "question")
	private String question;
	@Column(name = "answer1")
	private String answer1;
	@Column(name = "answer2")
	private String answer2;
	@Column(name = "answer3")
	private String answer3;
	@Column(name = "answer4")
	private String answer4;
	@Column(name = "answer5")
	private String answer5;
	@Column(name = "correctAnswer")
	private String correctAnswer;
	
	public int getIdTest() {
		return idTest;
	}
	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public String getAnswer5() {
		return answer5;
	}
	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public Test() {
		super();
	}
	public Test(int idTest, String question, String answer1, String answer2, String answer3, String answer4,
			String answer5, String correctAnswer) {
		super();
		this.idTest = idTest;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
		this.correctAnswer = correctAnswer;
	}
	public Test(String question, String answer1, String answer2, String answer3, String answer4, String answer5,
			String correctAnswer) {
		super();
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
		this.correctAnswer = correctAnswer;
	}
	@Override
	public String toString() {
		return "Test [idTest=" + idTest + ", question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2
				+ ", answer3=" + answer3 + ", answer4=" + answer4 + ", answer5=" + answer5 + ", correctAnswer="
				+ correctAnswer + "]";
	}
	
	
	
}
