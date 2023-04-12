package text5;

public class Cricle extends GeometricObject{
	private double radius;

	public Cricle() {
		super();
		this.radius = 1.0;
	}
	
	
	public Cricle(double radius) {
		super();
		this.radius = radius;
	}
	public Cricle(double radius,String color,double weight) {
		super();
		this.color = color;
		this.radius = radius;
		this.weight = weight;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double findArea() {
		return Math.PI * radius * radius;
	}
	public boolean equales(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Cricle) {
			Cricle cri1 = (Cricle) obj;
			return this.radius == cri1.getRadius();
		}
		return false;
	}
	public String toString() {
		return "这个圆的半径为：" + this.getRadius();
	}
	
}
