/*Name: Tyler Coy
 *Class: CSE 223
 *Date: 5/12/16
 *Assignment: Programming assignment 3
 *
 *
 *Program Description:
 *This program is a TIC-TAC-TOE game that can be played
 *on a computer. When the program is launched the user 
 *is greeted with a window that contains a 
 *TIC-TAC-TOE board and options for the user 
 *to change game settings. The options for the settings
 *include who has the first move, what symbol the player
 *will use and what difficulty to play on. Then there
 *is a start game button which starts the game and a quit
 *game button which quits the game. 
 *
 *When easy difficulty is chosen the AI just chooses random
 *boxes to mark. If a box already contains a mark it will continue
 *to pick randomly until a box is empty.
 *
 *When medium difficulty is chosen the AI starts off by moving to 
 *any of the four corners. Once a corner is chosen it will then
 *revert back to what easy difficulty does by choosing randomly
 *
 *When hard difficulty is chosen the AI starts off by moving to 
 *two of the any four corners. Once two corners are chosen it will 
 *revert back to what easy difficulty does by choosing randomly.
 *
 *After every move the program will check if the cpu or the player
 *won. If so then the game displays the winning row and in the top
 *left corner of the Jframe the title changes to who won the game. 
 *The title in the top left also changes for whos turn it is.
 *
 *
 *
 *Program Difficulties:
 *I tried to design the AI to block winning moves from the user when 
 *hard difficulty was chosen. But the way I was implementing the 
 *checks it didnt seem to work and often had problems. At one point I had
 *about 24 if statements. So i decided to just go with the corner plays.
 *
 *Also the mouse click is really sensitive. If you are moving the mouse 
 *while click a square it will not put down a mark because the coordinates are
 *moving.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */






