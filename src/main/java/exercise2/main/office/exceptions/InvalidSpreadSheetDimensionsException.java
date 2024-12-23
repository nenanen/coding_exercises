package exercise2.main.office.exceptions;

/**
 *  Exception when SpreadSheet is created with invalid dimensions.
 */
public class InvalidSpreadSheetDimensionsException extends IllegalArgumentException {

    public InvalidSpreadSheetDimensionsException(String message) {
        super(message);
    }
}