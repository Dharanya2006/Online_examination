package com.wipro.oers.entity;
import java.util.ArrayList;
public class AttemptRecord {
private String attemptId;
private String studentId;
private String examId;
private ArrayList<String> answers;
private int score;
public AttemptRecord(String attemptId, String studentId, String examId, ArrayList<String>
answers, int score) {
this.attemptId = attemptId;
this.studentId = studentId;
this.examId = examId;
this.answers = answers;
this.score = score;
}
public String getAttemptId() {
return attemptId;
}
public void setAttemptId(String attemptId) {
this.attemptId = attemptId;
}
public String getStudentId() {
return studentId;
}
public void setStudentId(String studentId) {
this.studentId = studentId;
}
public String getExamId() {
return examId;
}
public void setExamId(String examId) {
this.examId = examId;
}
public ArrayList<String> getAnswers() {
return answers;
}
public void setAnswers(ArrayList<String> answers) {
this.answers = answers;
}
public int getScore() {
return score;
}
public void setScore(int score) {
this.score = score;
}
}