package com.example.api.service;

import com.example.api.entity.Todo;
import com.example.api.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Active Mockito pour JUnit 5
class TodoServiceTest {

  @Mock
  private TodoRepository todoRepository; // Simule le repo

  @InjectMocks
  private TodoService todoService; // Injecte le mock dans le service

  private Todo myTodo;

  @BeforeEach
  void setUp() {
    myTodo = new Todo(1L, "Tester mon code", "Utiliser Mockito", false);
  }

  @Test
  void shouldSaveTodoSuccessfully() {
    // GIVEN (On définit le comportement attendu du mock)
    when(todoRepository.save(any(Todo.class))).thenReturn(myTodo);

    // WHEN (On appelle la méthode du service)
    Todo savedTodo = todoService.createTodo(new Todo());

    // THEN (On vérifie les résultats)
    assertNotNull(savedTodo);
    assertEquals("Tester mon code", savedTodo.getTitle());
    verify(todoRepository, times(1)).save(any(Todo.class)); // Vérifie que save() a été appelé 1 fois
  }
}