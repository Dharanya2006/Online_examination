package com.wipro.oers.main;
import java.util.ArrayList;
import com.wipro.oers.entity.*;
import com.wipro.oers.service.OnlineExamService;
import com.wipro.oers.util.*;
public class Main {
	 public static void main(String[] args) {
	 ArrayList<Student> students = new ArrayList<>();
	 students.add(new Student("S001", "Ravi Kumar"));
	 students.add(new Student("S002","Yashika"));
	 ArrayList<Exam> exams = new ArrayList<>();
	 exams.add(new Exam("E001", "Java Basics", "Programming"));
	 ArrayList<Question> questions = new ArrayList<>();
	 ArrayList<AttemptRecord> attempts = new ArrayList<>();
	 OnlineExamService service = new OnlineExamService(students, exams, questions, attempts);
	 try {
	 Question q1 = new Question("Q001", "E001", "What is JVM?", "Java Virtual Machine", "Java Very Much", "Just Virtual Mode", "None", "A");
	 Question q2 = new Question("Q002", "E001", "Which keyword creates an object?", "new","class", "void", "int", "A");
	 Question q3=new Question("Q003","E001","How many primitive data types are in Java?","2","5","8","10","C");
	 service.addQuestion(q1);
	 service.addQuestion(q2);
	 service.addQuestion(q3);
	 ArrayList<String> ans = new ArrayList<>();
	 ans.add("A");
	 ans.add("A");
	 ans.add("B");
	AttemptRecord ar = service.evaluateExam("A001","S001","E001",ans);
	AttemptRecord ar1 = service.evaluateExam("A002","S002","E001",ans);
	 System.out.println("Score: " + ar.getScore());
	 service.generateResultSummary("A001");
	 service.generateResultSummary("A002");
	 } catch (Exception ex) {
	 System.out.println(ex);
	 }
	 }
	}