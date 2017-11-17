package util;

import org.hibernate.Session;

public class ThreadUtil {
    private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();

    public static ThreadLocal<Session> getThreadLocal() {
        return threadLocal;
    }
}
