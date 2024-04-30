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
@RequiredArgsConstructor  //생성자 자동 주입
public class TodoServiceImpl implements TodoService{

    //자동 주입 대상은 final
    private final ModelMapper modelMapper;
    private final TodoRepository todoRepository;


    //#1. 등록(insert)
    @Override
    public Long register(TodoDTO todoDTO) {

        log.info("등록!!! .........");

        Todo todo = modelMapper.map(todoDTO, Todo.class);

        Todo savedTodo = todoRepository.save(todo);

        return savedTodo.getTno();

    }


    //#2. 조회(select)
    @Override
    public TodoDTO get(Long tno) {

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        TodoDTO dto = modelMapper.map(todo, TodoDTO.class);

        return dto;
    }

    //#3. 업데이트(update)
    @Override
    public void modify(TodoDTO todoDTO) {

        Optional<Todo> result = todoRepository.findById(todoDTO.getTno());

        Todo todo = result.orElseThrow();

        todo.changeTitle(todoDTO.getTitle());
        todo.changeDueDate(todoDTO.getDueDate());
        todo.changeComplete(todoDTO.isComplete());

        todoRepository.save(todo);

    }

    //#4. 삭제(delete)
    @Override
    public void remove(Long tno) {

        todoRepository.deleteById(tno);

    }

}