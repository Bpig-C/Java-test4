package realcode;

public class Test {
	static Student student0=new Student();

	static InformationOperation file = new InformationOperation();
	public static void main(String[] args) {
		
		  System.out.println("第四次实验：文件操作");
		  System.out.println("**********学生信息录入**********");//10
		  student0.inputInformation(); 
		  
		String a=file.readFile();
		String b = new String(file.operationFile(addNewInformation(student0),a));
		System.out.println(b);
		if(file.outFile(b))
			System.out.println("作业导入成功！");
		file.FindSth(b);

	}
	public static String addNewInformation(Student student) {
		String information = null;
		information="个人信息：\n姓名 性别 年龄       学号    \n"+student0.name+"   "+student0.sex+"    "+student0.age+"    "+student0.stuNo+"\n完成作业：\n";
		 return information;
	}
}
