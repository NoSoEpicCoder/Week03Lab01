package sait.cprg352.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sait.cprg352.logic.UserService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usernameStr = request.getParameter("username");
        String passwordStr = request.getParameter("password");
        request.setAttribute("username", usernameStr);
        request.setAttribute("password", passwordStr);
        
        UserService userService = new UserService();
        
        if(usernameStr == null || usernameStr.isEmpty() || passwordStr == null || passwordStr.isEmpty()){
            
            request.setAttribute("displayMessage", "Both values are required");
            
        } else if(userService.login(usernameStr, passwordStr) == false){
            
            request.setAttribute("displayMessage", "Invalid username or password");
            
        } else {
            
            request.setAttribute("usernameEntered", usernameStr);
            
            getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").
                forward(request, response);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").
                forward(request, response);
    }
}