package cn.com.hll.bean;

import org.apache.struts.action.ActionForm;

public class GradeForm extends ActionForm {
    int id;//成绩标识id
    String register_name;
    String class_class;
    String class_teacher;
    String class_score;
    String grade_grade;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRegister_name() {
        return register_name;
    }
    public void setRegister_name(String registerName) {
        register_name = registerName;
    }
    public String getClass_class() {
        return class_class;
    }
    public void setClass_class(String classClass) {
        class_class = classClass;
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
    public String getGrade_grade() {
        return grade_grade;
    }
    public void setGrade_grade(String gradeGrade) {
        grade_grade = gradeGrade;
    }
}
