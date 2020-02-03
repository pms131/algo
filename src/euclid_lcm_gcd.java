import java.util.Scanner;

public class euclid_lcm_gcd {
	private static void change(int val1, int val2) {
		int tmp = val2;
		val2 = val1;
		val1 = tmp;
	}
	
	private static int gcd(int val1, int val2) {
		while (val2 != 0) {
			int tmp = val1 % val2;
			val1 = val2;
			val2 = tmp;
		}
		
		return val1;
	}
	
	
	public static void main(String[] args) {
		int val1, val2, gcd, lcm;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫 번째 수를 입력하세요.");
		val1 = sc.nextInt();
		
		System.out.println("두 번째 수를 입력하세요.");
		val2 = sc.nextInt();

		if (val1 < val2) {
			change(val1, val2);
		}
		
		gcd = gcd(val1, val2);
		lcm = gcd * val1 * val2;
		
		System.out.println("최대 공약수 : " + gcd);
		System.out.println("최소 공배수 : " + lcm);
		
	}

}
