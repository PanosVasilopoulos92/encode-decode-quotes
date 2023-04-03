package gr.aueb.cf;

import java.util.Scanner;

/**
 *  Το πρόγραμμα αυτό κρυπτογραφεί και στη συνέχεια αποκρυπτογραφεί 3 συγκεκριμένα Strings ενώ ταυτόχρονα επικοινωνεί
 *  και παροτρύνει σε συμμετοχή τον χρήστη μέσω μιας ιδιαίτερης-ιδιάζουσας μορφής επικοινωνία.
 */
public class EncryptDecryptQuotesApp {

    static Scanner scanner = new Scanner(System.in);

    /**
     *  Αποτελεί ως γνωστών την κύρια μέθοδο, η οποία στο συγκεκριμένο πρόγραμμα θα χρειαστεί να καλέσει μία μόνο μέθοδο -εντός της οποίας εμπεριέχεται
     *  οτιδήποτε χρειάζεται για να τρέξει ορθά το πρόγραμμα.
     * @param args
     */
    public static void main(String[] args) {
        displayTheApp();
    }

    /**
     *  Η μέθοδος αυτή αναλαμβάνει την πρώτη επικοινωνία με τον χρήστη, χαιρετίζοντάς τον και ρωτώντας τον αν θέλει να συνεχίσει.
     */
    public static void greetUser() {
        int userChoice = 0;
        System.out.println("Καλησπέρα άγνωστε φίλε μου. Έχω μερικά αποφθέγματα για σένα, εάν φυσικά ενδιαφέρεσαι. Για να προχωρήσεις επέλεξε την επιλογή \"1\", εάν όχι επέλεξε τη \"2\".");
        System.out.println("1. Ναι, θα ήθελα να τα δω.");
        System.out.println("2. Όχι, δεν ενδιαφέρομαι.");

        userChoice = scanner.nextInt();
        scanner.nextLine();

        do {
            if (userChoice == 1) {
                System.out.println("Εξαιρετικά. Ας ξεκινήσουμε λοιπόν τη μικρή μας περιπέτεια...");
                break;
            } else if (userChoice == 2) {
                System.out.println("Καλώς. Να ευχηθώ καλή συνέχεια λοιπόν.");
                System.exit(0);
            } else {
                System.out.println("Δυστυχώς εισήγαγες κάτι λάθος. Πάμε πάλι\uD83D\uDE42");
                userChoice = scanner.nextInt();
                if (userChoice == 2) {      // 'Έβαλα αυτή την εντολή γιατί όταν ο χρήστης έδινε πρώτα μια λάθος τιμή και μετά το "2" για έξοδο, το πρόγραμμα συνέχιζε να εκτελείται κανονικά.
                    System.out.println("Καλώς. Να ευχηθώ καλή συνέχεια λοιπόν.");
                    System.exit(0);
                }
            }
        } while (userChoice != 2);
    }

    public static void getUserLikingForQuotes() {
        String answer = "";

        System.out.println("Πόσο θα έλεγες ότι σου αρέσουν τα αποφθέγματα; Γράψε μία από τις παρακάτω επιλογές:");
        System.out.println("Πολύ");
        System.out.println("Πάρα πολύ");
        System.out.println("Έτσι κι έτσι");
        answer = scanner.nextLine();

        System.out.printf("Ώστε %s. Μάλιστα. Ορίστε το πρώτο λοιπόν:", answer);
        System.out.println();
    }

    /**
     *  Η μέθοδος αυτή αναλαμβάνει να εμφανίσει στην κονσόλα το πρώτο quote (String) καθώς εμπεριέχει και μια μικρή αλληλεπίδραση με τον χρήστη.
     * @param quote Τυπική παράμετρος String που αντιπροσωπεύει-αντιστοιχεί στην όποια μέθοδο επιστέφει το String-quote που επιλέξουμε.
     */
    public static void displayFirstQuote(String quote) {
        int userChoice = 0;
        String encryptedQuote = EncryptQuote(quote, 2);

        System.out.println(encryptedQuote);
        System.out.println();

        System.out.println("Ουπς... Ξέχασα να σου αναφέρω ότι τα αποφθέγματα έχουν κρυπτογραφηθεί. Ξέρεις η Γνώση ζητά μεγάλα ανταλλάγματα από μεριάς μας " +
                "και το πιο μεγάλο εξ αυτών θαρρώ πως είναι ο χρόνος. \nΣήμερα όμως είσαι τυχερός γιατί θα χρειαστεί να δώσεις μονάχα λίγα δευτερόλεπτα." +
                " Αν θες να αποκρυπτογραφήσεις το απόφθεγμα πάτησε \"1\", εάν όχι πληκτολόγησε οποιονδήποτε άλλο αριθμό.");
        userChoice =scanner.nextInt();

        if (userChoice == 1) {
            String quoteDecrypted = decryptQuote(encryptedQuote, 2);
            System.out.println(quoteDecrypted);
        } else {
            System.out.println("Δεν πειράζει, ίσως μια άλλη φορά. Εις το επανιδείν.");
            System.exit(0);
        }
    }

