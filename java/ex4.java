package day3.ex1;

public class ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*     *        ����4�� ��1��
		 *    **        ����3�� ��2��
		 *   ***    ->  ����2�� ��3��
		 *  ****        ����1�� ��4��
		 * *****        ����0�� ��5��
		 * i=0 j=0 z=4  ����4�� ��1��
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
