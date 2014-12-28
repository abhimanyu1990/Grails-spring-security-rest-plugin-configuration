package com.abhimanyu.example.auth

class AuthToken {
	String username
	String token
    static constraints = {
		username nullable: false
		token nullable: false
    }
}
