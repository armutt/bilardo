package merveninProjesi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

public class Ball implements Drawable {
	final static double MASS=170;
	final static int RADIUS=25;
	double x,y;
	Integer name;
	Color color=Color.white;
	boolean striped;
	
	public Ball(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public void Paint(Graphics2D g) {
		g.setColor(color);
		g.fill(new Ellipse2D.Double(x, y, RADIUS, RADIUS));
		g.setColor(Color.black);
		if(name!=null)
		g.drawString(name.toString(), (float)(x+RADIUS*0.3), (float)(y+RADIUS*0.6));
	}
	
	

}
