package com.projetreactjs.demo.EmailValidator;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {
    private final EmailValidator underTest = new EmailValidator();
    @Test
    public  void itShouldValidateCorrectEmail(){
        assertThat(underTest.test("hello@gmail.com")).isTrue();
    }

    @Test
    public  void itShouldValidateAnIncorrectEmail(){
        assertThat(underTest.test("hellogmail.com")).isFalse();
    }
    @Test
    public  void itShouldValidateAnIncorrectEmailWithoutDotAtTheEnd(){
        assertThat(underTest.test("hellogmail")).isFalse();
    }

}