    public static void displaySecondQuote(String quote) {
        String encryptedQuote = EncryptQuote(quote, 2);
        int userChoice = 0;

        System.out.println();
        System.out.println("Έχεις όρεξη για ένα ακόμη; Εάν ναι, πάτησε \"1\", εάν όχι πληκτρολόγησε οποιονδήποτε άλλο αριθμό.");
        userChoice = scanner.nextInt();
        if (userChoice == 1) {
            System.out.println(encryptedQuote);
        } else {
            System.out.println("Δεν πειράζει, ίσως μια άλλη φορά. Εις το επανιδείν.");
            System.exit(0);
        }

        System.out.println();
        System.out.println("Xμμ... πολύ παράξενο, πάλι κρυπτογραφημένο. Αν επιθυμείς να το διαβάσεις πάτησε \"1\", εάν όχι πληκτρολόγησε οποιονδήποτε άλλο αριθμό.");
        userChoice = scanner.nextInt();
        if (userChoice == 1) {
            String quoteDecrypted = decryptQuote(encryptedQuote, 2);
            System.out.println(quoteDecrypted);
        } else {
            System.out.println("Όπως επιθυμείς. Εις το επανιδείν λοιπόν.");
            System.exit(0);
        }

        System.out.println();
        System.out.println();
        scanner.nextLine();
    }

    public static void displayThirdQuote(String quote) {
        String encryptedQuote = EncryptQuote(quote, 2);
        String quoteDecrypted = decryptQuote(encryptedQuote, 2);
        String properAnswer = "Δεν κουράστηκα";
        String userAnswer = "";
        int userChoice = 0;

        System.out.println("Έχω ένα τελευταίο απόφθεγμα για σένα άγνωστε φίλε μου, αν φυσικά δεν κουράστηκες. Αν κουράστηκες γράψε \"κουράστηκα\", αν όχι γράψε \"Δεν κουράστηκα\".");
        userAnswer = scanner.nextLine();

        if (userAnswer.equals(properAnswer)) {
            System.out.println(encryptedQuote);
        } else {
            System.out.println("Μάλλον κουράστηκες... Καλή συνέχεια!");
            System.exit(0);
        }

        System.out.println();
        System.out.println("Μάντεψε... \"1\" για αποκρυπτογράφηση, οποιονδήποτε άλλον αριθμό για έξοδο.");
        userChoice = scanner.nextInt();

        if (userChoice == 1) {
            System.out.println(quoteDecrypted);
        }
    }

    /**
     *  Η μέθοδος αυτή κρυπτογραφεί το String που θα δεχθεί ως παράμετρο - αρχικά μετατρέποντας το String σε πίνακα char, έπειτα τον πίνακα char σε πίνακα
     *  ακεραίων (τον αντίστοιχο ακέραιο αριθμό του χαρακτήρα στο σύστημα UCS-2), αυξάνει τον αριθμό αυτόν με βάσει το "Key" προκειμένου να δείχνει τώρα σε
     *  κάποιον άλλο χαρακτήρα περνώντας τις νέες τιμές σε έναν νέο πίνακα ακεραίων, μετατρέπει τους ακέριους αυτούς στους αντίστοιχους χαρακτήρες και τέλος
     *  τους μετατρέπει σε String
     * @param quote Η τυπική παράμετρος String
     * @param key   Η τυπική παράμετρος "Key" που αντιπροσωπεύει το κλειδί κρυπτογράφησης που θα χρησιμοποιηθεί.
     * @return  Επιστρέφει το κρυπτογραφημένο πλέον String.
     */
    public static String EncryptQuote(String quote, int key) {
        char[] letters = new char[quote.length()];
        int[] lettersInAscii = new int[letters.length];
        int[] lettersEncryptedInAscii = new int[lettersInAscii.length];
        char[] lettersEncrypted = new char[lettersEncryptedInAscii.length];
        String encryptedQuote = "";

        for (int i =0; i < quote.length(); i++) {
            letters[i] = quote.charAt(i);
        }

        for (int i = 0; i < letters.length; i++) {
            lettersInAscii[i] = (int) letters[i];
        }

        for (int i = 0; i < lettersInAscii.length; i++) {
            lettersEncryptedInAscii[i] = (lettersInAscii[i] + key);
        }

        for (int i = 0; i < lettersEncryptedInAscii.length; i++) {
            lettersEncrypted[i] = (char) lettersEncryptedInAscii[i];
        }

        encryptedQuote = String.valueOf(lettersEncrypted.clone());

        return encryptedQuote;
    }

