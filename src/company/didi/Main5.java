package company.didi;

public class Main5 {

	public int getVal(int v1 ,int v2,int n){
		int rate = v2 /v1;
		int v = v1;
		for(int i=1;i<n;++i){
			v *= rate;
		}
		return v;
	}
	
	
	public static int f(int n){  
        if(n <= 2){  
            return 1;  
        }  
        int f1 = 1, f2 = 1, f3 = 0;  
        for(int i = 0; i < n - 2; i ++){  
        	f3 = f1 + f2;  
            f1 = f2;  
            f2 = f3;  
        }  
        return f3;  
    }  
	
	int rand3(){
		return 0;
	}
	
	
	int rand5(){
	    int[][] vals = {
	        { 0, 1, 2 },
	        { 3, 4, -1 },
	        { -1,-1, -1}
	    };

	    int result = 0;
	    while (result == -1)
	    {
	        int i = rand3();
	        int j = rand3();
	        result = vals[i][j];
	    }
	    return result;
	}
}



