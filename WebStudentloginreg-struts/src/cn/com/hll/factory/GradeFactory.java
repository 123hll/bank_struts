package cn.com.hll.factory;

import cn.com.hll.dao.GradeDaoImpl;
import cn.com.hll.dao.ScoreDao;


public class GradeFactory {
    private static GradeFactory instance;

    private ScoreDao scoreDao;

    private GradeFactory() {
        //
        //可以从配置文件中动态装载ItemDao4MySqlImpl实现类,便于灵活更换
        //
        scoreDao = new GradeDaoImpl();//和持久层
    }

    public static synchronized GradeFactory getInstance() {//单利加同步
        if (instance == null) {
            instance = new GradeFactory();
        }
        return instance;
    }

    /**
     * 创建ItemDao对象
     * @return itemDao
     */
    public ScoreDao createScoreDao() {
        return scoreDao;
    }
}
