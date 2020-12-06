package opreation;

import java.io.*;
import java.util.Scanner;

public class FileInAndOut {
	int n;
	public String operationFile(String longer) {
		StringBuffer l=new StringBuffer(longer);

		String s;
	    char[] a;
		for(int i = 0;i<l.length();i=i+7) {
			 a=new char[7];
			 try {
				 longer.getChars(i, i+7, a, 0);
		       } catch( Exception ex) {
		            System.out.println("´¥·¢Òì³£...");
		        }
			s = String.valueOf(a);
			StringBuffer t = new StringBuffer(s);
			if(l!=null)
				l=l.append(t);
			if(((i+7)/7)%2==1) {
				l=l.append(",");
				}
			else if(((i+7)/7)%2==0) {
				l=l.append("¡£\n");
			}
			
		}
		String b=l.toString();
		return b;
	}
	
	public String readFile() {
		String original = null;
		int n=-1;
		char[] a = new char[100];//»º´æ£¬
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
	
}


