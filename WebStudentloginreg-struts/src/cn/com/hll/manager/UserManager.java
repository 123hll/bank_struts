package cn.com.hll.manager;

import cn.com.hll.bean.LoginBean;
import cn.com.hll.bean.RegisterBean;
import cn.com.hll.factory.UserFactory;

import cn.com.hll.bean.StudentBean;

import java.util.List;

public class UserManager {
    private static UserManager instance=null;//静态私有对象

    private UserManager()
    {

    }

     public static synchronized UserManager getInstance()
    {
        if(instance==null)
        {
            instance=new UserManager();

        }
        return instance;
    }
/**
 * 登录登录通过接口降低耦合性，实现持久层con（）方法
 */
   public boolean login(LoginBean loginf){
     boolean flag=UserFactory.getInstance().createStudentDao().con(loginf.getUsername(), loginf.getPassword(),loginf.getShenfen());
      return flag;
  }
    /**
     * 通过查找数据库是否有相同的姓名，若无则注册
     * @param
     * @param
     */
    public boolean Register(RegisterBean regf)
    {
        boolean flag=UserFactory.getInstance().createStudentDao().registerByName(regf);
        return flag;
    }



    /**
     * 添加学生信息，将表单的参数添加到数据库。再将更改后的SQL语句的数据库传回来
     * @param bean
     * @return
     */
    public boolean RegisterByName(StudentBean bean)
    {
        boolean flag=UserFactory.getInstance().createStudentDao().register(bean);
        return flag;
    }



    /**
     * 查询所有学生信息，调用持久层与数据库联系
     */
    public List findAllUse()
    {
        List AllUser=UserFactory.getInstance().createStudentDao().getAllUser();
        return AllUser;
    }


    /**
     * 根据姓名查询学生信息
     * @param name
     * @return
     */
    public List seeOneUser(String name)
    {
        List OneUser=UserFactory.getInstance().createStudentDao().getOneUser(name);
        return OneUser;
    }

    /**
     * 查找所有管理员
     */
    public List findAllAdmin()
    {
        List AllUser=UserFactory.getInstance().createStudentDao().getAllAdmin();
        return AllUser;
    }

    /**
     * 通过ID删除学生
     * @param id
     * @return
     */
    public int delUserById(String id)
    {
      int flag=UserFactory.getInstance().createStudentDao().delUserById(id);
        return flag;
    }



    /**
     * 通过id修改学生信息
     */
    public StudentBean findUserById(String id)
    {
      StudentBean bean=UserFactory.getInstance().createStudentDao().findUserById(id);
        return bean;
    }

    /**
     * 修改学生信息
     * @param regf
     * @param id
     * @return
     */
    public boolean modifyUser(StudentBean regf, String id)
    {
        boolean flag=UserFactory.getInstance().createStudentDao().modifyUser(regf,id);
        return flag;
    }


    /**
     * 密码修改
     * @param name
     * @param oldPw
     * @param newPw1
     * @return
     */
    public boolean updatepw(String name, String oldPw, String newPw1)
    {
        boolean flag=UserFactory.getInstance().createStudentDao().updatep(name,oldPw,newPw1);
        return flag;
    }

}
