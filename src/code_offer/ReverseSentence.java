package code_offer;

/**
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * @author mindw
 * @date 2017年8月1日
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if(str==null){
        	throw new RuntimeException("Invalid Parameter!");
        }
    	
        if(str.length()==0){
        	return "";
        }
        
        char[] chs = str.toCharArray();
        reverse(chs,0,chs.length-1);    
        
    	int begin = 0;
    	for(int i=0;i<chs.length;++i){
    		if(chs[i]==' '){
    			reverse(chs, begin, i-1);
    			begin = i+1;
    		}
    	}
    	reverse(chs, begin, chs.length-1);
    	
        return new String(chs);
    }
    
    public void reverse(char[] chs,int begin,int end){
    	char tmp;
    	while(begin<end){
    		tmp = chs[begin];
    		chs[begin] = chs[end];
    		chs[end] = tmp;
    		
    		++begin;
    		--end;
    	}
    }
}
