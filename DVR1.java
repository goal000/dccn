import java.util.*;
public class Distance_vector {
	static int min=Integer.MAX_VALUE;
    public static void main(String args[])
    {
    	Scanner s=new Scanner(System.in);
    	System.out.println("Enter no of vertciecs : ");
    	int n=s.nextInt();
    	int a[][]=new int[n+1][n+1];
    	System.out.println("Enter no of edgs : ");
    	int edgs=s.nextInt();
    	System.out.println("Enter edgs as src to dest with cost (src,dest,cost): ");
    	for(int i=0;i<edgs;i++)
    	{   
    		int src=s.nextInt(),dest=s.nextInt(),cos=s.nextInt();
    		a[src][dest]=cos;
    		a[dest][src]=cos;
    	}
    	int dis[][]=new int[n][n];
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			min=Integer.MAX_VALUE;
    			int vis[]=new int[n+1];
    			path((i+1),(j+1),vis,a,0);
    			dis[j][i]=min;
    		}
    	}
    	print(dis);
    	System.out.print("Enter src that whose cost is changed : ");
    	int src=s.nextInt();
    	System.out.print("Enter dest that whose cost is changed : ");
    	int dest=s.nextInt();
    	System.out.print("Enter cost that is changed : ");
    	int cost=s.nextInt();
    	
    	a[src][dest]=cost;
    	a[dest][src]=cost;
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			min=Integer.MAX_VALUE;
    			int vis[]=new int[n+1];
    			path((i+1),(j+1),vis,a,0);
    			dis[j][i]=min;
    		}
    	}
    	System.out.println("New routing tables ");
    	print(dis);
    }
    public static void path(int src,int dest,int vis[],int a[][],int sum)
    {
    	if(src==dest)
    	{
    		if(sum<min)
    			min=sum;
    		return ;
    	}
    	for(int i=1;i<a.length;i++)
    	{
    		if(a[src][i]>0 && vis[i]==0)
    		{
    			vis[i]=1;
    			path(i,dest,vis,a,sum+a[src][i]);
    			vis[i]=0;
    		}
    	}
    }
    public static void print(int a[][])
    {
    	System.out.println("Dist1:		Dist2:		Dist3:		Dist4:");
    	for(int i=0;i<a.length;i++)
    	{
    		for(int j=0;j<a.length;j++)
    			System.out.print(a[i][j]+"		");
    		System.out.println();
    	}
    }
}


/*
output
 Enter no of vertciecs : 
4
Enter no of edgs : 
5
Enter edgs as src to dest with cost (src,dest,cost): 
1 2 1
1 3 3
2 3 1
2 4 1
3 4 4
Dist1:		Dist2:		Dist3:		Dist4:
0		1		2		2		
1		0		1		1		
2		1		0		2		
2		1		2		0		
Enter src that whose cost is changed : 2
Enter dest that whose cost is changed : 4
Enter cost that is changed : 10
New routing tables 
Dist1:		Dist2:		Dist3:		Dist4:
0		1		2		6		
1		0		1		5		
2		1		0		4		
6		5		4		0		
*/
