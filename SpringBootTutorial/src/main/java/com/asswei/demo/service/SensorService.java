package com.asswei.demo.service;

import com.asswei.demo.enitity.Sensor;
import com.asswei.demo.mapper.SensorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SensorService {

    //依赖注入，没有new这个类
    @Autowired
    private SensorMapper sensorMapper;

    public List<Sensor> findAll(){
        return sensorMapper.findAll();
    }
}
