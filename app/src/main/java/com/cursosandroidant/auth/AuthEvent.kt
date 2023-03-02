package com.cursosandroidant.auth

enum class AuthEvent {
    SUCCESS,
    FAIL,
    ERROR,
    USER_EXIST,
    NOT_EXIST_USER,
    EMPTY_EMAIL,
    EMPTY_PASSWORD,
    EMPTY_FORM,
    INVALID_EMAIL,
    INVALID_PASSWORD,
    INVALID_USER,
    //Exceptions
    NULL_EMAIL,
    NULL_PASSWORD,
    NULL_FORM,
    INVALID_LENGTH_PASSWORD,
}