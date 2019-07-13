package com.example.shirojwt.exception;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.shirojwt.result.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * DefaultExceptionHandler:自定义异常处理器
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/12
 */
@Slf4j
@ControllerAdvice  //不指定包默认加了@Controller和@RestController都能控制
//@ControllerAdvice(basePackages ="com.example.demo.controller")
public class DefaultExceptionHandler {




    /**
     * 异常统一自定义处理
     */
    @ExceptionHandler({MyException.class})
    @ResponseBody
    public ResponseData MyException(MyException e) {
        ResponseData responseData=new ResponseData<>();
        responseData.setCode(500);
        responseData.setMsg(e.getMessage());
        responseData.setData(null);
        return responseData;
    }
    /**
     * 异常统一处理(最后的异常处理)
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
