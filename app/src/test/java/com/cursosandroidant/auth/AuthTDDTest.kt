package com.cursosandroidant.auth

import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Ignore
import org.junit.Test

class AuthTDDTest {

    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent() {
        val isAuthenticate = userAuthenticationTDD("ant@gmail.com", "1234")
        assertEquals(AuthEvent.USER_EXIST, isAuthenticate)
    }

    @Test
    fun login_completeForm_notExistUser_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("t@gmail.com" ,"1234")
        assertEquals(AuthEvent.NOT_EXIST_USER, isAuthenticate)
    }

    @Test
    fun login_emptyEmail_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("" ,"1234")
        assertEquals(AuthEvent.EMPTY_EMAIL, isAuthenticate)
    }

    @Test
    fun login_emptyPassword_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("t@gmail.com", "")
        assertEquals(AuthEvent.EMPTY_PASSWORD, isAuthenticate)
    }

    @Test
    fun login_emptyForm_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("", "")
        assertEquals(AuthEvent.EMPTY_FORM, isAuthenticate)
    }

    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("nt@gmailcom", "1234")
        assertEquals(AuthEvent.INVALID_EMAIL, isAuthenticate)
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("nt@gmail.com","1234e")
        assertEquals(AuthEvent.INVALID_PASSWORD, isAuthenticate)
    }

    @Test
    fun login_completeForm_invalidUser_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("nt@gmailcom", "12343e")
        assertEquals(AuthEvent.INVALID_USER, isAuthenticate)
    }

    @Test(expected = AuthException::class)
    fun login_nullEmail_returnsException() {
        val isAuthenticate = userAuthenticationTDD(null, "1234")
        assertEquals(AuthEvent.NULL_EMAIL, isAuthenticate)
    }

    @Test
    fun login_nullPassword_returnsException() {
        assertThrows(AuthException::class.java) {
            userAuthenticationTDD("nt@gmail.com", null)
        }
    }

    @Test
    fun login_nullForm_returnsException() {
        assertThrows(AuthException::class.java) {
            userAuthenticationTDD(null, null)
        }
    }

    @Ignore("Falta definir requisito del del negocio")
    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("nt@gmail.com", "123")
        assertEquals(AuthEvent.INVALID_LENGTH_PASSWORD, isAuthenticate)
    }
}