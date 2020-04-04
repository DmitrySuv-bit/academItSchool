package ru.academits.suvorov.main;

import ru.academits.suvorov.person.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personsList = new ArrayList<>();

        personsList.add(new Person("Роман", 21));
        personsList.add(new Person("Виктория", 16));
        personsList.add(new Person("Владимир", 23));
        personsList.add(new Person("Николай", 60));
        personsList.add(new Person("Екатерина", 17));
        personsList.add(new Person("Андрей", 22));
        personsList.add(new Person("Роман", 20));
        personsList.add(new Person("Елизавета", 18));
        personsList.add(new Person("Татьяна", 21));
        personsList.add(new Person("Екатерина", 25));

        List<String> uniqueNames = personsList.stream().map(Person::getName).distinct().collect(Collectors.toList());

        System.out.println("Список уникальных имен: " + String.join(", ", uniqueNames));
        System.out.println();

        List<String> peopleUnder18 = personsList.stream().filter(age -> age.getAge() < 18).map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("Список людей младше 18: " + String.join(", ", peopleUnder18)
                + ", их средний возраст: " + personsList.stream().filter(age -> age.getAge() < 18)
                .collect(Collectors.averagingDouble(Person::getAge)));
        System.out.println();

        Map<String, Double> personsByMiddleAge = personsList.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        System.out.println("Список сгруппированный по именам, со значениями - средний возраст: ");

        personsByMiddleAge.forEach((name, ages) -> System.out.printf("%s: %.1f%n", name, ages));
        System.out.println();

        List<String> personsBetween20And45 = personsList.stream()
                .filter(age -> age.getAge() >= 20 && age.getAge() <= 45)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(personsBetween20And45);
        System.out.println();

        System.out.println("Поток корней чисел: ");
        System.out.println("Введите сколько элементов нужно вычислить: ");

        int elementsCount = scanner.nextInt();

        DoubleStream squares = DoubleStream.iterate(0, x -> x + 1).map(Math::sqrt).limit(elementsCount);

        squares.forEach(System.out::println);
        System.out.println();

        System.out.println("Поток чисел Фиббоначчи: ");
        System.out.println("Введите сколько чисел Фиббоначчи вычислить: ");

        int fibonacciNumbersCount = scanner.nextInt();

        List<Integer> Fibonacci = Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
                .limit(fibonacciNumbersCount).map(x -> x[0]).collect(Collectors.toList());

        Fibonacci.forEach(System.out::println);
    }
}