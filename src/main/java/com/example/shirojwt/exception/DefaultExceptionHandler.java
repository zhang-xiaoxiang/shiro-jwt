package com.example.shirojwt.exception;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.shirojwt.result.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * DefaultExceptionHandler:
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/12
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    /**
     * 异常统一处理
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseData allException(Exception e) {
        ResponseData responseData=new ResponseData<>();
        responseData.setRtnCode("500");
        responseData.setRtnMsg("系统异常"+e.getMessage());
        responseData.setRtnCode(null);
        return responseData;
    }
}
