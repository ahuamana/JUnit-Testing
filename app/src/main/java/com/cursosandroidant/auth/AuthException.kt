package com.cursosandroidant.auth

class AuthException(val authEvent: AuthEvent, val msg:String?=null) : Exception(msg)  {

}