package coy_t_3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class window extends JPanel {
	int boxflag[][]= new int[3][3];//used to tell which square is taken
	int firstturn=0;//flag for first turn
	int playersymbol=0;//flag for player symbol
	int difficulty=0;//flag for difficulty
	int winnerflag=0;//flag for winner
	int noclick=0;//flag for no more clicks
	int titleflag=0;//flag to change title
	int winnersymbol=0;//flag to show the winning symbol
	int kickout=0;//flag to kick out of loop
	
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawLine(100, 0, 100, 300);//draw lines for the tic tac board
		g.drawLine(200, 0, 200, 300);
		g.drawLine(0, 100, 300, 100);
		g.drawLine(0, 200, 300, 200);
		g.setColor(Color.BLACK);//set the line colors to black

		if(boxflag[0][0]==1){//if the first square is marked draw x
			g.drawLine(10,10,90,90);//these lines used to draw x based on coordinates of square
			g.drawLine(90,10,10,90);
		}
		
		if(boxflag[0][1]==1){//if the second square is marked draw x
			g.drawLine(110, 10, 190, 90);//these lines used to draw x based on coordinates of square
			g.drawLine(190, 10, 110, 90);
		}
		
		if(boxflag[0][2]==1){//if the third square is marked draw x
			g.drawLine(210, 10, 290, 90);//these lines used to draw x based on coordinates of square
			g.drawLine(290, 10, 210, 90);
		}
		
		if(boxflag[1][0]==1){//if the fourth square is marked draw x
			g.drawLine(10, 110, 90, 190);//these lines used to draw x based on coordinates of square
			g.drawLine(90, 110, 10, 190);
		}
		
		if(boxflag[1][1]==1){//if the fifth square is marked draw x
			g.drawLine(110, 110, 190, 190);//these lines used to draw x based on coordinates of square
			g.drawLine(190, 110, 110, 190);
		}
		
		if(boxflag[1][2]==1){//if the sixth square is marked draw x
			g.drawLine(210, 110, 290, 190);//these lines used to draw x based on coordinates of square
			g.drawLine(290, 110, 210, 190);
		}
		
		if(boxflag[2][0]==1){//if the seventh square is marked draw x
			g.drawLine(10, 210, 90, 290);//these lines used to draw x based on coordinates of square
			g.drawLine(90, 210, 10, 290);
		}
		
		if(boxflag[2][1]==1){//if the eighth square is marked draw x
			g.drawLine(110, 210, 190, 290);//these lines used to draw x based on coordinates of square
			g.drawLine(190, 210, 110, 290);
		}
		
		if(boxflag[2][2]==1){//if the ninth sqare is marked draw x
			g.drawLine(210, 210, 290, 290);//these lines used to draw x based on coordinates of squard
			g.drawLine(290, 210, 210, 290);
		}
		
		
		
		
			if(boxflag[0][0]==2){//if first box is marked draw oval
				g.drawOval(10, 10, 75, 75);//used to draw oval based on square
			}
			
			if(boxflag[0][1]==2){//if second box is marked draw oval
				g.drawOval(110, 10, 75, 75);//used to draw oval based on square
				
			}
			
			if(boxflag[0][2]==2){//if third box is marked draw oval
				g.drawOval(210, 10, 75, 75);//used to draw oval based on square
			}
			
			if(boxflag[1][0]==2){//if fourth box is marked draw oval
				g.drawOval(10, 110, 75, 75);//used to draw oval based on square
			}
			
			if(boxflag[1][1]==2){//if fifth box is marked draw oval
				g.drawOval(110, 110, 75, 75);//used to draw oval based on square
			}
			
			if(boxflag[1][2]==2){//if the sixth box is marked draw oval
				g.drawOval(210, 110, 75, 75);//uesd to draw oval based on square
			}
			
			if(boxflag[2][0]==2){//if the seveth box is marked draw oval 
				g.drawOval(10, 210, 75, 75);//used to draw oval based on square
			}
			
			if(boxflag[2][1]==2){//if the eighth box is marked draw oval
				g.drawOval(110, 210, 75, 75);//used to draw oval based on square
			}
			
			if(boxflag[2][2]==2){//if the ninth box is marked draw oval
				g.drawOval(210, 210, 75, 75);//used to draw oval based on sqaure
			}
			
			if(winnerflag==1){//check ifrow is winner if so continue
				g.setColor(Color.GREEN);//set winning line color to green
				Graphics2D g2 = (Graphics2D) g;//make a 2d graphics obj
				g2.setStroke(new BasicStroke(6));//change line thickness
				g2.drawLine(50,50,50,250);//draw lines based on winning row coordinates
				//System.out.println("winner 1");//used for debug
			}
			
			if(winnerflag==2){//check if row is winner if so continue
				g.setColor(Color.GREEN);//set winning line color to green 
				Graphics2D g2 = (Graphics2D) g;//make a 2d graphics obj
				g2.setStroke(new BasicStroke(6));//change line thickness
				g2.drawLine(50,50, 250,50);//draw lines based on winning row coordinates
				//System.out.println("winner 2");//used for debug
			}
			
			if(winnerflag==3){//check if row is winner if so continue
				g.setColor(Color.GREEN);//set winning line color to green
				Graphics2D g2 = (Graphics2D) g;//make a 2d graphics obj
				g2.setStroke(new BasicStroke(6));//change line thickness
				g2.drawLine(250,50,250,250);//draw lines based on winning row coordinates
			//	System.out.println("winner 3");//used for debug
			}
			
			if(winnerflag==4){//check if column is winner if so continue 
				g.setColor(Color.GREEN);//set winning line color to green
				Graphics2D g2 = (Graphics2D) g;//make a 2d graphics obj
				g2.setStroke(new BasicStroke(6));//change line thickness
				g2.drawLine(50,50,250,250);//draw lines based on winning column coordinates
			//	System.out.println("winner 4");//used for debug
			}
			
			if(winnerflag==5){//check if column is winner if so continue
				g.setColor(Color.GREEN);//set winning line color to green
				Graphics2D g2 = (Graphics2D) g;//make a 2d graphics obj
				g2.setStroke(new BasicStroke(6));//change line thickness
				g2.drawLine(250,50,50,250);//draw lines based on winning column coordinates
				//System.out.println("winner 5");//used for debug
			}
			
			if(winnerflag==6){//check if column is winner if so continue
				g.setColor(Color.GREEN);//set winning line color to green
				Graphics2D g2 = (Graphics2D) g;//make a 2d graphics obj
				g2.setStroke(new BasicStroke(6));//change line thickness
				g2.drawLine(50,250,250,250);//draw lines based on winning column coordiantes
				//System.out.println("winner 6");//used for debug
			}
		
			if(winnerflag==7){//check if diagonal is winner if so continue
				g.setColor(Color.GREEN);//set winning line color to green 
				Graphics2D g2 = (Graphics2D) g;//make a 2d graphics obj
				g2.setStroke(new BasicStroke(6));//change line thickness
				g2.drawLine(150,50,150,250);//draw lines baed on winning diagonal coordinates
				//System.out.println("winner 7");//used for debug
			}
			
			if(winnerflag==8){//check if diagonal is winner fi so continue
				g.setColor(Color.GREEN);//set winning line color to green
				Graphics2D g2 = (Graphics2D) g;//make a 2d graphics obj
				g2.setStroke(new BasicStroke(6));//change line thickness
				g2.drawLine(50,150,250,150);//draw lines based on winning diagonal coordinates
				//System.out.println("winner 8");//used for debug
			}
			
			if(titleflag==1 && winnerflag==0){//if no winner then tie game 
				g.setColor(Color.RED);//set tie game lines to red
				Graphics2D g2 = (Graphics2D) g;//make a 2d graphics obj
				g2.setStroke(new BasicStroke(6));//change line thickness
				g2.drawLine(50,150,250,150);//these lines draw all possible winning
				g2.drawLine(150,50,150,250);//lines to show tie game
				g2.drawLine(50,250,250,250);
				g2.drawLine(250,50,50,250);
				g2.drawLine(50,50,250,250);
				g2.drawLine(250,50,250,250);
				g2.drawLine(50,50, 250,50);
				g2.drawLine(50,50,50,250);
			}
		
		}
	
	public void checkbox(int x, int y){//check the box where player clicked
		if(noclick==0){//if allowed to click continue
		if(playersymbol==0){//if player is x symbol continue
		if(x<=100 && y<=100){//if click between these ranges continue
			if(boxflag[0][0]==0){//if box empty continue
			boxflag[0][0]=1;//set box to x mark
			checkwin();//check for win
			cpumove();//cpu takes a turn
			}
		}
		
		if(((x<=200) && (x>=100))  && (y<=100)){//if click between these ranges continue
			if(boxflag[0][1]==0){//if box empty continue
			boxflag[0][1]=1;//et box to x mark
			checkwin();//check for win
			cpumove();//cpu takes a turn
			}
		}
		
		if(((x<=300) && (x>=200))  && (y<=100)){//if click between these ranges continue
			if(boxflag[0][2]==0){//if box empty continue
			boxflag[0][2]=1;//set box to x mark
			checkwin();//check win
			cpumove();//cpu takes a turn
			}
		}
		
		if((x<=100) && ((y>=100) && (y<=200))){//if click between these ranges continue
			if(boxflag[1][0]==0){//if box empty continue
			boxflag[1][0]=1;//set box to x mark
			checkwin();//check win
			cpumove();//cpu takes a turn
			}
		}
		
		if(((x<=200) && (x>=100)) && ((y>=100) && (y<=200))){//if click between these ranges continue
			if(boxflag[1][1]==0){//if box empty continue
			boxflag[1][1]=1;//set box to x mark
			checkwin();//check win
			cpumove();//cpu takes a turn
			}
		}
		
		if(((x<=300) && (x>=200)) && ((y>=100) && (y<=200))){//if click between these ranges continue
			if(boxflag[1][2]==0){//if box empty continue
			boxflag[1][2]=1;//set box to x mark
			checkwin();//check win
			cpumove();//cpu takes a turn
			}
		}
		
		if(x<=100 && y>=200){//if click between these ranges continue
			if(boxflag[2][0]==0){//if box empty continue 
			boxflag[2][0]=1;//set box to x mark
			checkwin();//check win
			cpumove();//cpu takes a turn
			}
		}
		
		if(((x<=200) && (x>=100))  && (y>=200)){//if click between thesr ranges continue
			if(boxflag[2][1]==0){//if box empty continue
			boxflag[2][1]=1;//set box to x mark
			checkwin();//check win
			cpumove();//cpu takes a turn
			}
		}
		
		if(((x<=300) && (x>=200))  && (y>=200)){//if click between these ranges continue
			if(boxflag[2][2]==0){//if box empty continue
			boxflag[2][2]=1;//set box to x mark
			checkwin();//check win
			cpumove();//cpu takes a turn
			}
		}
		}
		else{//the rest is for ovals
			if(x<=100 && y<=100){//if click between thesr ranges continue
				if(boxflag[0][0]==0){//if box empty continue
				boxflag[0][0]=2;//set box to oval mark
				checkwin();//check win
				cpumove();//cpu takes a turn
				}
			}
			
			if(((x<=200) && (x>=100))  && (y<=100)){//if click between thesr ranges continue
				if(boxflag[0][1]==0){//if box empty continue
				boxflag[0][1]=2;//set box to oval mark
				checkwin();//check win
				cpumove();//cpu takes a turn
				}
			}
			
			if(((x<=300) && (x>=200))  && (y<=100)){//if click between these ranges continue
				if(boxflag[0][2]==0){//if box empty continue
				boxflag[0][2]=2;//set box to oval mark
				checkwin();//check win
				cpumove();//cpu takes a turn
				}
			}
			
			if((x<=100) && ((y>=100) && (y<=200))){//if click between thesr ranges continue
				if(boxflag[1][0]==0){//if box empty continue
				boxflag[1][0]=2;//set box to oval mark
				checkwin();//check win
				cpumove();//cpu takes a turn
				}
			}
			
			if(((x<=200) && (x>=100)) && ((y>=100) && (y<=200))){//if click between these ranges continue
				if(boxflag[1][1]==0){//if box empty continue
				boxflag[1][1]=2;//set box to oval mark
				checkwin();//check win
				cpumove();//cpu takes a turn
				}
			}
			
			if(((x<=300) && (x>=200)) && ((y>=100) && (y<=200))){//if click between these ranges continue
				if(boxflag[1][2]==0){//if box empty continue
				boxflag[1][2]=2;//set box to oval mark
				checkwin();//check win
				cpumove();//cpu takes a turn
				}
			}
			
			if(x<=100 && y>=200){//if click between these ranges continue
				if(boxflag[2][0]==0){//if box empty continue
				boxflag[2][0]=2;//set box to oval mark
				checkwin();//check win
				cpumove();//cpu takes a turn
				}
			}
			
			if(((x<=200) && (x>=100))  && (y>=200)){//if click between these ranges continue
				if(boxflag[2][1]==0){//if box empty continue
				boxflag[2][1]=2;//set box to oval mark
				checkwin();//check win
				cpumove();//cpu takes a turn
				}
			}
			
			if(((x<=300) && (x>=200))  && (y>=200)){//if click between these ranges continue
				if(boxflag[2][2]==0){//if box empty continue
				boxflag[2][2]=2;//set box to oval mark
				checkwin();//check win
				cpumove();//cpu takes a turn
				}
			}
			
		}
		
		checkwin();//check win
		repaint();//repaint all new checks for boxes
		}
	}
	
	public void clearboard(){//clear the playing board of all marks
		for(int i=0; i<3; i++){//loop to move through the array of marks
			for(int z=0; z<3;z++){//loop array
				boxflag[i][z]=0;//set arry element to zero
			}
		}
		repaint();//repaint board to show empty
	}
	
	public void checkwin(){//check for win
		if(((boxflag[0][0]==1) && (boxflag[1][0]==1) && (boxflag[2][0]==1))){//check for win
			winnerflag=1;//set winner flag 
			noclick=1;//set for no more click
			winnersymbol=1;//set winning symbol
			}
		
		if((boxflag[0][0]==2) && (boxflag[1][0]==2 && (boxflag[2][0]==2))){//check for win
			winnerflag=1;//set winner flag 
			noclick=1;//set for no more clicks
			winnersymbol=2;//set winning symbol
		}
		
		if(((boxflag[0][0]==1) && (boxflag[0][1]==1) && (boxflag[0][2]==1))){ //check for win
			winnerflag=2;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=1;// set winning symbol
			}
		
		if((boxflag[0][0]==2) && (boxflag[0][1]==2 && (boxflag[0][2]==2))){//check for win
			winnerflag=2;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=2;//set winning symbol
		}
		
		if(((boxflag[0][2]==1) && (boxflag[1][2]==1) && (boxflag[2][2]==1))){ //check for win
			winnerflag=3;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=1;//set winning symbol
			}
		
		if((boxflag[0][2]==2) && (boxflag[1][2]==2 && (boxflag[2][2]==2))){//check for win
			winnerflag=3;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=2;//set winning symbol
		}
		
		if(((boxflag[0][0]==1) && (boxflag[1][1]==1) && (boxflag[2][2]==1))){ //check for win
			winnerflag=4;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=1;//set winning symbol
			}
		
		if((boxflag[0][0]==2) && (boxflag[1][1]==2 && (boxflag[2][2]==2))){//check for win
			winnerflag=4;//st winner flag
			noclick=1;//set for no more clicks
			winnersymbol=2;//set winning symbol
		}
		
		if(((boxflag[2][0]==1) && (boxflag[1][1]==1) && (boxflag[0][2]==1))){ //check for win
			winnerflag=5;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=1;//set winning symbol
			}
		
		if((boxflag[2][0]==2) && (boxflag[1][1]==2 && (boxflag[0][2]==2))){//check for win
			winnerflag=5;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=2;//set for winning symbol
		}
		
		if(((boxflag[2][0]==1) && (boxflag[2][1]==1) && (boxflag[2][2]==1))){//check for win
			winnerflag=6;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=1;//set for winning symbol
			}
		
		if((boxflag[2][0]==2) && (boxflag[2][1]==2 && (boxflag[2][2]==2))){//check for win
			winnerflag=6;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=2;//set for winnig symbol
		}
		
		if(((boxflag[0][1]==1) && (boxflag[1][1]==1) && (boxflag[2][1]==1))){ //check for win
			winnerflag=7;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=1;//set for winning symbol
			}
		
		if((boxflag[0][1]==2) && (boxflag[1][1]==2 && (boxflag[2][1]==2))){//check for win
			winnerflag=7;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=2;//set for winning symbol
		}
		
		if(((boxflag[1][0]==1) && (boxflag[1][1]==1) && (boxflag[1][2]==1))){ //check for win
			winnerflag=8;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=1;//set for winning symbol
			}
		
		if((boxflag[1][0]==2) && (boxflag[1][1]==2 && (boxflag[1][2]==2))){//check for win
			winnerflag=8;//set winner flag
			noclick=1;//set for no more clicks
			winnersymbol=2;//set for winning symbol
		}
		
		
		int othercounter=0;//used to check for tie
		for(int i=0; i<3; i++){//loop through array
			for(int z=0; z<3;z++){//keep loop
				if(boxflag[i][z]!=0){//if not zero increment
					othercounter++;
				}
					
				}
			}
		
		if(othercounter==9){//if 9 squares taken
			noclick=1;//set no clicks
			titleflag=1;//set flag for tie game
		}
		
		}
	
	
	public void cpumove(){//cpu turns
		Random randnum= new Random();//random math object
		int retry=0;//used to retry if square is taken
		titleflag=2;//set to show that it is players turn
		if(winnerflag==0){//if winner flag zero continue
		if(difficulty==0){//if difficulty is easy
			int cpunum=randnum.nextInt(9);//store random number
			//System.out.println(cpunum);//used for debug
			if((cpunum==0) && (boxflag[0][0]==0)){//if random number and box empty
				if(playersymbol==0){//and player symbol x
					boxflag[0][0]=2;//set square oval
					retry=1;//set retry to one so it wont retry
				}
				else{//if player not x set x
					boxflag[0][0]=1;
					retry=1;
				}
				
			}
			
			if((cpunum==1) && (boxflag[0][1]==0)){//if random number and box emtpy
				if(playersymbol==0){//and player symbol x
					boxflag[0][1]=2;//set oval
					retry=1;
				}
				else{
					boxflag[0][1]=1;//set x
					retry=1;
				}
				
			}
			
			if((cpunum==2) && (boxflag[0][2]==0)){//if random number and box empty 
				if(playersymbol==0){//and player symbol x
					boxflag[0][2]=2;//set oval
					retry=1;
				}
				else{
					boxflag[0][2]=1;//set x
					retry=1;
				}
				
			}
			
			if((cpunum==3) && (boxflag[1][0]==0)){//if random number and box empty
				if(playersymbol==0){
					boxflag[1][0]=2;//set oval
					retry=1;
				}
				else{
					boxflag[1][0]=1;//set x
					retry=1;
				}
				
			}
			
			if((cpunum==4) && (boxflag[1][1]==0)){//if random number and box emtpy
				if(playersymbol==0){//if player x
					boxflag[1][1]=2;//set oval
					retry=1;
				}
				else{
					boxflag[1][1]=1;//set x
					retry=1;
				}
				
			}
			
			if((cpunum==5) && (boxflag[1][2]==0)){//if random number and box empty 
				if(playersymbol==0){//if player x
					boxflag[1][2]=2;//set oval
					retry=1;
				}
				else{
					boxflag[1][2]=1;//set x
					retry=1;
				}
				
			}
			
			if((cpunum==6) && (boxflag[2][0]==0)){//if random number and box empty
				if(playersymbol==0){//if player x
					boxflag[2][0]=2;//set oval
					retry=1;
				}
				else{
					boxflag[2][0]=1;//set x
					retry=1;
				}
				
			}
			
			if((cpunum==7) && (boxflag[2][1]==0)){//if random number and box empty
				if(playersymbol==0){//if player x
					boxflag[2][1]=2;//set oval
					retry=1;
				}
				else{
					boxflag[2][1]=1;//set x
					retry=1;
				}
				
			}
			
			if((cpunum==8) && (boxflag[2][2]==0)){//if random number and box empty 
				if(playersymbol==0){//if player x
					boxflag[2][2]=2;//set oval
					retry=1;
				}
				else{
					boxflag[2][2]=1;//set x
					retry=1;
				}
				
			}
			
			int counter=0;//count taken squares
			for(int i=0; i<3; i++){//loop array
				for(int z=0; z<3;z++){
					if(boxflag[i][z]!=0){
						counter++;
					}
				}
			}
			
			if(((retry==0) && (counter <8)) || ((retry==0) && (counter<=8) && (firstturn==0))){//if no square marked retry
				cpumove();
			}
			
		}
		
		if(difficulty==1){//medium difficutly
			if(winnerflag==0){
			
			
			while(kickout==0){//while loop to choose corner
				int cpunum=randnum.nextInt(9);
				if((cpunum==0) || (cpunum==2) || (cpunum==6) || (cpunum ==8)){//if these squares
					if((cpunum==0) && (boxflag[0][0]==0)){//if zero and box empty
						if(playersymbol==0){//player x
							boxflag[0][0]=2;//set oval
							retry=1;
						}
						else{
							boxflag[0][0]=1;//set x
							retry=1;
						}
					}
				
						
					if((cpunum==2) && (boxflag[0][2]==0)){//if box empty
							if(playersymbol==0){//player x
								boxflag[0][2]=2;//set oval
								retry=1;
							}
							else{
								boxflag[0][2]=1;//set x
								retry=1;
							}
					}
							
							if((cpunum==6) && (boxflag[2][0]==0)){//if box empty
								if(playersymbol==0){//player x
									boxflag[2][0]=2;//set oval
									retry=1;
								}
								else{
									boxflag[2][0]=1;//set x
									retry=1;
								}
							}
								
							
							if((cpunum==8) && (boxflag[2][2]==0)){//if box empty
								if(playersymbol==0){//player x
									boxflag[2][2]=2;///set oval
									retry=1;
								}
								else{
									boxflag[2][2]=1;//set x
									retry=1;
								}
								}
					kickout=1;//set to break out of while
					return;
				}
			}
			
			
				int cpunum=randnum.nextInt(9);//choose random like normal
				//System.out.println(cpunum);//debug line
				if((cpunum==0) && (boxflag[0][0]==0)){//if box empty
					if(playersymbol==0){//if player x
						boxflag[0][0]=2;//set oval
						retry=1;
					}
					else{
						boxflag[0][0]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==1) && (boxflag[0][1]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[0][1]=2;//set oval
						retry=1;
					}
					else{
						boxflag[0][1]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==2) && (boxflag[0][2]==0)){//if box emtpy
					if(playersymbol==0){//if player x
						boxflag[0][2]=2;//set oval
						retry=1;
					}
					else{
						boxflag[0][2]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==3) && (boxflag[1][0]==0)){//if box emtpy
					if(playersymbol==0){//if player x
						boxflag[1][0]=2;//set oval
						retry=1;
					}
					else{
						boxflag[1][0]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==4) && (boxflag[1][1]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[1][1]=2;//set oval
						retry=1;
					}
					else{
						boxflag[1][1]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==5) && (boxflag[1][2]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[1][2]=2;//set oval
						retry=1;
					}
					else{
						boxflag[1][2]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==6) && (boxflag[2][0]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[2][0]=2;//set oval
						retry=1;
					}
					else{
						boxflag[2][0]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==7) && (boxflag[2][1]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[2][1]=2;//set oval
						retry=1;
					}
					else{
						boxflag[2][1]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==8) && (boxflag[2][2]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[2][2]=2;//set oval
						retry=1;
					}
					else{
						boxflag[2][2]=1;//set x
						retry=1;
					}
					
				}
				
				int counter=0;
				for(int i=0; i<3; i++){//loop array
					for(int z=0; z<3;z++){//keep looping
						if(boxflag[i][z]!=0){//if box taken
							counter++;//increment
						}
					}
				}
				
				if(((retry==0) && (counter <8)) || ((retry==0) && (counter<=8) && (firstturn==0))){//retry if box taken
					cpumove();
				}
				
			}
			
			
		}
		
		if(difficulty==2){//difficutly hard
			if(winnerflag==0){
				
				while(kickout<2){//pick two corners
					int cpunum=randnum.nextInt(9);//random number
					if((cpunum==0) || (cpunum==2) || (cpunum==6) || (cpunum ==8)){
						if((cpunum==0) && (boxflag[0][0]==0)){//if box empty
							if(playersymbol==0){//player x
								boxflag[0][0]=2;//set oval
								retry=1;
							}
							else{
								boxflag[0][0]=1;//set x
								retry=1;
							}
						}
					
							
						if((cpunum==2) && (boxflag[0][2]==0)){//if box empty
								if(playersymbol==0){//player x
									boxflag[0][2]=2;//set oval
									retry=1;
								}
								else{
									boxflag[0][2]=1;//set x
									retry=1;
								}
						}
								
								if((cpunum==6) && (boxflag[2][0]==0)){//if box empty
									if(playersymbol==0){//player x
										boxflag[2][0]=2;//set oval
										retry=1;
									}
									else{
										boxflag[2][0]=1;//set x
										retry=1;
									}
								}
									
								
								if((cpunum==8) && (boxflag[2][2]==0)){//if box empty
									if(playersymbol==0){//player x
										boxflag[2][2]=2;//set oval
										retry=1;
									}
									else{
										boxflag[2][2]=1;//set x
										retry=1;
									}
									}
								if(retry==0){
									cpumove();
								}
						kickout++;
						return;
					}
				}
				
				
			
			
		int cpunum=randnum.nextInt(9);
				//System.out.println(cpunum);
				if((cpunum==0) && (boxflag[0][0]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[0][0]=2;//set oval
						retry=1;
					}
					else{
						boxflag[0][0]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==1) && (boxflag[0][1]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[0][1]=2;//set oval
						retry=1;
					}
					else{
						boxflag[0][1]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==2) && (boxflag[0][2]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[0][2]=2;//set oval
						retry=1;
					}
					else{
						boxflag[0][2]=1;//st x
						retry=1;
					}
					
				}
				
				if((cpunum==3) && (boxflag[1][0]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[1][0]=2;//set oval
						retry=1;
					}
					else{
						boxflag[1][0]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==4) && (boxflag[1][1]==0)){//if box empty 
					if(playersymbol==0){//if player x
						boxflag[1][1]=2;//set oval
						retry=1;
					}
					else{
						boxflag[1][1]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==5) && (boxflag[1][2]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[1][2]=2;//set oval
						retry=1;
					}
					else{
						boxflag[1][2]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==6) && (boxflag[2][0]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[2][0]=2;//set oval
						retry=1;
					}
					else{
						boxflag[2][0]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==7) && (boxflag[2][1]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[2][1]=2;//set oval
						retry=1;
					}
					else{
						boxflag[2][1]=1;//set x
						retry=1;
					}
					
				}
				
				if((cpunum==8) && (boxflag[2][2]==0)){//if box empty
					if(playersymbol==0){//player x
						boxflag[2][2]=2;//set oval
						retry=1;
					}
					else{
						boxflag[2][2]=1;//set x
						retry=1;
					}
					
				}
				
				int counter=0;
				for(int i=0; i<3; i++){//loop array
					for(int z=0; z<3;z++){//loop array
						if(boxflag[i][z]!=0){
							counter++;
						}
					}
				}
				
				if(((retry==0) && (counter <8)) || ((retry==0) && (counter<=8) && (firstturn==0))){//retry if box taken
					cpumove();
				}
				
			}
			
			
		}
		
		}
		}
		

			
		
		
	
	
	public void setflags(boolean cpu, boolean player, boolean x, boolean o, boolean easy, boolean medium, boolean hard){//set all flags for everyting
		winnerflag=0;//winner flag used to flag if a row or coulmn has won
		noclick=0;// flag to set no more clicks
		winnersymbol=0;//flag to who what the winning symbol was
		titleflag=0;//title flag to tell what to change in the title
		kickout=0;//kick out of loop 
		
		if(cpu){
			firstturn=0;//set cpu turn
		}
		
		if(player){
			firstturn=1;//set player turn
		}
		
		if(x){
			playersymbol=0;//set player x
		}
		
		if(o){
			playersymbol=1;//set player oval
		}
		
		if(easy){
			difficulty=0;//set difficutly easy
		}
		
		if(medium){
			difficulty=1;//set difficulty medium
		}
		
		if(hard){
			difficulty=2;//set dificulty hard
		}
		
		titleflag=2;//title flag for player turn
		
	}
	
	public String titles(){//used to change titles in jfram
		if(titleflag==1 && winnerflag==0){//if no winner then tie game
			return("TIE GAME");
		}
		
		if(playersymbol==0 && winnersymbol==1){//if player wins then change title
			return("PLAYER WINS");
		}
		
		if(playersymbol==1 && winnersymbol == 2){//if player wins then change title
			return("PLAYER WINS");
		}
		
		if(playersymbol==0 && winnersymbol==2){//if cpu wins then change title
			return("CPU WINS");
		}
		
		if(playersymbol==1 && winnersymbol==1){//if cpu wins then change title
			return("CPU WINS");
		}
		
		if(titleflag==2){//change to show that it is players turn
			return("PLAYER'S TURN");
		}
		
		
		
		return("TIC TAC TOE");//set title tic tac toe
				
		
	}
	
	public window(){
		
	}

}
