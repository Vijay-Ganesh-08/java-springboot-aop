package org.training.sprinbootaop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private int eid;

    private String firstname;
    private String lastname;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Employee() {
    }

    public Employee(int eid, String firstname, String lastname) {
        this.eid = eid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

}