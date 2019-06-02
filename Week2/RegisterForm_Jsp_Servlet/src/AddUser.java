import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "AddUser", urlPatterns = "/add")
public class AddUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String id = request.getParameter("pwd");

        PrintWriter out = response.getWriter();

        out.println(id);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "root1234");


            Statement st = conn.createStatement();

            String sql = "select name,id from user";

            st.execute(sql);

            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                String name1 = rs.getString("name");
                String pwd1 = rs.getString("id");


                if (name1.equals(request.getParameter("name")) && pwd1.equals(request.getParameter("pwd"))) {


                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    break;
                } else {
                    PreparedStatement ps = conn.prepareStatement("INSERT into user values (?,?)");
                    ps.setString(1, name);
                    ps.setString(2, id);

                    int flag = ps.executeUpdate();

                    if (flag > 0) {

                        request.getRequestDispatcher("welcome.jsp").forward(request, response);

                    }
                }
            }

        } catch (Exception e) {

            out.println("Error" + e);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

//        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
