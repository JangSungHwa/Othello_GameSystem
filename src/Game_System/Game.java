package Game_System;

public class Game{
	
	public int box[][] = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,2,0,0,0,0},
			{0,0,0,0,2,1,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0}};
	
	int player = 1;
	int b_coin = 0;
	int w_coin = 0;
	int w_box = 0;
	int b_box = 0;
	boolean turnPass = false;
	boolean winJudge = false;
	
	
	Shadow sa = new Shadow();
	
	public void gameStart(int x, int y){

		Music clickmusic = new Music("Ŭ���Ҹ�.mp3",false);
		Music cantmusic = new Music("pi.mp3",false);
		
		turnPass = false;
		int count = 0 ; // �������� ���� Ȯ��
		int judge = 0; // ���� �� �ִ� ������ �Ǵ�
		b_coin = 0; //������ ����
		w_coin = 0; // ȭ��Ʈ ���� ����
		w_box = 0;
		b_box = 0;
		int shadow_count = 0; // ���� �� �ִ� �� ī��Ʈ
		boolean last_Judge = false; 
		sa.shadow_countdown(box, player);

//----------------------------------------------------------------------------
		
		if(box[x][y] != 0 && box[x][y] != 3) {
			cantmusic.start();
			System.out.println("���� �� ���� ���Դϴ�.");
			for(int i = 1; i <= 8 ; i ++) {
				for(int j = 1; j <= 8; j ++) {
					if(box[i][j] == 1) {
						w_box ++;
					}else if(box[i][j] == 2) {
						b_box ++;
					}
				}
			}
			b_coin = b_box;
			w_coin = w_box;
			return;
		}
		
		if(box[x-1][y] != 0&&x>=3&&box[x-1][y] != 3) {  //���δ� �� (��) �Ǵ�
			last_Judge = false;count = 0;
			for(int i = x-1; i >= 1; i--) {
				if(box[i][y] == 0 || box[i][y] == 3) {
					count = 0;
					break;
				}else if(box[i][y] != player) {
					count ++; 
				}else if(box[i][y] == player) {
					last_Judge = true;
					break;
				}
			}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1&&last_Judge) {
				box[x-count][y] = player;
				count --;
			}
		}
		
		if(box[x+1][y] != 0&&x<=6 && box[x+1][y] != 3) { //���δ� �� (�Ʒ�) �Ǵ�
			last_Judge = false;count = 0;
			for(int i = x+1; i <= 8; i++) {
				if(box[i][y] == 0 || box[i][y] == 3) {
					count = 0;
					break;
				}else if(box[i][y] != player) {
					count ++; 
				}else if(box[i][y] == player) {
					last_Judge = true;
					break;
				}
			}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
				box[x+count][y] = player;
				count --;
			}
		}
		if(box[x][y-1] != 0&&y>=3 && box[x][y-1] != 3) { //���δ� �� (����) �Ǵ�
			last_Judge = false;count = 0;
			for(int i = y-1; i >= 1; i--) {
				if(box[x][i] == 0 || box[x][i] == 3) {
					count = 0;
					break;
				}else if(box[x][i] != player) {
					count ++; 
				}else if(box[x][i] == player) {
					last_Judge = true;
					break;
				}}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
				box[x][y-count] = player;
				count --;
			}
		}
		if(box[x][y+1] != 0 && y <= 6 && box[x][y+1] != 3) { //���δ� �� (������) �Ǵ�
			last_Judge = false;count = 0;
			for(int i = y+1; i <= 8; i++) {
				if(box[x][i] == 0 || box[x][i] == 3) {
					count = 0;
					break;
				}else if(box[x][i] != player) {
					count ++; 
				}else if(box[x][i] == player) {
					last_Judge = true;
					break;
				}}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
	 			box[x][y+count] = player;
				count --;
			}
		}
		if(box[x-1][y-1] != 0 && x >= 3 && y >= 3&&box[x-1][y-1] != 3) { //���δ� �� (��,��) �Ǵ�
			last_Judge = false;count = 0;
			for(int i = 1; x-i >= 1 && y-i >= 1; i++) {
				if(box[x-i][y-i] == 0||box[x-1][y-1] == 3) {
					count = 0;
					break;
				}else if(box[x-i][y-i] != player) {
					count ++; 
				}else if(box[x-i][y-i] == player) {
					last_Judge = true;
					break;
				}}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
				box[x-count][y-count] = player;
				count --;
			}
		}
		if(box[x+1][y+1] != 0 && x <= 6 && y <= 6&&box[x+1][y+1] != 3) { //���δ� �� (����,�Ʒ�) �Ǵ�
			last_Judge = false;count = 0;
			for(int i = 1; x+i <= 8 && y+i <= 8; i++) {
				if(box[x+i][y+i] == 0||box[x+1][y+1] == 3) {
					count = 0;
					break;
				}else if(box[x+i][y+i] != player) {
					count ++; 
				}else if(box[x+i][y+i] == player) {
					last_Judge = true;
					break;
				}}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
				box[x+count][y+count] = player;
				count --;
			}
		}
		if(box[x-1][y+1] != 0 && x >= 3 && y <= 6 && box[x-1][y+1] != 3) { //���δ� �� (����, ��) �Ǵ�
			last_Judge = false;count = 0;
			for(int i = 1; x-i >= 1 && y+i <= 8; i++) {
				if(box[x-i][y+i] == 0 || box[x-1][y+1] == 3) {
					count = 0;
					break;
				}else if(box[x-i][y+i] != player) {
					count ++; 
				}else if(box[x-i][y+i] == player) {
					last_Judge = true;
					break;
				}}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
				box[x-count][y+count] = player;
				count --;
			}
		}
		if(box[x+1][y-1] != 0 && x <= 6 && y >= 3&&box[x+1][y-1] != 3) { //���δ� �� (��, �Ʒ�) �Ǵ�
			last_Judge = false;count = 0;
			for(int i = 1; x+i <= 8 && y-i >= 1; i++) {
				if(box[x+i][y-i] == 0 || box[x+1][y-1] == 3) {
					count = 0;
					break;
				}else if(box[x+i][y-i] != player) {
					count ++; 
				}else if(box[x+i][y-i] == player) {
					last_Judge = true;
					break;
				}}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
				box[x+count][y-count] = player;
				count --;
			}
		}
