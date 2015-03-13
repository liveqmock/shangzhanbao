package com.mini.util;


/**
 * ftl工具测试demo类
 * 针对第一个写死的模板
 * @author dlm
 *
 */
public class FreemarkUtil {
	
	/**
	 * 内部类
	 * @author dlm
	 *
	 */
	public class PicTextData{
		
		
		private String image = "";
		private String content = "";
		private String title = "";
		
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		
	}

	public FreemarkUtil(){
		
	}
	
}
