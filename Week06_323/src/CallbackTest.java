import javax.swing.Timer;

public class CallbackTest {

    public static void main(String[] args) {
        // 타이머 객체를 생성하고 1000밀리초(1초) 간격으로 이벤트를 처리할 수 있도록 설정
        Timer t = new Timer(1000, event -> System.out.println("beep"));
        
        // 타이머를 시작 (타이머 이벤트를 활성화)
        t.start();

        // 메인 스레드는 1초 간격으로 "beep" 메시지를 출력하는 타이머 이벤트를 기다림
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                // InterruptedException 예외 처리
            }
        }
    }
}
