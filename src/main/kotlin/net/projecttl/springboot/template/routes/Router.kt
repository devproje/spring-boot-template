package net.projecttl.springboot.template.routes

import net.projecttl.springboot.template.model.Resp
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class Router {
    @RequestMapping("/", method = [RequestMethod.GET])
    fun index(): Resp<String> {
        return Resp(1, "Hello, World!")
    }
}
