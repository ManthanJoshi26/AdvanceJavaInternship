import javax.persistence.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Forms",urlPatterns = "/form")
public class Forms extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("Uname");
        String pwd = request.getParameter("pwd");

        PrintWriter out = response.getWriter();

       try {

           EntityManagerFactory emf = Persistence.createEntityManagerFactory("frm");

           out.println("under emf");

           EntityManager em = emf.createEntityManager();

           out.println("under em ");


           EntityTransaction transaction =  em.getTransaction();

           transaction.begin();

           Form2 f1 = new Form2();

           f1.setName(name);
           f1.setPwd(pwd);

           em.persist(f1);

           transaction.commit();

           em.close();


       }

       catch (Exception e){

           out.println("<h2>"+"Error :- " + e + "</h2>");

       }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
