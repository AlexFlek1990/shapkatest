package ru.af.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="teams")
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private int id;

    @Column(name = "name", nullable = false, unique = true, length = 11)
    private String name;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
//    private List<User> userList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<User> getUserList() {
//        return userList;
//    }

//    public void setUserList(List<User> userList) {
//        this.userList = userList;
//    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
