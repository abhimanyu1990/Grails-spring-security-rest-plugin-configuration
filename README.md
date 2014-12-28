Grails-spring-security-rest-plugin
==================================

Step 1. First you need to follow https://github.com/abhimanyu1990/Grails-Springsecurity-username-email-login to configure spring security in your application. 
Step 2. Now moodify your BuildConfig.groovy and add below line in plugin to install the spring security rest plugin
```
compile ":spring-security-rest:1.4.1.RC2", {
    excludes: 'spring-security-core'
}
```
The above line will install spring security rest plugin in your application.

Step 3. Create a new domain AuthToken in your grails application , it will store authentication token when user login
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
Step 4. Now we need to specify configuration details in config.groovy.

Enable rest login facility
```
grails.plugin.springsecurity.rest.login.active = true
````
Specify Login Url
```
grails.plugin.springsecurity.rest.login.endpointUrl = "/api/login"
```

Status code if authentication failed
```
grails.plugin.springsecurity.rest.login.failureStatusCode =  401
```
Specify the property name that will be send in the params or json body to specify username and role in response
```
grails.plugin.springsecurity.rest.token.rendering.usernamePropertyName ="username"
grails.plugin.springsecurity.rest.token.rendering.authoritiesPropertyName = "roles"
```
to enable annoymous access vaildation
```
grails.plugin.springsecurity.rest.token.validation.enableAnonymousAccess = true
```
Specify whether authentication request will be json 
```
grails.plugin.springsecurity.rest.login.useJsonCredentials	= true
```
to specify the key send in json body or either as param to authenticate request (login request)
```
grails.plugin.springsecurity.rest.login.usernamePropertyName = "usernameoremail"
grails.plugin.springsecurity.rest.login.passwordPropertyName = "password"
```
To specify the logout url
```
grails.plugin.springsecurity.rest.logout.endpointUrl= '/api/logout'
```
to specify the authorization token method
```
grails.plugin.springsecurity.rest.token.generation.useSecureRandom = true
```
if you want to store the token in database
```
grails.plugin.springsecurity.rest.token.storage.useGorm = true
```
Add below line to specify the domain class to store the authorization token 
```
grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName = 'com.abhimanyu.example.AuthToken'
grails.plugin.springsecurity.rest.token.storage.gorm.tokenValuePropertyName = "token"
grails.plugin.springsecurity.rest.token.storage.gorm.usernamePropertyName = 'username'
```
Use below line enable or disable login request can contain username and passowrd as params
```
grails.plugin.springsecurity.rest.login.useRequestParamsCredentials	= false
```
To specify different url for anonymous access , to  require authentication

```
grails.plugin.springsecurity.filterChain.chainMap = [
	'/api/v1/logout': 'anonymousAuthenticationFilter', //to allow anonymous access
	'/api/v1/**': 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter', // Stateless chain
	'/**': 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter',                                          // Traditional chain
]
```
Step 5 . In UrlMappings.groovy , you could specify different http method require for your different url
Sample
```
```
