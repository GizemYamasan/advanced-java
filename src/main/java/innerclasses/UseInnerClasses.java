package innerclasses;

public class UseInnerClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Outer().new Inner().myMethod(); // Inner instance of outer
		
		new Outer.InnerStatic().myMethod(); //static inner class

	}

}
