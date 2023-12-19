import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

// host2ip 클래스는 특정 호스트의 IP 주소를 찾아 출력하는 예제를 나타냅니다.
public class host2ip {
    
    public static void main(String[] args) throws IOException {
        String hostname = "www.google.com";

        try {
            // 호스트명을 InetAddress 객체로 변환하여 IP 주소를 얻어옵니다.
            InetAddress address = InetAddress.getByName(hostname);
            System.out.println("IP 주소: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            // 호스트명의 IP 주소를 찾을 수 없을 때의 예외 처리
            System.out.println(hostname + "의 IP 주소를 찾을 수 없습니다.");
        }
    }
}
