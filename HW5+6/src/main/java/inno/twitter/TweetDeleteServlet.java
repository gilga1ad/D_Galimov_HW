package inno.twitter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteTweet")
public class TweetDeleteServlet extends HttpServlet {

    @Autowired
    private TweetService service;

    //WebApplicationContext ctx;

    @Override
    public void init() throws ServletException {
        //ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        //service = (TweetService) ctx.getBean("myTweets");
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        long id = Long.valueOf(req.getParameter("id"));
        service.remove(id);
        resp.sendRedirect("/twitter");
    }

}
