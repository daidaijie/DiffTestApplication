package com.daijie.difftestapplication;

/**
 * Created by liyujie on 2017/2/23.
 */

public class UserBean implements Cloneable {

    private String mName;

    private String mDesc;

    public UserBean() {
    }

    public UserBean(String name, String desc) {
        mName = name;
        mDesc = desc;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        UserBean userBean = null;
        try {
            userBean = (UserBean) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return userBean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBean userBean = (UserBean) o;

        return mName.equals(userBean.mName);

    }

    @Override
    public int hashCode() {
        return mName.hashCode();
    }
}
