package org.sk.designpatterns.builder;

public class TestBuilder {

    public static void main(String[] args) {
        Employee emp = Employee.builder()
                .id(1L).name("SK")
                .company("Citi")
                .build();

        System.out.println(emp);
    }
}
