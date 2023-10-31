public class DVDPlayer implements ExPlayers {
    // ExPlayers 인터페이스의 play() 메서드를 구현
    public void play() {
        System.out.println("DVD 재생 시작!");
    }

    // ExPlayers 인터페이스의 stop() 메서드를 구현
    public void stop() {
        System.out.println("DVD 재생 정지!");
    }

    // ExPlayers 인터페이스의 slow() 메서드를 구현
    public void slow() {
        System.out.println("DVD 느린 재생 시작!");
    }
}
