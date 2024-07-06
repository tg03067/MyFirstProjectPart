package org.example.myproject.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto<T> implements Result {
    @Builder.Default
    private Integer code = 1 ;
    @Builder.Default
    private String msg = "정상처리 되었습니다." ;

    private T data;
}
