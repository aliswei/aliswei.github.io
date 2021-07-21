package com.asswei.demo.controller;

import com.asswei.demo.enitity.Sensor;
import com.asswei.demo.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private SensorService sensorService;
    @RequestMapping("/abc")
    public String getName(){
        return "ASSWEI";
    }

    @RequestMapping("/abcd")
    public List<Sensor> getSensor(){
        return sensorService.findAll();
    }
}
