package cn.com.hll.action;

import cn.com.hll.bean.*;
import cn.com.hll.manager.UserManager;
import cn.com.hll.manager.UserManagerGrade;
import cn.com.hll.manager.UserManagerTitle;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class StudentAction extends StudentBaseAction{
    /**
     * 如果没有传递任何标识参数（如command参数），则默认调用unspecified方法
     */
    protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                        HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("ItemAction=>>unspecified()");
        ActionForward listActionForward = new ActionForward("/index.jsp", true);
        return listActionForward;
    }

    /**
     * 查询学生信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward findAllUse(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        StudentForm sf= (StudentForm) form;
        List list=UserManager.getInstance().findAllUse();
        request.setAttribute("user", list);
        //request.getRequestDispatcher("/WEB-INF/jsp/studentInfo.jsp").forward(request, response);
       // return null;
        return mapping.findForward("list_success");
    }

    /**
     * 查询学生成绩
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward findAllScore(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        StudentForm sf= (StudentForm) form;
        StudentBean sb=new StudentBean();
        BeanUtils.copyProperties(sb,sf);
        List list=UserManagerGrade.getInstance().findAllScore(sb.getName());
        request.setAttribute("username", list);
        request.getRequestDispatcher("/WEB-INF/jsp/score.jsp" ).forward(request,response);
        return  null;
    }

    /**
     * 添加学生成绩
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward GradeAdd(ActionMapping mapping, ActionForm form,
                                      HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List Alluser=UserManagerGrade.getInstance().findAlluser();
        List Allclass=UserManagerGrade.getInstance().findAllclass();
        request.setAttribute("Alluser", Alluser);
        request.setAttribute("Allclass", Allclass);
       request.getRequestDispatcher("/jsp/gradeAdd.jsp" ).forward(request,response);
        return null;

    }

    /**
     * 查看通告
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward findAllTitle(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserManagerTitle userMassage=UserManagerTitle.getInstance();
        List list =userMassage.findAllTitle();
        request.setAttribute("title", list);
       // return mapping.findForward("title");
        request.getRequestDispatcher("/jsp/title.jsp" ).forward(request,response);
        return null;
    }
    /**
     * 查询管理员
     */
    public ActionForward findAllAdmin(ActionMapping mapping, ActionForm form,
                                      HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserManager userMassage=UserManager.getInstance();
        List list =userMassage.findAllAdmin();
        request.setAttribute("user", list);
        request.getRequestDispatcher("/jsp/adminPw.jsp" ).forward(request,response);
        return  null;
        //return mapping.findForward("adminPw");
    }
    /**
     * 删除学生信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward delUserById(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        StudentForm sf= (StudentForm) form;
        request.setCharacterEncoding("utf-8");
        //点击删除键的请求参数的id
       String id = request.getParameter("userId");
        //实例化业务层对象，调用delUserById()方法
        UserManager userMassage=UserManager.getInstance();
        int rs = userMassage.delUserById(id);
        ActionForward af = new ActionForward("student.do?command=findAllUse",true);
        return af;
    }
/**
 * 修改学生信息
 */
