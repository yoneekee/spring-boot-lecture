package com.jjang051.todo.service;

import com.jjang051.todo.dto.TodoDto;
import java.util.List;

public interface TodoService {
  public int insertTodo(TodoDto todoDto);

  public List<TodoDto> getAllTodo(String pickedDate);

  public int deleteTodo(int no);

  int updateTodo(TodoDto todoDto);
}
