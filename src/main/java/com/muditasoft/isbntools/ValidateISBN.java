package com.muditasoft.isbntools;

public class ValidateISBN {

    public boolean checkISBN(String isbnNumber) {
        int total = 0;
        int tenCheckDigits = 10;

        if (isbnNumber.length() != tenCheckDigits)
            throw new NumberFormatException();

        for (int i = 0; i < tenCheckDigits; i++) {

            if (!Character.isDigit(isbnNumber.charAt(i)))
                throw new NumberFormatException("ISBN numbers can only contain numeric digits.");

            total += isbnNumber.charAt(i) * (tenCheckDigits - i);
        }
        return total % 11 == 0;
    }
}
