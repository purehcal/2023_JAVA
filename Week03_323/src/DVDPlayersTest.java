class DVDPlayersTest {

    public static void main(String[] args) {
        // DVDPlayer 클래스의 인스턴스를 생성합니다.
        DVDPlayer a = new DVDPlayer();
        
        // Players 인터페이스를 구현한 DVDPlayer 클래스의 인스턴스를 생성합니다.
        Players b = new DVDPlayer();
        
        // ExPlayers 인터페이스를 구현한 DVDPlayer 클래스의 인스턴스를 생성합니다.
        ExPlayers c = new DVDPlayer();
        
        System.out.println("DVDPlayer 형 변수 a");
        // DVDPlayer 형 변수 a로 접근하는 메서드 호출
        a.play();
        a.stop();
        a.slow();
        
        System.out.println("Player 형 변수 b");
        // Player 형 변수 b로 접근하는 메서드 호출
        b.play();
        b.stop();
        
        System.out.println("ExPlayer 형 변수 c");
        // ExPlayer 형 변수 c로 접근하는 메서드 호출
        c.play();
        c.stop();
        c.slow();
    }
}
