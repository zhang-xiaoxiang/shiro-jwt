package com.example.shirojwt.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * MyFilter:
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/12
 */
@Component
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!false) {
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
}



