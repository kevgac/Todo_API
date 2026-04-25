package com.example.api.controller;

import com.example.api.entity.Todo;
import com.example.api.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  // Récupérer la liste complète des tâches
  @GetMapping
  public List<Todo> getAll() {
    return todoService.getAllTodos();
  }

  // Récupérer une tâche spécifique par son ID
  @GetMapping("/{id}")
  public ResponseEntity<Todo> getById(@PathVariable Long id) {
    return todoService.getTodoById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // Créer une nouvelle tâche avec validation (@Valid)
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Todo create(@Valid @RequestBody Todo todo) {
    return todoService.createTodo(todo);
  }

  // Supprimer une tâche
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    todoService.deleteTodo(id);
    return ResponseEntity.noContent().build();
  }
}