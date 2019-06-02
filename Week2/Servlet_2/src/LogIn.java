import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

@WebServlet(name = "LogIn", urlPatterns = "/1")

public class LogIn extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");
        String id = request.getParameter("id");

        PrintWriter out = response.getWriter();


        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "root1234");


//            PreparedStatement ps = connection.prepareStatement("INSERT into form1 values (?,?)");
//
//            ps.setString(1,name);
//            ps.setString(2,id);

//            PreparedStatement ps=connection.prepareStatement("delete from form1 where name = ? ");
            //           ps.setString(1,name);


            PreparedStatement ps = connection.prepareStatement("select * from form1 where ID = ? ");
            ps.setString(1, id);

            out.print("<table width=50% border=1>");
            out.print("<caption>Result:</caption>");

            ResultSet rs = ps.executeQuery();

            /* Printing column names */

            ResultSetMetaData rsmd = rs.getMetaData();

            int total = rsmd.getColumnCount();
            out.print("<tr>");

            for (int i = 1; i <= total; i++) {
                out.print("<th>" + rsmd.getColumnName(i) + "</th>");
            }

            out.print("</tr>");

            while (rs.next()) {
                out.print("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td></tr>");

            }

            out.print("</table>");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


//        int flag = rs.executeUpdate();
//
//        if (flag>0){
//
//                out.println("<h1>" + "Your data is Successfully Entered" + "</h>");
//            }
//
//            else{
//
//            out.println("<h1>" + "Your data is unsuccessfully Entered" + "</h>");
//        }

    }


}

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//
//
//    }

