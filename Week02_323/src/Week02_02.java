class Sports {
    String getName() {
        return "아직 결정되지 않음";
    }

    int getPlayers() {
        return 0;
    }
}

class Soccer extends Sports {
    @Override
    String getName() {
        return "축구"; 
    }

    @Override
    int getPlayers() {
        return 11; 
    }
}
public class Week02_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Soccer soccer = new Soccer();
        System.out.println("경기이름: " + soccer.getName());
        System.out.println("경기자수: " + soccer.getPlayers());
	}

}