    /**
     *  Η μέθοδος αυτή αναλαμβάνει την αποκρυπτογράφηση του κρυπτογραφημένου String. Ξεκινάει μια διαδικασία αποσύνθεσης του String, μετατρέποντάς το σε έναν πίνακα
     *  χαρακτήρων, μετατρέπει έπειτα τους χαρακτήρες στα αντίστοιχα ordinal numbers τους και γνωρίζοντας προφανώς το κλειδί κρυπτογράφησης το χρησιμοποιεί για να
     *  αντιστοιχηθεί με τα αυθεντικά ordinal numbers των πραγματικών χαρακτήρων του String προ της κρυπτογράφησής του.
     * @param encryptedQuote    Η τυπική παράμετρος String που αντιστοιχεί στο κρυπτογραφημένο String.
     * @param key   Η τυπική παράμετρος "Key" που αντιπροσωπεύει το κλειδί κρυπτογράφησης που θα χρησιμοποιηθεί.
     * @return  Επιστρέφει το αποκρυπτογραφημένο πλέον String.
     */
    public static String decryptQuote(String encryptedQuote, int key) {
        char[] letters = new char[encryptedQuote.length()];
        int[] lettersInAscii = new int[letters.length];
        int[] lettersDecryptedFromAscii = new int[lettersInAscii.length];
        char[] lettersDecrypted = new char[lettersDecryptedFromAscii.length];
        String quoteDecrypted = "";

        for (int i =0; i < encryptedQuote.length(); i++) {
            letters[i] = encryptedQuote.charAt(i);
        }

        for (int i = 0; i < letters.length; i++) {
            lettersInAscii[i] = (int) letters[i];
        }

        for (int i = 0; i < lettersInAscii.length; i++) {
            lettersDecryptedFromAscii[i] = (lettersInAscii[i] - key);
        }

        for (int i = 0; i < lettersDecryptedFromAscii.length; i++) {
            lettersDecrypted[i] = (char) lettersDecryptedFromAscii[i];
        }

        quoteDecrypted = String.valueOf(lettersDecrypted.clone());

        return quoteDecrypted;
    }

    /**
     *  Εντός της μεθόδου αυτής καλούνται όλες οι μέθοδοι (γίνονται invoke) που απαιτούνται προκειμένου να τρέξει το πρόγραμμα
     *  ορθά και έτσι η main method χρειάζεται να εμπεριέχει μία μόνο μέθοδο εντός της. Επιτυγχάνεται έτσι μεγάλη εξοικονόμηση χώρου εντός της main method.
     */
    public static void displayTheApp() {
        greetUser();
        getUserLikingForQuotes();
        displayFirstQuote(getQuote1());
        displaySecondQuote(getQuote2());
        displayThirdQuote(getQuote3());
    }

    /**
     *  Η μέθοδος που αποτελεί το πρώτο quote.
     * @return  Επιστρέφεται το String που αποτελεί το πρώτο quote.
     */
    public static String getQuote1() {
      return "Οι λάθος σκέψεις ή πράξεις στη ζωή μας είναι σαν το νερό που μπάζει μέσα στο καράβι μας,\nμε το που το αντιληφθούμε οφείλουμε να πάρουμε τον κουβά και να αρχίσουμε να το βγάζουμε\nγρήγορα έξω πριν αυτό καταφέρει και το βουλιάξει.";
    }

    public static String getQuote2() {
        return "Στους ανθρώπους καλό μου παιδί μάθε μονάχα να δίνεις. Δίνε, δίνε, δίνε και μην τους ζητάς τίποτα. Όποιος έμαθε να ζητά, έμαθε και να απογοητεύεται.";
    }

    public static String getQuote3() {
        return "  Με σχοινοβάτη μοιάζει το λογικό του ανθρώπου, που περπατά σ΄ένα σχοινί.\nΣτη μια άκρη η Αρχή: η γέννησή του, στην άλλη άκρη το τέρμα: ο Θάνατός του.\nΣκοτεινή και τρομαχτική η άβυσσος από κάτω του• ένας ο σκοπός του: Να καταφέρει\nνα τερματίσει.\n" +
                "  Θύελλες το χτυπούν και αέρηδες, βροχή και χαλάζι• όλα με σκοπό να το ρίξουν\nστην άβυσσό τους απ΄ όπου δε θα μπορέσει ποτέ του να βγει. Έτσι δε θα γίνει ποτέ απειλή,\nπαρά όργανο και όπλο, για όποια Καταστροφή μπορέσει να το ρίξει.\n" +
                "  Τα πρώτα βήματα δύσκολα, μα τα επόμενα όλο και πιο σταθερά• ποτέ του όμως δεν πρέπει\nνα εφησυχάζει διότι ο κίνδυνος δεν έφυγε στιγμή. Βραβείο του σαν καταφέρει να φτάσει στο τέρμα;\nΗ ευτυχία του να πεθάνει μαζί με το σώμα.";
    }
}
