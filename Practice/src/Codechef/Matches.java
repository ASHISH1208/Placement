package Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Matches {
	  public static void main(String args[]) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int t = Integer.parseInt(br.readLine());
          for(int i=0; i<t; i++) {
        	 String[] input = br.readLine().split("\\s+");
         	 int n =  Integer.parseInt(input[0]);
             int m = Integer.parseInt(input[1]);
             System.out.println(playGame(n,m));
          }
         }
	  public static String playGame(int n,int m) {
		  String chance = "Ari";
			  while(n!=0||m!=0) {
				  if (n==m) {break;}
				  if(n>m) {
				  int result=n/m;
				  n=n-m*result;
				  if(m==0||n==0)break;
				  if(chance=="Ari") {chance="rich";}else chance = "Ari";
			    }
				  else if(n<m) {
					  int result=m/n;
					  m=m-n*result;
					  if(m==0||n==0)break;
					  if(chance=="Ari") {chance="rich";}else chance = "Ari";
				  }
			  }
			  return chance;
  }
}
