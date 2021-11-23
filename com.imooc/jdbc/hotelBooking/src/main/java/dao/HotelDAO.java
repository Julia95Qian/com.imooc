package dao;

import entity.Hotel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class HotelDAO {
    private JdbcTemplate jdbcTemplate;

    public Hotel findByOrderNo(Integer orderNo){
        String sql = "select * from hotel where orderNo = ?";
        Hotel hotel = jdbcTemplate.queryForObject(sql, new Object[]{orderNo}, new BeanPropertyRowMapper<Hotel>(Hotel.class));
        return hotel;
    }
    public List<Hotel> findByCity(String city){
        String sql = "select * from hotel where city = ?";
        List<Hotel> hotels = jdbcTemplate.query(sql, new Object[]{city}, new BeanPropertyRowMapper<Hotel>(Hotel.class));
        return hotels;
    }
    public void insert(Hotel hotel){
        String sql = "insert into hotel(orderNo, city, price, hotelname, arrivedate, leavedate) values(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{
                hotel.getOrderNo(), hotel.getCity(), hotel.getPrice(), hotel.getHotelname(), hotel.getArrivedate(), hotel.getLeavedate()
        });

    }
    public int update(Hotel hotel){
        String sql = "UPDATE hotel SET city = ?, price = ?, hotelname = ?, arrivedate = ?, leavedate = ? WHERE orderNo = ?";
        int count = jdbcTemplate.update(sql, new Object[]{hotel.getCity(), hotel.getPrice(), hotel.getHotelname(), hotel.getArrivedate(), hotel.getLeavedate(), hotel.getOrderNo()});
        return count;
    }
    public int deleteByOrderNo(Integer orderNo){
        String sql = "delete from hotel where orderNo = ?";
        int count = jdbcTemplate.update(sql, new Object[]{orderNo});
        return count;
    }

    public void batchImport(){
        for(int i = 1; i <= 5; i++){
            /*if(i == 3){
                throw new RuntimeException("manual stop");
            }*/
            Hotel hotel = new Hotel();
            hotel.setOrderNo(20210925 + i);
            hotel.setHotelname("hotel" + i);
            hotel.setCity("SH");
            hotel.setPrice(8000 + i);
            hotel.setArrivedate(new Date(3010, 9, 25));
            insert(hotel);
        }
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
