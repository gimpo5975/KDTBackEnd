package com.shopapi.repository;

import com.shopapi.domain.Todo;
import com.shopapi.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {
}
