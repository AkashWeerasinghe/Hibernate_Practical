package lk.jiat.webii.hp.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.webii.hp.entity.Address;
import lk.jiat.webii.hp.entity.City;
import lk.jiat.webii.hp.entity.Student;
import lk.jiat.webii.hp.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;

@WebServlet(name = "StudentController", urlPatterns = {"/student"})
public class StudentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        JsonObject requestObject = gson.fromJson(req.getReader(), JsonObject.class);
        JsonObject responseObject = new JsonObject();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Address address = new Address();
        address.setLineone(requestObject.get("lineone").getAsString());
        address.setLinetwo(requestObject.get("lineTwo").getAsString());

        City city = session.get(City.class, requestObject.get("cityId").getAsInt());

        address.setCity(city);

        Student student = new Student();
        student.setName(requestObject.get("name").getAsString());
        student.setEmail(requestObject.get("email").getAsString());
        student.setAddress(address);
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(address);
            session.persist(student);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }
}
