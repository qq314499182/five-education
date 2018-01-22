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
     * 管理培训主题搜索  0 显示 1隐藏
     */
    private Integer trainSubject = 0;

    /**
     * 机构名称搜索 0 显示 1隐藏
     */
    private Integer sponsor = 0;

    /**
     * 讲师信息搜索 0显示 1隐藏
     */
    private Integer lectuer = 0;

    /**
     * 累计搜索数
     */
    private Long searchCount = 0L;

    /**
     * 列表总计
     */
    private Long listCount ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTrainSubject() {
        return trainSubject;
    }

    public void setTrainSubject(Integer trainSubject) {
        this.trainSubject = trainSubject;
    }

    public Integer getSponsor() {
        return sponsor;
    }

    public void setSponsor(Integer sponsor) {
        this.sponsor = sponsor;
    }

    public Integer getLectuer() {
        return lectuer;
    }

    public void setLectuer(Integer lectuer) {
        this.lectuer = lectuer;
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
