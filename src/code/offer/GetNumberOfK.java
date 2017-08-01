package code.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月30日
 * @Description
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
    	if(array==null||array.length==0){
    		return 0;
    	}
    	
    	int first = getFirst(array, k, 0, array.length-1);
    	if(first==-1){
    		return 0;
    	}
    	int last = getLast(array, k, first, array.length-1);
        return (last-first+1);
    }
    
    private int getFirst(int [] array , int k,int bg,int ed){
    	if(bg>ed){
    		return -1;
    	}
    	
    	int mid = (bg+ed) >>> 1;
    	if(k==array[mid]){
    		if(mid==0||array[mid-1]!=k){
    			return mid;
    		}else{
    			return getFirst(array, k, bg, mid-1);
    		}
    	}else if(k<array[mid]){
    		return getFirst(array, k, bg, mid-1);
    	}else{
    		return getFirst(array, k, mid+1, ed);
    	}
    }
    
    private int getLast(int [] array , int k,int bg,int ed){
    	if(bg>ed){
    		return -1;
    	}
    	
    	int mid = (bg+ed) >>> 1;
    	if(k==array[mid]){
    		if(mid==array.length-1||array[mid+1]!=k){
    			return mid;
    		}else{
    			return getLast(array, k, mid+1, ed);
    		}
    	}else if(k<array[mid]){
    		return getLast(array, k, bg, mid-1);
    	}else{
    		return getLast(array, k, mid+1, ed);
    	}
    }
    
}
