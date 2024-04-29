package com.shopapi.service;

import com.shopapi.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Log4j2
public class TodoServiceImpl implements TodoService{

    @Override
    public Long register(TodoDTO todoDTO) {
        log.info("^^^^^^^^^^^^^^^^^^^^^^");
        return null;
    }//end of method




}//end of class
