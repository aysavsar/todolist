package com.aysavs.todolist.service;

import com.aysavs.todolist.dto.TodoDTO;
import com.aysavs.todolist.entity.Todo;
import com.aysavs.todolist.exception.TodoNotFoundException;
import com.aysavs.todolist.repository.TodoRepository;
import com.aysavs.todolist.request.TodoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TodoResponse getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));
        return mapToDTO(todo);
    }

    public TodoResponse createTodo(TodoDTO todoDTO) {
        Todo todo = mapToEntity(todoDTO);
        return mapToDTO(todoRepository.save(todo));
    }

    public TodoResponse updateTodo(Long id, TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setTitle(todoDTO.getTitle());
        todo.setCompleted(todoDTO.isCompleted());
        return mapToDTO(todoRepository.save(todo));
    }

    public void deleteTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));
        todoRepository.deleteById(todo.getId());
    }

    public List<TodoResponse> getCompletedTodos() {
        return todoRepository.findByCompleted(true)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private TodoResponse mapToDTO(Todo todo) {
        TodoResponse todoResponse = new TodoResponse();
        todoResponse.setId(todo.getId());
        todoResponse.setTitle(todo.getTitle());
        todoResponse.setCompleted(todo.isCompleted());
        return todoResponse;
    }

    private Todo mapToEntity(TodoDTO dto) {
        Todo todo = new Todo();
        todo.setTitle(dto.getTitle());
        todo.setCompleted(dto.isCompleted());
        return todo;
    }
}
