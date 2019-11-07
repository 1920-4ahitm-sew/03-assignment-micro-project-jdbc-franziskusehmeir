package at.htl.fitnesscenter.boundary;

import at.htl.fitnesscenter.model.Customer;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Stateless
@Path("customer")
public class CustomerEndpoint {
    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init(){
        System.err.println("CustumerEndpoint created *****");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Customer getCustomer(@PathParam("id") long id) {
        return em.find(Customer.class, id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public List<Customer> getAll() {
        return em.createNamedQuery("customer.findall", Customer.class).getResultList();
    }
}