public ActionForward updataUser(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
        throws Exception {
    StudentForm sf= (StudentForm) form;
    request.setCharacterEncoding("utf-8");
    //点击删除键的请求参数的id
    String id = request.getParameter("id");
    //实例化业务层对象，调用delUserById()方法
    UserManager userMassage=UserManager.getInstance();
    StudentBean bean=userMassage.findUserById(id);
    request.setAttribute("user",bean);
    //跳转
    request.getRequestDispatcher("/WEB-INF/jsp/Updata.jsp").forward(request, response);
    return null;
}
    /**
     * 添加学生信息
     */
    public ActionForward AddUser(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        StudentForm sf= (StudentForm) form;
        request.setCharacterEncoding("utf-8");
        StudentBean bean =new StudentBean();
        BeanUtils.copyProperties(bean,sf);
        UserManager userMassage=UserManager.getInstance();
        //将请求分发给业务层（单例加同步：解决并发性与安全性）
        boolean flag=userMassage.RegisterByName(bean);
        if (flag==true){
            ActionForward af = new ActionForward("student.do?command=findAllUse",true);
            return af;
        }
        else{
            request.getRequestDispatcher("/errorcf.jsp").forward(request, response);
            return null;
        }
    }
/**
 *删除学生成绩
 */
public ActionForward  GradeDel(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
        throws Exception {
    StudentForm sf= (StudentForm) form;
    request.setCharacterEncoding("utf-8");
    //点击删除键的请求参数的id
    String id = request.getParameter("userId");
    //实例化业务层对象，调用delUserById()方法
    int rs=UserManagerGrade.getInstance().delGradeById(id);
    if(rs!=0){
        ActionForward af = new ActionForward("student.do?command=findAllScore",true);
        return af;
    }
   return null;
}
/**
 * 修改学生成绩
 */
    public ActionForward  UpdataGrade(ActionMapping mapping, ActionForm form,
                                   HttpServletRequest request, HttpServletResponse response)
            throws Exception {
               request.setCharacterEncoding("utf-8");
                GradeForm gf= (GradeForm) form;
                GradeBean bean=new GradeBean();
                BeanUtils.copyProperties(bean,gf);
                request.setAttribute("studentname",bean.getRegister_name());
                request.setAttribute("studentclass",bean.getClass_class());
                request.setAttribute("studentgrade",bean.getGrade_grade());
                request.setAttribute("id",bean.getId());
                ActionForward af = new ActionForward("/jsp/updateGrade.jsp",true);
                return af;

    }
    public ActionForward   modifyGrade(ActionMapping mapping, ActionForm form,
                                      HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        GradeForm gf= (GradeForm) form;
        GradeBean bean=new GradeBean();
        bean.setRegister_name(gf.getRegister_name());
        bean.setClass_class(gf.getClass_class());
        bean.setGrade_grade(gf.getGrade_grade());
        if (request.getParameter("id") != null) {
            bean.setId(Integer.parseInt(request.getParameter("id")));
        }
        UserManagerGrade userGradeMassage = UserManagerGrade.getInstance();
        boolean rs = userGradeMassage.modifyGrade(bean);
        if (rs == true) {
            ActionForward af = new ActionForward("student.do?command=findAllScore",true);
            return af;
        }
        else{
            request.getRequestDispatcher("/errorcf.jsp").forward(request, response);
            return null;
        }
    }
    /**
     * 添加公告
     */
    public ActionForward AddTitle(ActionMapping mapping, ActionForm form,
                                       HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("utf-8");
        TitleBean bean=new TitleBean();
        TitleForm tf=(TitleForm)form;
        bean.setHead(tf.getHead());
        bean.setText(tf.getText());
        if (request.getParameter("id") != null) {
            bean.setId(Integer.parseInt(request.getParameter("id")));
        }
        UserManagerTitle userManager=UserManagerTitle.getInstance();
        //将请求分发给业务层（单例加同步：解决并发性与安全性）
        boolean flag=userManager.RegisterByTitle(bean);
        if (flag==true){
            ActionForward af = new ActionForward("student.do?command=findAllTitle",true);
            return af;
        }
        else
            request.getRequestDispatcher("/errorcf.jsp").forward(request, response);
        return null;
    }
/**
 * 更新通告
 */
public ActionForward   UpdateTitle(ActionMapping mapping, ActionForm form,
                                   HttpServletRequest request, HttpServletResponse response) throws Exception {
    UserManagerTitle userManager=UserManagerTitle.getInstance();
    List list=userManager.OneTitle(request.getParameter("id"));
    request.setAttribute("title",list);
    request.getRequestDispatcher("/jsp/showTitle.jsp").forward(request, response);
    return null;
}
/**
 * 删除通告
 */
public ActionForward  TitleDel(ActionMapping mapping, ActionForm form,
                                   HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("userId");
        UserManagerTitle userManager=UserManagerTitle.getInstance();
        boolean flag=userManager.DelTitle(id);
        if(flag=true){
            ActionForward af = new ActionForward("student.do?command=findAllTitle",true);
            return af;
    }
        return null;
}

    /**
     * 修改密码
     */
    public ActionForward   UpdataAdmin(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("user");
        PasswordForm pf=(PasswordForm)form;
        String oldPw=pf.getOldPw();
        String newPw1=pf.getNewPw1();
        UserManager userMassage=UserManager.getInstance();
        boolean falg=userMassage.updatepw( name, oldPw, newPw1);
        if (falg == true) {
            ActionForward af = new ActionForward("student.do?command=findAllAdmin",true);
            return af;
        }
        else {
            request.getRequestDispatcher("/errorcf.jsp").forward(request, response);
            return null;
        }
    }
/**
 * 学生查看信息
 */
public ActionForward   SeeStudentInfo(ActionMapping mapping, ActionForm form,
                                   HttpServletRequest request, HttpServletResponse response)
        throws Exception {
    UserManager userManager=UserManager.getInstance();
    HttpSession session = request.getSession();
    String username=(String) session.getAttribute("user");
    List list=userManager.seeOneUser(username);
    request.setAttribute("user",list);
    request.getRequestDispatcher("/jsp/SeestudentInfo.jsp").forward(request,response);
    return null;
    }

/**
 * 学生查看成绩
 */
public ActionForward  UserStudentgradeInfo(ActionMapping mapping, ActionForm form,
                                      HttpServletRequest request, HttpServletResponse response)
        throws Exception {
    HttpSession session = request.getSession();
    String username=(String) session.getAttribute("user");
    UserManagerGrade userMassageGrade = UserManagerGrade.getInstance();
    List list = userMassageGrade.seeOneGrade(username);
    request.setAttribute("user",list);
    request.getRequestDispatcher("/jsp/showpersongrade.jsp").forward(request,response);
    return null;
}
/**
 * 学生查看通告
 */
public ActionForward StudentTitleInfo(ActionMapping mapping, ActionForm form,
                                            HttpServletRequest request, HttpServletResponse response)
        throws Exception {
    UserManagerTitle userMassage=UserManagerTitle.getInstance();
    //调用业务层的findAllUse()方法返回list集合
    List list =userMassage.findAllTitle();
    request.setAttribute("title",list);
    request.getRequestDispatcher("/jsp/Studenttitle.jsp").forward(request,response);
    return null;
}
}




