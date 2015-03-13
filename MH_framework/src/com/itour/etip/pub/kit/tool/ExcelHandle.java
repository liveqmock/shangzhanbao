package com.itour.etip.pub.kit.tool;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * Created by IntelliJ IDEA. User: xl Date: 2005-7-17 Time: 9:33:22 To change
 * this template use File | Settings | File Templates.
 */
public class ExcelHandle {
	public ExcelHandle() {
	}

	/**
	 * ��ȡExcel
	 * 读取excel文件
	 * @param filePath
	 */
	public static List<List> readExcel(String filePath) {
		
		List<List> sheetList=new ArrayList<List>();//取得整个xls各个sheet中的总数据
		try {
			InputStream is = new FileInputStream(filePath);
			Workbook rwb = Workbook.getWorkbook(is);
			Sheet[] sheets=rwb.getSheets();
			
			for(int i=0;i<sheets.length-1;i++){//取得表中sheet的个数
				List<List> allLineList=new  ArrayList<List>();//取得一个sheet中n行的总记录，里面是每行的记录
				
				for(int k=1;k<sheets[i].getRows();k++){//读取多少行
					List<String> linelist=new ArrayList<String>();//将一行的值放入lineList
					
					for(int j=0;j<sheets[i].getColumns();j++){//取得一行的列数
						
						Cell cell=sheets[i].getCell(j,k);//读出每行的每个单元格数据
						String cellStr=cell.getContents();//得到单元格的内容
						
						if (cell.getType() == CellType.LABEL) {
							LabelCell ctr = (LabelCell) cell;
							cellStr = ctr.getString();
						}
						linelist.add(cellStr);
					}
					allLineList.add(linelist);
				}
				sheetList.add(allLineList);
					
			}
			// 关闭
			rwb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sheetList;
	}
	public static void main(String[] args){
	//ExcelHandle.readExcel("E:/itour/etipcc/WebContent/upload/0905091648484248.xls");
		
	}
}
