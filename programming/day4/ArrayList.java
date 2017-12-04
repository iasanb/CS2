//Name: Ian Sanborn
public class ArrayList<T> implements IList<T>{

 //instance variable
 T[] list;
 int length = 0;
 int current = 0;
 T move;

 //constructor
 public ArrayList(){
   list = (T[]) new Object[length];
 }

 public void insert(int idx, T v){
   T[] temporary = (T[]) new Object[list.length + 1];
   for(int i = 0; i < list.length + 1; i++){
     if(i == idx){
       temporary[i] = v;
     }
     else if(i > idx){
       temporary[i] = list[i-1];
     }

     else{
       temporary[i] = list[i];
     }
   }
   list = temporary;
 }

 public void append(T v){
   T[] temporary = (T[]) new Object[list.length + 1];
   if(list.length == 0){
     temporary[list.length] = v;
     list = temporary;
   }
   else{
     for(int i = 0; i < list.length; i++){
       temporary[i] = list[i];
     }
     temporary[list.length] = v;
     list = temporary;
   }
   current = list.length - 1;
 }

 public void remove(){
   T[] temporary = (T[]) new Object[list.length - 1];

   if(current == list.length - 1){
     for(int i = 0; i < list.length; i++){
       if(i < current){
         temporary[i] = list[i];
       }
     }
     list = temporary;
   }
   else if(current < list.length - 1){
     for(int i = 0; i < list.length; i++){
       if(i < current){
         temporary[i] = list[i];
       }
       else if(i > current){
         temporary[i-1] = list[i];
       }
     }
     list = temporary;
   }
   if(current == 0){
     current = 0;
   }
   else{
     current--;
   }
 }

 public void remove(int idx){
   T[] temporary = (T[]) new Object[list.length - 1];
   for(int i = 0; i < list.length; i++){
     if(i < idx){
       temporary[i] = list[i];
     }
     else if (i > idx){
       temporary[i-1] = list[i];
     }
     else{
     }
   }
   list = temporary;
 }

 public void move(int sidx, int didx){
   move = list[sidx];
   remove(sidx);
   insert(didx, move);
 }

 public T fetch(){
   return list[current];
 }

 public T fetch(int idx){
   return list[idx];
 }

 public void next(){
   if(current < list.length - 1){
     current++;
   }
 }

 public void prev(){
   if(current > 0){
     current--;
   }
 }

 public void jumpToTail(){
   current = list.length - 1;
 }

 public void jumpToHead(){
   current = 0;
 }

 public int size(){
   return list.length;
 }
}
