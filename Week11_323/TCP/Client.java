import java.io.*;
import java.net.Socket;
import java.util.Scanner;

// Client 클래스는 서버와 통신하는 클라이언트를 나타냅니다.
public class Client {
    
    public static void main(String[] args) throws IOException {
        Socket clientSocket = null; // 클라이언트 소켓
        BufferedReader in = null; // 입력 스트림
        PrintWriter out = null; // 출력 스트림
        final Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 스캐너 객체

        try {
            // 서버에 연결하는 소켓을 생성합니다.
            clientSocket = new Socket("localhost", 5000);
            
            // 출력 스트림을 생성합니다.
            out = new PrintWriter(clientSocket.getOutputStream());
            
            // 입력 스트림을 생성합니다.
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            String msg;
            
            // 사용자가 "quit"을 입력하기 전까지 반복합니다.
            while (true) {
                System.out.print("서버로 보낼 문자열을 입력하고 엔터키를 치세요: ");
                msg = sc.nextLine();
                
                // 사용자가 "quit"을 입력하면 루프를 종료합니다.
                if (msg.equalsIgnoreCase("quit")) {
                    out.println(msg);
                    out.flush();
                    break;
                }
                
                // 사용자가 입력한 메시지를 서버로 전송합니다.
                out.println(msg);
                out.flush();
                
                // 서버에서 받은 메시지를 출력합니다.
                msg = in.readLine();
                System.out.println("서버로부터 온 메시지: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 자원을 정리합니다.
            out.close();
            in.close();
            clientSocket.close();
        }
    }
}
