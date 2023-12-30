package com.recursive_math;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class RecursiveMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<String> operationsList = new LinkedList<String>(Arrays.stream(scanner.nextLine().split(" ")).toList());

        while(operationsList.size() != 1)
            operationsList = SolveOperation(operationsList);

        System.out.println(operationsList);
    }

    public static LinkedList<String> SolveOperation(LinkedList<String> list){

        int index = 0;

        if (list.contains("*") || list.contains("/")) {
            for (String element : list) {
                switch (element) {
                    case "*":
                        return SolveCase("*", list, index);
                    case "/":
                        return SolveCase("/", list, index);
                }
                index++;
            }
        } else {
            for (String element : list) {
                switch (element) {
                    case "+":
                        return SolveCase("+", list, index);
                    case "-":
                        return SolveCase("-", list, index);
                }
                index++;
            }
        }

        return list;
    }

    public static LinkedList<String> SolveCase(String sign, LinkedList<String> list, int index) {
        double num1 = Double.parseDouble(list.get(index - 1));
        double num2 = Double.parseDouble(list.get(index + 1));

        double result = switch (sign) {
            case "-" -> num1 - num2;
            case "+" -> num1 + num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };

        list.add(index - 1, String.valueOf(result));

        for (int i = 0; i <= 2; i ++) {
            list.remove(index);
        }

        return list;
    }
}
