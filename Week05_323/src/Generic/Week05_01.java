package Generic;

class Container<T>{
	private T t;
	public T get() {return t;}
	public void set(T t) {this.t=t;}
}

public class Week05_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Container<String> container1=new Container<String>();
		container1.set("홍길동");
		String str=container1.get();
		
		Container<Integer> container2=new Container<Integer>();
		container2.set(6);
		int value=container2.get();
	}
}
