package io.lemur.generation.util;

/**
 * 命名规则工具类
 * 
 * @author JueYue
 * @date 2014年12月21日
 */
public class NameUtil {

    private NameUtil() {

    }

    /**
     * 实体类驼峰转换,第一个字母大写
     * 
     * @param name
     * @return
     */
    public static String getEntityHumpName(String name) {
        StringBuilder builder = new StringBuilder();
        name = name.toLowerCase();
        int index = 0;
        while ((index = name.indexOf("_", index)) != -1) {
            builder.append(name.substring(0, index));
            name = name.substring(index + 1, index + 2).toUpperCase() + name.substring(index + 2);
        }
        builder.append(name);
        return builder.substring(0, 1).toUpperCase() + builder.substring(1);
    }

    /**
     * 字段驼峰转换,第一个字母小写,第二个字母也是小写
     * 
     * @param name
     * @return
     */
    public static String getFieldHumpName(String name) {
        StringBuilder builder = new StringBuilder();
        name = name.toLowerCase();
        int index = 0;
        while ((index = name.indexOf("_", index)) != -1) {
            builder.append(name.substring(0, index));
            name = name.substring(index + 1, index + 2).toUpperCase() + name.substring(index + 2);
        }
        builder.append(name);
        // 屏蔽第二个字母是大写的情况,强制换成小写,语法不对
        if (builder.length() > 1) {
            return builder.substring(0, 1) + builder.substring(1, 2).toLowerCase()
                   + builder.substring(2);
        }
        return builder.toString();
    }

}