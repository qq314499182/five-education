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
    private List<Integer> trainSubject;

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
    private List<Integer> daysInterval;

    /**
     * 是否收费
     */
    private Integer isFree;

    /**
     * 费用区间
     *
     */
    private List<Integer> expensesInterval;

    public List<Integer> getTrainType() {
        return trainType;
    }

    public void setTrainType(List<Integer> trainType) {
        this.trainType = trainType;
    }

    public List<Integer> getTrainSubject() {
        return trainSubject;
    }

    public void setTrainSubject(List<Integer> trainSubject) {
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

    public List<Integer> getDaysInterval() {
        return daysInterval;
    }

    public void setDaysInterval(List<Integer> daysInterval) {
        this.daysInterval = daysInterval;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    public List<Integer> getExpensesInterval() {
        return expensesInterval;
    }

    public void setExpensesInterval(List<Integer> expensesInterval) {
        this.expensesInterval = expensesInterval;
    }
}
