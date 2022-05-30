package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {
    
    // Get requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "---";
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }

    // Post requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        
        request.setAttribute("firstNum", first);
        request.setAttribute("secondNum", second);
        
        if (first == null || first.equals("") || second == null || second.equals("")) {
            String message = "invalid";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
        
        try {
            int firstNum = Integer.parseInt(first);
            int secondNum = Integer.parseInt(second);
            if (request.getParameter("add") != null) {
                int total = firstNum + secondNum;
                request.setAttribute("message", total);
            } else if (request.getParameter("subtract") != null) {
                int total = firstNum - secondNum;
                request.setAttribute("message", total);
            } else if (request.getParameter("multiply") != null) {
                int total = firstNum * secondNum;
                request.setAttribute("message", total);
            } else {
                int total = firstNum % secondNum;
                request.setAttribute("message", total);
            }
        } catch (NumberFormatException e) {
            String message = "invalid";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
    getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    return;
    }
}