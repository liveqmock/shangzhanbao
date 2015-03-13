package test;

/*
* java集合框架：
* 
* java.util.Collection;
* java.util.List;
* java.util.Set;
* java.util.List;
* java.util.ArrayList;
* java.util.LinkedList;
* java.util.HasSet;
* java.util.Map;
* java.util.HashMap;
* java.util.Map.Entry;
* TestMuster.java
* @author eric
* @src  http://eric-619.javaeye.com/blog/693684
* @time  5/3/2010
* 0、栈：stack;    堆：heep;
* 1、堆栈：相当于一个只有一个口的盒子，先进后出，后进先出。
* 2、队列：相当于一个管道，先进先出，后进后出,如List接口
* 
*/


import java.util.*;
import java.util.Map.Entry;

public class TestMuster {

public static void main(String[] args) {
	String ss = "aaa";
	String sss = "aaa";
	System.err.println(ss==sss);
//   new TestMuster().testCollection();
//        new TestMuster().testHashSet();
        //new TestMuster().testList();
        //new TestMuster().testMap();
//        new TestMuster().testCompositor();
  
}


/*
* 0、集合里存的是一个一个的对象
* 1、添加简单对象的Collection即相应接口实例
* 2、java.util.Collection接口,调用的是Collection接口里的方法，可重复
* 3、Collection接口的子接口List和Set,Set无序不可重复，List有序可重复
*     所谓有序无序是相对于add的程序执行顺序来说的 
* 4、注意从集合里取数据时的强制类型转换
*/
public void testCollection(){
  
   /*
   * Set接口没有定义Collection接口以外的方法！！！，
   * 所以下面的可以将Collectoin改成Set,只是多加了一个约束，无序不重复
   */
   Collection cols = new HashSet();   //无序不重复 
   cols.add(12); //添加
   cols.add(11);
   cols.add(12);
   cols.add(13);
   cols.add(12);
   cols.add(13);
   cols.add(10);
   cols.remove(13); //移除
   Iterator irs = cols.iterator(); //重点是Iterator接口的枚举遍历
   while(irs.hasNext()){
      int is = (Integer)irs.next(); 
      System.out.println("Set无序不重复is=="+is);
   }
   System.out.println("---------------------------------");
  
     Collection coll = new LinkedList(); //有序可重复
   coll.add(8);
   coll.add(9);
   coll.add(8);
   Iterator irtl = coll.iterator();
   while(irtl.hasNext()){
    int il = (Integer)irtl.next();
    System.out.println("List有序可重复il=="+il);
   }
   System.out.println("---------------------------------");
  
  
  
   // 以ArrayList类为例：集合元素的增删改查
   Collection cola = new ArrayList(); //和具体的实现类从理论上说没有关系
   // 往集合里添加对象 add(Object o);
   cola.add(1);
   cola.add(2);
   cola.add(2);
   cola.add(3);
   cola.add(4);
   cola.add(2);
   cola.add(3);
   cola.add(4); 
  
   cola.remove(3); //从集合里移除
      //cola.remove(3);
  
   Object[] boj = cola.toArray(); //集合里数据更新的方法: 先清空在add, toArray(),就是暂存数组里
   cola.clear();
   for(int i = 0; i < boj.length; i++){
    if(boj[i].equals(2)){
     boj[i] = 8;
    }
    cola.add(boj[i]);
   }
  
   Iterator irta = cola.iterator(); // 枚举遍历   java.util.Iterator接口的使用
     while(irta.hasNext()){
     int ia = (Integer)irta.next(); //转化为基础类型包装类整型类对象
     System.out.println("i=="+ia);
     } 
     
     int ias = cola.size();
     System.out.println(ias);
     System.out.println("---------------------------------");
     
}




// 添加复杂对象的HashSet类：顺便测试对象的调用默认方法的顺序
public void testHashSet(){
   Set rset = new HashSet();
   FuzaO fdx = new FuzaO();
     fdx.setAge(20);
     fdx.setUserId("26");
     fdx.setUsername("xuechong");
     rset.add(fdx);
   Iterator itr = rset.iterator();
   while(itr.hasNext()){
    FuzaO str = (FuzaO)itr.next();
    System.out.println(str);    //重写toString方法！
   } 
}




/*
* List接口的两大扩展：
*   1、增加了下标：所以就容易精确指定里面的目标元素；set(int index, E element)
*       这样本身各个对象就有了数据的定位置；集合里的元素也是从0开始数！
*   2、
*   3、ArrayList和LinkedList类的区别：
*        *如果只是随机访问，则用ArrayList类比较好些；
*        *如果要频繁的增加和删除里面的元素或有顺序的访问则用LinkedList类比较好些。
*          LinkedList类相当于一个链表
*   4、List是队列
*/
public void testList(){
   List tis = new ArrayList();
   FuzaO fdx = new FuzaO();
     fdx.setAge(20);
     fdx.setUserId("26");
     fdx.setUsername("xuechong");
     tis.add(fdx); //增加复杂对象
     tis.add(3);    //增加简单对象
     tis.add(5);
     tis.add(10);
     tis.remove(2); //删除指定对象，2代表顺序，即序列号，并不是代表个数
     int io = tis.size();   //List里对象的个数 int tis.size()
     System.out.println("List里的对象的个数是："+io); 
     tis.set(1,"2");    //List里这样更新数据多方便啊!!!
     tis.set(2,"2000");
     System.out.println("tis.get(0)\n"+tis.get(0)); //从取数据的另外一种写法
     System.out.println("tis.get(1)\n"+tis.get(1));
   Iterator itr = tis.iterator(); //集合的遍历查询模式
   while(itr.hasNext()){     
    Object str = (Object)itr.next();
    System.out.println(str);    //重写toString方法！
     } 
     }


