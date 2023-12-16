package com.zzh.admin.common.base.support;

import com.zzh.admin.common.base.entity.SimpleUser;

public class SimpleUserContextHolder {

    private static final ThreadLocal<SimpleUser> SIMPLE_USER_THREAD_LOCAL = new ThreadLocal<>();


    public static SimpleUser getSimpleUser() {

        return SIMPLE_USER_THREAD_LOCAL.get();
    }

    public static void setSimpleUser(SimpleUser simpleUser) {
        SIMPLE_USER_THREAD_LOCAL.set(simpleUser);
    }

    public static void clearSimpleUserHolder() {
        SIMPLE_USER_THREAD_LOCAL.remove();
    }

    private SimpleUserContextHolder() {}
}
