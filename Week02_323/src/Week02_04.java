interface Controllable {
    void play();
    void stop();
}

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
		// TODO Auto-generated method stub
		Controllable c = new VideoPlayer();
        c.play();
        c.stop();
	}

}
