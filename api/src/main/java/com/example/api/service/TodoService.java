package com.example.api.service;

import com.example.api.entity.Todo;
import com.example.api.repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

  private final TodoRepository todoRepository;

  // Utilisation de l'injection par constructeur (recommandé plutôt que
  // @Autowired)
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  // Récupérer tous les todos
  public List<Todo> getAllTodos() {
    return todoRepository.findAll();
  }

  // Récupérer un todo par son ID
  public Optional<Todo> getTodoById(Long id) {
    return todoRepository.findById(id);
  }

  // Créer ou sauvegarder un todo
  public Todo createTodo(Todo todo) {
    return todoRepository.save(todo);
  }

  // Supprimer un todo
  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }
}