package org.spring.dto;

import lombok.Data;

/**
 * @Created by Administrator on 2018/9/22.
 * @DESC
 * @DATE 22
 */

@Data
public class ResponseDTO<T> {
    private String code;
    private String msg;
    private T data;

    public ResponseDTO(String code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
