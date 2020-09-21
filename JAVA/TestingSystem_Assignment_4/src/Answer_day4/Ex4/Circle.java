package Answer_day4.Ex4;

public class Circle {
	private double radius = 1.0;
	private String color = "red";
	
	public Circle() {
		this.radius = 1.0;
		this.color = "red";
	}
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return radius*radius*3.14;
	}
	
	public String toString() {
		return "Radius: " + radius + "\nColor: "  + color + "\nArea: " + getArea();
	}
}
