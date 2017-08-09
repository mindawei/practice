package annotation;

@Bean()
public class Test {
	
	
	@Value("testValue")
	private String str;
	
	private String str2;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	
	
}
