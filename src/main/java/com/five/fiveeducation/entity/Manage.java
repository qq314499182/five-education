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
    private Long listCount ;

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
