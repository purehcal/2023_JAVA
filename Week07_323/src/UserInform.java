import java.io.*;
import java.util.Scanner;

public class UserInform {

    public static void main(String[] args) throws IOException {
        int num2;
        String search;
        String num, name, tel, email;
        Scanner scan = null;
        PrintWriter in = new PrintWriter(new FileWriter("user.txt"));
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("번호 : ");
            num = s.next();
            System.out.print("이름 : ");
            name = s.next();
            System.out.print("전화번호 : ");
            tel = s.next();
            System.out.print("이메일 : ");
            email = s.next();
            System.out.print("입력을 끝났으면 1, 계속하려면 0: ");
            num2 = s.nextInt();
            in.print(num + ", " + name + ", " + tel + ", " + email + "");
            in.flush();
            if (num2 == 1)
                break;
        }

        // PrintWriter를 사용하여 파일에 데이터를 쓴 후, PrintWriter를 닫습니다.
        in.close();

        // 이제 파일에서 번호를 기반으로 전화번호를 검색하는 코드를 추가합니다.
        BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
        String line;
        System.out.print("검색할 번호를 입력하세요: ");
        search = s.next();

        boolean found = false;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            if (parts.length >= 3 && parts[0].equals(search)) {
                System.out.println("검색 결과->");
                System.out.println("이름: " + parts[1]);
                System.out.println("전화번호: " + parts[2]);
                System.out.println("이메일: " + parts[3]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("해당 번호를 찾을 수 없습니다.");
        }

        reader.close();
    }
}
