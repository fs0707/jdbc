package org.java.web;

import org.java.entity.Inf;
import org.java.service.InfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class InfController {

    @Autowired
    private InfService infService;

    @GetMapping("/findAll")
    public List<Inf> findAll(){
        return infService.findAll();
    }
    @GetMapping("/findAll2")
    public List<Map<String,Object>> findAll2(){
        return infService.findAll2();
    }
}
