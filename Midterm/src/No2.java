import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class No2 {

    public static void main(String[] args) throws IOException {
        // 파일 경로 설정
        File inputFile = new File("C:/JAVA/Midterm/obama.txt");
        File outputFile = new File("C:/JAVA/Midterm/output.txt");

        // 문자 카운터 초기화
        char charCounter = 0;

        // 입력 파일을 읽기 위한 BufferedReader 생성
        BufferedReader in = new BufferedReader(new FileReader(inputFile));

        // 출력 파일에 쓰기 위한 PrintWriter 생성
        PrintWriter out = new PrintWriter(new FileWriter(outputFile));

        int ch;

        while ((ch = in.read()) != -1) {
            // 소문자인 경우 대문자로 변환
            if (Character.isLowerCase(ch)) {
                ch = Character.toUpperCase(ch);
            }
            out.write(ch);
        }

        // 파일을 열고 난 후 꼭 닫아줘야 합니다.
        in.close();
        out.close();
    }
}
