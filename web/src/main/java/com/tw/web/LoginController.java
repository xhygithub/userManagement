package com.tw.web;

import com.tw.core.User;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by xiehaiyan on 6/19/15.
 */


@RestController
@RequestMapping("/login")
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView logInPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void login(@ModelAttribute User user, HttpServletRequest request,HttpServletResponse response)throws Exception{
//        List logInf=userService.listUser();
        ModelAndView modelAndView = new ModelAndView("userList");
//        System.out.print("loopstart");
        List allUser = userService.login(user.getName(), user.getPassword());
        if (allUser.size() > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("USERNAME", user.getName());
//            String message = "login successfully";
            if(session.getAttribute("return_url")!=null){
                String return_path = session.getAttribute("return_url").toString();
                request.getSession().removeAttribute("return_url");
                response.sendRedirect(return_path);
            }
            else{
                response.sendRedirect("/web/user/");
            }
//            modelAndView.addObject("message", message);
//            modelAndView.addObject("users", userService.listUser());
//            return modelAndView;

        }
        else{
            response.sendRedirect("/web/login/");
        }
    }



}
