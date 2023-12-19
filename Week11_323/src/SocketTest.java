import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

// SocketTest 클래스는 소켓을 사용하여 NIST의 시간 서버에서 현재 시간 정보를 받아와 출력하는 예제를 나타냅니다.
public class SocketTest {

    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("time-c.nist.gov", 13)) {
            // 소켓에서 입력 스트림을 얻어옵니다.
            InputStream inStream = s.getInputStream();
            // 입력 스트림을 Scanner로 래핑합니다.
            Scanner in = new Scanner(inStream);

            // 입력 스트림에서 한 줄씩 읽어와 출력합니다.
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
