package com.jjang051.todo.dao;

import com.jjang051.todo.dto.TodoDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoDao {
  int insertTodo(TodoDto todoDto);
  List<TodoDto> getAllTodo(String pickedDate);
  int deleteTodo(int no);
  int updateTodo(TodoDto todoDto);
}
