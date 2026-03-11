package com.denis.linearlayout.Business

class UserBusiness {

    fun checkCredentials(email: String, password: String): Boolean{
        return email.isNotEmpty() && password.isNotEmpty()
    }
}