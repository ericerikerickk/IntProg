public class MySet implements Set{
  int [] items;
  int count;
  
  public MySet(int size){
   items = new int[size];
  }
  
  public MySet(){
   this(10);
  }
  
  public boolean isEmpty(){
   return count == 0;
  }
  
  public boolean isFull(){
   return count == items.length;
  }
  public void add(int item){
  if(!isFull())
   items[count++] = item;
  }

  public Set union(Set set){
   MySet union = new MySet();
   MySet argSet = (MySet)set;
   for(int i = 0; i < count; i++)
    union.add(items[i]);
   for(int i = 0; i < argSet.count; i++)
    if(!union.isFound(argSet.items[i]))
     union.add(argSet.items[i]);
   return union;
  }
  public Set intersection(Set set)
  {
   MySet intersection = new MySet();
   MySet argSet = (MySet)set;
   for(int i = 0; i < argSet.count; i++)
    if(isFound(argSet.items[i]))
     intersection.add(items[i]);
   return intersection;
  }
  public Set difference(Set set){return null;}
  public boolean isSubset(Set set){return false;}
  public int cardinality(){return 0;}
  
  public String toString(){
   StringBuffer sb = new StringBuffer();
   sb.append("{");
   for(int i = 0; i < count; i++)
    sb.append(items[i] + " ");
   sb.append("}");
   return sb.toString();
  }
  
  public boolean isFound(int item){
  boolean flag = false;
   for(int i = 0; i < count; i++)
    if(items[i] == item)
    {
     flag = true;
     break;
    }
    return flag;
  }
  
  public boolean equals(Object obj){
  boolean flag = true;
   if(obj instanceof Set){
    MySet set = (MySet)obj;
    for(int i = 0; i < count; i++)
     if(!set.isFound(items[i])){
      flag = false;
      break;
     }
   }
   return flag;
  }
  
  public static void main(String [] args){
   MySet setA = new MySet();
   MySet setB = new MySet();
   
   setA.add(5);
   setA.add(2);
   setA.add(1);
   setA.add(6);
   setA.add(3);
   
   setB.add(2);
   setB.add(6);
   setB.add(1);
   setB.add(4);
   
   System.out.println("setA contains:" + setA);
   System.out.println("setA contains:" + setB);
   System.out.println("setA.union(setB):" + setA.union(setB));
   System.out.println("setA.intersection(setB):" + setA.intersection(setB));
   
  }
 
}