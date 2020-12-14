package com.education.commonutils.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @author xusonglin
 * @date 2020/10/16 - 21:43
 */
public class ToolUtils {
    public static boolean isEmpty(Object obj) {
        return obj == null;
    }


    public static boolean isEmpty(Object[] obj) {
        return obj == null || obj.length == 0;
    }

    /**
     * 判断字符串是否为空，null、""、"null"、" "返回true，其他返回false,
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str) || "null".equalsIgnoreCase(str) || "".equals(str.trim());
    }

    /**
     * 判断map是否为空，如果map为null或者empty返回true,其他返回false
     *
     * @param map
     * @return
     */
    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    /**
     * 判断collection是否为空，如果collection为null或者empty返回true,其他返回false
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

}
