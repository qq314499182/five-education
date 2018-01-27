package com.five.fiveeducation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lectuer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String  msg;

    private Integer isSee;

    public Integer getIsSee() {
        return isSee;
    }

    public void setIsSee(Integer isSee) {
        this.isSee = isSee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
