package merveninProjesi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Board extends JPanel {
	List<Ball>balls=new  ArrayList<>();
	int width=800,height=400;
	java.util.List<Ellipse2D.Double> holes=new ArrayList<>();
	public Board() {
		super();
		setup();
		int HoleRadius=Ball.RADIUS*2;
		holes.add(new Ellipse2D.Double(0      , 0,      HoleRadius, HoleRadius));
		holes.add(new Ellipse2D.Double((width-HoleRadius)/2, 0,     HoleRadius, HoleRadius));
		holes.add(new Ellipse2D.Double(width-HoleRadius  , 0 ,     HoleRadius, HoleRadius));
		holes.add(new Ellipse2D.Double(0      , height-HoleRadius, HoleRadius, HoleRadius));
		holes.add(new Ellipse2D.Double((width-HoleRadius)/2, height-HoleRadius, HoleRadius, HoleRadius));
		holes.add(new Ellipse2D.Double(width-HoleRadius  , height-HoleRadius, HoleRadius, HoleRadius));
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.translate((getWidth()-width)/2 , (getHeight()-height)/2);
		super.paint(g);
		g.setColor(new Color(87, 38, 28));
		g.fillRect(0, 0, width, height);
		g.setColor(new Color(28, 87, 49));
		g.fillRect(Ball.RADIUS, Ball.RADIUS, width-Ball.RADIUS*2, height-Ball.RADIUS*2);
		Graphics2D g2=(Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(200, 199, 178));
		for (  Ellipse2D.Double h: holes) {
			g2.fill(h);
		}
		for (Ball ball : balls) {
			ball.Paint(g2);
		}
		
	}
	
	void setup() {
		balls.clear();
		Ball t=new Ball(width*0.75, height/2);
		balls.add(t);
		for(int i=0;i<5;i++) {
			for(int j=0;j<=i;j++) {
				Ball b=new Ball(width*0.25-Ball.RADIUS*i,(height/2-(Ball.RADIUS/2)*i)+Ball.RADIUS*j );
				b.name=balls.size();
				balls.add(b);
			}
		}
		
	}
	
}
