package com.example.docker.demo.repository;

import com.example.docker.demo.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<UserBean, Long> {
}
