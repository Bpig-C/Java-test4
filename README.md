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
1.设计四个类：  
Student类用于录入和存储学生信息  
FileInAndOut类用于文件读取和写入，以及对文件内字符串的操作  
JudgeException类用于异常处理  
Test类用于运行程序

**1.首先创建一个package：interfaceApplication。  
2.在包中创建两个接口StudentManagement和TeacherManagement，分别设定博士研究生作为学生和助教的两类行为标准。 
3.并在包中实例化一个类DoctoralCandidate来实现上述两个接口。实例化一个MoneyException异常类来进行对收税金的判断。实例化主类Test_JavaProgram对用户输入进行存储和操作。  
4.StudentManagement类中：**  
*(a)定义常量buzhu  
(b)设计两个方法：缴纳学费和查询学费*  
**5.TeacherManagement类中：**  
*(a)定义常量sanxianyijin  
(b)设计两个方法：查询工资和发放工资*  
**6.DoctoralCandidate类中：**  
*(a)定义基本信息变量  
(b)实现两个接口四个方法*    
**7.Test_JavaProgram类中：**  
*(a)首先定义全局变量和录入数组  
(b)设计三个循环：第一个循环依次录入个人信息，第二个循环判断录入工资和学费是否正确，第三个循环执行方法操作  
(c)设计税收算法方法    
(d)设计异常抛出方法*  
**8.MoneyException类中：**  
*(a)创建 MoneyException类为Exception类子类  
(b)创建 warnMess方法用来返回错误提示*  
**9.在实验类中创建DoctoralCandidate的对象Doctor，创建TeacherManagement的对象tea，创建StudentManagement的对象Stu,通过接口回调对实现接口的方法进行调用**
## 核心方法  
***1.revenue税收计算方法***
```
public final static double giveRevenue(double salary,double tuition) {
		tuition=tuition/6;                                                             
		revenue=TeacherManagement.sanxianyijin+StudentManagement.buzhu-tuition; 
		if(revenue<=5000.00) {                           
			return revenue*0.03;
		}
		else if(revenue>5000.00 && revenue<=12000.00) {  
			return (revenue-5000)*0.1+1500;
		}
		else if(revenue>12000.00 && revenue<=25000.00) { 
			return (revenue-12000)*0.2+2200;
		}
		else if(revenue>25000.00 && revenue<=35000.00) { 
			return (revenue-25000)*0.25+4800;
		}
		else if(revenue>35000.00 && revenue<=55000.00) { 
			return (revenue-35000)*0.3+7300;
		}
		else if(revenue>55000.00 && revenue<=80000.00) { 
			return (revenue-55000)*0.35+13300;
		}
		else if(revenue>80000.00) {                      
			return (revenue-80000)*0.45+22050;
		}
		return 0;
	}
``` 
***2.异常处理调用和返回方法***
```
 public static void giveSalary(double d,double e) throws MoneyException{
		if(d<0||e<0||d<e) {
			throw new MoneyException(d,e);
		}
	}
public MoneyException(double d,double e) {
		message = "工资"+d+"是负数或少于学费，或学费"+e+"是负数，";
	}
public String warnMess() {
		return message;
	}
``` 
***3.学费缴费方法***
```
public void payTuition(double tuition) {
		account=account-tuition;
		System.out.println("操作成功！");
		System.out.println("账户余额："+account);
	}
``` 
***4.学费查询方法***  
```
public void searchTuition(double tuition) {
		tuition=tuition-buzhu;
		System.out.println("本学期学费："+tuition);
		System.out.println("本学年学费："+2*tuition);
	}
``` 
***5.工资查询方法***
```
public void searchSalary(double salary,double revenue) {                       
		System.out.println("工资："+(salary-revenue));
		System.out.println("年实际工资："+12*(salary-revenue));
	}
``` 
***6.工资发放方法***
```
public void giveSalary(double salary,double revenue) {
		account=account+(salary-revenue);
		System.out.println("操作成功！");
		System.out.println("账户余额："+account);
	}
```
## 系统运行截图  
***Picture1：***  
![test31.png](https://i.loli.net/2020/11/08/UDcZdStBwr8eQRL.png)  
***Picture2：***  
![test32.png](https://i.loli.net/2020/11/08/4KJczYklW9nDBeH.png)  
## 实验感想  
**通过本次实验，我学会了接口和方法的使用，回顾了数组的声明和使用：  
首先创建接口来定义一些抽象方法，然后再通过实例化类来实现这些方法，在实验类中构造接口对象来实现接口回调，调用属于接口定义的原方法。  
实验中，通过数组存储数据，并对存储的数据进行计算和操作来实现实验目的。  
最后，在输入数据的方法使用try-catch进行异常处理。
本次实验不足：    
1.异常处理的覆盖面不够全面  
2.系统还差一些细节不够完善，会在日后维护中进行改进**
