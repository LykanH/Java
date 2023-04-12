package lanqiao_exe;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 小蓝特别喜欢单调递增的事物。 在一个字符串中，如果取出若干个字符，将这些字符按照在字符串中的顺
 * 序排列后是单调递增的，则成为这个字符串中的一个单调递增子序列。 例如，在字符串 lanqiao 中，如果取出字符 n 和 q，则 nq 组成一个单
 * 调递增子序列。类似的单调递增子序列还有 lnq、i、ano 等等。 小蓝发现，有些子序列虽然位置不同，但是字符序列是一样的，例如取第
 * 二个字符和最后一个字符可以取到 ao，取最后两个字符也可以取到 ao。小蓝 认为他们并没有本质不同。
 * 对于一个字符串，小蓝想知道，本质不同的递增子序列有多少个？ 例如，对于字符串 lanqiao，本质不同的递增子序列有 21 个。它们分别 是
 * l、a、n、q、i、o、ln、an、lq、aq、nq、ai、lo、ao、no、io、lnq、 anq、lno、ano、aio。 请问对于以下字符串（共
 * 200 个小写英文字母，分四行显示）：（如果你把 以下文字复制到文本文件中，请务必检查复制的内容是否与文档中的一致。在 试题目录下有一个文件
 * inc.txt，内容与下面的文本相同） tocyjkdzcieoiodfpbgcncsrjbhmugdnojjddhllnofawllbhf
 * iadgdcdjstemphmnjihecoapdjjrprrqnhgccevdarufmliqij
 * gihhfgdcmxvicfauachlifhafpdccfseflcdgjncadfclvfmad
 * vrnaaahahndsikzssoywakgnfjjaihtniptwoulxbaeqkqhfwl 本质不同的递增子序列有多少个？
 * 
 * @author LykanHyper
 *
 */
//动态规划解决该问题
/*
 * 1
 * l
 * 
 * 11
 * la (a<l)所以a只有自身一个
 * 
 * 11(1+1+1)
 * lan   n:n>a&&n>l  所以n的递增子序列有3个
 */
public class Main_D {
	public static void main(String[] args) {
		String s1 = "tocyjkdzcieoiodfpbgcncsrjbhmugdnojjddhllnofawllbhf"
				+ "iadgdcdjstemphmnjihecoapdjjrprrqnhgccevdarufmliqij"
				+ "gihhfgdcmxvicfauachlifhafpdccfseflcdgjncadfclvfmad"
				+ "vrnaaahahndsikzssoywakgnfjjaihtniptwoulxbaeqkqhfwl";
//		String s1 = "lanqiao";
		char[] charArray = s1.toCharArray();
		int dp[] = new int[charArray.length];//用于存放第i个字母的递增子序列有多少个
		Arrays.fill(dp, 1);
		for(int i=1;i<charArray.length;i++) {
			for(int j=0;j<i;j++) {
				if (charArray[j]<charArray[i]) {
					dp[i]+=dp[j];
				}
				if (charArray[i]==charArray[j]) {
//					dp[i]=dp[j];
//					dp[j]=0;
					dp[i]=0;
				}
			}
		}
		long sum = 0;
		for(int i = 0;i<dp.length;i++) sum+=dp[i];
		System.out.println(sum);
	}
}
