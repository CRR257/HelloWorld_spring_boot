package com.example.HelloWorld.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Date tStamp = new Date();

    public Log() {

    }
    public Log(Date tStamp) {
        this.settStamp(tStamp);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date gettStamp() {
        return tStamp;
    }

    public void settStamp(Date tStamp) {
        this.tStamp = tStamp;
    }
}

