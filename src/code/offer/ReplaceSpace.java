package code.offer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author 闵大为
 * @data 2017年7月27日
 * @Description
 */
public class ReplaceSpace {
	 public String replaceSpace(StringBuffer str) {
		 if(str==null){
			 return null;
		 }
		 
		 StringBuilder sb = new StringBuilder();
		 char ch;
		 for(int i=0;i<str.length();++i){
			 if((ch=str.charAt(i))==' '){
				 sb.append("%20");
			 }else{
				 sb.append(ch);
			 }
		 }
		 return sb.toString();
	 }
}
