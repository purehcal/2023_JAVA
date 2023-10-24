// Controllable 인터페이스 선언
interface Controllable {
    void play(); // 재생 메서드
    void stop(); // 정지 메서드
}

// VideoPlayer 클래스는 Controllable 인터페이스를 구현함
class VideoPlayer implements Controllable {
    @Override
    public void play() {
        System.out.println("동영상을 재생합니다.");
    }

    @Override
    public void stop() {
        System.out.println("동영상을 정지합니다.");
    }
}

public class Week02_04 {
    public static void main(String[] args) {
        // VideoPlayer 클래스의 인스턴스를 Controllable 인터페이스 타입으로 생성
        Controllable c = new VideoPlayer();

        // Controllable 인터페이스를 통해 play()와 stop() 메서드 호출
        c.play();
        c.stop();
    }
}
