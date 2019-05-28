package com.lantel.mine.mvp;

import com.lantel.mine.list.model.ChangeAccountBean;
import java.util.ArrayList;
import androidx.lifecycle.ViewModel;

public class ChangeAccountModel extends ViewModel {
    private ArrayList<ChangeAccountBean> changeAccountBeans;
    private String sid;

    public ArrayList<ChangeAccountBean> getChangeAccountBeans() {
        return changeAccountBeans;
    }

    public void setChangeAccountBeans(ArrayList<ChangeAccountBean> changeAccountBeans) {
        this.changeAccountBeans = changeAccountBeans;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
