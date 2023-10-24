class Sports {
    // 슈퍼 클래스인 Sports에서 getName 메서드 정의
    String getName() {
        return "아직 결정되지 않음";
    }

    // 슈퍼 클래스인 Sports에서 getPlayers 메서드 정의
    int getPlayers() {
        return 0;
    }
}

class Soccer extends Sports {
    @Override
    // 서브 클래스인 Soccer에서 getName 메서드를 재정의
    String getName() {
        return "축구";
    }

    @Override
    // 서브 클래스인 Soccer에서 getPlayers 메서드를 재정의
    int getPlayers() {
        return 11;
    }
}

public class Week02_02 {
    public static void main(String[] args) {
        // Soccer 클래스의 인스턴스 생성
        Soccer soccer = new Soccer();
        
        // 경기 이름과 경기자 수 출력
        System.out.println("경기이름: " + soccer.getName());
        System.out.println("경기자수: " + soccer.getPlayers());
    }
}
