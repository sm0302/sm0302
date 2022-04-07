package day3.ex1;

public class ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*     *        공백4번 별1번
		 *    **        공백3번 별2번
		 *   ***    ->  공백2번 별3번
		 *  ****        공백1번 별4번
		 * *****        공백0번 별5번
		 * i=0 j=0 z=4  공백4번 별1번
		 */
		for(int i=0;i<5;i++) {
			switch(i) {
			case 0:
				for(int z=4;z>0;z--){
					System.out.print(" ");
				}
				break;
			case 1:
				for(int z=3;z>0;z--){
					System.out.print(" ");
				}
				break;
			case 2:
				for(int z=2;z>0;z--){
					System.out.print(" ");
				}
				break;
			case 3:
				for(int z=1;z>0;z--){
					System.out.print(" ");
				}
				break;
			case 4:
				for(int z=0;z>0;z--){
					System.out.print(" ");
				}
				break;
			}
			for(int j=0;j<=i;j++) {
				
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
