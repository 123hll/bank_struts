package cn.com.hll.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import cn.com.hll.bean.RegisterBean;
import cn.com.hll.bean.StudentBean;
import cn.com.hll.util.DB;


public class UserDao4MySqlImpl implements StudentDao {
	Connection conn = null;
	Statement sta = null;
	ResultSet rs = null;
	String sql = null;
	PreparedStatement pstmt = null;//预编译语句
	List list = new ArrayList();

	/**
	 * 登录
	 *
	 * @param
	 * @return boolean
	 */
	public boolean con(String name, String password, int shenfen) {
		System.out.print(name + password + shenfen);
		try {
			if (shenfen == 1) {
				sql = "select * from user where usename='" + name + "' and password='" + password + "'";
			}
			if (shenfen == 0) {
				sql = "select * from register where name='" + name + "' and password='" + password + "'";
			}
			//与数据库连接
			conn = DB.getConn();
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);

			if (rs.next()) {
				System.out.print(rs.getString(1) + " " + rs.getString(2));
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DB.closeRs(rs);
			DB.closeStmt(sta);
			DB.closeConn(conn);
		}
		return false;
	}

	//持久层
	public boolean registerByName(RegisterBean regf) {
		sql = "select * from register where name=?";

		try {

			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);//动态填充
			pstmt.setString(1, regf.getName());
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				//不能循环输出System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
				sql = "insert into register (name,password,sex,email) values ('" + regf.getName() + "','" +
						regf.getPassword() + "','" + regf.getRadio() + "','" + regf.getEmail() + "')";
				pstmt.executeUpdate(sql);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {//无论正常结束还是异常都必须执行此代码
			DB.closeRs(rs);
			DB.closeStmt(sta);
			DB.closeConn(conn);
		}
		return false;
	}

	//查找所有学生信息
	public List getAllUser() {

		try {

			sql = "select * from register";

			conn = DB.getConn();
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);
			while (rs.next()) {
				//System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
				//将数据库收集的参数封装到结果bean
				StudentBean bean = new StudentBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setSex(rs.getString(4));
				bean.setEmail(rs.getString(5));
				//将结果bean返回list集合中
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (sta != null) {
					sta.close();
					sta = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}


	//查找所有管理员信息
	public List getAllAdmin() {
		try {
			sql = "select * from user";

			conn = DB.getConn();
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);
			while (rs.next()) {
				//System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
				//将数据库收集的参数封装到结果bean
				StudentBean bean = new StudentBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("usename"));
				bean.setPassword(rs.getString("password"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (sta != null) {
					sta.close();
					sta = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}


	   //查找所有管理员信息
	   public List getOneUser(String name) {
		   sql = "select * from register where name=?";
		   try {
			   conn = DB.getConn();
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1,name);
			   rs=pstmt.executeQuery();
			   while (rs.next()) {
				   //System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
				   //将数据库收集的参数封装到结果bean
				   StudentBean bean = new StudentBean();
				   bean.setId(rs.getInt("id"));
				   bean.setName(rs.getString("name"));
				   bean.setPassword(rs.getString("password"));
				   bean.setSex(rs.getString("sex"));
				   bean.setEmail(rs.getString("email"));
				   list.add(bean);
			   }
		   } catch (Exception e) {
			   e.printStackTrace();
		   } finally {
			   try {
				   if (rs != null) {
					   rs.close();
					   rs = null;
				   }
				   if (sta != null) {
					   sta.close();
					   sta = null;
				   }
				   if (conn != null) {
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
	 * 按id 删除学生信息
	 *
	 * @param  id
	 * @return int rs
	 */
	public int delUserById(String id) {

		String sql = null;
		int rs = 0;
		Connection conn = null;
		Statement sta = null;

		try {
			sql = "delete from register where id = " + id;
			conn = DB.getConn();
			sta = conn.createStatement();

			rs = sta.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (sta != null) {
					sta.close();
					sta = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rs;
	}

	/**
	 * 通过id 查找学生信息
	 *
	 * @param  id
	 * @return StudentBean
	 */
	public StudentBean findUserById(String id) {
		StudentBean bean = null;
		try {

			sql = "select * from register where id='" + id + "'";

			conn = DB.getConn();
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);
			if (rs.next()) {
				System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5));
				bean = new StudentBean();
				//将修改界面的参数设定到结果bean并且返回bean
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setSex(rs.getString(4));
				bean.setEmail(rs.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (sta != null) {
					sta.close();
					sta = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bean;
	}

	/**
	 * 返回更新后的bean
	 * @return boolean
	 */
	public boolean modifyUser(StudentBean regf, String id) {
		String name = regf.getName();
		String password = regf.getPassword();
		String sex = regf.getSex();
		String email = regf.getEmail();
		System.out.print(name + password + sex + email);
		sql = "update register set name='" + name + "',password='" + password + "',sex='" + sex + "',email='" + email + "' where id=" + id;


		try {
			conn = DB.getConn();
			sta = conn.createStatement();
			sta.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DB.closeStmt(sta);
			DB.closeConn(conn);
		}
		return false;
	}

	//录入学生信息方法1在注册上面改
	public boolean register(StudentBean bean) {
		sql = "select * from register where name=?";

		try {

			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);//动态填充
			pstmt.setString(1, bean.getName());
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				//不能循环输出System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
				sql = "insert into register (name,password,sex,email) values ('" + bean.getName() + "','" +
						bean.getPassword() + "','" + bean.getSex() + "','" + bean.getEmail() + "')";
				pstmt.executeUpdate(sql);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {//无论正常结束还是异常都必须执行此代码
			DB.closeRs(rs);
			DB.closeStmt(sta);
			DB.closeConn(conn);
		}
		return false;
	}

	//录入学生信息方法2
	public boolean register1(StudentBean bean) {
		String sql;
		sql = "select * from register where name ='" + bean.getName() + "'";
		try {
			conn = DB.getConn();
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);
			if (rs.next()) {
				sql = "update register set name='" + bean.getName() + "',password='" + bean.getPassword()
						+ "',sex='" + bean.getSex() + "',email='" + bean.getEmail() + "' where id=" + rs;
				sta.executeUpdate(sql);
			} else {
				sql = "insert into register (name,password,sex,email) values ('"
						+ bean.getName() + "','" + bean.getPassword() + "','" + bean.getSex() + "','" + bean.getEmail() + "')";
				sta.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (sta != null) {
					sta.close();
					sta = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean updatep(String name, String oldPw, String newPw1) {
		//String sql = null;
		int id = 0;
		try {
			sql = "select * from user where usename='" + name + "'";
			//System.out.println(sql);
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);//动态填充
			rs = pstmt.executeQuery();
			//UserBean bean = new UserBean();
			//List list = new ArrayList();
			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
				if (rs.getString("password").equals(oldPw)) {
					String password = newPw1;
					id = rs.getInt("id");
					System.out.println(id);
					sql = "update user set password='" + password + "' where id=" + id;
					System.out.println(sql);
					pstmt.executeUpdate(sql);
					return true;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (sta != null) {
					sta.close();
					sta = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}
		