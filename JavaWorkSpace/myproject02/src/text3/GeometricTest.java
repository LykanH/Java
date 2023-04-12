package text3;

public class GeometricTest {
	public static void main(String[] args) {
		GeometricObject o1 = new Cricle("blue", 21.1, 7);
		GeometricObject o2 = new Cricle("green", 21, 5);
		GeometricObject o3 = new MyRectangle("red", 21, 6, 7);
		GeometricObject o4 = new Cricle("red", 21, 5);
		GeometricTest test1 = new GeometricTest();
		
		test1.displayGeometricObject(o3);
		test1.equalsArea(o2, o1);
		test1.equalsArea(o1, o3);
		test1.equalsArea(o2, o4);
	}
	
	
	public void displayGeometricObject(GeometricObject a) {
		System.out.println(a.findArea());
	}
	
	public void equalsArea(GeometricObject a,GeometricObject b) {
		boolean isSure = a.findArea() == b.findArea();
		System.out.println("面积是否相等？" + isSure);
	}
}
