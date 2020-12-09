# Java-test4
# 计192 2019310191 齐睿
# Java 实验
Java课程作业项目仓库
# 阅读程序
## 实验目的
1.掌握字符串String及其方法的使用  
2.掌握文件的读取/写入方法  
3.掌握异常处理结构  
## 实验内容
在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。  
文件A包括两部分内容：  
一是学生的基本信息；  
二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：  

1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”  
2.允许提供输入参数，统计古诗中某个字或词出现的次数  
3.输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A  
4.考虑操作中可能出现的异常，在程序中设计异常处理程序  

输入：汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行<未完，待续>  

输出：  
汉皇重色思倾国，御宇多年求不得。  
杨家有女初长成，养在深闺人未识。  
天生丽质难自弃，一朝选在君王侧。  
回眸一笑百媚生，六宫粉黛无颜色。  
春寒赐浴华清池，温泉水滑洗凝脂。  
侍儿扶起娇无力，始是新承恩泽时。  
云鬓花颜金步摇，芙蓉帐暖度春宵。  
春宵苦短日高起，从此君王不早朝。  
…………
  
## 实验要求
1.设计学生类（可利用之前的）；  
2.采用交互式方式实例化某学生；  
3.设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。

## 实验过程
### 编程思路
**设计四个类：  
Student类：通过交互式录入和存储学生信息  
FileInAndOut类：用于文件读取和写入，以及对文件内字符串操作  
JudgeException类：用于异常处理  
Test类：调用各类方法用于运行程序**  

### 实现方法
**1.Student类中：**  
*(a)一个inputInformation方法：通过交互式存储学生信息  
(b)两个异常处理方法：sexJudge(String sex)方法和ageJudge(int age)方法*  
**2.InformationOperation类中：**  
*(a)定义InformationOperation()方法来操作文件中的字符串  
(b)定义readFile()方法读取文件内容  
(c)定义outFile(String a)方法输出文件内容，并返回成功与否  
(d)定义FindSth(String Str)方法查找字符串中内容*  
**3.JudgeException类中：**  
*(a)定义JudgeException(String input) 方法和JudgeException(int input)方法分别判断年龄和性别的输入正确与否*     
**4.Test类中：**  
*(a)首先构造Student对象student0，InformationOperation的对象file  
(b)通过student0调用inputInformation()方法来录入学生信息  
(c)然后通过readFile()、operationFile()、addNewInformation(student0)、outFile()以及FindSth()来实现字符串的读取操作录入和查询。*  

