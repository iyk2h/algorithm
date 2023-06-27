import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static boolean ch[] = new boolean[501];
    static LinkedList[] adj = new LinkedList[501];
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int trial = 1;
        while(true){
            int n = sc.nextInt();
            int k = sc.nextInt();
            if(n==0) break;
            int trees = 0;
            Arrays.fill(ch,false);

            for(int i=0; i<n+1; i++){
                adj[i] = new LinkedList<Integer>();
            }

            for(int i=0; i<k; i++){
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                adj[n1].add(n2);
                adj[n2].add(n1);
            }


            for(int i=1; i<=n; i++){
                flag = false;
                if(ch[i]==false){
                    ch[i] = true;
                    DFS(i, 0);
                    if(!flag) {
                        trees+=1;
                    }
                }
            }

            if(trees>1){
                System.out.printf("Case %d: A forest of %d trees.\n",trial, trees);
            }
            else if(trees==1) {
                System.out.printf("Case %d: There is one tree.\n",trial);
            }
            else{
                System.out.printf("Case %d: No trees.\n", trial);
            }

            trial+=1;
        }
    }
    static void DFS(int cur, int pre){
        for(Object a: adj[cur]){
            if(ch[(int)a]==true){
                if((int)a!=pre)flag = true;
            }
            else{
                ch[(int)a] = true;
                DFS((int)a, cur);
            }
        }
    }

}