package com.daijie.difftestapplication;

import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Created by liyujie on 2017/2/23.
 */

public class UserDiffCallBack extends DiffUtil.Callback {

    private List<UserBean> mOldUsers;
    private List<UserBean> mNewUsers;

    public UserDiffCallBack(List<UserBean> oldUsers, List<UserBean> newUsers) {
        mOldUsers = oldUsers;
        mNewUsers = newUsers;
    }

    @Override
    public int getOldListSize() {
        return ListUtils.getSizeSafety(mOldUsers);
    }

    @Override
    public int getNewListSize() {
        return ListUtils.getSizeSafety(mNewUsers);
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        UserBean oldUser = mOldUsers.get(oldItemPosition);
        UserBean newUser = mNewUsers.get(newItemPosition);

        return oldUser.getName().equals(newUser.getName());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        UserBean oldUser = mOldUsers.get(oldItemPosition);
        UserBean newUser = mNewUsers.get(newItemPosition);

        return oldUser.getName().equals(newUser.getName()) &&
                oldUser.getDesc().equals(newUser.getDesc());
    }
}
