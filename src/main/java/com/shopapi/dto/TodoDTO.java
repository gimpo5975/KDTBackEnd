package com.shopapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TodoDTO {

    private Long tno;

    private String title;

    private  String content;

    private boolean complete;

    private LocalDate deuDate;

}
