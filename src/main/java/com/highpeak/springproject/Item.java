package com.highpeak.springproject;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "item_table")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int item_id;
    private String name;
    private String color;
    private String brand;
    private double size;
    private boolean isDeleted;
    private Boolean isFound;
    private String reportedDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name =  "user_id")
    private User user;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
       this.isDeleted = deleted;
    }

    public Boolean getFound() {
        return isFound;
    }

    public void setFound(Boolean found) {
        isFound = found;
    }

    public String getReportedDate() {
        return reportedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setReportedDate(String reportedDate) {
        this.reportedDate = reportedDate;


    }

}
