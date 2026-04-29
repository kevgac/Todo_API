# 📝 Todo API - Spring Boot 3

![CI Status](https://github.com/kevgac/api/actions/workflows/ci.yml/badge.svg)
![Java Version](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-brightgreen?style=flat-square&logo=springboot)

> API REST robuste de gestion de tâches (To-Do List) développée pour démontrer la maîtrise des fondamentaux du backend moderne : architecture en couches, tests unitaires et automatisation.

---

## 🚀 Vue d'ensemble

Ce projet est une API complète permettant de gérer des listes de tâches. Au-delà du simple CRUD, il met en œuvre les meilleures pratiques de développement Java :
- **Validation stricte** des données entrantes.
- **Documentation interactive** intégrée.
- **Tests automatisés** garantissant la stabilité du code.

---

## 🛠️ Stack Technique

- **Backend** : Java 21 (LTS), Spring Boot 3
- **Persistance** : Spring Data JPA, H2 Database (In-Memory pour le développement)
- **Validation** : Bean Validation (Hibernate Validator)
- **Tests** : JUnit 5, Mockito
- **Documentation** : Swagger UI / OpenAPI 3
- **CI/CD** : GitHub Actions (Build & Test automatique à chaque push)

---

## 🏗️ Architecture du Projet

Le projet suit une architecture "Standard Spring" pour une séparation claire des responsabilités :
- `Controller` : Exposition des endpoints REST et gestion des codes de réponse HTTP.
- `Service` : Logique métier et manipulation des données.
- `Repository` : Interface d'accès à la base de données via JPA.
- `Entity` : Modèle de données avec contraintes de validation.

---

## 🔍 Aperçu des Endpoints

| Méthode | Endpoint | Description | Code Succès |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/todos` | Récupérer toutes les tâches | `200 OK` |
| `POST` | `/api/todos` | Créer une nouvelle tâche | `201 Created` |
| `GET` | `/api/todos/{id}` | Détails d'une tâche | `200 OK` |
| `DELETE` | `/api/todos/{id}` | Supprimer une tâche | `204 No Content` |

---

## 🚦 Comment tester ?

### 1. Lancer l'application
```bash
mvn spring-boot:run