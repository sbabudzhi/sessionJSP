package ru.babudzhi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            /* возвращается ссылка на сессию для текущего пользователя (если сессия еще не существует, то она при этом создается) */
            response.setContentType("text/html;charset=utf8");
            HttpSession session = request.getSession();
            PrintWriter out = response.getWriter();

            String name3 = new String(request.getParameter("lastname").getBytes("iso-8859-1"), "utf8");
            session.setAttribute("name3", name3);


            out.println("<h2>Поздравляю с третьим этапом!</h2> " +
                    "<p>Добро пожаловать, " +
                    session.getAttribute("name3") + " " + session.getAttribute("name") + " " + session.getAttribute("name2") + "</p>"
            );

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
