package com.example.docker.demo.service;

import com.example.docker.demo.bean.UserBean;
import com.example.docker.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoRepository repository;

    public String getName(Long id) {
        return repository.findById(id)
                .orElse(UserBean.createDummyUser())
                .getName();
    }
}
