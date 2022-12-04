import java.util.*;
public class Dijkstra {
	public static void dijkstra(int g[][],int src) {
		int n = g.length;
		boolean[] vis = new boolean[n];
		int dis[] = new int[n];
		Arrays.fill(vis, false);
		Arrays.fill(dis,Integer.MAX_VALUE);
		dis[src] = 0;
		for(int i=0;i<n;i++) {
			int u = findMinDisV(dis,vis);
			vis[u] = true;
			for (int v = 0; v < n; v++) {
                if (!vis[v] && g[u][v]!=0 && dis[u]+g[u][v] < dis[v])
                    dis[v] = dis[u] + g[u][v];
			}
		}
		for(int i=0;i<n;i++)
			System.out.println("Distance from "+src+" to "+i+" is :"+dis[i]);
	}
	public static int findMinDisV(int[] dis,boolean[] vis) {
		int mdis = Integer.MAX_VALUE;
		int minvertex = -1;
		for(int i=0;i<dis.length;i++) {
			if( !vis[i] && dis[i]<mdis) {
				mdis  = dis[i];
				minvertex = i;
			}
		}
		return minvertex;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertices :");
		int n = sc.nextInt();
		System.out.println("Enter cost adjacency matrix : ");
		int a[][] = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j] = sc.nextInt();
		System.out.println("Enter source vertex : ");
		int s = sc.nextInt();
		dijkstra(a,s);
	}

}


/*
 Output:
   Enter no of vertices :
5
Enter cost adjacency matrix : 
0 3 1 0 0
3 0 7 5 1
1 7 0 2 0
0 5 2 0 7
0 1 0 7 0
Enter source vertex : 
2
Distance from 2 to 0 is :1
Distance from 2 to 1 is :4
Distance from 2 to 2 is :0
Distance from 2 to 3 is :2
Distance from 2 to 4 is :5
*/
