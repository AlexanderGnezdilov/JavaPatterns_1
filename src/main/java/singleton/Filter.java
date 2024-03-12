package singleton;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    protected Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        int s = 0;
        for (int i : source) {
            if (i >= threshold) {
                logger.log("Элемент " + i + " проходит");
                result.add(i);
                s++;
            } else logger.log("Элемент " + i + " не проходит");
        }
        logger.log("Прошло фильтр " + s + " элемента из " + source.size());
        return result;
    }
}
