package cn.com.hll.manager;

import cn.com.hll.factory.TitelFactory;
import cn.com.hll.bean.TitleBean;

import java.util.List;

public class UserManagerTitle {
    private static  UserManagerTitle instance=null;//静态私有对象

    private UserManagerTitle()//私有的构造方法
    {

    }

    public static  synchronized UserManagerTitle getInstance()
    {
        if(instance==null)
        {
            instance=new UserManagerTitle(); //没有就创建

        }
        return instance;//返回业务层对象ַ
    }
    //查询所有的通告信息
    public List findAllTitle()
    {
        List AllUser=TitelFactory.getInstance().createTitleDao().getAllTitle();
        return AllUser;
    }
    //通过id添加通告
    public boolean RegisterByTitle(TitleBean bean)
    {
        boolean flag=TitelFactory.getInstance().createTitleDao().register(bean);
        return flag;
    }
    //通过id修改通告
    public TitleBean findTitleById(String id)
    {
        TitleBean bean=TitelFactory.getInstance().createTitleDao().findTitleById(id);
        return bean;
    }

    //管理员查询的通告信息
    public List OneTitle(String id)
    {
        List OneTitle=TitelFactory.getInstance().createTitleDao().getTitle(id);
        return OneTitle;
    }

    //管理员修改的通告信息
    public boolean ChangeTitle(int id,TitleBean titleBean)
    {
        boolean falg=TitelFactory.getInstance().createTitleDao().changeTitle(id,titleBean);
        return falg;
    }

    //管理员删除的通告信息
    public boolean DelTitle(String id)
    {
        boolean falg=TitelFactory.getInstance().createTitleDao().delTitle(id);
        return falg;
    }
}
