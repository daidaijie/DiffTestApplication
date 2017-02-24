package com.daijie.difftestapplication;

import java.util.List;

/**
 * Created by liyujie on 2017/2/23.
 */

public class ListUtils {

    public static int getSizeSafety(List<UserBean> list) {
        return list == null ? 0 : list.size();
    }
}
