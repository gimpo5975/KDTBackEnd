package com.shopapi.service;

import com.shopapi.domain.Todo;
import com.shopapi.dto.TodoDTO;
import com.shopapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final ModelMapper modelMapper;
    private final TodoRepository todoRepository;

    @Override
    public Long register(TodoDTO todoDTO) {

        log.info(".........");

        Todo todo = modelMapper.map(todoDTO, Todo.class);

        Todo savedTodo = todoRepository.save(todo);

        return savedTodo.getTno();

    }

    @Override
    public TodoDTO get(Long tno) {

        java.util.Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        TodoDTO dto = modelMapper.map(todo, TodoDTO.class);

        return dto;
    }

    @Override
    public void modify(TodoDTO todoDTO) {

        Optional<Todo> result = todoRepository.findById(todoDTO.getTno());

        Todo todo = result.orElseThrow();

        todo.changeTitle(todoDTO.getTitle());
        todo.changeDueDate(todoDTO.getDueDate());
        todo.changeComplete(todoDTO.isComplete());

        todoRepository.save(todo);

    }

    @Override
    public void remove(Long tno) {

        todoRepository.deleteById(tno);

    }
}