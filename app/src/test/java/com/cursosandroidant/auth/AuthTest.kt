package com.cursosandroidant.auth

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AuthTest {

    @Test
    fun login_complete_returnsTrue() {
        val isAuthenticate = userAuthentication("ant@gmail.com", "1234")
        assertTrue(isAuthenticate)
    }

    @Test
    fun login_complete_returnsFalse() {
        val isAuthenticate = userAuthentication("nt@@gmail.com", "1234")
        assertFalse(isAuthenticate)
    }

    @Test
    fun login_emtpyEmail_returnsFalse() {
        val isAuthenticate = userAuthentication("", "1234")
        assertFalse(isAuthenticate)
    }



    /* -- TDD -- */
    /*
    @Test
    fun login_nullEmail_returnsFalse() {
        val isAuthenticate = userAuthenticationTDD(null, "1234")
        assertFalse(isAuthenticate)
    }

    @Test
    fun login_nullPassword_returnsFalse() {
        val isAuthenticate = userAuthenticationTDD("nt@@gmail.com", null)
        assertFalse(isAuthenticate)
    }*/
}