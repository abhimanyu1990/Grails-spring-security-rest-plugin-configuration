package com.abhimanyu.example.auth

class User {

	transient springSecurityService

	String username
	String password
	String email
	String salt = UUID.randomUUID().toString()
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role }
	}

	String getSalt() {
		if(this.salt == null){
			this.salt = UUID.randomUUID().toString()
		}
		this.salt
	}
	/*def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}*/
}
