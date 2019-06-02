import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;

@WebServlet(name = "Register", urlPatterns = "/register")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try {

            PrintWriter out = response.getWriter();

            String name = request.getParameter("name");
            String id = request.getParameter("id");

            HttpSession session = request.getSession();
            session.setAttribute("Name", name);
            session.setAttribute("id", id);

            out.println("<h1>"+"<a href='outputs'>visit</a>" + "</h1>");

            out.close();


        } catch (Exception e) {

            out.print("Error:" + e);

        }


    }

}
