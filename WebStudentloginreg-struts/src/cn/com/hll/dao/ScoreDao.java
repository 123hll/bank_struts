package cn.com.hll.dao;

import java.util.List;

import cn.com.hll.bean.GradeBean;
import cn.com.hll.bean.GradeFrom;

public interface ScoreDao {
	
	public List findAllScore(String username);


	public List findAllStudentId();

	public List findOneStudent(String username);

	public List findAllClassId();
	
	 public void addGrade(GradeFrom gradeFrom);
	 
	 public GradeBean findGradeById(String id);
	 
	 public void updateGrade(int id,String grade);
	 
	 public int StudentGradeDel(String id);


	public boolean modifyGrade(GradeBean bean);


	public int addUseGrade(GradeBean bean);


}
