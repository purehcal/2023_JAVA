import java.io.*;
import java.util.Scanner;

public class ByteStreamsLab {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("원본 파일 명을 입력하세요: ");

        String inputFileName = scan.next();
        System.out.print("복사 파일 명을 입력하세요: ");
        String outputFileName = scan.next();

        try (InputStream inputStream = new FileInputStream(inputFileName);
             OutputStream outputStream = new FileOutputStream(outputFileName)) {
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(inputFileName + "을 " + outputFileName + "로 복사하였습니다.");
    }
}
