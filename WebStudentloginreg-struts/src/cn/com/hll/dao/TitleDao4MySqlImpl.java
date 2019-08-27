package cn.com.hll.dao;

import cn.com.hll.bean.TitleBean;
import cn.com.hll.util.DB;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TitleDao4MySqlImpl implements TitleDao {
    Connection conn = null;
    Statement sta = null;
    ResultSet rs = null;
    String sql = null;
    PreparedStatement pstmt = null;//预编译语句
    List list = new ArrayList();

    //查找所有通告信息
    public List getAllTitle() {
        try{
            sql="select * from title";

            conn = DB.getConn();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);
            while(rs.next()){
                //System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
                //将数据库收集的参数封装到结果bean
                //StudentBean bean = new StudentBean();
                TitleBean bean=new TitleBean();
                bean.setId(rs.getInt(1));//文件位置指针所指的第一个字段
                bean.setHead(rs.getString(2));
                bean.setText(rs.getString(3));
                bean.setTime(rs.getString(4));
                //将结果bean返回list集合中
                list.add(bean);//封装数据库对应的记录到结果bean的集合返回
              //  List<String> list = new ArrayList<String>();
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) {
                    rs.close();
                    rs = null;
                }
                if(sta != null) {
                    sta.close();
                    sta= null;
                }
                if(conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public TitleBean findTitleById(String id)
    {
        TitleBean bean=null;
        try{

            sql="select * from title where id='"+id+"'";

            conn = DB.getConn();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);
            if (rs.next()){
                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
                bean = new TitleBean();
                //将修改界面的参数设定到结果bean并且返回bean
                bean.setId(rs.getInt(1));
                bean.setHead(rs.getString(2));
                bean.setText(rs.getString(3));
                bean.setTime(rs.getString(4));

            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) {
                    rs.close();
                    rs = null;
                }
                if(sta != null) {
                    sta.close();
                    sta= null;
                }
                if(conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }

    //录入学生信息方法1在注册上面改
    public boolean register(TitleBean bean)
    {
        sql = "select * from title where head=?";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        String head = bean.getHead();
        String text = bean.getText();
        try {
            //System.out.println(bean.getHead());
            conn = DB.getConn();
            pstmt = conn.prepareStatement(sql);//动态填充
            pstmt.setString(1, bean.getHead());
            rs = pstmt.executeQuery();

            if (!rs.next()) {//rs进行读取一次，判断是否有数据
                //不能循环输出System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
                sql = "insert into title (head,text,time) values ('" + head + "','" +
                       text + "','" + date + "')";
                pstmt.executeUpdate(sql);
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {//无论正常结束还是异常都必须执行此代码
            DB.closeRs(rs);
            DB.closeStmt(sta);
            DB.closeConn(conn);
        }
        return false;
    }
    /**
     * 管理员查看通告
     */
    public List getTitle(String id){
        try{
            sql="select * from title where id='"+id+"'";
            conn = DB.getConn();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);
            while(rs.next()){
                TitleBean bean=new TitleBean();
                bean.setId(rs.getInt(1));
                bean.setHead(rs.getString(2));
                bean.setText(rs.getString(3));
                bean.setTime(rs.getString(4));
                list.add(bean);//封装数据库对应的记录到结果bean的集合返回

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) {
                    rs.close();
                    rs = null;
                }
                if(sta != null) {
                    sta.close();
                    sta= null;
                }
                if(conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 管理员查看通告
     */
    public boolean changeTitle(int id,TitleBean titleBean){
        String head=titleBean.getHead();
        String text=titleBean.getText();
        try{
            sql="update title set head='"+head+"',text='"+text+"' where id="+id;
            conn = DB.getConn();
            sta = conn.createStatement();
            sta.executeUpdate(sql);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) {
                    rs.close();
                    rs = null;
                }
                if(sta != null) {
                    sta.close();
                    sta= null;
                }
                if(conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 删除通告
     */
    public boolean delTitle(String id){
        try {
        sql="delete from title where id = "+id;
            conn = DB.getConn();
            sta = conn.createStatement();
            sta.executeUpdate(sql);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) {
                    rs.close();
                    rs = null;
                }
                if(sta != null) {
                    sta.close();
                    sta= null;
                }
                if(conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
