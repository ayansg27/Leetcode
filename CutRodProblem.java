package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CutRodProblem {
	
	public int MemoizedCutRod(int p[],int n) {
		int r[] = new int[n+1];
		for(int i=0;i<=n;i++) {
			r[i]=Integer.MIN_VALUE;
		}
		return MemoizedCutRodAux(p,n,r);
	}
	public int MemoizedCutRodAux(int p[],int n, int r[]) {
		int q;
		System.out.println("p: "+Arrays.toString(p)+" n: "+n+" r: "+Arrays.toString(r));
		if(r[n]>=0)
			return r[n];
		if(n==0) {
			q=0;
		}
		else {
			q=Integer.MIN_VALUE;
			for(int j=1;j<=n;j++) {
				q=Math.max(q,p[j]+MemoizedCutRodAux(p,n-j,r));
			}
		}
		System.out.println("Computing max for r[n]: "+q+" where n: "+n);
		r[n]=q;
		//System.out.println("max: "+q);
		return q;
	}

	public static void main(String[] args) {
		
		//initialize scanner
		Scanner input=new Scanner(System.in);
		System.out.print("Enter n: ");
		int n=input.nextInt();
		int[] p={0,1,5,8,9,10,17,17,20,24,30};
		
		CutRodProblem crp=new CutRodProblem();
		int max=crp.MemoizedCutRod(p, n);
		System.out.println("max: "+max);
		input.close();
	}

}
