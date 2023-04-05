package com.jjang051.jpa.service;

import com.jjang051.jpa.entity.TodoJpa;
import com.jjang051.jpa.repository.TodoJpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoJpaServiceImple implements TodoJpaService {

  @Autowired
  TodoJpaRepository todoJpaRepository;

  @Override
  public void insertTodo(TodoJpa todoJpa) {
    todoJpaRepository.save(todoJpa);
  }

  @Override
  public List<TodoJpa> getAllTodo() {
    List<TodoJpa> todoList = todoJpaRepository.findAllByOrderByNoDesc();
    return todoList;
  }

  @Override
  public TodoJpa getOneTodo(int no) {
    Optional<TodoJpa> optional = todoJpaRepository.findById(no);
    return optional.get();
  }
}
