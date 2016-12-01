package inno.controller;

import inno.model.User;
import inno.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String addSignUpPage(ModelMap map) {
        map.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute @Valid User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "signup";
        }
        userRepository.add(user);
        session.setAttribute("user", user);
        return "redirect:/posts";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String addLogInPage(ModelMap map) {
        map.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String LogInUser(@ModelAttribute User user, BindingResult result, HttpSession session) {
        User foundUser = userRepository.findByLogin(user.getLogin());
        if (foundUser == null) {
            result.addError(new FieldError("user", "login",
                    "Пользователь с таким логином не существует"));
            return "login";
        } else if (!foundUser.getPassword().equals(user.getPassword())) {
            result.addError(new FieldError("user", "password", "Неправильный пароль"));
            return "login";
        }
        session.setAttribute("user", foundUser);
        return "redirect:/posts";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String LogOutUser(ModelMap map, HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/posts";
    }

}
