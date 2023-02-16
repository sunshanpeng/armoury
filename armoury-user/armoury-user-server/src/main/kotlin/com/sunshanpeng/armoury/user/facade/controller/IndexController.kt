package com.sunshanpeng.armoury.user.facade.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping("/")
    fun index(): String {
        return "ok"
    }
}