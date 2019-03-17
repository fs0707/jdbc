package org.java.service;

import org.java.dao.InfDao;
import org.java.entity.Inf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InfService {
    @Autowired
    private InfDao dao;

    public List<Inf> findAll(){
        return dao.findAll();
    }
    public List<Map<String,Object>> findAll2(){
        return dao.findAllMap();
    }

}
