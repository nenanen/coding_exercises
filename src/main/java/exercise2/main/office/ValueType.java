package exercise2.main.office;

import static exercise2.main.utils.StringUtils.isInteger;

public enum ValueType {
    FORMULA,
    INTEGER,
    STRING;

    /**
     * Given a string, returns the corresponding ValueType based on custom logic.
     *
     * @param value the string to be checked
     * @return the corresponding ValueType (INTEGER, FORMULA, or STRING)
     */
    public static ValueType ofString(String value) {
        if (isInteger(value)) {
            return ValueType.INTEGER;
        }

        if (isFormula(value)) {
            return ValueType.FORMULA;
        }

        return ValueType.STRING;
    }


    private static boolean isFormula(String str) {
        return str.startsWith("=");
    }
}
