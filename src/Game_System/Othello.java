package Game_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Othello extends JFrame{
	//
	ImageIcon othello_base = new ImageIcon(Othello.class.getResource("../images/��������3.png")); // ��������
	ImageIcon iconBackground = new ImageIcon(Othello.class.getResource("../images/�Ϸ���Ʈ.png")); // �ٴٱ׸�
	ImageIcon player1icon = new ImageIcon(Othello.class.getResource("../images/�÷��̾�1ǥ��.png")); //�÷��̾�1 ������
	ImageIcon player2icon = new ImageIcon(Othello.class.getResource("../images/�÷��̾�2.png")); // �÷��̾�2 ������
	ImageIcon player1_underline = new ImageIcon(Othello.class.getResource("../images/�÷��̾�1_underline.png")); //�÷��̾�1 �� ������
	ImageIcon player2_underline = new ImageIcon(Othello.class.getResource("../images/�÷��̾�2_underline.png")); // �÷��̾�2 �� ������
	ImageIcon whiteTeam = new ImageIcon(Othello.class.getResource("../images/����.png")); // ������ �˸���
	ImageIcon blackTeam = new ImageIcon(Othello.class.getResource("../images/������.png")); // �������� �˸���
	ImageIcon blackplayer = new ImageIcon(Othello.class.getResource("../images/������.png")); // ������
	ImageIcon whiteplayer = new ImageIcon(Othello.class.getResource("../images/���.png")); // ���
	ImageIcon brounShadow = new ImageIcon(Othello.class.getResource("../images/������5.png")); // ������
	ImageIcon zeroImage = new ImageIcon(Othello.class.getResource("../images/zero.png")); // ���� 0
	ImageIcon oneImage = new ImageIcon(Othello.class.getResource("../images/one.png")); 
	ImageIcon twoImage = new ImageIcon(Othello.class.getResource("../images/two.png")); 
	ImageIcon threeImage = new ImageIcon(Othello.class.getResource("../images/three.png"));
	ImageIcon fourImage = new ImageIcon(Othello.class.getResource("../images/four.png"));
	ImageIcon fiveImage = new ImageIcon(Othello.class.getResource("../images/five.png"));
	ImageIcon sixImage = new ImageIcon(Othello.class.getResource("../images/six.png"));
	ImageIcon sevenImage = new ImageIcon(Othello.class.getResource("../images/seven.png"));
	ImageIcon eightImage = new ImageIcon(Othello.class.getResource("../images/eight.png"));
	ImageIcon nineImage = new ImageIcon(Othello.class.getResource("../images/nine.png")); // ���� 9
	ImageIcon reStart = new ImageIcon(Othello.class.getResource("../images/���Ǵ�.png")); // ���Ǵ�
	ImageIcon gameEx = new ImageIcon(Othello.class.getResource("../images/������.png")); // ������
	ImageIcon winb = new ImageIcon(Othello.class.getResource("../images/������_��.png")); // ������ ��
	ImageIcon white = new ImageIcon(Othello.class.getResource("../images/ȭ��Ʈ.png")); // ������ ��� ����
	ImageIcon winw = new ImageIcon(Othello.class.getResource("../images/������.png")); // ���� ��
	ImageIcon draw = new ImageIcon(Othello.class.getResource("../images/�����ϴ�.png")); // �����ϴ�.
	ImageIcon cant = new ImageIcon(Othello.class.getResource("../images/������ �ִ� ���� �����ϴ�..png")); // ���� �� �ִ� ���� �����ϴ�.
//	ImageIcon setting = new ImageIcon(Othello.class.getResource("../images/settings.png"));
//	ImageIcon exitIcon = new ImageIcon(Othello.class.getResource("../images/exit.png")); 
	
	JButton[][] butn = new JButton[10][10];
	JButton butn_restart = new JButton();
	JButton butn_exit = new JButton();
	
	Dimension d = new Dimension();
	Game g = new Game();
	Shadow sh = new Shadow();
	
	int box[][] = g.box;
	int player = 1;
	
	final int width = 994; // Panel ����
	final int height = 771; // Panel ����
	int x = 0;
	int y = 0;
	int b_first_coin = 0; // ������ ���� 10���ڸ�
	int w_first_coin = 0; // ��� ���� 10���ڸ�
	int b_second_coin = 2; // ������ ���� 1���ڸ�
	int w_second_coin = 2; // ��� ���� 1���ڸ�
	boolean winJudge = false;
	boolean turnPass = false;
	String name;
	
	public Othello() {
		
		Music intro = new Music("�����3.mp3",true);
		intro.start();
		
		sh.shadow_countdown(g.box,g.player);
		
		//---------------------------------- ó�� �������� 
		System.out.println("���� �����Դϴ�.");
		
		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j <= 8; j++) {
				System.out.printf("%d ",box[i][j]);
			}
			System.out.println();
		}System.out.println();
		//------------------------------------
		JPanel panel = new JPanel() { // ��������, ����, �÷��̾� panel
			@Override
			public void paint(Graphics g) {
				d = getSize();
				g.drawImage(iconBackground.getImage(), 0, 0, d.width, d.height, null); // ��������
				g.drawImage(othello_base.getImage(), (d.width - d.height*2/3)/2, d.height*2/3 -  d.height/2 , d.height*2/3, d.height*2/3, null);
//				g.drawImage(setting.getImage(), 770, 20, d.height/8-10, d.height/8-10, null);
//				g.drawImage(exitIcon.getImage(), 880, 20, d.height/8-10, d.height/8-10, null);
				
				if(player == 1) { //�÷��̾� �̹��� 
					g.drawImage(player1_underline.getImage(), 25, d.height / 30,d.height / 4, d.height / 4, null);
					g.drawImage(whiteTeam.getImage(), d.width/2-d.height*2/6+d.height/12, 15, d.height/2, d.height/8, null);
					g.drawImage(player2icon.getImage(), 775, d.height / 30,d.height / 4, d.height / 4, null);
				}else if(player == 2) {
					g.drawImage(player1icon.getImage(), 25, d.height / 30,d.height / 4, d.height / 4, null);
					g.drawImage(blackTeam.getImage(), d.width/2-d.height*2/6+d.height/12, 15, d.height/2, d.height/8, null);
					g.drawImage(player2_underline.getImage(), 775, d.height / 30,d.height / 4, d.height / 4, null);
				}
				
				for(int i = 1; i<= 8; i++) { //�����ξ� �� ������ ǥ��
					for(int j = 1; j <= 8; j++) {
						if(box[i][j] == 1) {
							g.drawImage(whiteplayer.getImage(), d.width/2-d.height*2/6+d.height*2/3/8*(j-1), (d.height-d.height*2/3)/2+d.height*2/3/8*(i-1)+2, d.height*2/3/8, d.height*2/3/8, null);
						}else if(box[i][j] == 2) {
							g.drawImage(blackplayer.getImage(), d.width/2-d.height*2/6+d.height*2/3/8*(j-1), (d.height-d.height*2/3)/2+d.height*2/3/8*(i-1)+2, d.height*2/3/8, d.height*2/3/8, null);
						}else if(box[i][j] == 3) {
							g.drawImage(brounShadow.getImage(),d.width/2-d.height*2/6+d.height*2/3/8*(j-1), (d.height-d.height*2/3)/2+d.height*2/3/8*(i-1)+2, d.height*2/3/8, d.height*2/3/8, null);
						}
					}
				}
				if(w_first_coin == 0) { // ���� ���
					g.drawImage(zeroImage.getImage(), 30, height / 3, 90, 175, null);
				}else if(w_first_coin == 1) {
					g.drawImage(oneImage.getImage(), 30, height / 3, 90, 175, null);
				}else if(w_first_coin == 2) {
					g.drawImage(twoImage.getImage(), 30, height / 3, 90, 175, null);
				}else if(w_first_coin == 3) {
					g.drawImage(threeImage.getImage(), 30, height / 3, 90, 175, null);
				}else if(w_first_coin == 4) {
					g.drawImage(fourImage.getImage(), 30, height / 3, 90, 175, null);
				}else if(w_first_coin == 5) {
					g.drawImage(fiveImage.getImage(), 30, height / 3, 90, 175, null);
				}else if(w_first_coin == 6) {
					g.drawImage(sixImage.getImage(), 30, height / 3, 90, 175, null);
				}
				if(w_second_coin == 0) {
					g.drawImage(zeroImage.getImage(), 125, height / 3, 90, 175, null);
				}else if(w_second_coin == 1) {
					g.drawImage(oneImage.getImage(), 125, height / 3, 90, 175, null);
				}else if(w_second_coin == 2) {
					g.drawImage(twoImage.getImage(), 125, height / 3, 90, 175, null);
				}else if(w_second_coin == 3) {
					g.drawImage(threeImage.getImage(), 125, height / 3, 90, 175, null);
				}else if(w_second_coin == 4) {
					g.drawImage(fourImage.getImage(), 125, height / 3, 90, 175, null);
				}else if(w_second_coin == 5) {
					g.drawImage(fiveImage.getImage(), 125, height / 3, 90, 175, null);
				}else if(w_second_coin == 6) {
					g.drawImage(sixImage.getImage(), 125, height / 3, 90, 175, null);
				}else if(w_second_coin == 7) {
					g.drawImage(sevenImage.getImage(), 125, height / 3, 90, 175, null);
				}else if(w_second_coin == 8) {
					g.drawImage(eightImage.getImage(), 125, height / 3, 90, 175, null);
				}else if(w_second_coin == 9) {
					g.drawImage(nineImage.getImage(), 125, height / 3, 90, 175, null);
				}
				if(b_first_coin == 0) {
					g.drawImage(zeroImage.getImage(), 780, height / 3, 90, 175, null);
				}else if(b_first_coin == 1) {
					g.drawImage(oneImage.getImage(), 780, height / 3, 90, 175, null);
				}else if(b_first_coin == 2) {
					g.drawImage(twoImage.getImage(), 780, height / 3, 90, 175, null);
				}else if(b_first_coin == 3) {
					g.drawImage(threeImage.getImage(), 780, height / 3, 90, 175, null);
				}else if(b_first_coin == 4) {
					g.drawImage(fourImage.getImage(), 780, height / 3, 90, 175, null);
				}else if(b_first_coin == 5) {
					g.drawImage(fiveImage.getImage(), 780, height / 3, 90, 175, null);
				}else if(b_first_coin == 6) {
					g.drawImage(sixImage.getImage(), 780, height / 3, 90, 175, null);
				}
				if(b_second_coin == 0) {
					g.drawImage(zeroImage.getImage(), 875, height / 3, 90, 175, null);
				}else if(b_second_coin == 1) {
					g.drawImage(oneImage.getImage(), 875, height / 3, 90, 175, null);
				}else if(b_second_coin == 2) {
					g.drawImage(twoImage.getImage(), 875, height / 3, 90, 175, null);
				}else if(b_second_coin == 3) {
					g.drawImage(threeImage.getImage(), 875, height / 3, 90, 175, null);
				}else if(b_second_coin == 4) {
					g.drawImage(fourImage.getImage(), 875, height / 3, 90, 175, null);
				}else if(b_second_coin == 5) {
					g.drawImage(fiveImage.getImage(), 875, height / 3, 90, 175, null);
				}else if(b_second_coin == 6) {
					g.drawImage(sixImage.getImage(), 875, height / 3, 90, 175, null);
				}else if(b_second_coin == 7) {
					g.drawImage(sevenImage.getImage(), 875, height / 3, 90, 175, null);
				}else if(b_second_coin == 8) {
					g.drawImage(eightImage.getImage(), 875, height / 3, 90, 175, null);
				}else if(b_second_coin == 9) {
					g.drawImage(nineImage.getImage(), 875, height / 3, 90, 175, null);
				}
				if(winJudge == true) { //���ӽºΰ�� ���
					if(w_first_coin * 10 + w_second_coin > b_first_coin * 10 + b_second_coin) {
						g.drawImage(white.getImage(),0,0,d.width,d.height,null);
						g.drawImage(winw.getImage(),0,0,d.width,d.height,null);
						g.drawImage(reStart.getImage(), d.width/4+30, d.height/2-350, d.width/5, d.height/12+20, null);
						g.drawImage(gameEx.getImage(), d.width/4+270, d.height/2-350, d.width/5, d.height/12+20, null);
					}
					else if(w_first_coin * 10 + w_second_coin < b_first_coin * 10 + b_second_coin) {
						g.drawImage(winb.getImage(),0,0,d.width,d.height,null);
						g.drawImage(reStart.getImage(), d.width/4+30, d.height/2-350, d.width/5, d.height/12+20, null);
						g.drawImage(gameEx.getImage(), d.width/4+270, d.height/2-350, d.width/5, d.height/12+20, null);
					}
					else if(w_first_coin * 10 + w_second_coin == b_first_coin * 10 + b_second_coin){
						g.drawImage(white.getImage(),0,0,d.width,d.height,null);
						g.drawImage(draw.getImage(),0,0,d.width,d.height,null);
						g.drawImage(reStart.getImage(), d.width/4+30, d.height/2-350, d.width/5, d.height/12+20, null);
						g.drawImage(gameEx.getImage(), d.width/4+270, d.height/2-350, d.width/5, d.height/12+20, null);
					}
				}
				setOpaque(false); // ����ȭ
				repaint();
				super.paintComponents(g);
			}
		};
		
		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j <= 8; j++) {
				box[i][j] = g.box[i][j];
			}
		}
		add(panel);
		panel.setLayout(null);
		panel.setBounds(0, 0, width, height);
		setTitle("Othello");
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // ������ ����
		setLocationRelativeTo(null); // �߾� ���
		
		setVisible(true); // ����
