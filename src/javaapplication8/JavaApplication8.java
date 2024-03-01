package javaapplication8;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Головний клас програми.
 */
public class JavaApplication8 {

    private static final ArrayList<MusicPlayer> musicians = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Точка входу в програму.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Додати музиканта");
            System.out.println("2. Показати всіх музикантів");
            System.out.println("3. Обрати музиканта, який гратиме");
            System.out.println("4. Додати новий інструмент існуючому музиканту");
            System.out.println("5. Вихід з програми");
            System.out.print("Виберіть опцію: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 ->
                        addMusician();
                    case 2 ->
                        showMusicians();
                    case 3 ->
                        chooseMusicianToPlay();
                    case 4 ->
                        addInstrumentToExistingMusician();
                    case 5 ->
                        exit = true;
                    default ->
                        System.out.println("Невірний вибір. Введіть число від 1 до 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введено некоректні дані. Спробуйте знову.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    /**
     * Метод для додавання нового музиканта.
     */
    private static void addMusician() {
        System.out.println("Додавання нового музиканта:");
        System.out.println("Введіть ім'я музиканта:");
        String name = scanner.nextLine();
        MusicPlayer musician = new MusicPlayer(name);

        boolean validInstrument = false;
        do {
            System.out.println("Введіть назву інструменту:");
            String instrumentName = scanner.nextLine();
            Instrument instrument = createInstrument(instrumentName);
            if (instrument != null) {
                musician.addInstrument(instrument);
                validInstrument = true;
            } else {
                System.out.println("Невідомий інструмент.");
            }
        } while (!validInstrument);

        musicians.add(musician);
        System.out.println("Музикант " + name + " успішно доданий.");
    }

    /**
     * Метод для відображення всіх музикантів.
     */
    private static void showMusicians() {
        System.out.println("Список всіх музикантів:");
        for (int i = 0; i < musicians.size(); i++) {
            System.out.println((i + 1) + ". " + musicians.get(i).getName());
        }
    }

    /**
     * Метод для вибору музиканта для гри.
     */
    private static void chooseMusicianToPlay() {
        showMusicians();
        if (!musicians.isEmpty()) {
            try {
                System.out.print("Оберіть номер музиканта: ");
                int musicianIndex = scanner.nextInt();
                scanner.nextLine();

                if (musicianIndex >= 1 && musicianIndex <= musicians.size()) {
                    MusicPlayer chosenMusician = musicians.get(musicianIndex - 1);
                    chosenMusician.playinstrument();
                } else {
                    System.out.println("Невірний номер музиканта.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введено некоректні дані. Спробуйте знову.");
                scanner.nextLine();
            }
        } else {
            System.out.println("Список музикантів порожній.");
        }
    }

    /**
     * Метод для додавання нового інструменту існуючому музиканту.
     */
    private static void addInstrumentToExistingMusician() {
        if (musicians.isEmpty()) {
            System.out.println("Список музикантів порожній.");
            return;
        }

        System.out.println("Оберіть музиканта, якому бажаєте додати інструмент:");
        showMusicians();
        try {
            System.out.print("Введіть номер музиканта: ");
            int musicianIndex = scanner.nextInt();
            scanner.nextLine();

            if (musicianIndex >= 1 && musicianIndex <= musicians.size()) {
                MusicPlayer chosenMusician = musicians.get(musicianIndex - 1);
                System.out.println("Введіть назву нового інструменту:");
                String instrumentName = scanner.nextLine();
                Instrument instrument = createInstrument(instrumentName);
                if (instrument != null) {
                    chosenMusician.addInstrument(instrument);
                } else {
                    System.out.println("Невідомий інструмент.");
                }
            } else {
                System.out.println("Невірний номер музиканта.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Введено некоректні дані. Спробуйте знову.");
            scanner.nextLine();
        }
    }

    /**
     * Метод для створення об'єкта інструменту на основі назви.
     *
     * @param name Назва інструменту.
     * @return Створений об'єкт інструменту або null, якщо інструмент невідомий.
     */
    private static Instrument createInstrument(String name) {
        return switch (name.toLowerCase()) {
            case "piano" ->
                new Piano();
            case "violin" ->
                new Violin();
            case "synthesizer" ->
                new Synthesizer();
            case "stringinstrument" ->
                new StringInstrument();
            case "keyboardinstrument" ->
                new KeyboardInstrument();
            default ->
                null;
        };
    }
}
