package cn.com.hll.manager;


	 import java.util.List;

	 import cn.com.hll.factory.GradeFactory;
	 import cn.com.hll.bean.GradeBean;

public class UserManagerGrade {

	private   static UserManagerGrade instance=null;
	 
	           private UserManagerGrade()
	                  {
		 
	           }

	public   static synchronized UserManagerGrade getInstance()
	          {
		   if(instance==null)
		   {
			  instance=new UserManagerGrade();
			 
		   }
	       return instance;
	    }
	       
	     //查找所以学生成绩
	       public List findAllScore(String username) {
			   List AllScore= GradeFactory.getInstance().createScoreDao().findAllScore(username);
	 	      return AllScore;
	 	     
	 	}
        //学生查看成绩
        public List seeOneGrade(String username){
			List OneUser=GradeFactory.getInstance().createScoreDao().findOneStudent(username);
            return OneUser;
        }
	       //通过学号删除学生成绩
	       public int delGradeById(String id)  
	   	{
			int flag=GradeFactory.getInstance().createScoreDao().StudentGradeDel(id);
	   		  return flag;
	   	}
	       // 通过学号更新学生成绩
	       public GradeBean findGradeById(String id)  
	   	{
			GradeBean bean=GradeFactory.getInstance().createScoreDao().findGradeById(id);
	   		return bean;
	   	}

	       //修改后学生成绩
	       public boolean modifyGrade(GradeBean bean)
	   	{
			boolean flag=GradeFactory.getInstance().createScoreDao().modifyGrade(bean);
	   		return flag;
	   	}

	       // 添加学生成绩
	      public int addUserGrade(GradeBean bean){
			  int rs =GradeFactory.getInstance().createScoreDao().addUseGrade(bean);
	   		return rs;
	   		
	   	}
           //查找所有学生姓名
	   	public List findAlluser(){
			List AllUser=GradeFactory.getInstance().createScoreDao().findAllStudentId();
		      return AllUser;
		}
	   	//查找所以课程名
		public List findAllclass(){
			List AllClass =GradeFactory.getInstance().createScoreDao().findAllClassId();
			return AllClass;
		}


	}
