package lanqiao_exe;
//判断质数
public class Main_C {

	public static void main(String[] args) {
		System.out.println(isprimes(192187));
	}
	
	static boolean isprimes(int n){
		if(n<2) return false;	
		for(int i=2;i<=n/i;i++){
			if(n%i==0) return false;
		}
		return true;
	}
}