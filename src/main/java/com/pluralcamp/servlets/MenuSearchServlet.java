package com.pluralcamp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.pluralcamp.data.MenuDataService;
import com.pluralcamp.domain.MenuItem;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MenuSearchServlet extends HttpServlet {
    public void service(HttpServletRequest request,
    HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String searchTerm = request.getParameter("searchTerm");

        MenuDataService menuDataService = new MenuDataService();                
        List<MenuItem> menuItems = menuDataService.find(searchTerm);

        out.println("<html><body><h1>Quark's Restaurant</h1>");
        out.printf("<h2>Dishes containing %s:</h2><ul>", searchTerm);

        for(MenuItem menuItem : menuItems){
            out.printf("<li>%s - %s</li>%n", menuItem, menuItem.getDescription());
        }

        out.println("</ul></body></html>");
        out.close();
}
}
