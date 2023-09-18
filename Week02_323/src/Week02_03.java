interface Animal {
    void walk();
    void fly();
    void sing();
}

class Bird implements Animal {
    @Override
    public void walk() {
        System.out.println("걸을 수 있음.");
    }

    @Override
    public void fly() {
        System.out.println("날을 수 있음.");
    }

    @Override
    public void sing() {
        System.out.println("노래 부를 수 있음.");
    }
}

public class Week02_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Bird bird = new Bird();
	        bird.walk();
	        bird.fly();
	        bird.sing();
	}

}
