//Name: Ian Sanborn
public class ArrayList<T> implements IList<T>{ //performs functions of an array list

 //instance variable
 T[] list; //array of the list
 int length = 0; //initial length of an empty list
 int current = 0; //current
 T move; //stores value to move in through the index

 //constructor
 public ArrayList(){
   list = (T[]) new Object[length];
 }

 //inserts a value(v) at a certain index in the list
 public void insert(int idx, T v){
   T[] temporary = (T[]) new Object[list.length + 1]; //temporary array that stores the new value
   for(int i = 0; i < list.length + 1; i++){
     if(i == idx){
       //is we are at the correct index, set that index to the value
       temporary[i] = v;
     }
     else if(i > idx){
       //if i is after the index, add the previous index of the list to the temporary array
       temporary[i] = list[i-1];
     }

     else{
       //if i is before the index, move the values into the temporary array
       temporary[i] = list[i];
     }
   }
   list = temporary; //set the list to the temporary array
 }

 public void append(T v){ //adds a value to the end of the list
   T[] temporary = (T[]) new Object[list.length + 1];
   if(list.length == 0){ //if the list is empty
     temporary[list.length] = v; //set the first index in the temporary equal to the value
     list = temporary;
   }
   else{ //if list is not empty
     for(int i = 0; i < list.length; i++){
       temporary[i] = list[i]; //scan through list and set temporary equal to all of lists elements
     }
     temporary[list.length] = v;
     list = temporary; //put the new value at the end of temporary
   }
   current = list.length - 1; //update where "current" points to
 }

 public void remove(){ //removes index that current is pointing to
   T[] temporary = (T[]) new Object[list.length - 1]; //temporary array one index smaller

   if(current == list.length - 1){ //if current is last value (removing from the end)
     for(int i = 0; i < list.length; i++){
       if(i < current){
         temporary[i] = list[i];
       }
     }
     list = temporary;
   }
   else if(current < list.length - 1){
     for(int i = 0; i < list.length; i++){
       if(i < current){//copy everything before the index being removed
         temporary[i] = list[i];
       }
       else if(i > current){ //copyeevrything after the index and move it one back
         temporary[i-1] = list[i];
       }
     }
     list = temporary;
   }
   //update current pointer to previous index
   if(current == 0){//cannot decrese curernt if it is 0
     current = 0;
   }
   else{
     current--;
   }
 }

 public void remove(int idx){ //removing a specific index
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

 public void move(int sidx, int didx){ //moving a value from one index to another
   move = list[sidx]; //store value of the index to be moved
   remove(sidx); //remove the value at the index
   insert(didx, move); //insert value back in at the new index
 }

 public T fetch(){ //fetch value that the current pointer is pointing to
   return list[current];
 }

 public T fetch(int idx){ //return a value at a specific index
   return list[idx];
 }

 public void next(){ //moves the curernt point forward
   if(current < list.length - 1){
     current++;
   }
 }

 public void prev(){ //moves current pointer backwards
   if(current > 0){
     current--;
   }
 }

 public void jumpToTail(){ //set current to the tail
   current = list.length - 1;
 }

 public void jumpToHead(){ //set current to the head
   current = 0;
 }

 public int size(){ //returns the size
   return list.length;
 }
}
