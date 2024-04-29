package com.shopapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_todo")
public class Todo {
    @Id    //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY )  //auto_increment, 데이터베이스가 알아서 처리, 자동으로 생성
    private Long tno;
    //    @Column(name="content", length = 20)
    private String title;
    //    @Column(nullable = false)
    private String writer;
    private boolean complete;
    private LocalDate dueDate;

}