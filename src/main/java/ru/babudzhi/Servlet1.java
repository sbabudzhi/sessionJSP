package ru.babudzhi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import org.h2.Driver;



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
            Class.forName("org.h2.Driver");
            try (Connection db = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
                try (Statement dataQuery = db.createStatement()) {
                    dataQuery.execute(CREATE_QUERY);
                    dataQuery.execute(DATA_QUERY);
                }

                try (PreparedStatement query =
                             db.prepareStatement("SELECT * FROM TEST123")) {
                    ResultSet rs = query.executeQuery();
                    while (rs.next()) {
                        System.out.println(String.format("%s, %s!",
                                rs.getString(2),
                                rs.getString("name1")));
                    }
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("Database connection failure: "
                        + ex.getMessage());
            }

        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        private static final String CREATE_QUERY =
                "CREATE TABLE TEST123 (name3 VARCHAR(45), name1 VARCHAR(45), name2 varchar (45))";

        private static final String DATA_QUERY =
                "INSERT INTO TEST123 VALUES('бабуджи', 'светлана', 'юрьевна')";


}
