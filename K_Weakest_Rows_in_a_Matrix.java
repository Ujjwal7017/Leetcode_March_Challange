//using Priority Queue
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]!=b[0] ? b[0]-a[0] : b[1]-a[1]);
        int[] res = new int[k];
        
        for(int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1) soldiers++;
                else break;
            }
            pq.offer(new int[]{soldiers, i});
        }
        
        while(pq.size() > k){
            pq.poll();
        }
        
        while(k > 0) res[--k] = pq.poll()[1];
        
        return res;
    }
}


//Using Binary Seearch 
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];
        
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] {numOnes(mat[i]), i});
            if (pq.size() > k)
                pq.poll();
        }
        
        while (k > 0)
            ans[--k] = pq.poll()[1];
        
        return ans;
    }
    
    private int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }
        
        return lo;
    }
}


//Using Array
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] count = new int[mat.length];
        int[] res = new int[k];
        
        for(int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1) soldiers++;
                else break;
            }
            count[i] = soldiers*1000 + i;
        }
        
        Arrays.sort(count);
        
        for(int i =0; i < k; i++) res[i] = count[i]%1000;
        
        return res;
    }
}
