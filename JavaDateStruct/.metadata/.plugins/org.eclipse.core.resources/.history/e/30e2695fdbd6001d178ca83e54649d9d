package kmp;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String sub = sub("ADOBECODEBANC", "ABC");
//		System.out.println(sub);
		System.out.println(judge("a", "a"));
		String s1 = "a";
		System.out.println(s1.substring(0,1));
	}
	
	static public String sub(String s,String t) {
		String temp;
        int i,j,k;
//        String s2 = (st)s.charAt(1);
        char charAt = s.charAt(0);
        System.out.println(charAt);
        for(k=1;k<s.length()-1;k++){
            for(i=0,j=i+k;j<=s.length();i++,j++){
                temp = s.substring(i,j);
//                System.out.println(temp);
                if(temp.contains(t)){
                    return temp;
                }
            }
        }
        return "";
        
	}
	
	static public boolean judge(String s1,String s2){
        boolean flag = true;
        Character c1;
        // if(s1.length()<s2.length()) return false;
        for(int i=0;i<s2.length();i++){
            c1 = s2.charAt(i);
            
            if(!s1.contains(c1.toString())) flag = false; 
        }
        return flag;
    }
}
