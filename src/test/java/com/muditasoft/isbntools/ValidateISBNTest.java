package com.muditasoft.isbntools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateISBNTest {

    private ValidateISBN validator;

    @BeforeEach
    void setUp() {
        validator = new ValidateISBN();
    }

    @Test
    void checkAValidISBN() {
        assertAll("Validate ISBN",
                () -> assertTrue(validator.checkISBN("0140449116"), "First Value"),
                () -> assertTrue(validator.checkISBN("0140177396"), "Second Value")
                );
    }

    @Test
    void checkAnInvalidISBN() {
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test
    void nineDigitsISBNsAreNotAllowed() {
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("140449117"));
    }

    @Test
    void nonNumericISBNsAreNotAllowed() {
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("helloWorld"));
    }
}