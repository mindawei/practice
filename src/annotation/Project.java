package annotation;


@PackageScan(basePackages = "annotation")
public class Project {
	
	public static void main(String[] args) {
		ProjectRunner.run(Project.class);
	
		Test test = ProjectRunner.getBean(Test.class);
		
		System.out.println(test.getStr());
	}
	
}