     /*
      * Map接口的使用：
      *   1、Map的实例是一个键值对：key-value,key不能重复，
      *        key就相当于代表，是关键，key也相当于存储在Set中。
      *   2、
      */
     public void testMap(){
     Map map1 = new HashMap();
     
     //Map的增删改查
     //add,     map1.put(Object o1, Object o2);
     map1.put("a", "3");
     map1.put("b", "2");
     map1.put("c", "1");
     map1.put("d","4");
     
     //update，   update的思想就是覆盖原来的key值，其实还是add ,用put()方法
     map1.put("a", "100");
     map1.put("d", "hehehe");
     
     //delete ,其实就是只删除key就行了
     map1.remove("c");
     
     /* query 
     * 1、 map1.keySet()方法是重点,此方法的作用是得到key的值，在根据key的值拿到value的值    
     * 2、通过集合实例调用iterator()方法得到Iterator实例，用该实例来遍历集合中的元素
     * 3、Map的取值是有序还是无序目前还没有查清楚。
     */
     Set mapset = map1.keySet();
     Iterator itr = mapset.iterator();
     while(itr.hasNext()){
        String skey = (String)itr.next();
        String svalue = (String)map1.get(skey); //value是根据key直接在Map里拿
        System.out.println("key=="+skey+",value=="+svalue);
     }
     System.out.println("-----");
     /* entry的用法： 
     * 关键是entrySet()方法的用法
     * 集合实例调用entrySet()方法得到子集合，子集合得到Iterator实例，遍历得到Entry实例，
     *     通过Entry实例调用getKey()和getValue()方法得到key和value的值。
     */
     Set setentry = map1.entrySet();
     Iterator entryit = setentry.iterator();
     while(entryit.hasNext()){
        Entry en = (Entry)entryit.next();
        String skey2 = (String)en.getKey();
        String svalue2 = (String)en.getValue();
        System.out.println("key2=="+skey2+",value2=="+svalue2);
     }
     System.out.println("--------------------------------");
     }
     
     
     /*
      * 集合排序   ,主要是用TreeSet类,主要方法是重写compareTo()方法。
      * 1、 你传进去的对象自己能排序，这是最重要的一点，不然会报告：
      *    cannot be cast to java.lang.Comparable错误。
      */
     public void testCompositor(){
     Collection ctree = new TreeSet();
     FuzaO ff1 = new FuzaO();
     ff1.setAge(20);
     ff1.setUserId("a");
     ff1.setUsername("3");
     ctree.add(ff1);
     
     FuzaO ff2 = new FuzaO();
     ff2.setAge(30);
     ff2.setUserId("d");
     ff2.setUsername("5");
     ctree.add(ff2);
     
     FuzaO ff3 = new FuzaO();
     ff3.setAge(25);
     ff3.setUserId("c");
     ff3.setUsername("4");
     ctree.add(ff3);
     
     Iterator itr = ctree.iterator();
     while(itr.hasNext()){
        FuzaO f = (FuzaO)itr.next();
        System.out.println(f);
     }
     }
     
   }


class FuzaO implements Comparable{
   // 设置方法：在source里点击：hasCode()和equals()重写
   private int age;
   private String userId;
   private String username;
   
   
   
     /*   由于是TreeSet，会自动找Compareable接口，所以此方法会默认自动调用的呵呵；
      *   重写compareTo()方法，然后自动被TreeSet调用。 
      *   this.getUsername()特别是this的含义是什么现在我也不清楚了？？？
      */
     public int compareTo(Object obj){
     FuzaO f1 = (FuzaO)obj;
     if(this.getUsername().compareTo(f1.getUsername()) > 0){
        return 1;
     }else if(this.getUsername().compareTo(f1.getUsername()) == 0){
        return 0;
     }else{
        return -1;
     }
     }

public int hashCode() {
   System.out.println("hashCode===========");
   final int prime = 31;
   int result = 1;
   result = prime * result + ((userId == null) ? 0 : userId.hashCode());
   return result;
}

public boolean equals(Object obj) {
   System.out.println("equals()============");
   if (this == obj)
    return true;
   if (obj == null)
    return false;
   if (getClass() != obj.getClass())
    return false;
   FuzaO other = (FuzaO) obj;
   if (userId == null) {
    if (other.userId != null)
     return false;
   } else if (!userId.equals(other.userId))
    return false;
   return true;
}

public String toString() {   //重写toString方法！
   System.out.println("toString=============");
   return "age="+age+"\n"+"userId="+userId+"\n"+"username="+username;
}
public int getAge() {
   return age;
}
public void setAge(int age) {
   this.age = age;
}
public String getUserId() {
   return userId;
}
public void setUserId(String userId) {
   this.userId = userId;
}
public String getUsername() {
   return username;
}
public void setUsername(String username) {
   this.username = username;
}
   
}

