package com.muditasoft.isbntools;

public class ValidateISBN {

    public boolean checkISBN(String isbnNumber) {
        int total = 0;
        int tenCheckDigits = 10;

        for (int i = 0; i < tenCheckDigits; i++) {
            total += isbnNumber.charAt(i) * (tenCheckDigits - i);
        }
        return total % 11 == 0;
    }
}
