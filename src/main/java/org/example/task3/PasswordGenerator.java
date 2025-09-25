package org.example.task3;

import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{};:,.<>?/";
    private static final String ALL = UPPER + LOWER + DIGITS + SPECIAL;

    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length;
        while (true) {
            System.out.print("Введите длину пароля (от 8 до 12): ");
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                if (length >= 8 && length <= 12) {
                    break;
                } else {
                    System.out.println("Ошибка: длина пароля должна быть от 8 до 12 символов.");
                }
            } else {
                System.out.println("Ошибка: введите целое число!");
                scanner.next();
            }
        }

        String password = generatePassword(length);

        System.out.println("Сгенерированный пароль: " + password);
    }

    private static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();

        password.append(randomChar(UPPER));
        password.append(randomChar(LOWER));
        password.append(randomChar(DIGITS));
        password.append(randomChar(SPECIAL));

        for (int i = 4; i < length; i++) {
            password.append(randomChar(ALL));
        }

        char[] pwdArray = password.toString().toCharArray();
        for (int i = 0; i < pwdArray.length; i++) {
            int j = random.nextInt(pwdArray.length);
            char temp = pwdArray[i];
            pwdArray[i] = pwdArray[j];
            pwdArray[j] = temp;
        }

        return new String(pwdArray);
    }

    private static char randomChar(String source) {
        return source.charAt(random.nextInt(source.length()));
    }
}
