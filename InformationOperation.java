package realcode;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationOperation {
	int n;
	@SuppressWarnings("null")
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
		            System.out.println("�����쳣...");
		        }
			s = String.valueOf(a);
			if(l!=null)
				l.append(s);
			if ((i + 7) % 7 == 0 && (i + 7) % 14 != 0)  {
				l.append(",");
				j++;
				}
			else if((i + 7) % 14 == 0) {
				 l.append("��\n");
	             j=j+2;
			}
			j=j+7;
		}
		l.deleteCharAt(j-1);
		return l;
	}
	
	public String readFile() {
		String original = null;
		int n=-1;
		char[] a = new char[100];//���棬
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
	public void FindSth(String Str){
		int m = 0;
		StringBuffer s1=new StringBuffer(Str);
		  a:
		            while (true) {
		                System.out.println("���������:\n1:��ѯ�ʾ�\n2:�˳�����\n");
		                try {
		                Scanner reader0 = new Scanner(System.in);
		                m = reader0.nextInt();
		                }
		                catch(Exception e) {
		                	System.out.println("�ı���û�и��ַ���");
		                }
		                switch (m) {
		                    case 1:
		                        System.out.println("��������Ҫ��ѯ���ֻ�ʣ�\n");
		                        Scanner reader1 = new Scanner(System.in);
		                        String s2 = reader1.nextLine();
		                        Pattern pattern = Pattern.compile(s2);
		                        Matcher matcher = pattern.matcher(s1);
		                        if (matcher.find()) {
		                            int num = 1;
		                            while (matcher.find()) {
		                                num++;
		                            }
		                            System.out.println("��"+s2+"�����ֵĴ���Ϊ:" + num);
		                        } else {
		                            System.out.println("�ı���û�и��ַ�");
		                        }
		                        break;
		                    case 2:
		                    	System.out.println("����ʵ�������");
		                        break a;
		                    default:
		                        System.out.println("������ı����������������");
		                }
		            }

		 }
	}
	



