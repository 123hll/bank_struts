package cn.com.hll.action;

import cn.com.hll.bean.LoginBean;
import cn.com.hll.bean.LoginForm;
import cn.com.hll.manager.UserManager;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        LoginForm lf=(LoginForm)form;
        LoginBean lo=new LoginBean();
        BeanUtils.copyProperties(lo,lf);
        boolean flag=UserManager.getInstance().login(lo);
        if(flag=true){
            HttpSession session=request.getSession();
            session.setAttribute("user", lo.getUsername());
            if(lo.getShenfen()==1){
                return mapping.findForward("success");
            }
            if(lo.getShenfen()==0){
                return mapping.findForward("studentlogin");
            }
        }
        return mapping.findForward("error");
    }
}
