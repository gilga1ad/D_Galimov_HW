package inno.exceprion;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**Глобальный перехватчик исключений*/
@ControllerAdvice
public class LoginExceptionAdvice {

    @ExceptionHandler(LoginException.class)
    public String errorLogin() {
        System.out.println("access denied");
        return "redirect:/login";
    }
}