package org.example.task1;

import java.util.*;

public class Hangman {
    private static final String[] WORDS = {
            "КОМПЬЮТЕР", "ПРОГРАММА", "ИГРА", "СОБАКА", "КОШКА", "ВИСЕЛИЦА", "УЧЕБНИК", "ШКОЛА",
            "КНИГА", "СТОЛ", "СТУЛ", "КЛАСС", "УЧИТЕЛЬ", "УЧЕНИК", "ТЕТРАДЬ", "РУЧКА",
            "ТЕЛЕФОН", "ЗВОНОК", "ЭКРАН", "КЛАВИАТУРА", "МЫШКА", "МОНИТОР", "ИНТЕРНЕТ", "САЙТ",
            "ПАРОЛЬ", "ПОЧТА", "КАРТИНА", "ОКНО", "ДВЕРЬ", "ЛЕСТНИЦА", "КОРИДОР", "КАРАНДАШ",
            "ЦВЕТЫ", "ДЕРЕВО", "ЛЕС", "ПАРК", "ГОРОД", "ДЕРЕВНЯ", "УЛИЦА", "ДОМ",
            "КРЫША", "КОМНАТА", "КОВЕР", "СТЕНА", "ПОЛ", "ПОТОЛОК", "ЛАМПА", "ЗЕРКАЛО",
            "ТЕЛЕВИЗОР", "РАДИО", "МУЗЫКА", "ПЕСНЯ", "ФИЛЬМ", "КИНО", "ТЕАТР", "СЦЕНА",
            "АКТЕР", "АКТРИСА", "РЕЖИССЕР", "КНИЖКА", "ГАЗЕТА", "ЖУРНАЛ", "НОВОСТИ", "СТАТЬЯ",
            "ПИСАТЕЛЬ", "СТИХИ", "ПОЭТ", "РОМАН", "БИБЛИОТЕКА", "КАРТА", "ГЛОБУС", "СТРАНА",
            "ГОРОДА", "ОЗЕРО", "РЕКА", "МОРЕ", "ОКЕАН", "ГОРЫ", "ПЛАНЕТА", "ВСЕЛЕННАЯ",
            "ЗВЕЗДА", "СОЛНЦЕ", "ЛУНА", "КОСМОС", "КОСМОНАВТ", "РАКЕТА", "СПУТНИК", "ТЕЛЕСКОП",
            "МАШИНА", "АВТОБУС", "ПОЕЗД", "САМОЛЕТ", "ВЕЛОСИПЕД", "ТРАМВАЙ", "МЕТРО", "МОСТ",
            "ПЛОЩАДЬ", "ПЕРЕУЛОК", "БИБЛИОТЕКАРЬ", "ДОКТОР", "МЕДСЕСТРА", "ПАЦИЕНТ", "ЛЕКАРСТВО", "АПТЕКА",
            "СПОРТ", "ФУТБОЛ", "ХОККЕЙ", "ТЕННИС", "ШАХМАТЫ", "ОЛИМПИАДА", "МЯЧ", "КОЛЬЦО",
            "СЕМЬЯ", "МАТЬ", "ОТЕЦ", "БРАТ", "СЕСТРА", "ДЕДУШКА", "БАБУШКА", "ДРУГ",
            "ПОДРУГА", "ЛЮБОВЬ", "СЧАСТЬЕ", "ДРУЖБА", "ЗНАНИЕ", "МУДРОСТЬ", "ИСТИНА", "ЖИЗНЬ",
            "ВРЕМЯ", "РАБОТА", "ДЕНЬ", "НОЧЬ", "НЕДЕЛЯ", "МЕСЯЦ", "ГОД", "ВЕКО"
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
        Scanner scanner = new Scanner(System.in, "UTF-8");
        Random random = new Random();

        String word = WORDS[random.nextInt(WORDS.length)];
        char[] guessedWord = new char[word.length()];
        Arrays.fill(guessedWord, '_');

        int lives = HANGMAN_PICS.length - 1;
        Set<Character> guessedLetters = new HashSet<>();

        System.out.println("Добро пожаловать в игру 'Виселица'!");
        System.out.println("Попробуйте угадать слово:");

        while (lives > 0 && new String(guessedWord).contains("_")) {
            System.out.println(HANGMAN_PICS[HANGMAN_PICS.length - 1 - lives]);
            System.out.println("Слово: " + String.valueOf(guessedWord));
            System.out.println("Жизни: " + lives);
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().toUpperCase(Locale.ROOT);

            if (input.length() != 1 || !input.matches("[А-ЯЁ]")) {
                System.out.println("Введите одну букву кириллицы!");
                continue;
            }

            char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("Вы уже вводили эту букву!");
                continue;
            }

            guessedLetters.add(guess);

            if (word.indexOf(guess) >= 0) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
                System.out.println("Верно!");
            } else {
                lives--;
                System.out.println("Неверно! Теряете жизнь.");
            }
        }

        if (new String(guessedWord).equals(word)) {
            System.out.println("Поздравляем! Вы угадали слово: " + word);
        } else {
            System.out.println(HANGMAN_PICS[HANGMAN_PICS.length - 1]);
            System.out.println("Вы проиграли! Загаданное слово было: " + word);
        }
    }
}
