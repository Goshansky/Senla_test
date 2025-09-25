package org.example.task1;

import java.util.*;

public class Hangman {
    private static final String[] WORDS = {
            "хцпю", "янаюйю", "йньйю", "бхяекхжю", "свеамхй", "ьйнкю",
            "ймхцю", "ярнк", "ярск", "йкюяя", "свхрекэ", "свемхй", "рерпюдэ", "псвйю",
            "рекетнм", "гбнмнй", "щйпюм", "йкюбхюрспю", "лшьйю", "лнмхрнп", "хмрепмер", "яюир",
            "оюпнкэ", "онврю", "йюпрхмю", "нймн", "дбепэ", "кеярмхжю", "йнпхднп", "йюпюмдюь",
            "жберш", "депебн", "кея", "оюпй", "цнпнд", "депебмъ", "скхжю", "днл",
            "йпшью", "йнлмюрю", "йнбеп", "яремю", "онк", "онрнкнй", "кюлою", "гепйюкн",
            "рекебхгнп", "пюдхн", "лсгшйю", "оеямъ", "тхкэл", "йхмн", "реюрп", "яжемю",
            "юйреп", "юйрпхяю", "пефхяяеп", "ймхфйю", "цюгерю", "фспмюк", "мнбнярх", "ярюрэъ",
            "охяюрекэ", "ярхух", "онщр", "пнлюм", "ахакхнрейю", "йюпрю", "цкнася", "ярпюмю",
            "цнпндю", "нгепн", "пейю", "лнпе", "нйеюм", "цнпш", "окюмерю", "бяекеммюъ",
            "гбегдю", "янкмже", "ксмю", "йнялня", "йнялнмюбр", "пюйерю", "яосрмхй", "рекеяйно",
            "люьхмю", "юбрнася", "онегд", "яюлнкер", "бекняхоед", "рпюлбюи", "лерпн", "лняр",
            "окныюдэ", "оепескнй", "ахакхнрейюпэ", "днйрнп", "ледяеярпю", "оюжхемр", "кейюпярбн", "юорейю",
            "яонпр", "тсранк", "унййеи", "реммхя", "ьюулюрш", "нкхлохюдю", "лъв", "йнкэжн",
            "яелэъ", "люрэ", "нреж", "апюр", "яеярпю", "дедсьйю", "аюасьйю", "дпсц",
            "ондпсцю", "кчанбэ", "явюярэе", "дпсфаю", "гмюмхе", "лсдпнярэ", "хярхмю", "фхгмэ",
            "бпелъ", "пюанрю", "демэ", "мнвэ", "медекъ", "леяъж", "цнд", "бейн"
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

        System.out.println("дНАПН ОНФЮКНБЮРЭ Б ХЦПС 'бХЯЕКХЖЮ'!");
        System.out.println("оНОПНАСИРЕ СЦЮДЮРЭ ЯКНБН:");

        while (mistakes < maxLives && new String(guessedWord).contains("_")) {
            System.out.println(HANGMAN_PICS[mistakes]);
            System.out.println("яКНБН: " + String.valueOf(guessedWord));
            System.out.println("фХГМХ: " + (maxLives - mistakes));
            System.out.print("бБЕДХРЕ АСЙБС: ");

            String input = scanner.nextLine().trim().toUpperCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("бБЕДХРЕ НДМС АСЙБС ЙХПХККХЖШ!");
                continue;
            }

            char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("бШ СФЕ ББНДХКХ ЩРС АСЙБС!");
                continue;
            }

            guessedLetters.add(guess);

            if (word.indexOf(guess) >= 0) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
                System.out.println("бЕПМН!");
            } else {
                mistakes++;
                System.out.println("мЕБЕПМН! рЕПЪЕРЕ ФХГМЭ.");
            }
        }

        if (!new String(guessedWord).contains("_")) {
            System.out.println("оНГДПЮБКЪЕЛ! бШ СЦЮДЮКХ ЯКНБН: " + word);
        } else {
            System.out.println(HANGMAN_PICS[HANGMAN_PICS.length - 1]);
            System.out.println("бШ ОПНХЦПЮКХ! гЮЦЮДЮММНЕ ЯКНБН АШКН: " + word);
        }
    }
}
