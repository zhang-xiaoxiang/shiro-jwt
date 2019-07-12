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
    public String rtnCode;

    /**
     * 统一错误消息
     */
    public String rtnMsg;

    /**
     * 结果对象
     */
    public T rtnData;

    public ResponseData() {
    }

    public ResponseData(String rtnCode, String rtnMsg) {
        this.rtnCode = rtnCode;
        this.rtnMsg = rtnMsg;
    }
}
