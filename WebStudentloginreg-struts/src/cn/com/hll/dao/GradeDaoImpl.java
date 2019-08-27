	  package cn.com.hll.dao;

	   
	  import java.util.ArrayList;
	  import java.util.List;

	  import cn.com.hll.bean.GradeFrom;
	  import cn.com.hll.util.DB;
	  import cn.com.hll.bean.ClassBean;
	  import cn.com.hll.bean.GradeBean;
	  import cn.com.hll.bean.StudentBean;
import java.sql.*;
	 
	  /**
	   * 
	   * @author Administrator
	   * 成绩持久层实现
	   */
	   public class GradeDaoImpl implements ScoreDao {
		  String sql = null;
		  Connection conn = null;
		  Statement sta = null;
		  ResultSet rs = null;
		  List list = new ArrayList();
		  PreparedStatement pstmt = null;

		  public GradeDaoImpl() {
		  }

		  /**
		   * 查找所有学生的成绩
		   *
		   * @return list
		   * @param：username
		   */
		  public List findAllScore(String username) {
			  /**
			   * 学生表register 课程表class 成绩表grade，通过等值连接完成关联查询
			   */
			  /*if (username == null)*/
				  sql = "select grade.id,register.name,class.class,class.teacher,class.score,grade.grade from grade,class,register where  (grade.stu_id=register.id) and (grade.class_id=class.id)";
			/*  else*/
				  //sql = "select grade.id,register.name,class.class,class.teacher,class.score,grade.grade from grade,class,register where  (grade.stu_id=register.id) and (grade.class_id=class.id)and register.name like '%" + username + "%'";
			  try {
				  conn = DB.getConn();
				  sta = conn.createStatement();
				  rs = sta.executeQuery(sql);

				  while (rs.next()) {
					  GradeBean grade = new GradeBean();
					  grade.setId(rs.getInt(1));
					  grade.setRegister_name(rs.getString(2));
					  grade.setClass_class(rs.getString(3));
					  grade.setClass_teacher(rs.getString(4));
					  grade.setClass_score(rs.getString(5));
					  grade.setGrade_grade(rs.getString(6));
					  list.add(grade);
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

		  public List findOneStudent(String username) {
			  if (username == null)
				  sql = "select grade.id,register.name,class.class,class.teacher,class.score,grade.grade from grade,class,register where  (grade.stu_id=register.id) and (grade.class_id=class.id)";
			  else
				  sql = "select grade.id,register.name,class.class,class.teacher,class.score,grade.grade from grade,class,register where  (grade.stu_id=register.id) and (grade.class_id=class.id)and register.name like '%" + username + "%'";
			  try {
			  //sql="select grade.id,register.name,class.class,class.teacher,class.score,grade.grade from grade,class,register where  (grade.stu_id=register.id) and (grade.class_id=class.id)and register.name = '=" + username + "'";
			  //sql="select class.class,class.teacher,class.score,grade.grade from grade,class,register where  (grade.stu_id=register.id) and (grade.class_id=class.id)and register.name like '%" + username + "%'";
				 /* sql = "select class,teacher,score,grade from (select g.id id,g.name name,class.class class,class.teacher teacher,class.score score,g.grade grade from" +
						  "(select grade.id,name,class_id,grade from grade join register on" +
						  "(grade.stu_id=register.id)) g join class on (class.id=g.class_id)) a where name='" + username + "'";*/
				  conn = DB.getConn();
				  sta = conn.createStatement();
				  rs = sta.executeQuery(sql);
				  while (rs.next()) {
					 /* Grade grade = new Grade();
					  grade.setClass_name(rs.getString(1));
					  grade.setClass_teacher(rs.getString(2));
					  grade.setClass_score(rs.getString(3));
					  grade.setStu_grade(rs.getString(4));
					  list.add(grade);*/
					  GradeBean grade = new GradeBean();
					  grade.setId(rs.getInt(1));
					  grade.setRegister_name(rs.getString(2));
					  grade.setClass_class(rs.getString(3));
					  grade.setClass_teacher(rs.getString(4));
					  grade.setClass_score(rs.getString(5));
					  grade.setGrade_grade(rs.getString(6));
					  list.add(grade);
				  }
			  } catch (SQLException e) {
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
			/*  if (username == null)
				  sql = "select grade.id,register.name,class.class,class.teacher,class.score,grade.grade from grade,class,register where  (grade.stu_id=register.id) and (grade.class_id=class.id)";
			  else
				  sql = "select grade.id,register.name,class.class,class.teacher,class.score,grade.grade from grade,class,register where  (grade.stu_id=register.id) and (grade.class_id=class.id)and register.name like '%" + username + "%'";
			  try {
				  conn = DB.getConn();
				  sta = conn.createStatement();
				  rs = sta.executeQuery(sql);

				  while (rs.next()) {
					  GradeBean grade = new GradeBean();
					  grade.setId(rs.getInt(1));
					  grade.setRegister_name(rs.getString(2));
					  grade.setClass_class(rs.getString(3));
					  grade.setClass_teacher(rs.getString(4));
					  grade.setClass_score(rs.getString(5));
					  grade.setGrade_grade(rs.getString(6));
					  list.add(grade);
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
			  return list;*/
		  }

			 public List findAllStudentId()
	        {
				sql="select id,name from register";
				conn = DB.getConn();
	 			try {
					sta = conn.createStatement();
					rs = sta.executeQuery(sql);
					 while(rs.next()){
						 StudentBean studentBean=new StudentBean();
						 studentBean.setId(rs.getInt(1));
						 studentBean.setName(rs.getString(2));
		    			 list.add(studentBean);
		    			  }
	 			} catch (SQLException e) {
					// TODO Auto-generated catch block
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
	          * 查找所有课程id
			  * @param
			  * @return List 
	        */
		    public List findAllClassId()
		    {   sql="select id,class from class";
		        conn = DB.getConn();
				try {
				sta = conn.createStatement();
				rs = sta.executeQuery(sql);
				while(rs.next()){
					 ClassBean classBean=new ClassBean();
					 classBean.setId(rs.getInt(1));
					 classBean.setClass_name(rs.getString(2));
	   			 list.add(classBean);
	   			  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
	          * 插入学生成绩
			  * @param 封装成绩的表单bean
			  * @return null 
	       */
		    public void addGrade(GradeFrom gradeFrom)
		    { 
		     sql="insert into grade(stu_id,class_id,grade) values (?,?,?)";
		     
		    conn = DB.getConn();
		    
		    try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gradeFrom.getStudentId());
			    pstmt.setInt(2, gradeFrom.getClassId());
			    pstmt.setString(3, gradeFrom.getGrade());
			    pstmt.executeUpdate(); 
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}finally{
			       try {
					       
					      if(pstmt != null) {
					    	 pstmt.close();
					    	 pstmt= null;
					       }
					      if(conn != null) {
						     conn.close();
						     conn = null;
					      }
				       } catch (SQLException e) {
					      e.printStackTrace();
				       }
			       }
			         
			
		    } 
		    public int addUseGrade(GradeBean bean) {
				String sql =null;
				try {
					System.out.println(bean.getRegister_name());
					sql = "select id from register where name='"+ bean.getRegister_name()+"'";
					conn = DB.getConn();
					sta = conn.createStatement();
					rs = sta.executeQuery(sql);
					if ((rs.next()) && (bean.getId() == 0)){
						//stu_id = rs.getInt("id");
						//class_id = Integer.parseInt(req.getParameter("class"));
						sql = "insert into grade (stu_id,class_id,grade) values ('"
								+ rs.getInt("id") + "','" + bean.getClass_class() + "','" + bean.getGrade_grade() + "')";
						sta.executeUpdate(sql);
					}
					else{
						sql = "update grade set stu_id='" + rs.getInt("id")
								+ "',grade='" + bean.getGrade_grade() + "'where id=" + bean.getId();
						System.out.print(sql);
						sta.executeUpdate(sql);
					}
					return 1;
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
				finally {

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
				
			}


		    public GradeBean findGradeById(String id)
	        {   
		    	GradeBean bean=null;
		    	                                                                                                                                        
		    	
			    try{
			    	sql="select grade.id,register.name,class.class,grade.grade from grade,class,register where(grade.stu_id=register.id) and (grade.class_id=class.id)and grade.id='"+id+"'" ;
				    conn = DB.getConn();
			      sta = conn.createStatement();
			      rs = sta.executeQuery(sql);
			      if(rs.next()){
			    	  bean=new GradeBean();
			    	  bean.setId(rs.getInt(1));
			    	  bean.setRegister_name(rs.getString(2));
			    	  bean.setClass_class(rs.getString(3));
			    	  bean.setGrade_grade(rs.getString(4));
				  }
	           }catch(Exception e){
				      e.printStackTrace();
			         }finally{
				       try {
					      if(rs != null) {
						    rs.close();
						    rs = null;
					        }
					      if(pstmt!= null) {
					    	 pstmt.close();
					    	 pstmt= null;
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
	      

		    public void updateGrade(int id,String grade)
	        {  try {
				sql="update grade set grade='"+grade+"'where id="+id;
				conn = DB.getConn();
				sta = conn.createStatement();
				sta.executeUpdate(sql); 
	        } catch (SQLException e) {
				 
				e.printStackTrace();
			}finally{
			       try {
					       
					      if(sta!= null) {
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
	        	
	        }
	       

		     public int StudentGradeDel(String id)
	        {  
		    	 String sql=null;
			 		int rs = 0;
			 		Connection conn = null;
	                Statement sta = null;
	       try{
		       sql="delete from grade where id = "+id;
	           
				   conn = DB.getConn();
				   sta = conn.createStatement();
				   sta.executeUpdate(sql); 
				  
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				       try {
						       
						      if(sta!= null) {
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
			  return rs; 
			}
		     //通过id 查找学生成绩并且返回表单
		     public boolean modifyGrade(GradeBean bean) {
		 		String sql =null;
		 		try {
		 			System.out.println(bean.getRegister_name());
		 			sql = "select id from register where name='"+ bean.getRegister_name()+"'";
		 			conn = DB.getConn();
		 			sta = conn.createStatement();
		 			rs = sta.executeQuery(sql);
		 			if ((rs.next()) && (bean.getId() == 0)){
		 				sql = "insert into grade (stu_id,class_id,grade) values ('"
		 						+ rs.getInt("id") + "','" + bean.getClass_class() + "','" + bean.getGrade_grade() + "')";
		 				sta.executeUpdate(sql);
		 			}
		 			else{
		 				sql = "update grade set stu_id='" + rs.getInt("id")
		 						+ "',grade='" + bean.getGrade_grade() + "'where id=" + bean.getId();
		 				System.out.print(sql);
		 				sta.executeUpdate(sql);
		 			}
		 			return true;
		 		} catch (Exception e) {
		 			e.printStackTrace();
		 			return false;
		 		}
		 		finally {

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
		 		
		 	}

	     }

