package com.shopapi.repository.search;

import com.querydsl.jpa.JPQLQuery;
import com.shopapi.domain.QTodo;
import com.shopapi.domain.Todo;
import com.shopapi.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {
    public TodoSearchImpl() {//생성자 생성
        super(Todo.class);
    }

    @Override
    public Page<Todo> search1(PageRequestDTO pageRequestDTO) {


        log.info("search1.........................");

        QTodo todo = QTodo.todo;
        //QTodo는 Todo 엔티티의 QueryDSL을 위한 쿼리 타입입니다.
        //todo는 QTodo.todo에서 Todo 엔티티의 인스턴스를 가져와 생성한 변수입니다.

        JPQLQuery<Todo> query = from(todo);
        //from(todo)는 Todo 엔티티에 대한 JPQLQuery를 생성합니다. 이 쿼리 객체는 Todo 엔티티에 대한
        // 쿼리를 작성할 수 있게 합니다.
        //이 쿼리는 Todo 엔티티의 인스턴스(todo)를 대상으로 합니다.



        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage()-1,
                pageRequestDTO.getSize(),
                Sort.by("tno").descending());
        //Pageable은 페이지네이션을 위한 설정을 정의하는 인터페이스입니다.
        //PageRequest.of(1, 10, Sort.by("tno").descending())는 페이지 번호(0부터 시작하므로 1은 두 번째 페이지),
        // 페이지 크기(10개 항목), 정렬 조건(키 필드인 tno를 내림차순)으로 페이지네이션 설정을 생성합니다.


        this.getQuerydsl().applyPagination(pageable, query);
        //getQuerydsl().applyPagination(pageable, query)는 쿼리에 페이지네이션 설정을 적용합니다.
        //pageable 매개변수는 페이지네이션 설정을, query 매개변수는 쿼리를 나타냅니다.

        List<Todo> list = query.fetch();// 목록 데이터
        //query.fetch()는 쿼리를 실행하고 결과를 가져옵니다.
        //이 호출은 쿼리 결과 목록을 반환하지만, 결과는 여기서 활용하지 않습니다.

        long total =  query.fetchCount();//query.fetchCount()는 쿼리 결과의 총 항목 수를 반환합니다.

        return new PageImpl<>(list, pageable, total);
    }
}
