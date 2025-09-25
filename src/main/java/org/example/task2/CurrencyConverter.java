package org.example.task2;

import java.util.Scanner;

public class CurrencyConverter {
    private static final double EUR = 0.92;
    private static final double GBP = 0.80;
    private static final double RUB = 94.5;
    private static final double JPY = 148.7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в Конвертер валют!");
        System.out.println("Доступные валюты: USD, EUR, GBP, RUB, JPY");

        double amount;
        while (true) {
            System.out.print("Введите сумму: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("Ошибка: сумма должна быть больше нуля.");
                } else {
                    break;
                }
            } else {
                System.out.println("Ошибка: введите число!");
                scanner.next();
            }
        }

        String currency;
        while (true) {
            System.out.print("Введите валюту (USD, EUR, GBP, RUB, JPY): ");
            currency = scanner.next().toUpperCase();
            if (currency.equals("USD") || currency.equals("EUR") ||
                    currency.equals("GBP") || currency.equals("RUB") ||
                    currency.equals("JPY")) {
                break;
            } else {
                System.out.println("Ошибка: неизвестная валюта.");
            }
        }

        double amountInUSD = switch (currency) {
            case "USD" -> amount;
            case "EUR" -> amount / EUR;
            case "GBP" -> amount / GBP;
            case "RUB" -> amount / RUB;
            case "JPY" -> amount / JPY;
            default -> 0;
        };


        System.out.println("\nЭквиваленты:");
        System.out.printf("USD: %.2f\n", amountInUSD);
        System.out.printf("EUR: %.2f\n", amountInUSD * EUR);
        System.out.printf("GBP: %.2f\n", amountInUSD * GBP);
        System.out.printf("RUB: %.2f\n", amountInUSD * RUB);
        System.out.printf("JPY: %.2f\n", amountInUSD * JPY);
    }
}


