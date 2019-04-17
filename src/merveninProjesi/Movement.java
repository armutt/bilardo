package merveninProjesi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Movement  implements ActionListener{
	
	Timer timer;
	Ball ball;
	double angle;
	static double acceleration=0.7;
	double power;
	double speed;
	public Movement(Ball b, double ang,double power ) {
		ball=b;
		angle=ang;
		speed=power;
		timer=new Timer(10,this );
	}
	void start() {
		timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		double speedx=Math.cos(angle)*speed;
		double speedy=Math.sin(angle)*speed;
		
		ball.x+=speedx;
		ball.y+=speedy;
		speed*=acceleration;
		if(speed<0.2)
			timer.stop();
	}

}
