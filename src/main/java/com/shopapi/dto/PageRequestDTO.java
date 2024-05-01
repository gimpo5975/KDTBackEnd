package com.shopapi.dto;
// 페이지 번호나 사이즈 등을 처리

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder  //자바 빈(java Bean) 클래스를 빌더 패턴으로 간편하게 구현
                // 상속받은 필드도 빌더에서 사용할 수 있도록 처리하기 위해
                // @Builder는 상속 받은 필드를 빌더에서 사용하지 못함

@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

}