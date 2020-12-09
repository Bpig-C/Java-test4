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
(c)然后通过readFile()、operationFile()、addNewInformation(student0)、outFile()以及FindSth()来实现字符串的读取操作录入和查询。    *  

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
![test31.png](![resultpicture.jpg](https://i.loli.net/2020/12/10/PhkOlbEYTfL2cCx.jpg))  
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
