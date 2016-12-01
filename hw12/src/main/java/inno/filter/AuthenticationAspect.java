package inno.filter;


import inno.exceprion.LoginException;
import inno.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class AuthenticationAspect {

    private static HttpSession getSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true);
    }

    public String filterController(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpSession session = getSession();
        User user = (User) session.getAttribute("user");

        /**Завернул контроллер в аспект и вернул другое имя представления*/
//        if (user == null) {
//            return "redirect:/error";
//        }
//        Object result = joinPoint.proceed();
//        return result.toString();

        if(user == null) {
            throw new LoginException();
        }
        Object result = joinPoint.proceed();
        return result.toString();
    }

}
