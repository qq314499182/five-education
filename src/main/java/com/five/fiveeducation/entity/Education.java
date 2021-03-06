package com.five.fiveeducation.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 培训类型
     */
    private String trainType;

    /**
     * 培训主题
     */
    private String trainSubject;

    /**
     * 培训地点
     */
    private String trainSite;

    /**
     * 主办方
     */
    private String sponsor;

    /**
     * 讲师信息
     */
    private String lectuer;

    /**
     * 费用
     */
    private Integer expenses;

    /**
     * 培训具体日程
     */
    private String trainPlan;

    /**
     * 培训内容链接
     */
    private String url;

    /**
     * 报名内容链接
     */
    private String twoUrl;

    /**
     * 持续时间
     */
    private Integer days;

    /**
     * 持续时间区间
     */
    private String daysInterval;

    /**
     * 国内外
     */
    private String country;

    /**
     * 地区
     */
    private String region;

    /**
     * 热度
     */
    private Integer host = 0;

    /**
     * 浏览时间
     */
    private Long scanTime = 0L;

    /**
     * 开始时间
     */
    private Date startDate;

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
     * 是否免费
     */
    private Integer isFree;

    /**
     * 价位区间
     */
    private String priceInterval;

    /**
     * 竞价
     */
    private Integer auction;

    /**
     * 是否显示
     *  0 显示
     *  1 隐藏
     */
    private Integer isShow = 0;

    /**
     * 过期
     * 0 未过期
     * 1 过期
     */
    private Integer overdue = 0;

    /**
     * 报名数
     */
    private Long enrollCount = 0L;


    /**
     * 点击外部连接数
     */
    private Long clickCount = 0L;


    public String getTwoUrl() {
        return twoUrl;
    }

    public void setTwoUrl(String twoUrl) {
        this.twoUrl = twoUrl;
    }

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

    public String getDaysInterval() {
        return daysInterval;
    }

    public void setDaysInterval(String daysInterval) {
        this.daysInterval = daysInterval;
    }

    public Integer getStratDateSearch() {
        return stratDateSearch;
    }

    public void setStratDateSearch(Integer stratDateSearch) {
        this.stratDateSearch = stratDateSearch;
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getTrainSubject() {
        return trainSubject;
    }

    public void setTrainSubject(String trainSubject) {
        this.trainSubject = trainSubject;
    }

    public String getTrainSite() {
        return trainSite;
    }

    public void setTrainSite(String trainSite) {
        this.trainSite = trainSite;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getLectuer() {
        return lectuer;
    }

    public void setLectuer(String lectuer) {
        this.lectuer = lectuer;
    }

    public Integer getExpenses() {
        return expenses;
    }

    public void setExpenses(Integer expenses) {
        this.expenses = expenses;
    }

    public String getTrainPlan() {
        return trainPlan;
    }

    public void setTrainPlan(String trainPlan) {
        this.trainPlan = trainPlan;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getScanTime() {
        return scanTime;
    }

    public void setScanTime(Long scanTime) {
        this.scanTime = scanTime;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    public String getPriceInterval() {
        return priceInterval;
    }

    public void setPriceInterval(String priceInterval) {
        this.priceInterval = priceInterval;
    }

    public Integer getAuction() {
        return auction;
    }

    public void setAuction(Integer auction) {
        this.auction = auction;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getHost() {
        return host;
    }

    public void setHost(Integer host) {
        this.host = host;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id) {
        this.id = id;
    }

}
