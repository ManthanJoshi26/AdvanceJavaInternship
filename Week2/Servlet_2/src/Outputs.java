import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Outputs",urlPatterns = "/outputs")
public class Outputs extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            HttpSession session = request.getSession();

            String name = (String) session.getAttribute("Name");
            String id = (String) session.getAttribute("id");

            out.println("Hello:- " + name + "<br/><br/>");
            out.println("ID:- " + id + "<br/><br/>");

            out.close();
        } catch (Exception e) {

            out.println("Error :- " + e);

        }


    }
}
