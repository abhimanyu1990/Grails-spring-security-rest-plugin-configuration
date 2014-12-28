class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/api/v1/anonymous/${username}"(controller:'test',action:'show', method:"GET")
		"/api/v1/authentication"(controller:'test',action:'show2', method:"POST")
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
