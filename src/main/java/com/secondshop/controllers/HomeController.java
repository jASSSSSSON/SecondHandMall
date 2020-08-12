package com.secondshop.controllers;

import com.secondshop.models.User;
import com.secondshop.services.UserService;
import com.secondshop.utils.InfoCheck;
import com.secondshop.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
//用于注册登录注销的controller类
@Controller
public class HomeController {
    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }
    //跳转到用户登陆页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap mode, HttpServletRequest request) {
        String preURL = request.getHeader("Referer");//获取来访者地址
        mode.addAttribute("preURL", preURL);//将获取来访者地址存在ModelMap
        return "home/login";//跳转到用户登陆页面
    }

    /**
     * 用户登陆
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(ModelMap model,
                              @RequestParam(value = "preURL", required = false, defaultValue = "") String preURL,//获取来访者地址
                              @RequestParam(value = "email", required = false) String email,//获取前端传来的邮箱
                              @RequestParam(value = "password", required = false) String password,//获取前端传来的密码
                              HttpSession session) {//获取前端jsp传递的数据
        User user = userService.getUserByEmail(email);//通过邮箱查询用户信息
        String message;
        if (user != null){
            String mdsPass = DigestUtils.md5DigestAsHex((password + user.getCode()).getBytes());//加密密码
            if (!mdsPass .equals(user.getPassword())){//判断密码的正确性
                message = "用户密码错误！";
            } else {
                if (user.getStatusId() == 4){
                    session.setAttribute("user",user);//将登录的用户账号信息存在session
                    if (preURL.equals("")){
                        return "redirect:/";
                    } else {
                        return "redirect:" + preURL;//重定向到原页面
                    }
                } else {
                    message = "用户已失效！";
                }
            }
        } else {
            message = "用户不存在！";
        }
        model.addAttribute("message", message);//将message数据存在ModelMap
        return "home/login";//登陆成功跳转到login.jsp页面
    }

    /**
     * 用户注销
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(@RequestParam(required = false, defaultValue = "false" )String logout, HttpSession session){
        if (logout.equals("true")){
            session.removeAttribute("user");//销毁session中的数据
        }
        return "redirect:/";
    }
    /**
     *   跳转到用户注册页面
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);//user数据存在ModelMap中
        return "home/register";//跳转到用户注册页面
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerSuccess(ModelMap model,
                                  @Valid User user) {
        String status;
        Boolean insertSuccess;
        InfoCheck infoCheck = new InfoCheck();
        if (!infoCheck.isMobile(user.getMobile())){//验证手机合法性
            status = "请输入正确的手机号！";
        } else if (!infoCheck.isEmail(user.getEmail())){//验证邮箱合法性
            status = "请输入正确的邮箱！";
        } else if (userService.getUserByMobile(user.getMobile()) != null) {
            status = "此手机号码已使用！";
        } else if (userService.getUserByEmail(user.getEmail()) != null) {
            status = "此邮箱已使用！";
        } else if (user.getPassword2() == null){//验证密码与二次密码是否一致
            status = "请确认密码！";
        } else {
            RandomString randomString = new RandomString();
            user.setCode(randomString.getRandomString(5));//加密code
            String md5Pass = DigestUtils.md5DigestAsHex((user.getPassword() + user.getCode()).getBytes());
            user.setPassword(md5Pass);//加密密码password
            insertSuccess = userService.registerUser(user);//往user_table中插入用户数据
            if (insertSuccess){
                return "home/login";//插入数据成功，则跳转到login.jsp
            } else {
                status = "注册失败！";
                model.addAttribute("user", user);
                model.addAttribute("status", status);
                return "home/register";//插入数据失败，则跳转到register.jsp页面
            }
        }
        System.out.println(user.getMobile());
        System.out.println(status);
        model.addAttribute("user", user);//user存入ModelMap
        model.addAttribute("status", status);//status存入ModelMap
        return "home/register";//跳转到register.jsp页面
    }
}