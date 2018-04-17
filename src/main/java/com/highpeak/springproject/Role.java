package com.highpeak.springproject;

import javax.persistence.*;

@Entity
@Table(name = "role_table")
public class Role {
    @Id
    private int role_id;
    private String roleName;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


}
