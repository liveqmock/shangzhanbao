package com.common.util;

import java.io.File;
public class DirectoryFilter implements java.io.FilenameFilter {

	String myString;
  	DirectoryFilter(String myString)
  	{
  		this.myString = myString;
  	}
  	@Override
  	public boolean accept(File dir,String name)
  	{//FilenameFilter.accept(File dir, String name) 
         // 测试指定文件是否应该包含在某一文件列表中。
  		String f= new File(name).getName();
  		return f.equals(myString);
  	}
	
    public static void FileName(String pageId,String nn){
	   	String fileName=File.separator+"newTemp_"+pageId+".html";//要判断的文件或文件夹
	   	try{
		   File path = new File(nn+File.separator+"temp");
		   String[] myList;//定义一个字符串数组
		   if(fileName == null && fileName.length() == 0)//不含自变量则显示所有文件
			   myList = path.list();
		   else 
			   myList = path.list(new DirectoryFilter(fileName));
		   if(myList.length>0 && myList!=null){
		   for(int i = 0; i< myList.length;i++)//输出文件列表
			   System.out.println(myList[i]);
		   }else{
			   System.out.println("文件不存在");
		   }
	   }catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   
   }

}
