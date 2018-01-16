package com.five.fiveeducation.entity;

import java.util.List;


public class EducationSearch {

    /**
     * 培训l类型
     */
    private List<Integer> trainType;

    /**
     * 培训主题
     */
    private List<String> trainSubject;

    /**
     * 国家
     */
    private List<Integer> country;

    /**
     * 地区
     */
    private List<Integer>region;

    /**
     * 开始时间区间
     */
    private List<Integer> startDateInterval;

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

    public List<Integer> getTrainType() {
        return trainType;
    }

    public void setTrainType(List<Integer> trainType) {
        this.trainType = trainType;
    }

    public List<String> getTrainSubject() {
        return trainSubject;
    }

    public void setTrainSubject(List<String> trainSubject) {
        this.trainSubject = trainSubject;
    }

    public List<Integer> getCountry() {
        return country;
    }

    public void setCountry(List<Integer> country) {
        this.country = country;
    }

    public List<Integer> getRegion() {
        return region;
    }

    public void setRegion(List<Integer> region) {
        this.region = region;
    }

    public List<Integer> getStartDateInterval() {
        return startDateInterval;
    }

    public void setStartDateInterval(List<Integer> startDateInterval) {
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
