package com.example.shirojwt.filter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.shirojwt.jwt.JwtToken;
import com.example.shirojwt.result.ResponseData;
import com.example.shirojwt.result.ResponseDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * JwtFilter:jwt过滤器来作为shiro的过滤器
 * 现在这里进行过滤,之后再到过滤器
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/12
 */
@Slf4j
@Component
public class JwtFilter extends BasicHttpAuthenticationFilter implements Filter {



    /**
     * 执行登录认证
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        try {
           return executeLogin(request, response);
//            return true;
        } catch (Exception e) {
            log.error("JwtFilter过滤验证失败!");
            return false;
        }
    }



    /**
     *
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Token");
        JwtToken jwtToken = new JwtToken(token);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        try {
            getSubject(request, response).login(jwtToken);
            // 如果没有抛出异常则代表登入成功，返回true
            return true;
        } catch (AuthenticationException e) {
            System.out.println("executeLogin   ==>>"+e.getMessage());
            ResponseData responseData = ResponseDataUtil.authorizationFailed( "没有访问权限，原因是:" + e.getMessage());
            //SerializerFeature.WriteMapNullValue为了null属性也输出json的键值对
            Object o = JSONObject.toJSONString(responseData, SerializerFeature.WriteMapNullValue);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(o);
            return false;
        }

    }


    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }




}
