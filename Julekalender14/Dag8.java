import java.util.ArrayList;
public class Dag8{
  public static void main(String [] args){
    ArrayList <Integer> rareTall = new ArrayList<>();
    int sum = 0;
    for (int i =2; i <10000; i++){
      for (int k = 1; k<i ; k++){
        if(i%k ==0){
          sum += k;
        }
      }
      if (sum == i ){
        rareTall.add(i);
      }
      sum = 0;
    }
    for (int i : rareTall){
      System.out.println(i);
    }
    
    System.out.println(rareTall.size());
  }
}
