import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] arr =new ArrayList[n+1];
        Arrays.setAll(arr, i -> new ArrayList<>());
        
        Queue<Integer> q = new LinkedList();
        for(int[] x : edge){
            arr[x[1]].add(x[0]);
            arr[x[0]].add(x[1]);
        }
        
        boolean[] visited = new boolean[n + 1];
        q.add(1);
        visited[1] = true;
        int[] dept = new int[n+1];
        int maxdept = 0;
        
        while(!q.isEmpty()){
            int curn = q.poll();
            
            for(int x : arr[curn]){
                
             if(!visited[x]){
                q.add(x);
                visited[x] = true;
                 dept[x] = dept[curn] +1;
                 maxdept =Math.max(maxdept, dept[x]);
            }
                
            }
        }
        int answer = 0;
        for(int i = 0; i <=n; i++){
           if(dept[i] == maxdept) {answer ++; }
        }
        
        
        return answer;
    }
}