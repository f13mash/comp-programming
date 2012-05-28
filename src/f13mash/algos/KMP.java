package f13mash.algos;

import java.util.Arrays;

public class KMP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pattern = "ABCDABD";
		String text = "ABC ABCDAB ABCDABCDABDE";
		System.out.print(search(text, pattern));
	}
	
	public static int search(String text, String pattern) {
		int[] pref=genPrefixArray(pattern);
		int m=0, i=0;
		int len=text.length();
		
		char[] s=text.toCharArray();
		char[] p=pattern.toCharArray();
		
		while((m+i)<len){
			if(s[m+i]==p[i]){
				i++;
				if(i==p.length)
					return m;
			}
			else{
				m=m+i-pref[i];
				i=pref[i];
				if(i==-1)
					i=0;
			}
		}
		return -1;
	}
	
	public static int[] genPrefixArray(String pattern){
		char[] arr=pattern.toCharArray();
		int[] ret=new int[pattern.length()];
		
		for(int i=1;i<ret.length;i++){
			if(arr[i-1]==arr[ret[i-1]] && (i-1)!=ret[i-1]){
				ret[i]=ret[i-1]+1;
			}
			else
				if(arr[i-1]==arr[0] && (i-1)!=0){
					ret[i]=ret[0]+1;
				}
				else{
					ret[i]=0;
				}
		}
		ret[0]=-1;
		return ret;
	}

}
