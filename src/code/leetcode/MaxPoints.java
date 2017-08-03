package code.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * https://www.nowcoder.com/practice/bfc691e0100441cdb8ec153f32540be2?tpId=46&tqId=29032&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author mindw
 * @date 2017年8月3日
 */
public class MaxPoints {
	
	public static void main(String[] args) {
		
		Point[] points = new Point[4];
		points[0] = new Point(3, 1);
		points[1] = new Point(12, 3);
		points[2] = new Point(3, 1);
		points[3] = new Point(-6, -1);
		
		System.out.println(new MaxPoints().maxPoints(points));
		
		// [(3,1),(12,3),(3,1),(-6,-1)]
	}

	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	
//	/**
//	 * 
//	 * 选定一个点，分别计算其他点和它构成的直线的斜率，斜率相同的点肯定在同一条直线上。
//	 * 计算斜率时，注意重合点和x值相同的两个点（数学上称斜率不存在，此时斜率用int的最大值表示）
//	 * 
//	 */
//	public int maxPoints(Point[] points) {  
//        
//        if (points.length < 3) return points.length;  
//          
//        int max = 0;//用于返回的结果，即共线点的最大个数  
//        Map<Double, Integer> map = new HashMap<Double, Integer>();//保存同一个斜率的点的个数  
//          
//        for (int i = 0; i < points.length; i++) {//以每一个点为固定点  
//            map.clear();  
//            int duplicate = 1;//记录跟固定点重合的个数  
//              
//            for(int j = 0 ; j < points.length; j++){//遍历其他点，求其与固定点之间的斜率  
//                if (i == j) continue;//如果是自己，跳过  
//                double slope = 0.0;//斜率  
//                  
//                if (points[i].x == points[j].x && points[i].y == points[j].y) {//如果跟固定点重合  
//                    duplicate++;  
//                    continue;  
//                } else if (points[i].x == points[j].x) {//如果跟固定点在同一条竖线上，斜率设为最大值  
//                    slope = Integer.MAX_VALUE;  
//                } else {//计算该点与固定点的斜率  
//                    slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);  
//                }  
//                map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);  
//            }  
//              
//            //更新最优解  
//            if (map.keySet().size() == 0) {//如果map为空  
//                max = duplicate > max ? duplicate : max;  
//            } else {  
//                for (double key : map.keySet()) {  
//                    max = Math.max((duplicate + map.get(key)), max);   
//                }  
//            }  
//        }  
//        return max;  
//    }  
	
	
	public int maxPoints(Point[] points) {

		if(points.length<=2){
			return points.length;
		}
		
		Arrays.sort(points,new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x!=o2.x){
					return o1.x - o2.x;
				}else{
					return o1.y - o2.y;
				}
			}
		});

		int maxNum = 2;
		int num;
		Point p0,p1 = null,p2;
		int i=0;
		int base;
		while(i<points.length){
			
			p0 = points[i];
			base = 1;
			
			while(i+1<points.length){
				p1 = points[i+1];
				if(p0.x==p1.x&&p0.y==p1.y){
					++i;
					++base;
				}else{
					break;
				}
			}
			
			if(i==points.length-1){
				maxNum = Math.max(base, maxNum);
				break;
			}
			
			for(int j=i+1;j<points.length;++j){
	
				p1 = points[j];
				num = base+1;
					
				for(int k=j+1;k<points.length;++k){
					p2 = points[k];
					if((p1.x-p0.x)*(p2.y-p0.y)==(p2.x-p0.x)*(p1.y-p0.y)){
						++num;
					}
				}
				maxNum = Math.max(num, maxNum);
			}

			++i;
		}
		
		return maxNum;
	}
}
