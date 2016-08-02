package com.issc29.sample;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class sampleServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");

        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);

        int sum = mathUtils.sum(num1, num2);

       // request.setAttribute("sumTotal",sum);

        PrintWriter out = response.getWriter();
        out.println(sum);
        out.flush();
        out.close();

    }
}



