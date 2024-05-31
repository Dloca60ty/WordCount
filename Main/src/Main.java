import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Main {

    public static void main(String[] args) {
        /*if (args.length != 1) {
            System.out.println("Usage: java FileWordCharacterCounter <filename>");
            return;
        }

        String filename = args[0];*/
        int charCount = 0;
        int wordCount = 0;
        boolean inWord = false;

        try (BufferedReader br = new BufferedReader(new FileReader("src/202131060732.txt"))) {
            int c;
            while ((c = br.read()) != -1) {
                charCount++;

                if (Character.isLetter((char) c) || c == '\'') {
                    inWord = true;
                } else {
                    if (inWord) {
                        wordCount++;
                        inWord = false;
                    }
                }
            }

            // Check if the last word extends to the end of the file
            if (inWord) {
                wordCount++;
            }

            System.out.println("字符数: " + charCount);
            System.out.println("单词数: " + wordCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}



