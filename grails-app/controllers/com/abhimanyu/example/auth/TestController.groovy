package com.abhimanyu.example.auth

import org.springframework.security.access.annotation.Secured
class TestController {

    def index() { }
	
	def show(){
		render params.username
	}
	
	@Secured("permitAll")
	def show2(){
		render request.getJSON().username
	}
}
