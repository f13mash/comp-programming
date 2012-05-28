package f13mash.probs.spoj;

import java.io.*;

public class NHAY {

	/**
	 * @param args
	 */
	
	static BufferedReader br;
	
	static int BUF_SIZE=1084576;
	static StringBuilder sb=null;
	static char[] buff=null;
	static char[] arr=null;
	
	static long curr=0, read=0, base=0;
	
	static boolean isfirst=true;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		
		buff=new char[BUF_SIZE];
		int count=0;
		while(search()){
			/*System.out.println("count : "+count);
			count++;*/
		}
		System.out.println(sb.toString());
	}
	
	public static boolean search() throws IOException{
		String ln=readAndStoreTill('\n');
		if(ln==null || ln.length()==0)
			return false;
		
		if(isfirst)
			isfirst=false;
		else{
			sb.append('\n');
		}
		
		int pattSize=Integer.parseInt(ln);
		
		ln=readAndStoreTill('\n');
		String pattern=ln.substring(0, pattSize);
		arr=pattern.toCharArray();
		
		int[] pref=genPrefixArray(pattern);
		
		int m=0, i=0;
		
		boolean ff=false;
		
		
		
		while(true){
			//System.out.println("curr : "+curr+" read : "+read+" m : "+m+" i : "+i+" : "+buff[(int) curr]);
			if(curr>=read){
				base=read;
				read+=br.read(buff, 0, BUF_SIZE);
			}
			if(curr>=read){
				break;
			}
			if(buff[(int) (curr-base)]=='\n'){
				curr++;
				break;
			}
			
			if(buff[(int) (curr-base)]==arr[i]){
				if(i==(pattSize-1)){
					//store answer here
					if(ff)
						sb.append('\n');
					else
						ff=true;
					sb.append(m);
					
					
					m=m+i-pref[i];
					i=pref[i];
					if(i==-1)
						i=0;
				}
				else{
					curr++;
					i++;
				}
			}
			else{
				m=m+i-pref[i];
				i=pref[i];
				if(i==-1){
					curr++;
					i=0;
				}
			}
		}
		
		return true;
	}
	
	static String readAndStoreTill(char c) throws IOException{
		StringBuilder ret=new StringBuilder();
		while(true){
			if(curr>=read){
				base=read;
				read+=br.read(buff, 0, BUF_SIZE);
			}
			if(curr>=read)
				return null;
			if(buff[(int) (curr-base)]==c){
				curr++;
				break;
			}
			else{
				ret.append(buff[(int) (curr-base)]);
				curr++;
			}
		}
		return ret.toString();
	}
	
	public static int[] genPrefixArray(String pattern){
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
