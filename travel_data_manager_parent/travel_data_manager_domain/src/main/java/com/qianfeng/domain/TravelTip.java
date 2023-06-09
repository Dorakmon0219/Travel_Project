package com.qianfeng.domain;

import java.util.Date;

public class TravelTip {
    private String tipId;
    private Date shareTime;
    private String address;
    private String author;
    private String introduction;
    private String url;
    private int readCount;

    public TravelTip() {

    }

    public TravelTip(String tipId, Date shareTime, String address, String author, String introduction, String url, int readCount) {
        this.tipId = tipId;
        this.shareTime = shareTime;
        this.address = address;
        this.author = author;
        this.introduction = introduction;
        this.url = url;
        this.readCount = readCount;
    }

    public String getTipId() {
        return tipId;
    }

    public void setTipId(String tipId) {
        this.tipId = tipId;
    }

    public Date getShareTime() {
        return shareTime;
    }

    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    @Override
    public String toString() {
        return "TravelTip{" +
                "tipId='" + tipId + '\'' +
                ", shareTime=" + shareTime +
                ", address='" + address + '\'' +
                ", author='" + author + '\'' +
                ", introduction='" + introduction + '\'' +
                ", url='" + url + '\'' +
                ", readCount=" + readCount +
                '}';
    }
}
