package com.cursosandroidant.auth

/****
 * Project: Auth
 * From: com.cursosandroidant.auth
 * Created by Alain Nicolás Tello on 14/12/21 at 12:05
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/

fun userAuthentication(email: String, password: String): Boolean {
    if (email == "ant@gmail.com" && password == "1234"){
        return true
    }
    return false
}

fun userAuthenticationTDD(email: String?, password: String?): AuthEvent {
    if (email == null && password == null){
        return throw AuthException(AuthEvent.NULL_FORM, "Email and Password are null")
    }

    if (email == null){
        return throw AuthException(AuthEvent.NULL_EMAIL, "Email is null")
    }
    if(password == null){
        return throw AuthException(AuthEvent.NULL_PASSWORD, "Password is null")
    }

    if (email.isEmpty() && password!!.isEmpty()){
        return AuthEvent.EMPTY_FORM
    }

    if (email.isEmpty()){
        return AuthEvent.EMPTY_EMAIL
    }

    if (password.isEmpty()){
        return AuthEvent.EMPTY_PASSWORD
    }
    if(password.length  != 4){
        return AuthEvent.INVALID_LENGTH_PASSWORD
    }

    val passwordNumeric = password.matches("-?\\d+(\\.\\d+)?".toRegex())

    if (!passwordNumeric && !isEmailValid(email)){
        return AuthEvent.INVALID_USER
    }

    if (!isEmailValid(email)){
        return AuthEvent.INVALID_EMAIL
    }

    if(!passwordNumeric){
        return AuthEvent.INVALID_PASSWORD
    }

    if (email == "ant@gmail.com" && password == "1234"){
        return AuthEvent.USER_EXIST
    }

    return AuthEvent.NOT_EXIST_USER
}

fun isEmailValid(email: String): Boolean {
    val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return EMAIL_REGEX.toRegex().matches(email);
}