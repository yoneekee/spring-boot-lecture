package com.jjang051.todo.service;

import com.jjang051.todo.dao.TodoDao;
import com.jjang051.todo.dto.TodoDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

  @Autowired
  TodoDao todoDao;

  public int insertTodo(TodoDto todoDto) {
    int result = todoDao.insertTodo(todoDto);
    return result;
  }

  @Override
  public List<TodoDto> getAllTodo(String pickedDate) {
    List<TodoDto> todoList = todoDao.getAllTodo(pickedDate);
    return todoList;
  }

  @Override
  public int deleteTodo(int no) {
    int result = todoDao.deleteTodo(no);
    return result;
  }

  @Override
  public int updateTodo(TodoDto todoDto) {
    int result = todoDao.updateTodo(todoDto);
    return result;
  }
}
