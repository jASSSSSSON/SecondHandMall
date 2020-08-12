package com.secondshop.controllers;

import com.secondshop.models.FirstType;
import com.secondshop.models.Good;
import com.secondshop.models.Order;
import com.secondshop.models.User;
import com.secondshop.services.GoodService;
import com.secondshop.services.OrderService;
import com.secondshop.services.TypeService;
import com.secondshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
    //对其他系统的调用
    private final UserService userService;
    private final GoodService goodService;
    private final TypeService typeService;
    private final OrderService orderService;

    /**
     * 自动装配
     * @param userService 用户服务
     * @param goodService 商品服务
     * @param typeService 分类服务
     * @param orderService 订单服务
     */
    @Autowired
    public AdminController(UserService userService, GoodService goodService, TypeService typeService, OrderService orderService) {
        this.userService = userService;
        this.goodService = goodService;
        this.typeService = typeService;
        this.orderService = orderService;
    }
    /**
     * 管理员登录控制器防止直接访问
     */
    @RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
    public String getAdminLogin(){
        return "admin/adminLogin";
    }

    /**
     * 管理员正常登录验证控制器
     * @param model 返回前台
     * @param email 登录名
     * @param password 密码
     * @param session 会话
     * @return 返回提示信息
     */
    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public String postAdminLogin(ModelMap model,
                                 @RequestParam(value = "email", required = false) String email,
                                 @RequestParam(value = "password", required = false) String password,
                                 HttpSession session) {
        User admin = userService.getUserByEmail(email);
        String message;
        if (admin != null){
            String mdsPass = DigestUtils.md5DigestAsHex((password + admin.getCode()).getBytes());
//            if (!mdsPass .equals(admin.getPassword())){
//                message = "用户密码错误！";
//            }
            if (!password .equals(admin.getPassword())){
                message = "用户密码错误！";
            } else if (admin.getRoleId() != 101){
                message = "用户没有权限访问！";
            } else {
                session.setAttribute("admin",admin);
                return "redirect:/admin/adminPage";
            }
        } else {
            message = "用户不存在！";
        }
        model.addAttribute("message", message);
        return "admin/adminLogin";
    }

    /**
     *  管理员退出控制器
     * @param adminLogout 退出
     * @param session 会话
     * @return 返回提示信息
     */
    @RequestMapping(value = "/adminLogout", method = RequestMethod.GET)
    public String adminLogout(@RequestParam(required = false, defaultValue = "false" )String adminLogout, HttpSession session){
        if (adminLogout.equals("true")){
            session.removeAttribute("admin");
        }
//        adminLogout = "false";
        return "redirect:/";
    }

    /**
     * 管理员主页装配
     * @param model 前台页面模型
     * @param session 会话
     * @return 返回提示信息
     */
    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public String getAdminPage(ModelMap model,
                               HttpSession session){
        User admin = (User) session.getAttribute("admin");
        if (admin == null){
            return "redirect:/admin/adminLogin";
        }
        List<Good> goodList = goodService.getAllGoodList();
        for (Good good : goodList) {
            good.setGoodUser(userService.getUserById(good.getUserId()));
            good.setGoodSecondType(typeService.getSecondTypeById(good.getSecondTypeId()));
        }
        List<User> userList = userService.getAllUser();
        List<FirstType> firstTypeList = typeService.getAllFirstType();
        List<Order> orderList = orderService.getOrderList();
        model.addAttribute("goodList", goodList);
        model.addAttribute("userList", userList);
        model.addAttribute("firstTypeList", firstTypeList);
        model.addAttribute("orderList", orderList);
        return "admin/adminPage";
    }

    /**
     * 管理员禁用/激活用户
     * @param statusId 调整用户状态
     * @param userId 被操作用户ID
     * @return 返回提示信息
     */
    @RequestMapping(value = "/user/update/status/{statusId}&{userId}", method = RequestMethod.GET)
    public ResponseEntity updateUserStatus(@PathVariable Integer statusId,
                                            @PathVariable Integer userId){
        Boolean success = userService.updateUserStatus(statusId, userId);
        if (success){
            List<User> userList = userService.getAllUser();
            return ResponseEntity.ok(userList);
        }
        return ResponseEntity.ok(success);
    }

    /**
     * 管理员删除用户
     * @param userId 被操作用户ID
     * @return  返回提示信息
     */
    @RequestMapping(value = "/user/delete/{userId}", method = RequestMethod.GET)
    public ResponseEntity deleteUser(@PathVariable Integer userId){
        Boolean success = userService.deleteUser(userId);
        if (success){
            List<User> userList = userService.getAllUser();
            return ResponseEntity.ok(userList);
        }
        return ResponseEntity.ok(success);
    }

}
