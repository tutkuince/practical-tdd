package com.muditasoft.isbntools;

public class ValidateISBN {

    public boolean checkISBN(String isbnNumber) {
        int total = 0;
        int tenCheckDigits = 10;

        if (isbnNumber.length() != tenCheckDigits)
            throw new NumberFormatException();

        for (int i = 0; i < tenCheckDigits; i++) {

            // If last digit is X, X is 10.
            if (i  == tenCheckDigits - 1 && isbnNumber.charAt(tenCheckDigits - 1) == 'X') {
                total += 10 * (tenCheckDigits - i);
                break;
            }


            if (!Character.isDigit(isbnNumber.charAt(i)))
                throw new NumberFormatException("ISBN numbers can only contain numeric digits.");

            total += Character.getNumericValue(isbnNumber.charAt(i)) * (tenCheckDigits - i);
        }
        return total % 11 == 0;
    }
}
