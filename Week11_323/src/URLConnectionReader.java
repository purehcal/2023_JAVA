import java.net.*;
import java.io.*;

// URLConnectionReader 클래스는 URL을 통해 웹 사이트의 내용을 읽어오는 예제를 나타냅니다.
public class URLConnectionReader {
    
    public static void main(String[] args) throws Exception {
        // URL 객체를 생성하여 특정 웹 사이트의 주소를 지정합니다.
        URL site = new URL("https://www.naver.com/");
        
        // URLConnection을 통해 연결을 열고 데이터를 읽어오기 위한 BufferedReader를 설정합니다.
        URLConnection url = site.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));
        
        String inLine;

        // 한 줄씩 읽어와서 콘솔에 출력합니다.
        while ((inLine = in.readLine()) != null) 
            System.out.println(inLine);
        
        // BufferedReader를 닫습니다.
        in.close();
    }
}
