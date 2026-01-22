package com.wipro.oers.entity;
public class Exam {
private String examId;
private String title;
private String subject;
public Exam(String examId, String title, String subject) {
this.examId = examId;
this.title = title;
this.subject = subject;
}
public String getExamId() {
return examId;
}
public void setExamId(String examId) {
this.examId = examId;
}
public String getTitle() {
return title;
}
public void setTitle(String title) {
this.title = title;
}
public String getSubject() {
return subject;
}
public void setSubject(String subject) {
this.subject = subject;
}
}