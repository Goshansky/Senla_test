package org.example.task1;

import java.util.*;

public class Hangman {
    private static final String[] WORDS = {
            "����", "������", "�����", "��������", "�������", "�����",
            "�����", "����", "����", "�����", "�������", "������", "�������", "�����",
            "�������", "������", "�����", "����������", "�����", "�������", "��������", "����",
            "������", "�����", "�������", "����", "�����", "��������", "�������", "��������",
            "�����", "������", "���", "����", "�����", "�������", "�����", "���",
            "�����", "�������", "�����", "�����", "���", "�������", "�����", "�������",
            "���������", "�����", "������", "�����", "�����", "����", "�����", "�����",
            "�����", "�������", "��������", "������", "������", "������", "�������", "������",
            "��������", "�����", "����", "�����", "����������", "�����", "������", "������",
            "������", "�����", "����", "����", "�����", "����", "�������", "���������",
            "������", "������", "����", "������", "���������", "������", "�������", "��������",
            "������", "�������", "�����", "�������", "���������", "�������", "�����", "����",
            "�������", "��������", "������������", "������", "���������", "�������", "���������", "������",
            "�����", "������", "������", "������", "�������", "���������", "���", "������",
            "�����", "����", "����", "����", "������", "�������", "�������", "����",
            "�������", "������", "�������", "������", "������", "��������", "������", "�����",
            "�����", "������", "����", "����", "������", "�����", "���", "����"
    };

    private static final String[] HANGMAN_PICS = {
            """
                  +
                  |
                  |
                  |
                  |
                  |
            =========
            """,
            """
              +---+
                  |
                  |
                  |
                  |
                  |
            =========
            """,
            """
              +---+
              |   |
                  |
                  |
                  |
                  |
            =========
            """,
            """
              +---+
              |   |
              O   |
                  |
                  |
                  |
            =========
            """,
            """
              +---+
              |   |
              O   |
              |   |
                  |
                  |
            =========
            """,
            """
              +---+
              |   |
              O   |
             /|   |
                  |
                  |
            =========
            """,
            """
              +---+
              |   |
              O   |
             /|\\  |
                  |
                  |
            =========
            """,
            """
              +---+
              |   |
              O   |
             /|\\  |
             /    |
                  |
            =========
            """,
            """
              +---+
              |   |
              O   |
             /|\\  |
             / \\  |
                  |
            =========
            """
    };


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String word = WORDS[random.nextInt(WORDS.length)];
        char[] guessedWord = new char[word.length()];
        Arrays.fill(guessedWord, '_');

        int maxLives = HANGMAN_PICS.length - 1;
        int mistakes = 0;

        Set<Character> guessedLetters = new HashSet<>();

        System.out.println("����� ���������� � ���� '��������'!");
        System.out.println("���������� ������� �����:");

        while (mistakes < maxLives && new String(guessedWord).contains("_")) {
            System.out.println(HANGMAN_PICS[mistakes]);
            System.out.println("�����: " + String.valueOf(guessedWord));
            System.out.println("�����: " + (maxLives - mistakes));
            System.out.print("������� �����: ");

            String input = scanner.nextLine().trim().toUpperCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("������� ���� ����� ���������!");
                continue;
            }

            char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("�� ��� ������� ��� �����!");
                continue;
            }

            guessedLetters.add(guess);

            if (word.indexOf(guess) >= 0) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
                System.out.println("�����!");
            } else {
                mistakes++;
                System.out.println("�������! ������� �����.");
            }
        }

        if (!new String(guessedWord).contains("_")) {
            System.out.println("�����������! �� ������� �����: " + word);
        } else {
            System.out.println(HANGMAN_PICS[HANGMAN_PICS.length - 1]);
            System.out.println("�� ���������! ���������� ����� ����: " + word);
        }
    }
}
