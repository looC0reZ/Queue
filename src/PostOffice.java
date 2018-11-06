/* class PostOffice.
 *
 * ver.: 0.0.2
 *
 * Информации об авторском параве нет
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/** Реализация структуры данных PriorityQueue.
 * @version   0.2 27 Oct 2018
 * @author    Georgiy Krasko
 */

public class PostOffice {
    public static void main(final String[] args) {
        Comparator<Customer> customerComparator = new AgeComparator();
        Queue<Customer> customerQueue = new PriorityQueue<>(5, customerComparator);
        customerQueue.add(new Customer("Иванов", 16));
        customerQueue.add(new Customer("Сидоров", 61));
        customerQueue.add(new Customer("Петров", 32));
        customerQueue.add(new Customer("Семенова", 66));
        customerQueue.add(new Customer("Галкина", 25));
        while (!customerQueue.isEmpty()) {
            System.out.println(customerQueue.remove().getName());


        }
    }
}

class Customer {

    private String name;
    private int age;

    Customer(final String n, final int a) {
        this.name = n;
        this.age = a;
    }

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }
}

class AgeComparator implements Comparator<Customer> {
    @Override
    public int compare(final Customer c1, final Customer c2) {
        if ((c1.getAge() >= 60) && (c2.getAge() >= 60)) {
            return 0;
        } else if ((c1.getAge() >= 60) || (c2.getAge() >= 60)) {
            if (c1.getAge() > c2.getAge()) {
                return -1;
            } else if (c1.getAge() < c2.getAge()) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
