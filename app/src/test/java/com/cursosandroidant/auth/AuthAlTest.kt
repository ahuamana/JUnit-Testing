package com.cursosandroidant.auth

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class AuthAlTest {

    private var email: String? = null
    private var password: String? = null

    @Before
    fun setUp() {
        email = "ant@gmail.com"
        password = "1234"
    }

    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent() {
        val isAuthenticate = userAuthenticationTDD(email, password)
        TestCase.assertEquals(AuthEvent.USER_EXIST, isAuthenticate)
    }

    @Test
    fun login_completeForm_notExistUser_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD(email, password)
        TestCase.assertEquals(AuthEvent.NOT_EXIST_USER, isAuthenticate)
    }

    @Test
    fun login_emptyEmail_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD(email, password)
        TestCase.assertEquals(AuthEvent.EMPTY_EMAIL, isAuthenticate)
    }

    @Test
    fun login_emptyPassword_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD(email, password)
        TestCase.assertEquals(AuthEvent.EMPTY_PASSWORD, isAuthenticate)
    }

    @Test
    fun login_emptyForm_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD(email, password)
        TestCase.assertEquals(AuthEvent.EMPTY_FORM, isAuthenticate)
    }

    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD(email, password)
        TestCase.assertEquals(AuthEvent.INVALID_EMAIL, isAuthenticate)
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD(email, password)
        TestCase.assertEquals(AuthEvent.INVALID_PASSWORD, isAuthenticate)
    }

    @Test
    fun login_completeForm_invalidUser_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD(email, password)
        TestCase.assertEquals(AuthEvent.INVALID_USER, isAuthenticate)
    }

    @Test(expected = AuthException::class)
    fun login_nullEmail_returnsException() {
        val isAuthenticate = userAuthenticationTDD(email, password)
        TestCase.assertEquals(AuthEvent.NULL_EMAIL, isAuthenticate)
    }

    @Test
    fun login_nullPassword_returnsException() {
        Assert.assertThrows(AuthException::class.java) {
            userAuthenticationTDD(email, password)
        }
    }

    @Test
    fun login_nullForm_returnsException() {
        Assert.assertThrows(AuthException::class.java) {
            userAuthenticationTDD(email, password)
        }
    }

    @Ignore("Falta definir requisito del del negocio")
    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD(email, password)
        TestCase.assertEquals(AuthEvent.INVALID_LENGTH_PASSWORD, isAuthenticate)
    }
}