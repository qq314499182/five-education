package com.five.fiveeducation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 累计搜索数
     */
    private Long searchCount = 0L;

    /**
     * 列表总计
     */
    private Long listCount = 0L;

    /**
     *  累计报名数
     */
    private Long enrollCount = 0L;

    /**
     * 累计跳转链接数
     */
    private Long clickCount = 0L;

    public Long getEnrollCount() {
        return enrollCount;
    }

    public void setEnrollCount(Long enrollCount) {
        this.enrollCount = enrollCount;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(Long searchCount) {
        this.searchCount = searchCount;
    }

    public Long getListCount() {
        return listCount;
    }

    public void setListCount(Long listCount) {
        this.listCount = listCount;
    }
}
