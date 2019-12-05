package com.zhiyou.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseVo<T> {
    private Integer code;
    private String message;
    private T data;
}
