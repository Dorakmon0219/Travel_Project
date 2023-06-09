package com.qianfeng.domain;

public class HotelInfo {
    private String hotelId;
    private String hotelName;
    private String address;
    private String phoneNum;
    private String contacter;
    private int price;
    private String hotelType;

    public HotelInfo() {
    }

    public HotelInfo(String hotelId, String hotelName, String address, String phoneNum, String contacter, int price, String hotelType) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.address = address;
        this.phoneNum = phoneNum;
        this.contacter = contacter;
        this.price = price;
        this.hotelType = hotelType;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    @Override
    public String toString() {
        return "HotelInfo{" +
                "id='" + hotelId + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", contacter='" + contacter + '\'' +
                ", price=" + price +
                ", hotelType='" + hotelType + '\'' +
                '}';
    }
}
