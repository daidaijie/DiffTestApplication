package com.daijie.difftestapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by liyujie on 2017/2/23.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<UserBean> mUsers;

    public void setUsers(List<UserBean> users) {
        mUsers = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserBean user = mUsers.get(position);
        holder.mUserNameTextView.setText(user.getName());
        holder.mUserDescTextView.setText(user.getDesc());
    }

    @Override
    public int getItemCount() {
        return ListUtils.getSizeSafety(mUsers);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mUserNameTextView;
        TextView mUserDescTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mUserNameTextView = (TextView) itemView.findViewById(R.id.usernameTextView);
            mUserDescTextView = (TextView) itemView.findViewById(R.id.userDescTextView);
        }
    }
}
