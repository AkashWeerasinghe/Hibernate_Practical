package lk.jiat.webii.hp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.webii.hp.entity.Student;
import lk.jiat.webii.hp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

@WebServlet(name = "TestController", urlPatterns = {"/test"})
public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        String stuId = req.getParameter("stuId");
        Student singleResult = session.createQuery("FROM Student s WHERE s.id=:id", Student.class)
                .setParameter("id", Integer.parseInt(stuId))
                .getSingleResult();
        System.out.println(singleResult);
    }

}
