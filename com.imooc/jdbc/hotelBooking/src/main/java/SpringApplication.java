import dao.HotelDAO;
import entity.Hotel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HotelDAO hotelDAO = applicationContext.getBean("hotelDao", HotelDAO.class);
        Hotel hotel = hotelDAO.findByOrderNo(10001);
        System.out.println("10001 hotel" + hotel);
    }
}
