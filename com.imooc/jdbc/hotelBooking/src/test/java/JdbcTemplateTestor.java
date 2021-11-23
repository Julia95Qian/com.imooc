import dao.HotelDAO;
import entity.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JdbcTemplateTestor {
    @Resource
    private HotelDAO hotelDAO;
//    查询订单号为10001的订单信息
    @Test
    public void testFindByOrderNo(){
        Hotel hotel = hotelDAO.findByOrderNo(10006);
        System.out.println(hotel);
    }
//    查询上海市的订单信息
    @Test
    public void testFindByCity(){
        List<Hotel> hotels = hotelDAO.findByCity("上海");
        hotels.forEach(hotel -> System.out.println(hotel));
    }
//    向表格中插入一条数据
    @Test
    public void testInsert(){
        Hotel hotel = new Hotel();
        hotel.setOrderNo(10006);
        hotel.setCity("北京");
        hotel.setPrice(588);
        hotel.setHotelname("hotel5");
        hotel.setArrivedate(new Date(115, 4, 8));
        hotel.setLeavedate(new Date(115, 4, 11));
        hotelDAO.insert(hotel);
    }
//    修改订单号为10003的到达时间改为2020-4-30，离开时间改为2020-5-3
    @Test
    public void testUpdate(){
        Hotel originhotel = hotelDAO.findByOrderNo(10003);
        Hotel hotel = originhotel;
        hotel.setArrivedate(new Date(120, 3, 30));
        hotel.setLeavedate(new Date(120,4,30));
        int count = hotelDAO.update(hotel);
        System.out.println("affect"+ count + "record");
    }
//    将订单号为10005的订单删除
    @Test
    public void testDelete(){
        int count = hotelDAO.deleteByOrderNo(10005);
        System.out.println("affect"+ count + "record");
    }
    @Test
    public void testBatchImport(){
        hotelDAO.batchImport();
        System.out.println("batch import success!");
    }
}
