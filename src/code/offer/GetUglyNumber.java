package code.offer;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月30日
 * @Description
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
        	return 0;
        }
        
        int[] arr = new int[index+1];
        arr[1] = 1;
        int p2=1,p3=1,p5=1;
        int v2,v3,v5;
        for(int i=2;i<=index;++i){
        	v2 = arr[p2] *2;
        	v3 = arr[p3] *3;
        	v5 = arr[p5] *5;
        	arr[i] = Math.min(Math.min(v2, v3), v5);
        	if(v2==arr[i]){
        		++p2;
        	}
        	if(v3==arr[i]){
        		++p3;
        	}
        	if(v5==arr[i]){
        		++p5;
        	}
        }
        
    	return arr[index];
    }
}
