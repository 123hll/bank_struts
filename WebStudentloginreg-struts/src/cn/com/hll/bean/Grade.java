package cn.com.hll.bean;

public class Grade {
	int id;
	String stu_name;
	String class_name;
	String class_teacher;
	String class_score;
	String stu_grade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stuName) {
		stu_name = stuName;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String className) {
		class_name = className;
	}
	public String getClass_teacher() {
		return class_teacher;
	}
	public void setClass_teacher(String classTeacher) {
		class_teacher = classTeacher;
	}
	public String getClass_score() {
		return class_score;
	}
	public void setClass_score(String classScore) {
		class_score = classScore;
	}
	public String getStu_grade() {
		return stu_grade;
	}
	public void setStu_grade(String stuGrade) {
		stu_grade = stuGrade;
	}
}
