package module_7;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Review_7 {
    public static void main(String[] args) {
        List<IBook> list = List.of(
                new Book("Война и мир", 1500, Category.DRAMA),
                new Book("Звездные войны", 4500, Category.SCY),
                new Book("Не властелин колец", 100, Category.FANTASY),
                new Book("Альманах", 100500, Category.FANTASY),
                new Book("Назад в будущеее", 100500, Category.SCY),
                new Book("Назад в прошлое", 2990, Category.SCY),
                new Book("Назад в фвыфв", 155, Category.DRAMA),
                new Book("Шерлок 1", 500, Category.DETECTIVE),
                new Book("Шерлок 2", 999, Category.DETECTIVE)

        );
        var lower = getLowestBook(list);
        Category find = Category.SCY;
        var book = list.stream()
                .filter(x -> x.getCategory() == find)
                .sorted().findFirst().get();

        System.out.println(book);
    }

    enum Category {
        SCY, FANTASY, DRAMA, DETECTIVE
    }

    static Map<Category, Integer> getLowestBook(List<IBook> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        IBook::getCategory, IBook::getPrice, BinaryOperator.minBy(Comparator.naturalOrder())));
    }

}

class Book implements IBook, Comparable<Book> {
    Review_7.Category category;
    String name;
    int price;

    public Book(String name, int price, Review_7.Category category) {
        this.category = category;
        this.price = price;
        this.name = name;
    }

    @Override
    public Review_7.Category getCategory() {
        return category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Book o) {
        return price - o.getPrice();
    }

    @Override
    public String toString() {
        return "Book{" +
                "category=" + category +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

interface IBook {
    Review_7.Category getCategory();

    String getName();

    int getPrice();
}

class Man implements Comparable<Man> {
    private int age;

    public Man() {
        age = (new Random()).nextInt(0, 50);
    }

    @Override
    public String toString() {
        return String.format("I'm %s years old.", age);
    }

    public int getAge() {
        return age;
    }

    public Man live() {
        age++;
        return this;
    }


    @Override
    public int compareTo(Man o) {
        return age - o.getAge();
    }
}
