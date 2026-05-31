import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@FunctionalInterface
interface Calculator {
    int operation(int a, int b);
}

class Employee {

    String name;
    int salary;
    String dept;

    Employee(String name, int salary, String dept) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public String toString() {
        return name + " " + salary + " " + dept;
    }
}


public class Java8Demo {

    public static void main(String[] args) {


        // 1. Lambda with Custom Functional Interface

        Calculator add = (a,b) -> a+b;
        Calculator mul = (a,b) -> a*b;

        System.out.println(add.operation(10,20));
        System.out.println(mul.operation(10,20));



        // 2. Predicate<T>
        // input leta hai -> boolean return karta hai

        Predicate<Integer> isEven =
                x -> x % 2 == 0;

        System.out.println(isEven.test(10));



        // 3. Function<T,R>
        // input -> output convert

        Function<String,Integer> length =
                s -> s.length();

        System.out.println(length.apply("Vishal"));



        // 4. Consumer<T>
        // input leta hai return kuch nahi

        Consumer<String> print =
                s -> System.out.println(s);

        print.accept("Java8");



        // 5. Supplier<T>
        // input kuch nahi, output deta hai

        Supplier<Integer> random =
                () -> 100;

        System.out.println(random.get());



        List<Integer> nums =
                Arrays.asList(5,2,8,1,4,8,10);



        // 6. filter()
        // condition

        List<Integer> even =
                nums.stream()
                .filter(x -> x%2==0)
                .collect(Collectors.toList());

        System.out.println(even);



        // 7. map()
        // transform

        List<Integer> square =
                nums.stream()
                .map(x -> x*x)
                .collect(Collectors.toList());

        System.out.println(square);



        // 8. sorted()

        nums.stream()
                .sorted()
                .forEach(System.out::println);



        // reverse sorting

        nums.stream()
                .sorted((a,b)->b-a)
                .forEach(System.out::println);




        // 9. distinct()

        nums.stream()
                .distinct()
                .forEach(System.out::println);




        // 10. limit()

        nums.stream()
                .limit(3)
                .forEach(System.out::println);




        // 11. skip()

        nums.stream()
                .skip(2)
                .forEach(System.out::println);




        // 12. count()

        long count =
                nums.stream()
                .filter(x -> x>5)
                .count();

        System.out.println(count);




        // 13. reduce()
        // combine into single answer

        int sum =
                nums.stream()
                .reduce(0,(a,b)->a+b);

        System.out.println(sum);




        // 14. anyMatch()

        boolean ans =
                nums.stream()
                .anyMatch(x -> x>9);

        System.out.println(ans);




        // 15. allMatch()

        boolean ans2 =
                nums.stream()
                .allMatch(x -> x>0);

        System.out.println(ans2);




        // 16. findFirst()

        Optional<Integer> first =
                nums.stream()
                .findFirst();

        System.out.println(first.get());






        // Employee Real Example


        List<Employee> employees =
                Arrays.asList(
                        new Employee("A",50000,"IT"),
                        new Employee("B",90000,"IT"),
                        new Employee("C",40000,"HR"),
                        new Employee("D",70000,"HR")
                );




        // salary > 50000 employee names


        employees.stream()
                .filter(e -> e.salary>50000)
                .map(e -> e.name)
                .forEach(System.out::println);




        // sort employee by salary


        employees.stream()
                .sorted(
                    (a,b)->a.salary-b.salary
                )
                .forEach(System.out::println);




        // 17. groupingBy()
        // department wise grouping


        Map<String,List<Employee>> map =
                employees.stream()
                .collect(
                    Collectors.groupingBy(
                        e -> e.dept
                    )
                );


        System.out.println(map);



        // 18. max salary employee


        Employee max =
                employees.stream()
                .max(
                   (a,b)->a.salary-b.salary
                )
                .get();


        System.out.println(max);

    }
}