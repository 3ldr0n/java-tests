import java.util.concurrent.ThreadLocalRandom;

public class WordGenerator {
    public static void main(String[] args) {
        char[] consonants = "bcdfghjklmnpqrstvxwyz".toCharArray();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        int size = ThreadLocalRandom.current().nextInt(5, 9);
        char[] word = new char[size];
        char letter;
        for (int i = 0; i<size ; i++) {
            if (i == 0) {
                letter = consonants[ThreadLocalRandom.current().nextInt(0, consonants.length)];
            } else if (i == 1) {
                letter = vowels[ThreadLocalRandom.current().nextInt(0, vowels.length)];
            } else if (i == 2) {
                int double_consonant = ThreadLocalRandom.current().nextInt(0, 1);
                if (double_consonant == 0) {
                    letter = vowels[ThreadLocalRandom.current().nextInt(0, vowels.length)];
                } else {
                    letter = consonants[ThreadLocalRandom.current().nextInt(0, consonants.length)];
                }
            } else {
                boolean contains = false;
                for (char consonant : consonants) {
                    if (consonant == word[i-1]) {
                        contains = true;
                        break;
                    }
                }
                if (contains) {
                    letter = vowels[ThreadLocalRandom.current().nextInt(0, vowels.length)];
                } else {
                    letter = consonants[ThreadLocalRandom.current().nextInt(0, consonants.length)];
                }
            }
            word[i] = letter;
        }

        System.out.println(word);
    }
}
