package cn.com.hll.dao;

import cn.com.hll.bean.TitleBean;

import java.util.List;

public interface TitleDao {

    public List getAllTitle();
    public TitleBean findTitleById(String id);
    //public boolean RegisterByTitle(StudentBean bean);
    public boolean register(TitleBean bean);

    public List getTitle(String id);

    public boolean changeTitle(int id,TitleBean titleBean);

    public boolean delTitle(String id);
}
