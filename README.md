Grails-spring-security-rest-plugin
==================================

1. First you need to follow https://github.com/abhimanyu1990/Grails-Springsecurity-username-email-login to configure spring security in your application. 
2. Now moodify your BuildConfig.groovy and add below line in plugin to install the spring security rest plugin
```
compile ":spring-security-rest:1.4.1.RC2", {
    excludes: 'spring-security-core'
}
```
The above line will install spring security rest plugin in your application.

3. Create a new domain AuthToken in your grails application , it will store authentication token when user login
AuthToken.groovy
```
class AuthToken {
	String username // this field will store username of the authenticated user
	String token
    static constraints = {
		username nullable: false
		token nullable: false
    }
}

```
4. Now we need to specify configuration details in config.groovy.
