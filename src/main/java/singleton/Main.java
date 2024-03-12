package singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int size, maxValue, threshold;

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        Scanner scanner = new Scanner(System.in);
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка: ");
        if (scanner.hasNextInt()) {
            size = scanner.nextInt();
            logger.log("Введено число.");
        } else {
            logger.log("Введено не число!");
        }
        if (size <= 0) {
            logger.log("Введено некорректное число!");
        }
        System.out.println("Введите верхнюю границу для значений: ");
        if (scanner.hasNextInt()) {
            maxValue = scanner.nextInt();
            logger.log("Введено число.");
        } else {
            logger.log("Введено не число!");
        }
        if (maxValue <= 0) {
            logger.log("Введено некорректное число!");
        }
        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(maxValue));
        }
        System.out.println("Вот случайный список: " + list);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра: ");
        if (scanner.hasNextInt()) {
            threshold = scanner.nextInt();
            logger.log("Введено число.");
        } else {
            logger.log("Введено не число!");
        }
        if (threshold <= 0 || threshold > maxValue) {
            logger.log("Введено некорректное число!");
        }
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(threshold);
        List<Integer> result = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + result);
        logger.log("Завершаем программу");
    }
}
