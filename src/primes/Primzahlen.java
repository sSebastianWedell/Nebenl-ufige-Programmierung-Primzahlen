package primes;

import java.util.*;
import java.io.*;

/**
 * Erfasst die Benutzereingaben, legt
 * die Zahlenräume für die Threads fest, speichert die gefundenen Primzahlen in
 * der ArrayList primes und speichert die Konsolenausgaben in einer Datei.
 * 
 * @author Sebastian Wedell
 *
 */

public class Primzahlen {

    // ober/untergrenzen für jeden Threads
    public static int a, b, c, d, e, f, g, h, i, j, k, l, m, n;
    // gefundene Primzahlen
    public static List<Integer> primes = new ArrayList<>();
    // Ausgabe
    public static String[] resultsText = new String[8];
    // Dauer
    public static long[] results = new long[16];
    // Konsolenausgabe
    public static String message;

    public static void main(String[] args) {

        // Mini und maxi Zahlenraumes Eingabe
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert min number: ");
        int minThreshold = scanner.nextInt();
        System.out.println("Insert max number: ");
        int maxThreshold = scanner.nextInt();

        for (int anzahl = 1; anzahl <= 8; anzahl++) {

            // Ausgabe in Console und Speicherung in 'ue02-prime.txt'
            System.out.println(
                    "Start, Mainthread ID: " + Thread.currentThread().getId());
            message = "Start, Mainthread ID: " + Thread.currentThread().getId();
            saveConsoleOutput(message);
            System.out.println(
                    "Nuber range: " + minThreshold + " to " + maxThreshold);
            System.out.println("Number of Threads: " + anzahl);
            message = "Number range: " + minThreshold + " to " + maxThreshold
                    + "\nNumber Threads: " + anzahl;
            saveConsoleOutput(message);

            // Schliessen des Scanners
            scanner.close();

            // Startzeit fuer die Zeitmessung
            long timeStart = System.nanoTime();

            // Switch case -Abfrage f�r die unterschiedliche Anzahl der Threads
            switch (anzahl) {
            case 1: {
                PrimzahlTask task1 = new PrimzahlTask(minThreshold, maxThreshold);
                Thread t1 = new Thread(task1);
                t1.start();
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {
                defineBoundaries(maxThreshold, minThreshold, anzahl);

                PrimzahlTask task1 = new PrimzahlTask(minThreshold, a);
                Thread t1 = new Thread(task1);

                if (anzahl == 2) {
                    c = maxThreshold;
                }
                PrimzahlTask task2 = new PrimzahlTask(b, maxThreshold);
                Thread t2 = new Thread(task2);
                t1.start();
                t2.start();

                try {
                    t1.join();
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
            }

            case 3: {
                defineBoundaries(maxThreshold, minThreshold, anzahl);

                PrimzahlTask task1 = new PrimzahlTask(minThreshold, a);
                Thread t1 = new Thread(task1);

                PrimzahlTask task2 = new PrimzahlTask(b, c);
                Thread t2 = new Thread(task2);

                PrimzahlTask task3 = new PrimzahlTask(d, maxThreshold);
                Thread t3 = new Thread(task3);
                t1.start();
                t2.start();
                t3.start();
                try {
                    t1.join();
                    t2.join();
                    t3.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
            }
            case 4: {

                defineBoundaries(maxThreshold, minThreshold, anzahl);

                PrimzahlTask task1 = new PrimzahlTask(minThreshold, a);
                Thread t1 = new Thread(task1);

                PrimzahlTask task2 = new PrimzahlTask(b, c);
                Thread t2 = new Thread(task2);

                PrimzahlTask task3 = new PrimzahlTask(d, e);
                Thread t3 = new Thread(task3);

                PrimzahlTask task4 = new PrimzahlTask(f, maxThreshold);
                Thread t4 = new Thread(task4);
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                try {
                    t1.join();
                    t2.join();
                    t3.join();
                    t4.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
            }

            case 5: {
                defineBoundaries(maxThreshold, minThreshold, anzahl);

                PrimzahlTask task1 = new PrimzahlTask(minThreshold, a);
                Thread t1 = new Thread(task1);

                PrimzahlTask task2 = new PrimzahlTask(b, c);
                Thread t2 = new Thread(task2);

                PrimzahlTask task3 = new PrimzahlTask(d, e);
                Thread t3 = new Thread(task3);

                PrimzahlTask task4 = new PrimzahlTask(f, g);
                Thread t4 = new Thread(task4);

                PrimzahlTask task5 = new PrimzahlTask(h, maxThreshold);
                Thread t5 = new Thread(task5);
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();
                try {
                    t1.join();
                    t2.join();
                    t3.join();
                    t4.join();
                    t5.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
            }
            case 6: {

                defineBoundaries(maxThreshold, minThreshold, anzahl);

                PrimzahlTask task1 = new PrimzahlTask(minThreshold, a);
                Thread t1 = new Thread(task1);

                PrimzahlTask task2 = new PrimzahlTask(b, c);
                Thread t2 = new Thread(task2);

                PrimzahlTask task3 = new PrimzahlTask(d, e);
                Thread t3 = new Thread(task3);

                PrimzahlTask task4 = new PrimzahlTask(f, g);
                Thread t4 = new Thread(task4);

                PrimzahlTask task5 = new PrimzahlTask(h, i);
                Thread t5 = new Thread(task5);

                PrimzahlTask task6 = new PrimzahlTask(j, maxThreshold);
                Thread t6 = new Thread(task6);

                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();
                t6.start();
                try {
                    t1.join();
                    t2.join();
                    t3.join();
                    t4.join();
                    t5.join();
                    t6.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
            }
            case 7: {
                defineBoundaries(maxThreshold, minThreshold, anzahl);

                PrimzahlTask task1 = new PrimzahlTask(minThreshold, a);
                Thread t1 = new Thread(task1);

                PrimzahlTask task2 = new PrimzahlTask(b, c);
                Thread t2 = new Thread(task2);

                PrimzahlTask task3 = new PrimzahlTask(d, e);
                Thread t3 = new Thread(task3);

                PrimzahlTask task4 = new PrimzahlTask(f, g);
                Thread t4 = new Thread(task4);

                PrimzahlTask task5 = new PrimzahlTask(h, i);
                Thread t5 = new Thread(task5);

                PrimzahlTask task6 = new PrimzahlTask(j, k);
                Thread t6 = new Thread(task6);

                PrimzahlTask task7 = new PrimzahlTask(l, maxThreshold);
                Thread t7 = new Thread(task7);

                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();
                t6.start();
                t7.start();
                try {
                    t1.join();
                    t2.join();
                    t3.join();
                    t4.join();
                    t5.join();
                    t6.join();
                    t7.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
            }
            case 8: {

                defineBoundaries(maxThreshold, minThreshold, anzahl);

                PrimzahlTask task1 = new PrimzahlTask(minThreshold, a);
                Thread t1 = new Thread(task1);

                PrimzahlTask task2 = new PrimzahlTask(b, c);
                Thread t2 = new Thread(task2);

                PrimzahlTask task3 = new PrimzahlTask(d, e);
                Thread t3 = new Thread(task3);

                PrimzahlTask task4 = new PrimzahlTask(f, g);
                Thread t4 = new Thread(task4);

                PrimzahlTask task5 = new PrimzahlTask(h, i);
                Thread t5 = new Thread(task5);

                PrimzahlTask task6 = new PrimzahlTask(j, k);
                Thread t6 = new Thread(task6);

                PrimzahlTask task7 = new PrimzahlTask(l, m);
                Thread t7 = new Thread(task7);

                PrimzahlTask task8 = new PrimzahlTask(n, maxThreshold);
                Thread t8 = new Thread(task8);

                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();
                t6.start();
                t7.start();
                t8.start();
                try {
                    t1.join();
                    t2.join();
                    t3.join();
                    t4.join();
                    t5.join();
                    t6.join();
                    t7.join();
                    t8.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
            }
            }

            // Endzeitpunkt für die Zeitmessung
            long timeEnd = System.nanoTime();

            // Konsolenausgabe und fortlaufende Speicherung in der Textdatei
            // 'ue02-prime.txt'
            System.out.println("Thread-ID: " + Thread.currentThread().getId()
                    + " - Gesamtzahl gefundener Primzahlen: " + primes.size());
            message = "Thread-ID: " + Thread.currentThread().getId()
                    + " - Gesamtzahl gefundener Primzahlen: " + primes.size();
            saveConsoleOutput(message);
            System.out.println("Vergangene Zeit in Mikrosekunden: "
                    + ((timeEnd - timeStart) / 1000));
            message = "Vergangene Zeit in Mikrosekunden: "
                    + ((timeEnd - timeStart) / 1000);
            saveConsoleOutput(message);

            // Anlegen der Datei für die Speicherung der ArrayList und Pruefung,
            // ob die Datei schon existiert
            File datei = new File("primes.txt");
            if (datei.isFile()) {
                System.out.println("Datei existiert bereits: " + datei);
                message = "Datei existiert bereits: " + datei;
                saveConsoleOutput(message);
            }

            // Aufruf der Methode, die die ArrayList in die Datei 'primes.txt'
            // schreibt
            savePrimeNumbers(primes, datei);

            // ArrayList leeren
            primes.clear();

            // Zuordnung der Threadanzahl und Zeitdauer zum resultssarray
            results[anzahl - 1] = anzahl;
            results[anzahl + 7] = (timeEnd - timeStart) / 1000;

        }
        findSlowFastWay();

        // Gesamtresultsstabelle für die Konsole und Datei
        System.out.println("Gesamtresults\n----------------");
        message = "Gesamtresults";
        saveConsoleOutput(message);
        System.out
                .println("Anzahl Threads\tZeitdauer in Mikrosekunden\tresults");
        message = "Anzahl Threads\tZeitdauer in Mikrosekunden\tresults";
        saveConsoleOutput(message);
        for (int a = 0; a < 8; a++) {
            System.out.println(results[a] + "\t\t" + results[a + 8] + "\t\t\t\t"
                    + resultsText[a]);
            message = results[a] + "\t\t" + results[a + 8] + "\t\t\t\t"
                    + resultsText[a];
            saveConsoleOutput(message);
        }

    }
    
    /**
     * Sucht den schnellsten/langsamsten Ablauf
     */
    private static void findSlowFastWay() {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 8; i < 16; i++) {
            if (results[i] < min) {
                min = results[i];
            }
            if (results[i] > max) {
                max = results[i];
            }
        }

        for (int i = 8; i < 16; i++) {
            if (results[i] == min) {
                resultsText[i - 8] = "fastest calculation";
            }
            if (results[i] == max) {
                resultsText[i - 8] = "slowest calculation";
            }
        }

        for (int i = 0; i < 8; i++) {
            if (resultsText[i] == null) {
                resultsText[i] = "------------------------------";
            }
        }
    }

    /**
     * Methode savePrimeNumbers() zur Speicherung der ArrayList in der Datei
     * 'primes.txt'.
     * 
     * @param list  Name der zu speichernden ArrayList
     * @param datei Name der Datei, in der die Liste gespeichert wird
     */
    private static void savePrimeNumbers(List<Integer> list, File datei) {

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(datei))) {
            for (Integer integer : list) {
                printWriter.println(integer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(
                "Erfolgreich in die Datei geschrieben.\n------------------------------------------");
        message = "Erfolgreich in die Datei geschrieben.\n------------------------------------------";
        saveConsoleOutput(message);
    }

    /**
     * Methode saveConsoleOutput() zur Speicherung der Konsolenausgaben in der
     * Datei 'ue02-prime.txt'
     * 
     * @param message Konsolennachricht als String
     */

    public static void saveConsoleOutput(String message) {
        try (PrintWriter pWriter = new PrintWriter(
                new FileWriter("ue02-prime.txt", true), true)) {
            pWriter.println(message);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Methode defineBoundaries(), die die Zahlenräume für die gewünschte Anzahl
     * an Threads festlegt.
     * 
     * @param max           größte Zahl des Zahlraumes
     * @param numberThreads Anzahl der Threads
     */

    private static void defineBoundaries(int max, int min, int numberThreads) {
        if ((max - min) % numberThreads == 0) {
            a = min + (max - min) / numberThreads;
            b = min + ((max - min) / numberThreads) + 1;

            if (numberThreads == 3 || numberThreads == 4 || numberThreads == 5
                    || numberThreads == 6 || numberThreads == 7
                    || numberThreads == 8) {
                c = min + (2 * ((max - min) / numberThreads));
                d = min + (2 * ((max - min) / numberThreads) + 1);
            }

            if (numberThreads == 4 || numberThreads == 5 || numberThreads == 6
                    || numberThreads == 7 || numberThreads == 8) {
                e = min + (3 * ((max - min) / numberThreads));
                f = min + (3 * ((max - min) / numberThreads) + 1);
            }

            if (numberThreads == 5 || numberThreads == 6 || numberThreads == 7
                    || numberThreads == 8) {
                g = min + (4 * ((max - min) / numberThreads));
                h = min + (4 * ((max - min) / numberThreads) + 1);
            }

            if (numberThreads == 6 || numberThreads == 7
                    || numberThreads == 8) {
                i = min + (5 * ((max - min) / numberThreads));
                j = min + (5 * ((max - min) / numberThreads) + 1);
            }

            if (numberThreads == 7 || numberThreads == 8) {
                k = min + (6 * ((max - min) / numberThreads));
                l = min + (6 * ((max - min) / numberThreads) + 1);
            }

            if (numberThreads == 8) {
                m = min + (7 * ((max - min) / numberThreads));
                n = min + (7 * ((max - min) / numberThreads) + 1);
            }

        } else {

            a = min + ((max - min) + ((max - min) % numberThreads))
                    / numberThreads;
            b = min + (((max - min) + ((max - min) % numberThreads))
                    / numberThreads) + 1;

            if (numberThreads == 3 || numberThreads == 4 || numberThreads == 5
                    || numberThreads == 6 || numberThreads == 7
                    || numberThreads == 8) {
                c = min + (2 * ((max - min) / numberThreads))
                        + ((max - min) % numberThreads);
                d = min + 2 * ((max - min) / numberThreads)
                        + ((max - min) % numberThreads) + 1;
            }

            if (numberThreads == 4 || numberThreads == 5 || numberThreads == 6
                    || numberThreads == 7 || numberThreads == 8) {
                e = min + ((3 * ((max - min) / numberThreads))
                        + ((max - min) % numberThreads));
                f = min + (3 * ((max - min) / numberThreads))
                        + ((max - min) % numberThreads) + 1;
            }

            if (numberThreads == 5 || numberThreads == 6 || numberThreads == 7
                    || numberThreads == 8) {
                g = min + (4 * ((max - min) / numberThreads))
                        + ((max - min) % numberThreads);
                h = min + (4 * ((max - min) / numberThreads))
                        + ((max - min) % numberThreads) + 1;
            }

            if (numberThreads == 6 || numberThreads == 7
                    || numberThreads == 8) {
                i = min + (5 * ((max - min) / numberThreads))
                        + ((max - min) % numberThreads);
                j = min + (5 * ((max - min) / numberThreads))
                        + ((max - min) % numberThreads) + 1;
            }

            if (numberThreads == 7 || numberThreads == 8) {
                k = min + (6 * ((max - min) / numberThreads))
                        + ((max - min) % numberThreads);
                l = min + (6 * ((max - min) / numberThreads))
                        + ((max - min) % numberThreads) + 1;
            }

            if (numberThreads == 8) {
                m = min + (7 * ((max - min) / numberThreads))
                        + ((max - min) % numberThreads);
                n = min + (7 * ((max - min) / numberThreads))
                        + ((max - min) % numberThreads) + 1;
            }
        }

    }

}
