package com.abhimanyu.example.auth;


import grails.plugin.springsecurity.userdetails.GrailsUser
import org.springframework.security.core.GrantedAuthority

class CustomUserDetails extends GrailsUser {
	public final String salt;

	 CustomUserDetails(String username, String password, boolean enabled,
                 boolean accountNonExpired, boolean credentialsNonExpired,
                 boolean accountNonLocked,
                 Collection<GrantedAuthority> authorities,
                 long id, String salt) {
      super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, id)

      this.salt = salt
   }

   String getSalt(){
	  	   return null
   }
}