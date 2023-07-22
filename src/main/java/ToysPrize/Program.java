package ToysPrize;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static ToysPrize.ToysStore.allToys;
import static ToysPrize.ToysStore.prizeToys;


public class Program {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // формирование списка игрушек
        Toy toy1 = new Toy(1, "Конструктор", 10, 20);
        Toy toy2 = new Toy(2, "Трансфомер", 5, 50);
        Toy toy3 = new Toy(3, "Мяч", 50, 90);
        Toy toy4 = new Toy(4, "Кукла", 25, 30);
        Toy toy5 = new Toy(5, "Пазл", 50, 90);
        allToys.add(toy1);
        allToys.add(toy2);
        allToys.add(toy3);
        allToys.add(toy4);
        allToys.add(toy5);
        //System.out.println("Список всех игрушек: " + allToys);


        boolean f = true;
        while(f){
            System.out.println("Введите необходимое действие: ");
            System.out.println("1 - Показать список всех игрушек;");
            System.out.println("2 - Добавить новую игрушку");
            System.out.println("3 - Изменить вес игрушки");
            System.out.println("4 - Выбрать приз");
            System.out.println("5 - Печать списка призовых игрушек");
            System.out.println("6 - Выдача приза и запись в файл");
            System.out.println("0 - Выход из программы.");
            System.out.println("**************************************");

            int no = Integer.parseInt(scanner.nextLine());

            switch(no){
                case 1:
                    System.out.println("Список всех игрушек: " + allToys);
                    System.out.println();
                    break;
                case 2:
                    // добавление новой игрушки
                    System.out.println("Введите id: " );
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите название игрушки: " );
                    String name = scanner.nextLine();;
                    System.out.println("Введите количество игрушек: " );
                    int count = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите вес игрушки: " );
                    double weight = Double.parseDouble(scanner.nextLine());
                    Toy newToy = new Toy(id, name, count, weight);
                    allToys.add(newToy);
                    System.out.println();
                    break;
                case 3:
                    // вносим изменения веса игрушки
                    addToyOnWeight(toy1, 30);
                    System.out.println("Список всех игрушек, после изменения веса: " + allToys);
                    System.out.println();
                    break;
                case 4:
                    // выбираем призовые игрушки
                    ToysStore selectToy = new ToysStore(allToys);
                    Toy prizeToy1 = selectToy.changeToyWeight();
                    // добавляем их в список призов
                    prizeToys.add(prizeToy1);
                    break;
                case 5:
                    System.out.println("Список призовых игрушек: " + prizeToys);
                    System.out.println();
                    break;
                case 6:
                    // выбор приза на выдачу:
                    Toy prize1 = SelectPrize(prizeToys);
                    prizeToys.remove(prize1);
                    System.out.println("Выдана следующая игрушка: " + prize1);
                    System.out.println("Список призовых игрушек после выдачи: " + prizeToys);
                    // записываем выданные игрушки в файл
                    FileSave.savePrizeToy(prize1);
                    break;
                case 0:
                    System.out.println("Завершение работы приложения");
                    f = false;
                    break;
                default:
                    System.out.println("Вы указали некорректный номер задачи.\nПовторите попытку ввода. ");
                    break;
            }
        }
    }

    public static void addToyOnWeight(Toy newToy, double newWeight){
        newToy.setWeight(newWeight);
        allToys.add(newToy);
    }

    public static Toy SelectPrize(List<Toy> prizeToys){
        Random random = new Random();
        int n = random.nextInt(prizeToys.size());
        return  prizeToys.get(n);
    }
}
