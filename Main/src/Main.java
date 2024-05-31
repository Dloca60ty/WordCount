import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException {
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

            // 判断是不是最后一个单词
            if (inWord) {
                wordCount++;
            }

            System.out.println("字符数: " + charCount);
            System.out.println("单词数: " + wordCount);

        }
    }
}



