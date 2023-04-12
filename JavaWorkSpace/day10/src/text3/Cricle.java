package text3;

public class Cricle extends GeometricObject{
	private double radius;

	public Cricle(String color, double weight, double radius) {
		super(color, weight);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	

	@Override
	public double findArea() {
		// TODO Auto-generated method stub
		return (radius * radius * Math.PI);
	}


	
	
	
	
}
