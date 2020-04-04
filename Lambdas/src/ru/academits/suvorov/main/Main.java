package ru.academits.suvorov.main;

import ru.academits.suvorov.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Егор", 21));
        personList.add(new Person("Виктория", 16));
        personList.add(new Person("Владимир", 23));
        personList.add(new Person("Николай", 20));
        personList.add(new Person("Екатерина", 17));
        personList.add(new Person("Андрей", 22));
        personList.add(new Person("Роман", 20));
        personList.add(new Person("Елизавета", 18));
        personList.add(new Person("Татьяна", 21));
        personList.add(new Person("Екатерина", 25));

        List<String> uniqueNames = personList.stream().map(Person::getName).distinct().collect(Collectors.toList());

        System.out.println("Список уникальных имен: " + String.join(", ", uniqueNames));
        System.out.println();

        List<String> peopleUnder18 = personList.stream().filter(age -> age.getAge() < 18).map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("Список людей младше 18: " + String.join(", ", peopleUnder18)
                + ", их средний возраст: " + personList.stream().filter(age -> age.getAge() < 18)
                .mapToInt(Person::getAge).average());
    }
}