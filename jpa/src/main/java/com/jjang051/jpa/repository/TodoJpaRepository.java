package com.jjang051.jpa.repository;

import com.jjang051.jpa.entity.TodoJpa;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJpaRepository extends JpaRepository<TodoJpa, Integer> {
  // 여기는 만약 Jpa가 제공하는 메서드가 없으면 내가 만들어 쓰는 곳
  List<TodoJpa> findAllByOrderByNoDesc();
}
