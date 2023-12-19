// MyRunnable 클래스는 Runnable을 구현하여 스레드의 로직을 정의합니다.
class MyRunnable implements Runnable {
    String myName;

    // 생성자에서 이름을 받아와 인스턴스 변수에 저장합니다.
    public MyRunnable(String name) {
        myName = name;
    }

    // run 메서드는 스레드가 실행될 때 수행되는 로직을 정의합니다.
    public void run() {
        // 0부터 10까지 반복하면서 현재 스레드의 이름과 반복 변수를 출력합니다.
        for (int i = 0; i <= 10; i++)
            System.out.print(myName + i + " ");
    }
}

// TestThread 클래스는 스레드를 생성하고 실행하는 예제를 나타냅니다.
public class TestThread {
    // main 메서드는 프로그램의 시작점입니다.
    public static void main(String[] args) {
        // MyRunnable을 이용하여 각각의 스레드를 생성합니다.
        Thread t1 = new Thread(new MyRunnable("A"));
        Thread t2 = new Thread(new MyRunnable("B"));
        Thread t3 = new Thread(new MyRunnable("T"));

        // 각각의 스레드를 시작합니다.
        t1.start();
        t2.start();
        t3.start();
    }
}
