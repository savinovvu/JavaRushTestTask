package ru.inbox.savinov_vu.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.inbox.savinov_vu.entity.User;
import ru.inbox.savinov_vu.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class MainController {


    static public UserServiceImpl userDao = new UserServiceImpl();


    /*Стартовая страница*/
    @RequestMapping("/")
    public String printWelcome(Model model) {
        UserServiceImpl userDao = new UserServiceImpl();
        model.addAttribute("users", null);
        return "welcome";
    }


    /* Отображение всех пользователей*/
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String printAllUsers(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");

        int numberOfPage = Integer.parseInt(request.getParameter("numberOfPage"));

        if ("".equals(name) || name == null) {

            List<User> users = userDao.getAll(numberOfPage);

            model.addAttribute("users", users);
            model.addAttribute("countPages", userDao.countPages());
            model.addAttribute("numberOfPage", numberOfPage );
            return "readUsers";
        } else {

            model.addAttribute("name", name);
            model.addAttribute("users", userDao.getByName(name, numberOfPage));
            model.addAttribute("countPages", userDao.countPages());
            model.addAttribute("numberOfPage", numberOfPage );
            return "readUsers";
        }
    }





    /*Отображение пользователя по ID*/
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public String getUserFromId(HttpServletRequest request, Model model) {
        List<User> list = new ArrayList<>();
        User user = userDao.getById(Integer.parseInt(request.getParameter("id")));
        list.add(user);
        System.out.println(user);
        model.addAttribute("users", list);
        return "readUsers";
    }

    /*Редактирование Пользователя*/
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUserFromId(HttpServletRequest request, Model model) {
        System.out.println(userDao.getById(Integer.parseInt(request.getParameter("id"))).getName());/////////////////
        model.addAttribute("users", userDao.getById(Integer.parseInt(request.getParameter("id"))));
        return "editUser";
    }

    @RequestMapping(value = "/finishEdit", method = RequestMethod.GET)
    public String finishEdit(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));

        User selectedUser = userDao.getById(id);
        selectedUser.setName(name);
        selectedUser.setAge(age);
        selectedUser.setIsAdmin(isAdmin);
        userDao.editUser(selectedUser);

        return "welcome";
    }


    /*Удалить пользователя*/
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUserFromId(HttpServletRequest request) {
        userDao.delete(Integer.parseInt(request.getParameter("id")));
        return "welcome";
    }

    /*Добавить пользователя*/
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser() {
        return "addUser";
    }

    /*Добавить пользователя*/
    @RequestMapping(value = "/finishAdd", method = RequestMethod.GET)
    public String finishAddUserFromId(HttpServletRequest request) {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));
        User newUser = new User(name, age, isAdmin, new Date());
        userDao.addUser(newUser);
        return "welcome";
    }
}
