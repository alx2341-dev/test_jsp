package com.servlets;

import com.dto.Color;
import com.helper.Helper;
import com.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Service<Color> colorService = new ColorService();
        try {
            List<Color> colorList = colorService.getDataList();

            JSONArray colorListJsonArray = Helper.listColorToJsonArray(colorList);

            request.setAttribute("jsonArray", colorListJsonArray);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

            /*request.setAttribute("jsonArray", colorListJsonArray.toString());

            request.getRequestDispatcher("test.jsp").forward(request, response);
*/
            /*
            request.getSession().setAttribute("jsonArray", colorListJsonArray.toString());

            response.sendRedirect("test.jsp");
*/
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }
    }
}
