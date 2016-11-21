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
import java.util.List;

@WebServlet(urlPatterns = "/twitter")
public class TweeterServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tweet> tweets = service.getTweets();
        req.setAttribute("tweets", tweets);
        req.getRequestDispatcher("/tweets.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String message = req.getParameter("message");
        service.add(message);
        resp.sendRedirect("/twitter");
    }

}
