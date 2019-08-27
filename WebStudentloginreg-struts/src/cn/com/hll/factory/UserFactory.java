package cn.com.hll.factory;

import cn.com.hll.dao.StudentDao;
import cn.com.hll.dao.UserDao4MySqlImpl;

public class UserFactory {

    private static UserFactory instance;

    private StudentDao studentDao;

    private UserFactory() {
        //
        //可以从配置文件中动态装载ItemDao4MySqlImpl实现类,便于灵活更换
        //
        studentDao = new UserDao4MySqlImpl();//和持久层
    }

    public static synchronized UserFactory getInstance() {//单利加同步
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }

    /**
     * 创建ItemDao对象
     * @return itemDao
     */
    public StudentDao createStudentDao() {
        return studentDao;
    }
}
