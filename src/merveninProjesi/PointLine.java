package merveninProjesi;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class PointLine  {

	 Color color=Color.white;
	 private int radius=5;
	 private ArrayList<Ellipse2D.Double> points;
	 private boolean option;
	 private  double x1,x2,y1,y2;
	 private int number=10;
	 private int distance=10;
	
	public PointLine(double x1, double y1, double x2, double y2, boolean option) {
		super();
		points=new ArrayList<>();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.option = option;
		set();
	}

	
	private void set() {
		points.clear();
		
		if(option){
			double a=(x1-x2)/number;
			
			double b=(y1-y2)/number;
			for(int i=0;i<number;i++){
				Ellipse2D.Double e=new Ellipse2D.Double(x2+(a*i),y2+(b*i),radius,radius);
				points.add(e);
			}
		}
		else{
			double angle = Math.atan((x1-x2)/(y1-y2));
			double a=x1;
			double b=y1;
	
			while(Math.abs((a-x1)/(x1-x2))<=1&&Math.abs((b-y1)/(y2-y1))<=1) {
				
				Ellipse2D.Double e=new Ellipse2D.Double(a,b,radius,radius);
				points.add(e);
				a+=Math.cos(angle)*distance;
				b+=Math.sin(angle)*distance;
			}
		}
	}
	
	void Paint(Graphics2D g2) {
		g2.setColor(color);
		for (Ellipse2D.Double double1 : points) {
			g2.fill(double1);
		}
	}


	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
		set();
	}


	public boolean isOption() {
		return option;
	}


	public void setOption(boolean option) {
		this.option = option;
		set();
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
		set();
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
		set();
	}
	
	
}
