// JoinTest 클래스는 Thread를 상속받아 run 메서드를 구현하는 스레드를 나타냅니다.
public class JoinTest extends Thread {
    
    // run 메서드는 스레드가 실행될 때 수행되는 로직을 정의합니다.
    public void run() {
        for (int i = 1; i <= 3; i++) {
            // 현재 실행 중인 스레드의 이름과 반복 횟수를 출력합니다.
            System.out.println(getName() + " " + i);
        }
    }

    // main 메서드는 프로그램의 시작점입니다.
    public static void main(String args[]) {
        // JoinTest 객체를 두 개 생성합니다.
        JoinTest t1 = new JoinTest();
        JoinTest t2 = new JoinTest();

        // 첫 번째 스레드를 시작합니다.
        t1.start();
        
        try {
            // 첫 번째 스레드가 종료될 때까지 대기합니다.
            t1.join();
        } catch (Exception e) {
            // 예외가 발생하면 예외 메시지를 출력합니다.
            System.out.println(e);
        }

        // 두 번째 스레드를 시작합니다. (첫 번째 스레드의 종료를 기다렸다가 시작됩니다.)
        t2.start();
    }
}
