import java.net.InetAddress;
import java.net.UnknownHostException;

// MyIp 클래스는 현재 컴퓨터의 IP 주소를 얻어와 출력하는 프로그램을 나타냅니다.
public class MyIp {
    
    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost(); // 현재 컴퓨터의 InetAddress 객체를 얻어옵니다.
            System.out.println("내 컴퓨터 IP 주소: " + local.getHostAddress()); // IP 주소를 출력합니다.

        } catch (UnknownHostException e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력합니다.
        }
    }
}
