package com.daijie.difftestapplication;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private List<UserBean> mUsers;

    UserAdapter mUserAdapter;

    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        initData();
        initAdapter();
        initRecyclerView();
    }

    private void initData() {
        mUsers = new ArrayList<>();
        mUsers.add(new UserBean("呆杰", "Android"));
        mUsers.add(new UserBean("呆杰", "Java"));
        mUsers.add(new UserBean("呆杰", "背锅"));
        mUsers.add(new UserBean("呆杰", "手撕产品"));
        mUsers.add(new UserBean("呆杰", "手撕测试"));
    }

    private void initAdapter() {
        mUserAdapter = new UserAdapter();
        mUserAdapter.setUsers(mUsers);
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mUserAdapter);
    }

    @Override
    public void onRefresh() {
        try {
            List<UserBean> newUsers = new ArrayList<>();
            for (UserBean user : mUsers) {
                newUsers.add((UserBean) user.clone());
            }

            newUsers.add(new UserBean("赵子龙", "直播砍曹操"));
            newUsers.get(0).setDesc("Android 7.1");

            UserBean movedUser = newUsers.get(1);
            newUsers.remove(1);
            newUsers.add(movedUser);

            // 2B青年
            // 将新数据赋值给旧数据并刷新
//            mUsers = newUsers;
//            mUserAdapter.setUsers(mUsers);
//            mUserAdapter.notifyDataSetChanged();

            // 文艺青年
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(
                    new UserDiffCallBack(mUsers, newUsers), true);
            mUsers = newUsers;
            mUserAdapter.setUsers(mUsers);

            diffResult.dispatchUpdatesTo(mUserAdapter);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } finally {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

}
