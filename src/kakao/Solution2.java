package kakao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Solution2 {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String filename;
        filename = scan.nextLine();
        int more5000Count = 0;
        long totalSize = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split(" ");
                int byteSize = Integer.parseInt(lineArray[lineArray.length - 1]);

                if (byteSize >= 5000) {
                    more5000Count++;
                    totalSize += byteSize;
                }
            }
        }

        File file = new File("bytes_" + filename);

        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(String.valueOf(more5000Count) + "\n");
            fileWriter.write(String.valueOf(totalSize));

            fileWriter.flush();
        }
    }
}
