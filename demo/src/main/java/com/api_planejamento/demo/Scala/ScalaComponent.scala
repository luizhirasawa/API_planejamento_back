package com.api_planejamento.demo.Scala;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ScalaComponent {

    @GetMapping(Array("/zawarudo"))
    def sayHello(): String = "Hello from Scala!"
}