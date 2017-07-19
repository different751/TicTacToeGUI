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
 *Program Difficulties:
 *I tried to design the AI to block winning moves from the user when 
 *hard difficulty was chosen. But the way I was implementing the 
 *checks it didnt seem to work and often had problems. At one point I had
 *about 24 if statements. So i decided to just go with the corner plays.
 * 
 * 
 * Also the mouse click is really sensitive. If you are moving the mouse 
 *while click a square it will not put down a mark because the coordinates are
 *moving.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */







package coy_t_3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	window panel;
	boolean cpucheck;
	JRadioButton rdbtnCpu = new JRadioButton("CPU");//radio button for cpu first
	JRadioButton rdbtnPLAYER = new JRadioButton("PLAYER");//radio button for player first
	JRadioButton rdbtnX = new JRadioButton("X");//radio button for x first
	JRadioButton rdbtnO = new JRadioButton("O");//radio button for o first
	JRadioButton rdbtnEasy = new JRadioButton("EASY");//radio button for difficutly
	JRadioButton rdbtnMedium = new JRadioButton("MEDIUM");//radio button for difficulty 
	JRadioButton rdbtnHard = new JRadioButton("HARD");//radio button for difficulty
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("TIC TAC TOE");//set title
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 408);//constructing frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.MAGENTA);//set backgroud color
		
		final window panel = new window();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {//mouse listen event for click
				int x=arg0.getX(); int y=arg0.getY();//record mouse location
				panel.checkbox(x,y);//sent coordinates to checkbox in mypanel
				setTitle(panel.titles());//change titles from the flags in mypanel
				//System.out.println(x + " " + y); //used for debugging
			}
		});
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, null, null));//playing board bg 
		panel.setBounds(10, 11, 300, 300);
		contentPane.add(panel);
		
		JButton btnStartGame = new JButton("START GAME");//button for start game
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//if button pressed
				panel.clearboard();//clear playing board
				//set all flags in mypanel
				panel.setflags(rdbtnCpu.isSelected(), rdbtnPLAYER.isSelected(), rdbtnX.isSelected(), rdbtnO.isSelected(), rdbtnEasy.isSelected(), rdbtnMedium.isSelected(), rdbtnHard.isSelected());
				setTitle(panel.titles());//set all titles
				if(rdbtnCpu.isSelected()){//if cpu first then give first move to cpu
					panel.cpumove();//call cpu move
				}
			}
			
		});
		btnStartGame.setBounds(395, 239, 145, 23);
		contentPane.add(btnStartGame);
		
		//JRadioButton rdbtnCpu = new JRadioButton("CPU");
		buttonGroup.add(rdbtnCpu);
		rdbtnCpu.setBounds(405, 53, 57, 23);
		contentPane.add(rdbtnCpu);
		
		
		
		//JRadioButton rdbtnPLAYER = new JRadioButton("PLAYER");
		buttonGroup.add(rdbtnPLAYER);
		rdbtnPLAYER.setBounds(481, 53, 84, 23);
		contentPane.add(rdbtnPLAYER);
		
		JLabel lblSelectFirstTurn = new JLabel("SELECT FIRST TURN");//constructing label
		lblSelectFirstTurn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSelectFirstTurn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectFirstTurn.setBounds(395, 32, 145, 14);
		contentPane.add(lblSelectFirstTurn);
		
		
		JLabel lblSelectPlayerSymbol = new JLabel("SELECT PLAYER SYMBOL");//constructing label
		lblSelectPlayerSymbol.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSelectPlayerSymbol.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectPlayerSymbol.setBounds(395, 91, 145, 14);
		contentPane.add(lblSelectPlayerSymbol);
		
		//JRadioButton rdbtnX = new JRadioButton("X");
		buttonGroup_1.add(rdbtnX);
		rdbtnX.setBounds(405, 112, 44, 23);
		contentPane.add(rdbtnX);
		
		//JRadioButton rdbtnO = new JRadioButton("O");
		buttonGroup_1.add(rdbtnO);
		rdbtnO.setBounds(481, 112, 44, 23);
		contentPane.add(rdbtnO);
		
		JLabel lblSelectDifficulty = new JLabel("SELECT DIFFICULTY");//constructing label 
		lblSelectDifficulty.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSelectDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectDifficulty.setBounds(395, 150, 145, 14);
		contentPane.add(lblSelectDifficulty);
		
		//JRadioButton rdbtnEasy = new JRadioButton("EASY");
		buttonGroup_2.add(rdbtnEasy);
		rdbtnEasy.setBounds(375, 171, 57, 23);
		contentPane.add(rdbtnEasy);
		
		//JRadioButton rdbtnMedium = new JRadioButton("MEDIUM");
		buttonGroup_2.add(rdbtnMedium);
		rdbtnMedium.setBounds(434, 171, 77, 23);
		contentPane.add(rdbtnMedium);
		
		//JRadioButton rdbtnHard = new JRadioButton("HARD");
		buttonGroup_2.add(rdbtnHard);
		rdbtnHard.setBounds(513, 171, 63, 23);
		contentPane.add(rdbtnHard);
		
		JButton btnQuit = new JButton("QUIT");//if quit then exit program
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(395, 273, 145, 23);
		contentPane.add(btnQuit);
		
	}
	}
