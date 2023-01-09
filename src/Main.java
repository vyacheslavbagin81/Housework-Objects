import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    /**
     * Реализуйте метод, который получает в качестве параметра год, проверяет, является ли он високосным,
     * и выводит результат в консоль. Теперь проверку оберните в метод и используйте год, который приходит в виде параметра. *
     * Результат программы выведите в консоль. Если год високосный, то напечатайте сообщение: «...  год — високосный год».
     * Если год невисокосный, то: «... год — невисокосный год».
     */
    public static void task1() {
        System.out.println("Задача №1");
        System.out.println("Введите год что бы узнать висакосный он или нет");
        Scanner scn = new Scanner(System.in);
        int year = scn.nextInt();
        String textTrue = " год является високосным";
        String textFalse = " год не является високосным";
        if (chek(year)) {
            printYear(textTrue, year);
        } else printYear(textFalse, year);
    }

    /**
     * Проверка на года високосный или нет
     * @param year задается год
     * @return правда или ложь
     */
    public static boolean chek(int year) {
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                return true;
            } else return false;
        } else if (year % 4 == 0) {
            return true;
        } else return false;
    }

    /**
     * Выводим текст
     * @param text берем шаблон текста
     * @param year берем год
     */
    public static void printYear(String text, int year) {
        System.out.println(year + text);
    }

    /**
     * Вспомните задание 2 из урока «Условные операторы», где вы предлагали пользователю облегченную версию приложения.
     * Напишите метод, куда подаются два параметра: тип операционной системы (0 — iOS, 1 — Android ) и год выпуска устройства.
     * Если устройство старше текущего года, предложите ему установить облегченную версию.
     * Текущий год можно получить таким способом: int currentYear = LocalDate.now().getYear();
     * Или самим задать значение вручную — ввести в переменную числовое значение.
     * В результате программа должна выводить в консоль сообщение, какую версию приложения (обычную или облегченную)
     * и для какой ОС (Android или iOS) установить пользователю.
     */
    public static void task2() {
        System.out.println("Задача №2");
        System.out.println("Для установки приложения укажите вашу ОС. Если у Вас iOS - нажмите 0, если Android - 1");
        Scanner scn = new Scanner(System.in);
        int clientOS = scn.nextInt();
        System.out.println("Так же укажите год выпуска телефона");
        Scanner scn1 = new Scanner(System.in);
        int clientDeviceYear = scn1.nextInt();
        checkingOSEndTheYearOfManufacture(clientOS, clientDeviceYear);
    }

    /**
     * Проверяем год и ОС
     * Выводим что нужно загрузить
     * @param clientOS операционная система
     * @param clientDeviceYear год выпуска телефона
     */
    public static void checkingOSEndTheYearOfManufacture(int clientOS, int clientDeviceYear) {
        int currentYear = LocalDate.now().getYear();
        if (clientDeviceYear < currentYear) {
            switch (clientOS) {
                case 0:
                    System.out.println("Установите облегченную версию приложения для iOS по ссылке");
                    break;
                case 1:
                    System.out.println("Установите облегченную версию приложения для Android по ссылке");
                    break;
            }
        } else
            switch (clientOS) {
                case 0:
                    System.out.println("Установите версию приложения для iOS по ссылке");
                    break;
                case 1:
                    System.out.println("Установите версию приложения для Android по ссылке");
                    break;
            }
    }

    /**
     * Возвращаемся к задаче на расчет дней доставки банковской карты.Ваша задача — доработать код,
     * а именно написать метод, который на вход принимает дистанцию и возвращает итоговое количество дней доставки.
     */
    public static void task3() {
        System.out.println("Задача №3");
        System.out.println("Для определения срока поставки укажите растояние до адреса доставки");
        Scanner scn = new Scanner(System.in);
        int deliveryDistance = scn.nextInt();
        int deliveryTime = chekDeliveryDistance(deliveryDistance);
        if (deliveryTime < 4) {
            printInfo(deliveryTime);
        } else System.out.println("Свыше 100 км доставки нет.");
    }

    /**
     * Проверяем какое растояние доставки и определяем колличество дней
     * @param deliveryDistance дистанция до точки получения
     * @return количество дней доставки
     */
    public static int chekDeliveryDistance(int deliveryDistance) {
        int minimumDeliveryTime = 1;
        if (deliveryDistance < 20) {
            return minimumDeliveryTime;
        } else if (deliveryDistance < 60) {
            return (minimumDeliveryTime + 1);
        } else if (deliveryDistance < 100) {
            return (minimumDeliveryTime + 1 + 1);
        } else return 4;
    }

    /**
     * Выводим сколь дней потребуется на доставку
     * @param deliveryTime время доставки
     */
    public static void printInfo(int deliveryTime) {
        System.out.println("Потребуется дней: " + deliveryTime);
    }
}