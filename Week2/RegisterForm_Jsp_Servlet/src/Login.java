import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "Login", urlPatterns = "/login")

public class Login extends HttpServlet {




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

//        HttpServletRequest request;
        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        session.setAttribute("name", name);
        session.setAttribute("pwd", pwd);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "root1234");

            Statement st = conn.createStatement();

            String sql = "select name,id from user";

            st.execute(sql);

            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                name = rs.getString("name");
                pwd = rs.getString("id");


                if (name.equals(request.getParameter("name")) && pwd.equals(request.getParameter("pwd"))) {


                    request.getRequestDispatcher("welcome.jsp").forward(request, response);

                } else {

                    request.getRequestDispatcher("error.jsp").forward(request, response);

                }
            }

        } catch (Exception e) {

            out.println("<h1>Error :- " + e + "</h1>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
