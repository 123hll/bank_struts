package cn.com.hll.action;


import cn.com.hll.bean.RegisteForm;
import cn.com.hll.bean.RegisterBean;
import cn.com.hll.manager.UserManager;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RegisteForm rf = (RegisteForm)form;
        RegisterBean rb=new RegisterBean();
        BeanUtils.copyProperties(rb,rf);
        boolean flag=UserManager.getInstance().Register(rb);
        if(flag=true){
            return mapping.findForward("success");
        }
        return mapping.findForward("errorcf");
    }
}
