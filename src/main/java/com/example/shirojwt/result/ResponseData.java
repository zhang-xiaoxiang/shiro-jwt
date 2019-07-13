package com.example.shirojwt.result;

import lombok.Data;

/**
 * ResponseData:
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/12
 */
@Data
public class ResponseData<T> {

    /**
     * 统一返回码
     */
    public Integer code;

    /**
     * 统一错误消息
     */
    public String msg;

    /**
     * 结果对象
     */
    public T data;

    public ResponseData() {
    }

    public ResponseData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}
