package com.cursosandroidant.auth


import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Ignore
import org.junit.Test

class AuthHamcrestTest {
    //given-when-then
    //given -> precondiciones
    //when -> accion
    //then -> resultado
    @Test
    fun loginUser_correctData_returnsSuccessEvent() {
        val isAuthenticate = userAuthenticationTDD("ant@gmail.com", "1234")
        assertThat(AuthEvent.USER_EXIST, `is` (isAuthenticate))
    }

    @Test
    fun loginUser_wrongData_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("t@gmail.com" ,"1234")
        assertThat(AuthEvent.NOT_EXIST_USER, `is` (isAuthenticate))
    }

    @Test
    fun loginUser_emptyEmail_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("" ,"1234")
        assertThat(AuthEvent.EMPTY_EMAIL, `is` (isAuthenticate))
    }

    @Test
    fun loginUser_emptyPassword_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("t@gmail.com", "")
        assertThat(AuthEvent.EMPTY_PASSWORD, `is` (isAuthenticate))
    }

    @Test
    fun loginUser_emptyUser_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("", "")
        assertThat(AuthEvent.EMPTY_FORM, `is` (isAuthenticate))
    }

    @Test
    fun loginUser_invalidEmail_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("nt@gmailcom", "1234")
        assertThat(AuthEvent.INVALID_EMAIL,`is` (isAuthenticate))
    }

    @Test
    fun loginUser_invalidPassword_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("nt@gmail.com","1234e")
        assertThat(AuthEvent.INVALID_PASSWORD, `is` (isAuthenticate))
    }

    @Test
    fun loginUser_invalidEmailPassword_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("nt@gmailcom", "12343e")
        assertThat(AuthEvent.INVALID_USER, `is` (isAuthenticate))
    }

    @Test(expected = AuthException::class)
    fun loginUser_nullEmail_returnsException() {
        val isAuthenticate = userAuthenticationTDD(null, "1234")
        assertThat(AuthEvent.NULL_EMAIL, `is` (isAuthenticate))
    }

    @Test
    fun loginUser_nullPassword_returnsException() {
        val isAuthenticate = userAuthenticationTDD("nt@gmail.com", null)
        assertThat(AuthException::class.java, `is` (isAuthenticate))
    }

    @Test
    fun loginUser_nullUser_returnsException() {
        val isAuthenticate = userAuthenticationTDD(null, null)
        assertThat(AuthException::class.java, `is` (isAuthenticate))
    }

    @Ignore("Falta definir requisito del del negocio")
    @Test
    fun loginUser_errorLengthPassword_returnsFailEvent() {
        val isAuthenticate = userAuthenticationTDD("nt@gmail.com", "123")
        assertThat(AuthEvent.INVALID_LENGTH_PASSWORD, `is` (isAuthenticate))
    }

    @Test
    fun checkNames_differentUsers_match() {
        assertThat("Antonio", both(containsString("A")).and(containsString("n")))
    }

    @Test
    fun checkData_emailPassword_noMatch() {
        val email = "nt@gmail.com"
        val password = "1234"
        assertThat(email, not(`is`(password)))
    }

    @Test
    fun checkExist_newEmail_returnsString() {
        val oldEmail = "nt@gmail.com"
        val newEmail = "nta@gmail.com"
        val emails = arrayOf(oldEmail, newEmail)
        assertThat(emails, hasItemInArray(newEmail))
    }

    @Test
    fun checkDomain_arrayEmails_returnsString() {
        val nextEmail = "alain@hotmail.com"
        val oldEmail = "nt@gmail.com"
        val newEmail = "nta@gmail.com"
        val emails = arrayListOf(oldEmail, newEmail)
        assertThat(emails, everyItem(endsWith("@gmail.com")))

    }




}