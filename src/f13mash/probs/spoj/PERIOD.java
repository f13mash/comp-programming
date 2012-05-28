package f13mash.probs.spoj;

import java.io.*;
import java.util.Arrays;

public class PERIOD {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine().trim());
		
		StringBuilder out=new StringBuilder();
		
		for(int t=1;t<=cases;t++){
			int size=Integer.parseInt(br.readLine());
			char[] arr=new char[size+1];
			
			br.read(arr, 0, size+1);
			arr[size]='$';
			
			int[] pref=genPrefixArray(arr);
			
			if(t>1)
				out.append('\n');
			out.append("Test case #"+t+'\n');
			
			for(int i=2;i<pref.length;i++){
				int plen=i-pref[i];
				if(i%plen==0 && i/plen > 1){
					out.append(i+" "+i/plen+'\n');
				}
			}
		}
		System.out.println(out);
	}
	
	public static int[] genPrefixArray(char[] arr){
		int[] ret=new int[arr.length];
		
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
