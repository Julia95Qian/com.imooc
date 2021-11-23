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
//    ��ѯ������Ϊ10001�Ķ�����Ϣ
    @Test
    public void testFindByOrderNo(){
        Hotel hotel = hotelDAO.findByOrderNo(10006);
        System.out.println(hotel);
    }
//    ��ѯ�Ϻ��еĶ�����Ϣ
    @Test
    public void testFindByCity(){
        List<Hotel> hotels = hotelDAO.findByCity("�Ϻ�");
        hotels.forEach(hotel -> System.out.println(hotel));
    }
//    �����в���һ������
    @Test
    public void testInsert(){
        Hotel hotel = new Hotel();
        hotel.setOrderNo(10006);
        hotel.setCity("����");
        hotel.setPrice(588);
        hotel.setHotelname("hotel5");
        hotel.setArrivedate(new Date(115, 4, 8));
        hotel.setLeavedate(new Date(115, 4, 11));
        hotelDAO.insert(hotel);
    }
//    �޸Ķ�����Ϊ10003�ĵ���ʱ���Ϊ2020-4-30���뿪ʱ���Ϊ2020-5-3
    @Test
    public void testUpdate(){
        Hotel originhotel = hotelDAO.findByOrderNo(10003);
        Hotel hotel = originhotel;
        hotel.setArrivedate(new Date(120, 3, 30));
        hotel.setLeavedate(new Date(120,4,30));
        int count = hotelDAO.update(hotel);
        System.out.println("affect"+ count + "record");
    }
//    ��������Ϊ10005�Ķ���ɾ��
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
