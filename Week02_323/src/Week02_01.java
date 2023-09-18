class Circle{
	protected int radius;
	public Circle(int r) {radius=r;}
}

class Pizza extends Circle{
	String p;
	public Pizza(String p,int r) {
		super(r);
		this.p=p;
	}
	public void print() {
		System.out.println(radius+" is radius of "+p);
	}
}

public class Week02_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza obj=new Pizza("Pepperoni", 20);
		obj.print();
	}

}
