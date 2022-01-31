package com.company;

import java.util.Scanner;

public class CryptoTask01 {
    private static final Scanner GLOBAL_SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        runnerFunction();
        System.out.println("Всего доброго!");
    }
    public static void runnerFunction() {
        String s;
        boolean readInput = false;
        do {
            System.out.println("Добрый день! Выберите действие:");
            System.out.println("1 - зашифровать файл");
            System.out.println("2 - расшифровать файл");
            System.out.println("3 - брутфорс зашифрованного файла");
            System.out.println("4 - статистический анализ");
            System.out.println("---------------------------------");
            System.out.println("0 - выход из программы");
            s = GLOBAL_SCANNER.nextLine();
            int m = tryParse(s);
            switch (m) {
                case 1 -> encrypt();
                case 2 -> decrypt();
                case 3 -> bruteforce();
                case 4 -> statisticalAnalysis();
                case 0 -> { return; }
                default -> {
                    readInput = false;
                    System.out.println("Выберите действие или введите любой другой текст для выхода");
                    m = tryParse(s);
                    if (m <= 0) {

                        return;
                    }
                    readInput = true;
                }

            }
        } while (readInput);
    }
    public static void encrypt() {
        System.out.println("Шифрование файла. Введите путь к файлу:");

    }
    public static void decrypt() {

    }
    public static void bruteforce() {

    }
    public static void statisticalAnalysis() {

    }
    public static Integer tryParse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
= new