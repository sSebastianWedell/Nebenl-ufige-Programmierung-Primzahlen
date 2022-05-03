package primes;

/**
 * Klasse PrimzahlTask, die die Klasse Runnable implementiert und die run()-Methode
 * für die Threads enthält.
 * 
 * @author Sebastian Wedell
 *
 */

public class PrimzahlTask implements Runnable {

    // Zahlenbereich, mit dem jeder Thread arbeiten soll
    private int lowerBound;
    private int upperBound;
    // Gefundene Primzahlen
    private int primeNumberMatcher = 0;

    public PrimzahlTask(int a, int b) {
        this.lowerBound = a;
        this.upperBound = b;
    }

    /**
     * Überprüft, ob das Argument i eine Primzahl ist.
     *
     * @param i
     * @return true - Wenn das Argument i eine Primzahl ist
     * @return false - Wenn das Argument i KEINE Primzahl ist
     */
    private static boolean isPrime(int i) {
        if (i <= 1) {
            return false;
        }
        for (int j = 2; j <= i / 2; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    // Methode run() fuer die Bestimmung der Primzahlen eines Zahlraumes
    @Override
    public synchronized void run() {

        System.out.println(
                "Starte Nebenthread-ID: " + Thread.currentThread().getId());
        String message = "Starte Nebenthread-ID: "
                + Thread.currentThread().getId();
        Primzahlen.saveConsoleOutput(message);
        System.out.println("Thread-ID: " + Thread.currentThread().getId()
                + " - Zahlbereich von " + this.lowerBound + " bis "
                + this.upperBound);
        message = "Thread-ID: " + Thread.currentThread().getId()
                + " - Zahlbereich von " + this.lowerBound + " bis "
                + this.upperBound;
        Primzahlen.saveConsoleOutput(message);

        // for-Schleife, die �ber alle Zahlen des Zahlenraumes iteriert
        for (int i = lowerBound; i <= upperBound; i++) {

            // fuege die Primzahl zur ArrayList primes hinzu,
            // Schutz des Zugriffs auf die Liste mit 'synchronized'
            if (isPrime(i)) {
                synchronized (Primzahlen.primes) {
                    Primzahlen.primes.add(i);
                    primeNumberMatcher++;
                }
            }
        }
        System.out.println("Thread-ID: " + Thread.currentThread().getId()
                + "- Gefundene Primzahlen: " + primeNumberMatcher);
        message = "Thread-ID: " + Thread.currentThread().getId()
                + "- Gefundene Primzahlen: " + primeNumberMatcher;
        Primzahlen.saveConsoleOutput(message);
    }
}