package ru.af.dao.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "words")
public class Word implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "word", nullable = false)
    private String body;

//    @Column(name = "status", nullable = false, unique = true, length = 11)
//    private boolean status;

    @Column(name = "user_id", nullable = false)
    private long userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String word) {
        this.body = word;
    }

//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + body + '\'' +
//                ", user=" + user +
                '}';
    }
}
