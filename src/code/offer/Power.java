package code.offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class Power {
    public double Power(double base, int exponent) {
        if(exponent==0){
        	return 1;
        }else if(exponent<0){
        	return 1/exp(base, -exponent);
        }else{
        	return exp(base, exponent);
        }
    }
    
    private double exp(double base, int exponent) {
        if(exponent==0){
        	return 1;
        }
        double half = exp(base, (exponent>>>1));
    	if((exponent&1)==0){
        	return half * half;
        }else{
        	return half * half * base;
        }
    }
}
