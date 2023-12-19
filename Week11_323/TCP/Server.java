import java.io.*;
import java.net.*;
import java.util.Scanner;

// Server 클래스는 클라이언트와 통신하는 서버를 나타냅니다.
public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null; // 서버 소켓
        Socket clientSocket = null; // 클라이언트 소켓
        BufferedReader in = null; // 입력 스트림
        PrintWriter out = null; // 출력 스트림
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 스캐너 객체

        try {
            // 지정된 포트(5000)에 바인딩된 서버 소켓을 생성합니다.
            serverSocket = new ServerSocket(5000);
            System.out.println("연결을 기다리고 있음");

            // 클라이언트의 연결을 기다리고, 연결이 수립되면 클라이언트 소켓을 반환합니다.
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("클라이언트와 연결되었음");

            // 클라이언트로부터 메시지를 받고, "quit"이 입력될 때까지 반복합니다.
            while (true) {
                String msg = in.readLine();

                // 클라이언트가 "quit"을 보내면 연결 종료 메시지를 출력하고 반복을 종료합니다.
                if (msg.equalsIgnoreCase("quit")) {
                    System.out.println("클라이언트에서 연결을 종료하였음");
                    break;
                }

                // 클라이언트로부터 받은 메시지를 출력합니다.
                System.out.println("클라이언트가 보낸 문자열: " + msg);

                // 사용자로부터 메시지를 입력받아 클라이언트로 전송합니다.
                System.out.print("클라이언트로 보낼 문자열을 입력하고 엔터키를 치세요: ");
                String omsg = sc.nextLine();
                out.write(omsg + "\n");
                out.flush();
            }

            // 자원을 정리합니다.
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
