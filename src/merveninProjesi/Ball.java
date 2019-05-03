package merveninProjesi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

public class Ball implements Drawable {
	final static int RADIUS=25;
	private double x,y;
	Integer name;
	Color color=Color.white;
	boolean striped;//not implemented yet
	private Shape shape;
	public Ball(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		shape=new Ellipse2D.Double(x, y, RADIUS, RADIUS);
	}
	boolean intersects(Shape s) {
		return shape.intersects(s.getBounds2D());
	}
	boolean intersects(Ball b) {
		return shape.intersects(b.shape.getBounds2D());
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
		shape=new Ellipse2D.Double(x, y, RADIUS, RADIUS);
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
		shape=new Ellipse2D.Double(x, y, RADIUS, RADIUS);
	}

	@Override
	public void Paint(Graphics2D g) {
		g.setColor(color);
		g.fill(shape);
		g.setColor(Color.black);
		if(name!=null)
		g.drawString(name.toString(), (float)(x+RADIUS*0.3), (float)(y+RADIUS*0.6));
	}
	double getCenterX() {
		return x+(RADIUS/4);
	}
	double getCenterY() {
		
		return y+(RADIUS/4);
	}
	
	

}
