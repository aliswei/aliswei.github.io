package com.asswei.demo.mapper;

import com.asswei.demo.enitity.Sensor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SensorMapper {
    List<Sensor> findAll();
}
