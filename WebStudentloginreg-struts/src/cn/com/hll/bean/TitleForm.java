package cn.com.hll.bean;

import org.apache.struts.action.ActionForm;

public class TitleForm extends ActionForm {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    String head;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    String text;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    String time;
}
