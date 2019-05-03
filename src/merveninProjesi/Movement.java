package merveninProjesi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Movement implements ActionListener {
	
	Ball ball;
	double angleX,angleY;
	
	int minX,minY,maxX,maxY;
	static double acceleration=0.9;
	double speed;
	Timer timer;
	
	public Movement(Ball b, double ang,double power ) {
		ball=b;
		angleX=Math.cos(ang);
		angleY=Math.sin(ang);
		speed=power;
		timer=new Timer(50, this);
	}
	
	public void start() {
		timer.start();
	}
	
	public void setBounds(int x1,int y1,int x2,int y2) {
		minX=x1;
		maxX=x2;
		minY=y1;
		maxY=y2;
		
	}
	
	public void move() {}
	
	public boolean isStopped() {return !timer.isRunning();}
		
		
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		double speedx=angleX*speed;
		double speedy=angleY*speed;
		double nX=ball.getX() + speedx;
		double nY=ball.getY() + speedy;
		if(nX<minX) { 
			nX=minX+(minX-nX);
			angleX*=-1;
		}
		else if(nX>maxX) {
			nX=maxX-(nX-maxX);
			angleX*=-1;
		}
		if(nY<minY) { 
			nY=minY+(minY-nY);
			angleY*=-1;
		}
		else if(nY>maxY) {
			nY=maxY-(nY-maxY);
			angleY*=-1;
		}
			
		ball.setX(nX);
		ball.setY(nY);
		speed*=acceleration;
		if(speed<1)
			timer.stop();
		
	}
	

}
