package cn.com.hll.factory;


import cn.com.hll.dao.TitleDao;
import cn.com.hll.dao.TitleDao4MySqlImpl;


public class TitelFactory {
    private static TitelFactory instance;

    private TitleDao titleDao;

    private TitelFactory() {
        //
        //可以从配置文件中动态装载ItemDao4MySqlImpl实现类,便于灵活更换
        //
        titleDao = new TitleDao4MySqlImpl();//和持久层
    }

    public static synchronized TitelFactory getInstance() {//单利加同步
        if (instance == null) {
            instance = new TitelFactory();
        }
        return instance;
    }

    /**
     * 创建ItemDao对象
     * @return itemDao
     */
    public TitleDao createTitleDao() {
        return titleDao;
    }
}
