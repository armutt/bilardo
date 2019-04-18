package merveninProjesi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements MouseListener {
	List<Ball>balls=new  ArrayList<>();
	int width=800,height=400;
	java.util.List<Ellipse2D.Double> holes=new ArrayList<>();
	boolean pressed=false,opt=false;
	
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
		addMouseListener(this);
		Timer t=new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				
			}
		});
		t.start();
		
		
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
		if(pressed)
		{PointLine p=new PointLine(balls.get(0).x+(Ball.RADIUS/2), balls.get(0).y+(Ball.RADIUS/2), getMousePosition().getX(), getMousePosition().getY(), opt);
		p.Paint(g2);}
		
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON3)
		{
			opt=!opt;
			return;
		}
		pressed=true;
		System.out.println('!');
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON3)
			return;
		pressed=false;
		
	}
	
}
