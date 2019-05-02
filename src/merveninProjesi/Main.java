package merveninProjesi;

import javax.swing.JFrame;

public class Main  {
	
	public static void main(String[] args) {
		Board b=new Board();  
		JFrame j=new JFrame("Bilardo");
		j.setSize(840, 460);
		j.add(b);
		
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