//------------------------------------------------------------------------	
		if(judge == 1) {//player��ü, ����
			
			clickmusic.start();
			box[x][y] = player;
			judge = 0;
			if(player == 1) {
				player = 2;
			}else if(player == 2) {
				player = 1;
			}
		}else {
			cantmusic.start();
			System.out.println("���� �� ���� ��");
		}		
		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j <= 8; j++) {
				if(box[i][j] == 3) {
					box[i][j] = 0;
				}
			}
		}
		for(int i = 1; i<= 8; i++) { // game.box ���
			for(int j = 1; j <= 8; j++) {
				System.out.print(box[i][j]+" ");
			}
			System.out.println("");
		}System.out.println("");

		sa.shadow_countdown(box, player);
		for(int i = 1; i<= 8; i++) { // shadow ��� 
			for(int j = 1; j <= 8; j++) {
				if(box[i][j] == 1) {
					w_coin ++;
				}else if(box[i][j] == 2) {
					b_coin ++;
				}else if(sa.shadowBox[i][j] == 3){
					shadow_count ++;
				}
				System.out.print(sa.shadowBox[i][j]+" ");
			}
			System.out.println("");
		}
		w_box = w_coin;
		b_box = b_coin;
		System.out.println("");
		if(shadow_count == 0) { // ���� ���� ���� ��� 
			turnPass = true;
			System.out.println("���� �� �ִ� ���� �����Ƿ� �ٽ� �ѹ� ��");
			if(player == 1) {
				player = 2;
			}else if(player == 2) {
				player = 1;
			}
			sa.shadow_countdown(box, player);
		}
		for(int i = 1; i <= 8; i ++) {
			for(int j = 1; j <= 8; j++) {
				if(sa.shadowBox[i][j] == 3) {
					shadow_count ++;
				}
			}
		}
		if(player == 1) {
			System.out.println("���� �����Դϴ�.");
		}else {
			System.out.println("������ �����Դϴ�.");
		}
	
		System.out.printf("���� : %d   ����: %d\n",w_coin,b_coin); 
		if(w_coin + b_coin == 64||w_coin == 0||b_coin == 0||shadow_count == 0) { //�º� ���
			System.out.println("������ �������ϴ�.");
			winJudge = true;
			if(w_coin > b_coin) {
				System.out.print("�� ���� �̰���ϴ�.");
			}else if(w_coin < b_coin) {
				System.out.print("�������� �̰���ϴ�.");
			}else {
				System.out.print("�����ϴ�.");
			}
		}
	}
}
