package realcode;

public class Test {
	static Student student0=new Student();

	static InformationOperation file = new InformationOperation();
	public static void main(String[] args) {
		
		  System.out.println("���Ĵ�ʵ�飺�ļ�����");
		  System.out.println("**********ѧ����Ϣ¼��**********");//10
		  student0.inputInformation(); 
		  
		String a=file.readFile();
		String b = new String(file.operationFile(addNewInformation(student0),a));
		System.out.println(b);
		if(file.outFile(b))
			System.out.println("��ҵ����ɹ���");
		file.FindSth(b);

	}
	public static String addNewInformation(Student student) {
		String information = null;
		information="������Ϣ��\n���� �Ա� ����       ѧ��    \n"+student0.name+"   "+student0.sex+"    "+student0.age+"    "+student0.stuNo+"\n�����ҵ��\n";
		 return information;
	}
}
