package cn.com.hll.bean;

import org.apache.struts.action.ActionForm;

public class PasswordForm extends ActionForm {
    private int id;
    private String oldPw;
    private String newPw1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOldPw() {
        return oldPw;
    }

    public void setOldPw(String oldPw) {
        this.oldPw = oldPw;
    }

    public String getNewPw1() {
        return newPw1;
    }

    public void setNewPw1(String newPw1) {
        this.newPw1 = newPw1;
    }
}
