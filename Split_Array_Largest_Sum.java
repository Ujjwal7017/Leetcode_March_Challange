class Solution {
 public int splitArray(int[] nums, int k) {
		int start=0;
		int end=0;
		int answer=0;
		for(int i=0;i<nums.length;i++) {
			  start=Math.max(start,nums[i]);
			  end+=nums[i];
		}
		while(start<=end) {
			int mid=(start+end)/2;
			if(check(mid,nums,k)) {
				  answer=mid;
				  end=mid-1;
			}else {
				 start=mid+1;
			}
		}
		return answer;
	}
	
	public boolean check(int mid,int[] nums, int k) {
		int sum=0;
		int count=0;
		for(int i=0;i<nums.length;i++) {
			   if(nums[i] > mid) {
				   return false;
			   }
			   sum+=nums[i];
			   if(sum>mid) {
				   count++;
				   sum=nums[i];
			   }
		}
		count++;
		if(count<=k) {
			return true;
		}
		return false;
    }
}
