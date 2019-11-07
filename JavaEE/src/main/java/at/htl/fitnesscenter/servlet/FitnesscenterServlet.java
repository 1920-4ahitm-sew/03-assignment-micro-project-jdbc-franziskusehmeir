package at.htl.fitnesscenter.servlet;

import at.htl.fitnesscenter.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("fitnesscenterservlet")
public class FitnesscenterServlet extends HttpServlet{
    @PersistenceContext
    EntityManager em;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TypedQuery<Customer> query = em.createNamedQuery("customer.findall",Customer.class);
        List<Customer> products = query.getResultList();
        resp.getWriter().printf("" + products);
    }
}