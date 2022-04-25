package test;

import java.util.*;

class Concert extends Test {

	public Concert() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <= 10; j++) {
				this.underline[i][j] = " ---";
			}
		}
		this.underline[0][0] = "S";
		this.underline[1][0] = "A";
		this.underline[2][0] = "B";
	}

	public static void printConcert() {
		for (int i = 0; i < 3; i++) {
			System.out.print(underline[i][0] + ">>");
			for (int j = 1; j <= 10; j++) {
				System.out.print(underline[i][j]);
			}
			System.out.println();
		}
	}

	public static void printStatus() {

		System.out.print("좌석 구분 S(1), A(2), B(3) >>");
		int seat = sc.nextInt();
		if (seat == 1) {
			System.out.print(underline[0][0] + ">>");
			for (int i = 1; i <= 10; i++) {
				System.out.print(underline[0][i]);
			}
		} else if (seat == 2) {
			System.out.print(underline[1][0] + ">>");
			for (int i = 1; i <= 10; i++) {
				System.out.print(underline[1][i]);
			}
		} else if (seat == 3) {
			System.out.print(underline[2][0] + ">>");
			for (int i = 1; i <= 10; i++) {
				System.out.print(underline[2][i]);
			}
		} else {
			System.out.println("잘못된 입력입니다.");
			run();
		}
		System.out.println();
		System.out.print("이름 >> ");
		String name = sc.next();
		System.out.print("번호 >> ");
		num = sc.nextInt();
		
		switch (seat) {
		case 1:
			underline[0][num] = name;
			
			break;
		case 2:
			underline[1][num] = name;
			break;
		case 3:
			underline[2][num] = name;
			break;
		}
	}


	public static void printCancle() {
		// TODO Auto-generated method stub
		System.out.print("예약을 취소할 예약자이름을 입력하시오. >> ");
		String kname = sc.next();
		System.out.print("해당좌석(S(1), A(2), B(3))을 입력해주세요. >> ");
		int seatA = sc.nextInt();
		System.out.print("자리번호를 입력해주세요.(1~10) >> ");
		int seatB = sc.nextInt();
		if(kname.equals(underline[seatA-1][seatB])){
		for(int i=0;i<3;i++) {
			for(int j=1;j<=10;j++) {
				if(underline[i][j].equals(kname)) {
						underline[i][j]=" ---";
						System.out.println("예약 취소되었습니다.");
					}
				}
			}
		}
		else {
			System.out.println("해당 이름이 없습니다");
			run();
		}
	}
}

class Test {
	static Scanner sc = new Scanner(System.in);
	public static String underline[][] = new String[3][11];
	static String name;
	static int num;
	public static void run() {
		while (true) {
			System.out.print("예약:1,조회:2,예약 취소:3,끝내기:99 >> ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Concert.printStatus();
				continue;
			case 2:
				Concert.printConcert();
				continue;
			case 3:
				Concert.printCancle();
				continue;
			}
			if (choice == 99) {
				break;
			}
		}
	}
}

public class ConcertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Concert c = new Concert();
		System.out.println("자바 콘서트에 오신 여러분을 환영 합니다.^^");
		Test.run();
	}

}
