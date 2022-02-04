package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CryptoTask01 {
    private static final Scanner GLOBAL_SCANNER = new Scanner(System.in);
    private static final String ALPHABET_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя `1234567890-=~!@#$%^&*()_+\\|/.,<>№;:?«»–\"\r\n";
    public static void main(String[] args) {
        runnerFunction();
        System.out.println("Всего доброго!");
    }
    public static void runnerFunction() {
        String s;
        System.out.println("Добрый день!");
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - зашифровать файл");
            System.out.println("2 - расшифровать файл");
//            System.out.println("3 - брутфорс зашифрованного файла");
//            System.out.println("4 - статистический анализ");
            System.out.println("---------------------------------");
            System.out.println("0 - выход из программы");
            s = GLOBAL_SCANNER.nextLine();
            int m = tryParse(s);
            switch (m) {
                case 1 -> cryptRunner(true);
                case 2 -> cryptRunner(false);
                case 3 -> bruteforce();
                case 4 -> statisticalAnalysis();
                case 0 -> { return; }
                default -> {
                    System.out.println("Выберите действие или введите любой другой текст для выхода");
                    m = tryParse(s);
                    if (m <= 0) {
                        return;
                    }
                }
            }
        }
    }
    public static void cryptRunner(boolean encrypt) {
        System.out.println((encrypt ? "Шифрование файла." : "Расшифрование файла."));
        InputDataBundle inputDataBundle = getInputDataBundle(encrypt);
        cryptAndWriteFileToPath(inputDataBundle);
    }

    private static String encryptByShift(InputDataBundle inputDataBundle) {
        String stringToEncrypt = inputDataBundle.getFileContents();
        int shiftKey = inputDataBundle.isEncrypt() ? inputDataBundle.getShiftkey() :  ALPHABET_STRING.length() - inputDataBundle.getShiftkey();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringToEncrypt.length(); i++) {
            char c = stringToEncrypt.charAt(i);
            int indexOfChar = (ALPHABET_STRING.indexOf(c) + shiftKey)%ALPHABET_STRING.length();
            stringBuilder.append(ALPHABET_STRING.charAt(indexOfChar));
        }
        return(stringBuilder.toString());
    }

    private static InputDataBundle getInputDataBundle(boolean encrypt){
        InputDataBundle inputDataBundle = new InputDataBundle(encrypt);
        System.out.println("Введите путь к файлу:");
        inputDataBundle.setPathToFile(GLOBAL_SCANNER.nextLine());
        System.out.printf("Введите ключ от 0 до %d:%n",ALPHABET_STRING.length()-1);
        inputDataBundle.setShiftkey(tryParse(GLOBAL_SCANNER.nextLine()));
        inputDataBundle.setFileContents(readFileByPath(inputDataBundle.getPathToFile()));
        return (inputDataBundle);
    }

    private static String readFileByPath(String pathToFile) {
        Path filePath = Path.of(pathToFile);
        try {
            byte[]  fileBytes = Files.readAllBytes(filePath);
            return new String(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void cryptAndWriteFileToPath(InputDataBundle inputDataBundle) {
        String fileNameSuffix = (inputDataBundle.isEncrypt() ? "-encrypted" : "-decrypted");
        try {
            Files.writeString(Path.of(addDescriptionToFileName(inputDataBundle.getPathToFile(),fileNameSuffix)),encryptByShift(inputDataBundle));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Файл сохранен под именем %s%n",addDescriptionToFileName(inputDataBundle.getPathToFile(),fileNameSuffix));
    }
    public static String addDescriptionToFileName (String sourcePath, String fileDescription) {
        int extensionDotIndex = sourcePath.lastIndexOf(".");
        if (extensionDotIndex == -1 || extensionDotIndex + 1 >= sourcePath.length()) {
            return (sourcePath + fileDescription);
        }
        return (sourcePath.substring(0,extensionDotIndex) + fileDescription + sourcePath.substring(extensionDotIndex));
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
