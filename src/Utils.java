import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static List<Integer> generateIntegerArray(Integer size,
                                                     Integer min,
                                                     Integer max){
        List<Integer> data = new ArrayList<>();

        for(int i=0;i<size;++i){
            data.add(ThreadLocalRandom.current().nextInt(min, max + 1));
        }

        return data;
    }
}
