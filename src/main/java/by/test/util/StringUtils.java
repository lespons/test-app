package by.test.util;

/**
 * Created by lespons on 11.12.14.
 */
public class StringUtils extends org.springframework.util.StringUtils {
    public static String safeString(String str) {
        return isEmpty(str) ? "" : str;
    }
}
