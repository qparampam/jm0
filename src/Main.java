import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите грузоподъемность машины:");
        String title1 = scanner.nextLine();
        System.out.println("Введите предметы для перевозки:");
        String title2 = scanner.nextLine();
        System.out.println("Вывод: " + title1 + " " + title2);
        String delimiter = " ";
        String[] subStr = title2.split(delimiter);

        Truck capacity = new Truck(Integer.parseInt(title1));

    //    Furniture furniture = new Furniture(name, number);

        List<Furniture> list = new ArrayList<Furniture>();

        for (int i = 0; i < subStr.length; ++i) {
            String[] subStr1 = subStr[i].split("/");
            int w1 = 0;
            int w2 = 1;

            for (int w3 = 2; w1 < subStr1.length; w1 += 3) {
                list.add(new Furniture(subStr1[w1], Integer.parseInt(subStr1[w2]), Integer.parseInt(subStr1[w3])));
                System.out.println(list.get(i).getProduct() + " " + list.get(i).getWeight() + " " + list.get(i).getPrice());
            }
        }

        // Отсюда в массиве перебираем
        // ПРОВЕРИТЬ СУММУ, ПРОХОДИТ ПОД < 50
        // ПРОВЕРЬ ЕЕ СУММУ ДЕНЕГ
        //

        int K = capacity.getCapacity();

        Furniture opt = new Furniture("null",0,0);

        List<Furniture> list1 = new ArrayList<Furniture>();

        list1.add(opt);

        List<Furniture> newSums = new ArrayList<Furniture>();

        long sumPrice = 0;


        // Перебираем весь ввод
        for (Furniture input : list) {

            // Перебираем лист с результатами (изначально с 1 пустым элементом)
            for (Furniture sum : list1) {

                int newSum = sum.getWeight() + input.getWeight();
                long newSumPrice = sum.getPrice() + input.getPrice();

                System.out.println("newSumPrice " + newSumPrice);

                // Если значение веса попадает под диапазон
                if (newSum <= K) {

                    System.out.println("newSum " + newSum);

                    if(newSums.isEmpty()){
                        newSums.add(new Furniture(input.getProduct(),input.getWeight(),input.getPrice()));
                    } else {
                        // Перебираем
                        for(int i = 0; i < newSums.size(); i++) {

                            sumPrice += newSums.get(i).getPrice();
                            System.out.println("sumPrice " + sumPrice + " i " + i);

                        //    System.out.println("Есть такой тоже");

                            if (newSumPrice > sumPrice){
                                newSums.clear();
                                newSums.add(new Furniture(input.getProduct(),input.getWeight(),input.getPrice()));
                                sumPrice = 0;
                            }
                        }
                    }
                }
            }

            list1.addAll(newSums);

        }

    //    System.out.println(opt.getWeight());
    //    System.out.println("opt! " + opt.getProduct() + " " + opt.getWeight() + " " + opt.getPrice());

        System.out.println(opt);
        for(int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i).getProduct() + " " + list1.get(i).getWeight() + " " + list1.get(i).getPrice());
        }
    //    System.out.println(K);
    }
}


// Создать класс грузовик, товар
// Объекты классов поместить в arraylist или подобное
// Потом циклами проверять, помещается ли объект в грузовик, если да, запоминаем, смотрим следующий

