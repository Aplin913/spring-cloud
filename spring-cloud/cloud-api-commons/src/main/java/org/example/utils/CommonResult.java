package org.example.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T extends Serializable> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){ this(code, message, null);}
}
