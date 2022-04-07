package day3.ex1;

public class ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * * 공백4번 별1번 ** 공백3번 별2번 *** -> 공백2번 별3번 **** 공백1번 별4번 ***** 공백0번 별5번 i=0 j=0
		 * z=4 공백4번 별1번
		 */
		for (int i = 0; i < 5; i++) {

			for (int z = 4 - i; z > 0; z--) {
				System.out.print(" ");
			}

			for (int j = 0; j <= i; j++) {

				System.out.print("*");
			}
			System.out.println();
		}
	}

}
