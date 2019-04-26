import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите грузоподъемность машины:");
        String sCapacityTruck = scanner.nextLine();
        System.out.println("Введите предметы для перевозки:");
        String sFurniture = scanner.nextLine();
        System.out.println("Вывод: " + sCapacityTruck + " " + sFurniture);

        // Разделяем предметы друг от друга
        String delimiter = " ";
        String[] subStr = sFurniture.split(delimiter);

        // Задаем грузовику введенную грузоподъемность
        Truck capacity = new Truck(Integer.parseInt(sCapacityTruck));

        // Создаем list со всеми введенными предметами
        List<Furniture> list = new ArrayList<Furniture>();

        // Разделяем свойства предметов и заполняем list
        for (int i = 0; i < subStr.length; ++i) {
            String[] subStr1 = subStr[i].split("/");
            int w1 = 0;
            int w2 = 1;

            for (int w3 = 2; w1 < subStr1.length; w1 += 3) {
                list.add(new Furniture(subStr1[w1], Integer.parseInt(subStr1[w2]), Integer.parseInt(subStr1[w3])));
                System.out.println(list.get(i).getProduct() + " " + list.get(i).getWeight() + " " + list.get(i).getPrice());
            }
        }

        // capacityT = грузоподъемность грузовика
        int capacityT = capacity.getCapacity();

        // Здесь будут храниться все подходящие предметы
        List<Furniture> list1 = new ArrayList<Furniture>();

        // Пустой предмет, нужен для выполнения for each
        Furniture opt = new Furniture("null",0,0);
        list1.add(opt);

        // Здесь будут храниться временные предметы, пока не определим лучшее сочетание
        List<Furniture> newSums = new ArrayList<Furniture>();

        // Сумма цен
        long sumPrice = 0;


        // Перебираем все предметы
        for (Furniture input : list) {

            // Перебираем лист с результатами (изначально с 1 пустым элементом)
            for (Furniture sum : list1) {

                int newSum = sum.getWeight() + input.getWeight();
                long newSumPrice = sum.getPrice() + input.getPrice();

                // Если значение веса предметов вмещается в грузовик
                if (newSum <= capacityT) {

                    // Если в памяти еще нет лучших вариантов, заполняем
                    if(newSums.isEmpty()){
                        newSums.add(new Furniture(input.getProduct(),input.getWeight(),input.getPrice()));
                    } else {

                        // Перебираем лучшие значения
                        for(int i = 0; i < newSums.size(); i++) {
                            sumPrice += newSums.get(i).getPrice();

                            // Если сумма предметов на этой итерации больше, чем сумма предметов в памяти
                            if (newSumPrice > sumPrice){
                                // Чистим список памяти
                                newSums.clear();
                                // Добавляем в него предмет с этой итерации
                                newSums.add(new Furniture(input.getProduct(),input.getWeight(),input.getPrice()));
                                // Обнуляем сумму
                                sumPrice = 0;
                            }
                        }
                    }
                }
            }
            list1.addAll(newSums);
        }

        // Смотрим, что получилось
        System.out.println(opt);
        for(int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i).getProduct() + " " + list1.get(i).getWeight() + " " + list1.get(i).getPrice());
        }
    }
}

