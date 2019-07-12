package com.example.shirojwt.filter;

import com.example.shirojwt.jwt.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
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
public class JwtFilter  extends BasicHttpAuthenticationFilter implements Filter {




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
            executeLogin(request, response);
            return true;
        } catch (Exception e) {
            log.error("JwtFilter过滤验证失败!");
            return false;
        }
    }


    @Override
    public void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        log.warn("进入了MyFilter。。。。");
          boolean flag=false;
        try {
            flag= executeLogin(request, response);
        } catch (Exception e) {
            flag=false;
        }
        //flag登录错误直接写出去
        if (flag) {
            log.warn("直接写出.................");
            Map<String, String> map = new HashMap<>();
            map.put("code", "9999");
            map.put("msg", "没有访问权限，如需要访问，请联系管理员!");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(map);
            return;
        }

        chain.doFilter(request, response);
        return;
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
        } catch (AuthenticationException e) {
            return false;
        }
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
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
