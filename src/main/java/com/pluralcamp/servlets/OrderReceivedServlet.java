package com.pluralcamp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.tomcat.util.digester.SystemPropertySource;

import com.pluralcamp.data.MenuDataService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderReceivedServlet extends HttpServlet {

    MenuDataService menuDataService = new MenuDataService();

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int maxId = menuDataService.getFullMenu().size();

        for (int i = 0; i < maxId; i++) {
            String quantity = request.getParameter("item_" + i);
            try {
                int q = Integer.parseInt(quantity);
                if (q > 0){
                    System.out.printf("You have ordered %d items of %s%n", q, menuDataService.getItem(i));
                    menuDataService.addToOrder(menuDataService.getItem(i), q);
                }
            } catch (NumberFormatException nfe) {
                // that's fine it just means there wasn't a valid order for this item
                System.err.println("Error: please enter an integer number");
            }
        }

        Double total = menuDataService.getOrderTotal();

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body><h1>Quark's Restaurant</h1>");
        out.println("<h2>Order your food</h2>");

        out.printf("Thank you - your order has been received. You need to pay %.2f euros", total);

        out.println("</body></html>");
        out.close();
    }
}
