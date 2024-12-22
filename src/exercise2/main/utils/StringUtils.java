package exercise2.main.utils;

public class StringUtils {

    /**
     * Checks if a given string can be parsed as an integer.
     * Handles both negative & positive integers
     *
     * @param str the string to check
     * @return true if the string is a valid integer, false otherwise
     */
    public static boolean isInteger(String str) {
        return str.matches("-?\\d+");
    }
}