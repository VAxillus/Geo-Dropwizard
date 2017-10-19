package com.server.backend;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
//import java.util.Date;
import java.sql.Date;


public class Commercial {

    @NotNull
    @JsonProperty
    private Integer id;

    @NotNull
    @JsonProperty
    private String company;

    @NotNull
    @JsonProperty
    private double credit;

    @NotNull
    @JsonProperty
    private Date startDate;

    public Commercial(){
        // Jackson deserialization
    }
    public Commercial(String company, double credit, Date startDate) {
        this.company = company;
        this.credit = credit;
        this.startDate = startDate;
    }

    public Commercial(int id, String company, double credit, Date startDate) {
        this.id = id;
        this.company = company;
        this.credit = credit;
        this.startDate = startDate;
    }


    public String getCompany() {
        return this.company;
    }

    public double getCredit() {
        return this.credit;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    @JsonProperty
    public void setCompany(String company) { this.company = company;}
    @JsonProperty
    public void setCredit(double credit) { this.credit = credit;}
    @JsonProperty
    public void setStartDate(Date startDate) { this.startDate = startDate;}


}
