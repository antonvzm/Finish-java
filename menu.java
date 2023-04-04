import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class menu {

    public static void main(String[] args) {
        Toys toy1 = new Toys("1", "Плюша", "10");
        Toys toy2 = new Toys("2", "Хитрюга", "15");
        Toys toy3 = new Toys("3", "Жулик", "20");
        Toys toy4 = new Toys("4", "Лавелас", "25");
        Toys toy5 = new Toys("5", "Хубба", "30");
        ArrayList<Toys> toyShop = new ArrayList<>();
        ArrayList<Toys> toyShopPrize = new ArrayList<>();
        boolean flag = true;
        Random rand = new Random();
        while (flag) {
            while (toyShop.size() <= 10) {
                int randomToy = rand.nextInt(5) + 1;
                switch (randomToy) {
                    case 1:
                        toyShop.add(toy1);
                    case 2:
                        toyShop.add(toy2);
                    case 3:
                        toyShop.add(toy3);
                    case 4:
                        toyShop.add(toy4);
                    case 5:
                        toyShop.add(toy5);
                }
            }
            System.out.println("--------------------------------");
            System.out.println("Загрузка меню...");
            System.out.println("Выберите действие...");
            System.out.println("--------------------------------");
            System.out.println("1. Играть");
            System.out.println("2. Вывод игрушек в автомате");
            System.out.println("3. Вывод призов");
            System.out.println("4. Изминение шанса выпадения");
            System.out.println("5. Выход");
            System.out.println("--------------------------------");
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            switch (str) {
                case "1":
                    Integer temp = 0;
                    Random random = new Random();
                    for (Toys obj : toyShop) {
                        Integer chanceToy = Integer.parseInt(obj.getChance());
                        Integer chance = random.nextInt(100);
                        if (chance < chanceToy) {
                            System.out.println("Ты выйграл " + obj.toString());
                            toyShopPrize.add(obj);
                            toyShop.remove(obj);
                            temp += 1;
                            break;
                        }
                    }
                    if (temp == 0) {
                        System.out.println("Неудачная попытка, попробуй еще =(");
                        break;
                    }
                    break;
                case "2":
                    for (Toys obj : toyShop) {
                        System.out.println(obj.toString());
                    }
                    break;
                case "3":
                    for (Toys obj : toyShopPrize) {
                        System.out.println(obj.toString());
                    }
                    break;
                case "4":
                    System.out.println("Введите ID игрушки: ");
                    String editIdString = in.nextLine();
                    Integer editId = Integer.parseInt(editIdString);
                    if (editId >= 6) {
                        System.out.println("Игрушки с таким ID нет...");
                    } else {
                        System.out.println("Введите новый шанс в диапазоне от 0 до 100, число должно быть целое: ");
                        String newChance = in.nextLine();
                        Integer newChanceInt = Integer.parseInt(newChance);
                        if (newChanceInt < 0 || newChanceInt > 100) {
                            System.out.println("Ошибка ввода: неверный диапазон...");
                            break;
                        } else {
                            for (Toys toy : toyShop) {
                                if (toy.getId().equals(editIdString)) {
                                    toy.editChance(newChance);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case "5":
                    flag = false;
                    System.out.println("--------------------------------");
                    System.out.println("Закрытие программы...");
                    break;
                default:
                    System.out.println("--------------------------------");
                    System.out.println("Ошибка ввода...");

            }
        }
    }
}
