package entity;

import java.util.Date;

public class Hotel {
    private Integer orderNo;
    private String city;
    private Float price;
    private String hotelname;
    private Date arrivedate;
    private Date leavedate;

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public Date getArrivedate() {
        return arrivedate;
    }

    public void setArrivedate(Date arrivedate) {
        this.arrivedate = arrivedate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "orderNo=" + orderNo +
                ", city='" + city + '\'' +
                ", price=" + price +
                ", hotelname='" + hotelname + '\'' +
                ", arrivedate=" + arrivedate +
                ", leavedate=" + leavedate +
                '}';
    }
}
