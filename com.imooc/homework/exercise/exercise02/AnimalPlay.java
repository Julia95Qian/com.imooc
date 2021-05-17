package exercise02;
import java.util.List;
public class AnimalPlay {
    //按任务要求实现该类   
    public void play(List<? extends Animal> animal){
        for(Animal a:animal){
            a.play();
        }
    }
}
