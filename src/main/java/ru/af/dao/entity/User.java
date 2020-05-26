package ru.af.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "team_id")
//    private Team team;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    private List<Word> wordList;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    public List<Word> getWordList() {
//        return wordList;
//    }
//
//    public void setWordList(List<Word> wordList) {
//        this.wordList = wordList;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", team=" + team +
                '}';
    }
}
