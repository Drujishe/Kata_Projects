package module_7;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FunctionsTest {
    static int sum = 0;

    public static void main(String[] args) {
        System.out.println(Math.scalb(2,3));
    }

    public void hardTest_7_2_13() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.lines()
                    // перевод в нижний регистр, удаление символов и создание массива из слов
                    .map(s -> s.toLowerCase().replaceAll("(?U)[^\\p{L}\\d]+", " ").split(" "))
                    // извлекает строки из массива строк
                    .flatMap(Arrays::stream)
                    // создание карты и группировка по названию ключа (строка), счетчик
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    // перевод обратно в стрим
                    .entrySet().stream()
                    // сортировка по алфавиту ключей
                    .sorted(Map.Entry.comparingByKey())
                    // сортировка по убыванию значений
                    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                    // лимит на 10
                    .limit(10)
                    // вывод всех ключей в консоль
                    .forEach(x -> System.out.println(x.getKey()));

        } catch (Exception ignore) {
        }
    }

    public <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> array = stream.sorted(order).toList();
        if (array.size() == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(array.get(0), array.get(array.size() - 1));
        }
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> (x * x) / 10 % 1000);
    }


    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
/*
        return new Function<T, U>() {
            @Override
            public U apply(T t) {
                if (condition.test(t)) {
                    return ifTrue.apply(t);
                } else {
                    return ifFalse.apply(t);
                }
            }
        };
*/
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }


    @FunctionalInterface
    interface NumberGenerator<T extends Number> {
        boolean cond(T arg);
    }

    public static NumberGenerator<? super Number> getGenerator() {
        return new NumberGenerator<Number>() {
            @Override
            public boolean cond(Number arg) {
                return arg.intValue() > 0;
            }
        };
    }

    public static UnaryOperator<Integer> sqrt() {
        return x -> x * x;
    }
}

class Dog implements AutoCloseable {

    void lol() throws Exception {
        throw new Exception();
    }

    @Override
    public void close() throws Exception {
        throw new Exception();
    }
}
