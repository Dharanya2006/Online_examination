package com.wipro.oers.service;
import java.util.ArrayList;
import com.wipro.oers.util.ExamNotFoundException;
import com.wipro.oers.util.InvalidExamOperationException;
import com.wipro.oers.util.StudentNotFoundException;
import com.wipro.oers.entity.AttemptRecord;
import com.wipro.oers.entity.Exam;
import com.wipro.oers.entity.Question;
import com.wipro.oers.entity.Student;
public class OnlineExamService {
private ArrayList<Student>students;
private ArrayList<Exam> exams;
private ArrayList<Question> questions;
private ArrayList<AttemptRecord> attempts;
public OnlineExamService(ArrayList<Student>students, ArrayList<Exam>
exams,ArrayList<Question> questions,ArrayList<AttemptRecord> attempts) {
this.students=students;
this.exams=exams;
this.questions=questions;
this.attempts=attempts;
}
public void addStudent(Student s) {
for(Student a:students) {
if(a.getStudentId().equals(s.getStudentId())) {
System.out.println("Student already exist withID:"+s.getStudentId());
return;
}
}
students.add(s);
System.out.println("Student registered successfully");
}
public Student findStudent(String studentId)throws StudentNotFoundException{
for(Student a:students) {
if(a.getStudentId().equals(studentId)) {
return a;
}
}
throw new StudentNotFoundException("Student not found with the id"+studentId);
}
public void addExam(Exam exam) {
for(Exam a:exams) {
if(a.getExamId().equals(exam.getExamId())) {
System.out.println("Exam already exist with ID"+exam.getExamId());
return;
}
}
exams.add(exam);
System.out.println("Exam added successfully");
}
public Exam findExam(String examId) throws ExamNotFoundException{
for(Exam a:exams) {
if(a.getExamId().equals(examId)) {
return a;
}
}
throw new ExamNotFoundException("Exam not Found with ID:"+examId);
}
public void addQuestion(Question q) throws
ExamNotFoundException,InvalidExamOperationException{
boolean examexist=false;
for(Exam a:exams) {
if(a.getExamId().equals(q.getExamId())) {
examexist=true;
break;
}
}
if(!examexist) {
throw new ExamNotFoundException("Exam not Found withID:"+q.getExamId());
}
System.out.println("Question Text: " + q.getText());
 System.out.println("Option A: " + q.getOptionA());
 System.out.println("Option B: " + q.getOptionB());
 System.out.println("Option C: " + q.getOptionC());
 System.out.println("Option D: " + q.getOptionD());
 System.out.println("Correct Answer: " + q.getCorrectAnswer());
 if (q.getText() == null || q.getText().isEmpty() ||q.getOptionA() == null || q.getOptionB() == null ||q.getOptionC() == null || q.getOptionD() == null ||q.getCorrectAnswer() == null) {
		 throw new InvalidExamOperationException("Some fields are NULL or empty");
		 }
		 String ca = q.getCorrectAnswer().trim().toUpperCase();
		 if (!(ca.equals("A") || ca.equals("B") || ca.equals("C") || ca.equals("D"))) {
		 throw new InvalidExamOperationException(
		 "Correct answer must be A, B, C or D but found: " + ca);
		 }
		 questions.add(q);
		 System.out.println("Question added successfully");
		 System.out.println();
		}
		public ArrayList<Question>getQuestionsForExam(String examId) throws
		ExamNotFoundException{
		boolean examexist=false;
		for(Exam a:exams) {
		if(a.getExamId().equals(examId)) {
		examexist=true;
		break;
		}
		}
		if(!examexist) {
		throw new ExamNotFoundException("Exam not Found with ID:"+examId);
		}
		ArrayList<Question>examques=new ArrayList<>();
		for(Question q:questions) {
		if(q.getExamId().equals(examId)) {
		examques.add(q);
		}
		}
		return examques;
		}
		public AttemptRecord evaluateExam(String attemptId, String studentId, String
		examId,ArrayList<String> answers) throws
		ExamNotFoundException,InvalidExamOperationException,StudentNotFoundException {
		Student stud=null;
		for(Student s:students) {
		if(s.getStudentId().equals(studentId)) {
		stud=s;
		}
		}
		if(stud==null) {
		throw new StudentNotFoundException("Student not found with ID:"+studentId);
		}
		Exam ex=null;
		for(Exam e:exams) {
		if(e.getExamId().equals(examId)) {
		ex=e;
		}
		}
		if(ex==null) {
		throw new ExamNotFoundException("Exam not found with the Id:"+examId);
		}
		ArrayList<Question>exques=new ArrayList<>();
		for(Question a:questions) {
		if(a.getExamId().equals(examId)) {
		exques.add(a);
		}
		}
		if(exques.isEmpty()) {
			throw new InvalidExamOperationException("No questions available for this ExamId:"+examId);
			}
			if (answers == null || answers.size() != exques.size()) {
			 throw new InvalidExamOperationException("Number of answers does not match number of questions");
			 }
			int score = 0;
			 for (int i = 0; i < exques.size(); i++) {
			 Question q = exques.get(i);
			 String correct = q.getCorrectAnswer();
			 String given = answers.get(i);
			 if (correct.equalsIgnoreCase(given)) {
			 score++;
			 }
			 }
			 AttemptRecord attempt = new AttemptRecord(attemptId,
					 studentId,examId,answers,score);
					  attempts.add(attempt);
					  System.out.println("Exam evaluated successfully. Score: " + score);
					  return attempt;
					 }
					 public ArrayList<AttemptRecord>getStudentAttempts(String studentId) throws
					 StudentNotFoundException{
					 boolean stud=false;
					 for(Student s:students) {
					 if(s.getStudentId().equals(studentId)) {
					 stud=true;
					 break;
					 }
					 }
					 if(!stud) {
						 throw new StudentNotFoundException("Student not Found with the ID:"+studentId);
						 }
						 ArrayList<AttemptRecord> studentAttempts = new ArrayList<>();
						 for (AttemptRecord ar : attempts) {
						  if (ar.getStudentId().equals(studentId)) {
						  studentAttempts.add(ar);
						  }
						  }
						  return studentAttempts;
						 }
						 public void generateResultSummary(String attemptId) {
						  AttemptRecord attempt = null;
						  for (AttemptRecord ar : attempts) {
						  if (ar.getAttemptId().equals(attemptId)) {
						  attempt = ar;
						  break;
						  }
						  }
						  if (attempt == null) {
						  System.out.println("Attempt not found with ID: " + attemptId);
						  return;
						  }
						  Student student = null;
						  for (Student s : students) {
						  if (s.getStudentId().equals(attempt.getStudentId())) {
						  student = s;
						  break;
						  }
						  }
						  Exam exam = null;
						  for (Exam e : exams) {
						  if (e.getExamId().equals(attempt.getExamId())) {
						  exam = e;
						  break;
						  }
						  }
						  ArrayList<Question> examQuestions = new ArrayList<>();
						  for (Question q : questions) {
						  if (q.getExamId().equals(attempt.getExamId())) {
						  examQuestions.add(q);
						  }
						  }
						  int totalQuestions = examQuestions.size();
						  int correct = attempt.getScore();
						  int wrong = totalQuestions - correct;
						  System.out.println("------ RESULT SUMMARY ------");
						  System.out.println("Attempt ID : " + attempt.getAttemptId());
						  System.out.println();
						  System.out.println("Student Details:");
						  System.out.println("Student ID : " + student.getStudentId());
						  System.out.println("Student Name : " + student.getName());
						  System.out.println();
						  System.out.println("Exam Details:");
						  System.out.println("Exam ID : " + exam.getExamId());
						  System.out.println("Title : " + exam.getTitle());
						  System.out.println("Subject : " + exam.getSubject());
						  System.out.println();
						  System.out.println("Performance:");
						  System.out.println("Total Questions : " + totalQuestions);
						  System.out.println("Correct Answers : " + correct);
						  System.out.println("Wrong Answers : " + wrong);
						  System.out.println("Score : " + correct + " / " + totalQuestions);
						  System.out.println("-----------------------------");
						  System.out.println();
						 }
						 }
