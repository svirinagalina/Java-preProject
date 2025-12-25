package web.controller;

import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // простой тест: текст прямо в браузер
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("msg", "UserController is working");
        return "test";   // test.html
    }

    // опционально: главная страница
    @GetMapping("/")
    public String index() {
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "users";          // users.html
    }

    @GetMapping("/users/add")
    public String showAddForm() {
        return "user-add";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String name,
                          @RequestParam String surname) {

        User user = new User();
        user.setName(name);
        user.setSurname(surname);

        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    public String showEditForm(@RequestParam int id,
                               Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @PostMapping("/users/edit")
    public String editUser(@RequestParam int id,
                           @RequestParam String name,
                           @RequestParam String surname) {

        User user = userService.getById(id);
        user.setName(name);
        user.setSurname(surname);
        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
