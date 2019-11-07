package at.htl.fitnesscenter.model;

import javax.persistence.*;

@Entity
@NamedQueries(
        @NamedQuery(
                name = "customer.findall",
                query = "select c from Customer c"
        )
)

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstname;
    String surname;

    public Customer(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public Customer(){

    }

    public Long getId() {
        return id;
    }

    /*
    public void setId(Long id) {
        this.id = id;
    }
    */

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return  id + ": firstname= " + firstname + " surname= " + surname;
    }
}


