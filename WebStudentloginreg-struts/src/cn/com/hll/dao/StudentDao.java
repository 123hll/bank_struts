package cn.com.hll.dao;

import java.util.List;

import cn.com.hll.bean.RegisterBean;
import cn.com.hll.bean.StudentBean;


public interface StudentDao {

	public boolean con(String name,String password,int shenfen);
	

	public boolean registerByName(RegisterBean regf);
	

	public List getAllUser();
	

	
	public int delUserById(String id);

	public StudentBean findUserById(String id);
	

	public boolean modifyUser(StudentBean regf,String id);

	
	public boolean register(StudentBean bean);

	public boolean register1(StudentBean bean);

	public List getAllAdmin() ;

	public boolean updatep(String name, String oldPw, String newPw1);

	public List getOneUser(String name);

	}
