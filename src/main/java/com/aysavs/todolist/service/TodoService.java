package com.aysavs.todolist.service;

import com.aysavs.todolist.dto.TodoDTO;
import com.aysavs.todolist.entity.Todo;
import com.aysavs.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDTO> getAllTodos() {
        return todoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TodoDTO getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        return mapToDTO(todo);
    }

    public TodoDTO createTodo(TodoDTO todoDTO) {
        Todo todo = mapToEntity(todoDTO);
        return mapToDTO(todoRepository.save(todo));
    }

    public TodoDTO updateTodo(Long id, TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setTitle(todoDTO.getTitle());
        todo.setCompleted(todoDTO.isCompleted());
        return mapToDTO(todoRepository.save(todo));
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    public List<TodoDTO> getCompletedTodos() {
        return todoRepository.findByCompleted(true)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private TodoDTO mapToDTO(Todo todo) {
        TodoDTO dto = new TodoDTO();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setCompleted(todo.isCompleted());
        return dto;
    }

    private Todo mapToEntity(TodoDTO dto) {
        Todo todo = new Todo();
        todo.setId(dto.getId());
        todo.setTitle(dto.getTitle());
        todo.setCompleted(dto.isCompleted());
        return todo;
    }
}
