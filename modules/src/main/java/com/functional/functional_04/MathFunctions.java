package com.functional.functional_04;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
    public static void main(String[] args) {

        Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        System.out.println(squareFunction.apply(5));
        System.out.println(squareFunction.apply(25));

        Function<Integer, Boolean> isOdd =  x -> x % 2 == 1;

        Predicate<Integer> isEven = x -> x % 2 == 0;

        isEven.test(4);

        Predicate<Student> isApproved = student -> student.getCalification() >= 6.0;

        Student joan = new Student(5.9);
        System.out.println(isApproved.test(joan));
    }

    static class Student {

        private double calification;

        public Student(double calification) {
            this.calification = calification;
        }

        public double getCalification() {
            return calification;
        }
    }
}
