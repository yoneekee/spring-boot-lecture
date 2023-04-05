package com.jjang051.jpa.service;

import com.jjang051.jpa.entity.TodoJpa;
import java.util.List;

// import java.util.Optional;

public interface TodoJpaService {
  public void insertTodo(TodoJpa todoJpa);

  public List<TodoJpa> getAllTodo();

  public TodoJpa getOneTodo(int no);
}
