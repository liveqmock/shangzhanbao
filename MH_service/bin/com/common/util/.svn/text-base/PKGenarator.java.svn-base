package com.common.util;


import org.hibernate.id.UUIDHexGenerator;


/**
 * 唯一标识生成
 * 数据库主键
 * 
 * @author Administrator
 *
 */
public class PKGenarator 
{

	private PKGenarator()
	{
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		 
//		System.out.print( getId());
        
	}
	/**
	 * 获取数据库唯一主键
	 * @return 主键 32位字符窜
	 */
    public  synchronized static String getId()
    {
    	return (String) new UUIDHexGenerator().generate(null, null);  
    }

}
