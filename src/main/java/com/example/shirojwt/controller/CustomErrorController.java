// package com.example.shirojwt.controller;
//
// import com.example.shirojwt.result.ResponseData;
// import org.springframework.beans.factory.annotation.Autowired;
//
//
// import org.springframework.boot.web.reactive.error.ErrorAttributes;
// import org.springframework.boot.web.servlet.error.ErrorController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.context.request.RequestAttributes;
// import org.springframework.web.context.request.ServletRequestAttributes;
// import org.springframework.web.context.request.ServletWebRequest;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.util.Map;
//
// /**
//  * CustomErrorController:
//  *
//  * @author zhangxiaoxiang
//  * @date: 2019/07/12
//  */
// @RestController
// public class CustomErrorController implements ErrorController {
//
//     private static final String PATH = "/error";
//     @Autowired
//     private HttpServletRequest request;
//
//     @Autowired
//     private ErrorAttributes errorAttributes;
//
//     @RequestMapping(value = PATH)
//     ResponseData error(HttpServletRequest request, HttpServletResponse response) {
//         // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring.
//         // Here we just define response body.
//         Map<String, Object> errorMap = getErrorAttributes(request);
//         ResponseData d= new ResponseData(response.getStatus()+"", errorMap.get("message").toString());
//         response.setStatus(HttpServletResponse.SC_OK);
//         return d;
//     }
//
//     @Override
//     public String getErrorPath() {
//         return PATH;
//     }
//
//     private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
//         RequestAttributes requestAttributes = new ServletRequestAttributes(request);
//         return errorAttributes.getErrorAttributes(requestAttributes, false);
//     }
//
// }
