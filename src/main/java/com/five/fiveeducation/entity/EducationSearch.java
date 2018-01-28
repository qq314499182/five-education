package com.five.fiveeducation.entity;

import java.util.List;


public class EducationSearch {

    /**
     * 培训类型
     */
    private List<String> trainType;

    /**
     * 培训类型模糊查询
     */
    private String trainTypeLike;

    /**
     * 培训主题
     */
    private List<String> trainSubject;

    /**
     * 国家
     */
    private List<String> country;

    /**
     * 地区
     */
    private List<String>region;

    /**
     * 开始时间区间
     */
    private List<String> startDateInterval;

    /**
     * 持续区间
     */
    private List<String> daysInterval;

    /**
     * 是否收费
     */
    private Integer isFree;

    /**
     * 费用区间
     *
     */
    private List<String> priceInterval;

    /**
     * 开始时间至今
     * 1 -- 15天以内
     * 2 -- 30天以内
     * 3 -- 60天以内
     * 4 -- 90天以内
     * 5 -- 180天以内
     * 6 -- 全年
     */
    private Integer stratDateSearch;

    /**
     * 主办方
     */
    private List<String> sponsor;

    /**
     * 讲师信息
     */
    private List<String> lectuer;

    /**
     * 查询状态 :
     *      0 为列表
     *      1 为查询
     */
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTrainTypeLike() {
        return trainTypeLike;
    }

    public void setTrainTypeLike(String trainTypeLike) {
        this.trainTypeLike = trainTypeLike;
    }

    public List<String> getSponsor() {
        return sponsor;
    }

    public void setSponsor(List<String> sponsor) {
        this.sponsor = sponsor;
    }

    public List<String> getLectuer() {
        return lectuer;
    }

    public void setLectuer(List<String> lectuer) {
        this.lectuer = lectuer;
    }

    public List<String> getPriceInterval() {
        return priceInterval;
    }

    public void setPriceInterval(List<String> priceInterval) {
        this.priceInterval = priceInterval;
    }

    public Integer getStratDateSearch() {
        return stratDateSearch;
    }

    public void setStratDateSearch(Integer stratDateSearch) {
        this.stratDateSearch = stratDateSearch;
    }

    public List<String> getTrainType() {
        return trainType;
    }

    public void setTrainType(List<String> trainType) {
        this.trainType = trainType;
    }

    public List<String> getTrainSubject() {
        return trainSubject;
    }

    public void setTrainSubject(List<String> trainSubject) {
        this.trainSubject = trainSubject;
    }

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public List<String> getRegion() {
        return region;
    }

    public void setRegion(List<String> region) {
        this.region = region;
    }

    public List<String> getStartDateInterval() {
        return startDateInterval;
    }

    public void setStartDateInterval(List<String> startDateInterval) {
        this.startDateInterval = startDateInterval;
    }

    public List<String> getDaysInterval() {
        return daysInterval;
    }

    public void setDaysInterval(List<String> daysInterval) {
        this.daysInterval = daysInterval;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

}
