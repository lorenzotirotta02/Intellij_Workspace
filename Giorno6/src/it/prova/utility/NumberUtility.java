package it.prova.utility;

public class NumberUtility {
    public static Integer parseFromStringToInt(String input) {
        Integer result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            result = null;
        }
        return result;
    }
}
