package com.example.shirojwt.exception;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.shirojwt.result.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * DefaultExceptionHandler:
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/12
 */
@Slf4j
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
        responseData.setCode(500);
        responseData.setMsg("系统异常");
        responseData.setData(null);
        return responseData;
    }
}