## 核心方法  
***1.inputInformation()学生信息录入方法***
```
public void inputInformation() {
	Scanner reader = new Scanner(System.in);
	a:for(;;) {
		try {
			System.out.println("请输入姓名");
	        name=reader.nextLine();
	        System.out.println("录入成功~");
	        break a;
		}
		catch(Exception e) {
			System.out.println("您输入的 “"+name+"” 格式不正确，请重新输入！");
		}
	}
	b:for(;;) {
	try{
	System.out.println("请输入性别（中文）");
	sex=reader.nextLine();
	sexJudge(sex);
	break b;
	}
	catch(JudgeException e) {
		System.out.println(e.JudgeException(sex));
	}
	}
	c:for(;;) {
		try{
			System.out.println("请输入年龄（15-75岁）");
			age=reader.nextInt();
		    ageJudge(age);
		    break c;
		}
		catch(JudgeException e) {
			System.out.println(e.JudgeException(age));
		}
		}
	d:for(;;) {
		try {
			Scanner reader0 = new Scanner(System.in);
			System.out.println("请输入学号");
			stuNo=reader0.nextLine();
	        System.out.println("录入成功~");
	        break d;
		}
		catch(Exception e) {
			System.out.println("您输入的“"+stuNo+"”格式不正确，请重新输入！");
		}
	}
	
}
``` 
***2.operationFile字符串操作方法***
```
 public StringBuffer operationFile(String studentInformation,String longer) {
		StringBuffer l=new StringBuffer(studentInformation);
		String s;
		int j=l.length();
	    char[] a;
		for(int i = 0;i<longer.length();i=i+7) {
			 a=new char[7];
			 try {
				 longer.getChars(i, i+7, a, 0);
		       } catch( Exception ex) {
		            System.out.println("触发异常...");
		        }
			s = String.valueOf(a);
			if(l!=null)
				l.append(s);
			if ((i + 7) % 7 == 0 && (i + 7) % 14 != 0)  {
				l.append(",");
				j++;
				}
			else if((i + 7) % 14 == 0) {
				 l.append("。\n");
	             j=j+2;
			}
			j=j+7;
		}
		l.deleteCharAt(j-1);
		return l;
	}
``` 
***3.readFile文件读取方法***
```
public String readFile() {
		String original = null;
		int n=-1;
		char[] a = new char[100];//缓存，
		try {
			File file = new File("e:\\B.txt");
			InputStream fli = new FileInputStream(file);
			InputStreamReader in = new InputStreamReader(fli, "GBK");
		while((n=in.read(a,0,100))!=-1) {
		String s = new String(a,0,n);
		this.n=n;
		if(original!=null)
		original = original+s;
		else original=s;
		}
		
        in.close();
      	}
		catch (IOException e) {
			System.out.println("File read erroe:"+e);
		}
		return original;
	}
``` 
***4.outFile文件输出方法***  
```
public boolean outFile(String a) {
		byte [] b = a.getBytes();
		try {
			File file = new File("e:\\A.txt");
			OutputStream out = new FileOutputStream(file,true);
			
            out.write(b);
            out.flush();
            out.close();
           
		}
		catch (IOException e) {
			System.out.println("File read erroe:"+e);
		}
		 return true;
		}
``` 
***5.FindSth字词查询方法***
```
public void FindSth(String Str){
		int m = 0;
		StringBuffer s1=new StringBuffer(Str);
		  a:
		            while (true) {
		                System.out.println("请输入序号:\n1:查询词句\n2:退出程序\n");
		                try {
		                Scanner reader0 = new Scanner(System.in);
		                m = reader0.nextInt();
		                }
		                catch(Exception e) {
		                	System.out.println("文本中没有该字符！");
		                }
		                switch (m) {
		                    case 1:
		                        System.out.println("输入你想要查询的字或词：\n");
		                        Scanner reader1 = new Scanner(System.in);
		                        String s2 = reader1.nextLine();
		                        Pattern pattern = Pattern.compile(s2);
		                        Matcher matcher = pattern.matcher(s1);
		                        if (matcher.find()) {
		                            int num = 1;
		                            while (matcher.find()) {
		                                num++;
		                            }
		                            System.out.println("“"+s2+"”出现的次数为:" + num);
		                        } else {
		                            System.out.println("文本中没有该字符");
		                        }
		                        break;
		                    case 2:
		                    	System.out.println("本次实验结束！");
		                        break a;
		                    default:
		                        System.out.println("您输入的编号有误，请重新输入");
		                }
		            }

		 }
``` 

## 系统运行截图  
***Picture1：***  
![resultpicture.jpg](https://i.loli.net/2020/12/10/XZsN6OEe83Dc14q.jpg)  
***Picture2：***  
![txtpicture.jpg](https://i.loli.net/2020/12/10/sEH86ZFDOChPimv.jpg) 
## 实验感想  
**通过本次实验，我学会了文件操作方法以及字符串操作方法，回顾了交互式存储信息的方法：  
在Student类中，通过scannner来录入键入信息，并存入字符串中，再在InformationOperation类中读取文件中字符串并存入新的StringBuffer里，最后写入文件。再通过单独的方法，来进行字符串的查询。  
最开始我通过String类来操作字符串的，后来使用StringBuffer，感受两者的内存使用区别。
本次实验不足：    
1.异常处理的覆盖面不够全面  
2.系统还差一些细节不够完善，会在日后维护中进行改进~**
