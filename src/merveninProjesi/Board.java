package merveninProjesi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements MouseListener {
	List<Ball>balls=new  ArrayList<>();
	int width=800,height=400;
	int kenar=20;
	java.util.List<Ellipse2D.Double> holes=new ArrayList<>();
	List<Movement> moves=new ArrayList<>();
	int offsetX,offsetY;
	boolean pressed=false,opt=false;
	public Board() {
		super();
		setup();
		
		/*
		int HoleRadius=Ball.RADIUS*2;
		holes.add(new Ellipse2D.Double(0      , 0,      HoleRadius, HoleRadius));
		holes.add(new Ellipse2D.Double((width-HoleRadius)/2, 0,     HoleRadius, HoleRadius));
		holes.add(new Ellipse2D.Double(width-HoleRadius  , 0 ,     HoleRadius, HoleRadius));
		holes.add(new Ellipse2D.Double(0      , height-HoleRadius, HoleRadius, HoleRadius));
		holes.add(new Ellipse2D.Double((width-HoleRadius)/2, height-HoleRadius, HoleRadius, HoleRadius));
		holes.add(new Ellipse2D.Double(width-HoleRadius  , height-HoleRadius, HoleRadius, HoleRadius));
		*/
		addMouseListener(this);
		Timer t=new Timer(1, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				for (Movement movement : moves) {
					if(movement.isStopped()) {
						moves.remove(movement);
					break;
					}
				}
				
			}
		});
		t.start();
		
		
	}
	@Override
	public void paint(Graphics g) {
		offsetX=(getWidth()-(width+2*kenar))/2;
		offsetY=(getHeight()-(height+2*kenar))/2;
		g.translate(offsetX , offsetY);
		super.paint(g);
		g.setColor(new Color(87, 38, 28));
		g.fillRect(0, 0, width+2*kenar, height+2*kenar);
		g.setColor(new Color(28, 87, 49));
		g.fillRect(kenar, kenar, width, height);
		Graphics2D g2=(Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(200, 199, 178));
		for (  Ellipse2D.Double h: holes) {
			g2.fill(h);
		}
		for (Ball ball : balls) {
			ball.Paint(g2);
		}
		if(pressed){
			PointLine p=new PointLine(balls.get(0).getCenterX(), balls.get(0).getCenterY(), getMousePosition().getX()-offsetX, getMousePosition().getY()-offsetY, opt);
		p.Paint(g2);}
		
	}
	
	void setup() {
		balls.clear();
		Ball t=new Ball(width*0.75, height/2);
		balls.add(t);
		/*  
		for(int i=0;i<5;i++) {
			for(int j=0;j<=i;j++) {
				Ball b=new Ball(width*0.25-Ball.RADIUS*i,(height/2-(Ball.RADIUS/2)*i)+Ball.RADIUS*j );
				b.name=balls.size();
				balls.add(b);
			}
		}
		*/
	}
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		
		switch (e.getButton()) {
		case MouseEvent.BUTTON1:
			pressed=true;
			break;
		case MouseEvent.BUTTON2:
			double angle=Math.atan2(e.getY()-balls.get(0).getCenterY()-offsetY,e.getX()-balls.get(0).getCenterX()-offsetX)+Math.PI;
			 Movement m=new Movement(balls.get(0),angle, 50);
			m.setBounds(kenar, kenar, kenar+width, kenar+height);
			 moves.add(m);
			 m.start();
			break;
		case MouseEvent.BUTTON3:
			opt=!opt;
			break;

		default:
			break;
		}
		//System.out.println('!');
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			pressed=false;
			double angle=Math.atan2(e.getY()-balls.get(0).getCenterY(),e.getX()-balls.get(0).getCenterX())+Math.PI;
			double power=(e.getX()-balls.get(0).getCenterX())+(e.getY()-balls.get(0).getCenterY());
					power/=5;
					Movement m=new Movement(balls.get(0),angle, 50);
					 m.setBounds(kenar, kenar, kenar+width, kenar+height);
					 moves.add(m);
					 m.start();
		}
	}
	
}
