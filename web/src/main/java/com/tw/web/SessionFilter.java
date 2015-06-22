package com.tw.web;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xiehaiyan on 6/18/15.
 */
//@SessionAttributes({"userInfo"})
//public class SessionFilter implements Filter {
//    private FilterConfig filterConfig;
//
//    private String excludePath;
//
//    private String redirectUrl;
//
//    private String loginUrl;
//
//    public void destroy() {
//        this.filterConfig = null;
//
//    }
//    public void doFilter(ServletRequest req, ServletResponse res,
//                         FilterChain chain) throws IOException, ServletException {
//        ModelMap map;
//        HttpServletRequest request = (HttpServletRequest)req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        String url = request.getRequestURL().toString();
//        String controller = url.substring(url.lastIndexOf("/")+1);
//        String[] exclude = excludePath.split(",");
//        boolean flag = false;
//        for(String str:exclude){
//            if(url.indexOf(str)!=-1){
//                flag = true;
//                break;
//            }
//        }
//        if(flag){
//            chain.doFilter(request, response);
//        }else{
//            String tag = (String)SessionTimeOutListener.threadLocal.get();
//            String userInfo =(String) request.getSession().getAttribute("userInfo");
//            if(null!=tag && tag.equals("timeOut")){
//                response.sendRedirect(request.getContextPath()+redirectUrl);
//                return ;
//            }else if(null==tag && null==userInfo){
//                response.sendRedirect(request.getContextPath()+loginUrl);
//                return ;
//            }else if(null!=userInfo){
//                chain.doFilter(request, response);
//            }
//
//        }
//        chain.doFilter(request, response);
//    }
//
//
//    public void init(FilterConfig filterConfig) throws ServletException {
//        this.filterConfig = filterConfig;
//        this.excludePath = this.filterConfig.getInitParameter("excludePath");
//        this.redirectUrl = this.filterConfig.getInitParameter("redirectUrl");
//        this.loginUrl =this.filterConfig.getInitParameter("loginUrl");
//    }
//
//
//public class  SessionFilter implements HandlerInterceptor{
//
//    public boolean preHandle(HttpServletRequest req, HttpServletResponse res,Object Handler) throws ServletException,IOException{
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        String url = request.getRequestURL().toString();
//
////            String tag = (String)SessionTimeOutListener.threadLocal.get();
//        String username = (String) request.getSession().getAttribute("USERNAME");
//        String password = (String) request.getSession().getAttribute("PASSWORD");
////            if(null!=tag && tag.equals("timeOut")){
////                response.sendRedirect(request.getContextPath()+redirectUrl);
////                return ;
////            }
//        if (null == username | password == null) {
////                response.sendRedirect(request.getContextPath()+loginUrl);
//            // return to the login page
//            response.sendRedirect("/web/user/login");
//            return false;
//        } else {
////                chain.doFilter(request, response);
//            //enter the correct page
//            return true;
//        }
//
//    }
//}

public class SessionFilter implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("USERNAME")== null){
            String Return_Url = request.getRequestURL().toString();
            response.sendRedirect("/web/login/");
            session.setAttribute("return_url",Return_Url);
            return false;

        }
        else{
            return true;
        }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}



