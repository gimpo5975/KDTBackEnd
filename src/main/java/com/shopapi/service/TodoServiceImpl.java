package com.shopapi.service;

import com.shopapi.domain.Todo;
import com.shopapi.dto.TodoDTO;
import com.shopapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public TodoDTO get(Long tno) {

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo  = result.orElseThrow();

        return entityToDTO(todo);
    }

    @Override
    public Long register(TodoDTO dto) {

        Todo todo = dtoToEntity(dto);
        Todo result = todoRepository.save(todo);

        return result.getTno();
    }


    @Override
    public void modify(TodoDTO dto) {

        Optional<Todo> result = todoRepository.findById(dto.getTno());

        Todo todo  = result.orElseThrow();

        todo.setTitle(dto.getTitle());
        todo.setContent(dto.getContent());
        todo.setComplete(dto.isComplete());
        todo.setDueDate(dto.getDueDate());

        todoRepository.save(todo);

    }

    @Override
    public void remove(Long tno) {

        todoRepository.deleteById(tno);

    }



}//end of interface