//-------------------------------------------------------------------		
		JPanel btPanel = new JPanel();//btPanel ��ư ���
		
		add(btPanel);
		btPanel.setOpaque(false); //btPanel ����ȭ
		btPanel.setLayout(null); //btPanel Layout ���ֱ�
		
		int w = 994, h = 771; // �������� ũ��
		
		butn_restart = new JButton();
		butn_restart.setOpaque(false);
		butn_restart.setFocusPainted(false); // ���� �Ǿ����� ����� �׵θ� ����
		butn_restart.setContentAreaFilled(false);				
		butn_restart.setBounds(w/4+30, h/2-350, w/5, h/12+20);
		
		butn_exit = new JButton();
		butn_exit.setOpaque(false);
		butn_exit.setFocusPainted(false); // ���� �Ǿ����� ����� �׵θ� ����
		butn_exit.setContentAreaFilled(false);		
		butn_exit.setBounds(w/4+270, h/2-350, w/5, h/12+20);
		
		btPanel.add(butn_restart); // �ѹ��� ��ư
		btPanel.add(butn_exit); // ������ ��ư
		
		butn_restart.setEnabled(false);
		butn_exit.setEnabled(false);
		
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				butn[i][j] = new JButton();
				butn[i][j].setOpaque(false);
				butn[i][j].setFocusPainted(false); // ���� �Ǿ����� ����� �׵θ� ����
				butn[i][j].setContentAreaFilled(false);				
				butn[i][j].setBounds((w/2 - h/3) + (h/12*(j-1)),h/2-h/3+(h/12*(i-1)),h/12, h/12);
				
				btPanel.add(butn[i][j]);
				
				butn[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							for(int i =1; i <=8; i++) {
								for(int j = 1; j <= 8; j++) {
									if(e.getSource() == butn[i][j]) {
										x = i; y = j;
									}
								}
							}
							System.out.println(x+","+y);
							g.gameStart(x, y);	 
							player = g.player;
							Shadow sh = new Shadow();
							sh.shadow_countdown(g.box,g.player);
							box = sh.shadowBox;
							b_first_coin = g.b_coin;
							b_second_coin = b_first_coin % 10;
							b_first_coin = b_first_coin / 10;
							w_first_coin = g.w_coin;
							w_second_coin = w_first_coin%10;
							w_first_coin = w_first_coin / 10;		
							winJudge = g.winJudge;
							turnPass = g.turnPass;
							
							if(winJudge == true) {						
								for(int i = 1; i <= 8; i ++) {
									for(int j = 1; j <= 8; j++) {
										butn[i][j].setEnabled(false);
									}
								}
								butn_restart.setEnabled(true);
								butn_exit.setEnabled(true);
								Music clap = new Music("�ڼ�.mp3",false);
								clap.start();
							}
						}
					}
				);// ������ ��ư actionlistener ������
			}
		}	

				
		butn_restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player = 1;
				g.player = 1;
				b_first_coin = 0;
				w_first_coin = 0;
				b_second_coin = 2;
				w_second_coin = 2;
				for(int i = 1; i <= 8; i ++){
					for(int j = 1; j <= 8; j++) {
						box[i][j] = 0;
					}
				}
				box[4][4] = 1;
				box[5][5] = 1;
				box[4][5] = 2;
				box[5][4] = 2;
				sh.shadow_countdown(box,player);
				box = sh.shadowBox;
				winJudge = false;
				g.winJudge = false;
				if(winJudge == false) {
					butn_restart.setEnabled(false);
					butn_exit.setEnabled(false);
					for(int i = 1; i <= 8; i++) {
						for(int j = 1; j <= 8; j++) {
							butn[i][j].setEnabled(true);
						}
					}
				}
			}	
		});// �ٽ��ϱ� actionlistener ������
		panel.repaint(); // �ٽ� �׸���
		btPanel.repaint(); // �ٽ� �׸���
	}
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_TAB) {
				System.out.println("exit");
				System.exit(0);
			}
		}
	}
}
