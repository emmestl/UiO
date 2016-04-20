import java.util.*;
import java.awt.Color;

class Lights{

    public static final String[] color = {"\u001B[1m", "\u001B[30m", "\u001B[34m", "\u001B[36m", "\u001B[35m", "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[37m", "\u001B[0m"};

    private static int[] start = new int[2];
    private static int[] end = new int[2];
    private static int[][] grid = new int [1000][1000];
    private static String cmd;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNextLine()){
            clean(in.nextLine().split(" "));

            if(cmd.equals("toggle")){
                for(int i = start[0]; i <= end[0]; i ++){
                    for(int j = start[1]; j <= end[1]; j++){
                        grid[i][j]  += 2;
                    }
                }
            }
            else if(cmd.equals("off")){
                for(int i = start[0]; i <= end[0]; i ++){
                    for(int j = start[1]; j <= end[1]; j++){
                        grid[i][j] = grid[i][j] == 0 ? 0 : grid[i][j] - 1; //0
                    }
                }
            }
            else if(cmd.equals("on")){
                for(int i = start[0]; i <= end[0]; i ++){
                    for(int j = start[1]; j <= end[1]; j++){
                        grid[i][j]  += 1;
                    }
                }
            }
        }


        print();
        //System.out.println (count());
    }

    public static void clean(String[] line){
        String[] cordinates = line[line.length -1].split(",");

        for(int i = 0; i < cordinates.length; i ++){
            end[i] = Integer.parseInt(cordinates[i]);
        }

        cordinates = line[line.length -3].split(",");

        for(int i = 0; i < cordinates.length; i ++){
            start[i] = Integer.parseInt(cordinates[i]);
        }

        cmd = line.length == 4 ? line[0] : line[1];
    }


    public static void print(){
        /*
          for(int i = 0; i < grid.length; i+= 6){
          for(int j = 0; j < grid[i].length; j += 6){
          if(grid[i][j] == 0){
          System.out.printf ("%s%s%3d%s",color[4], color[0] ,grid[i][j], color[color.length -1]);
          }
          else{
          System.out.printf ("%s%s%3d%s",color[3], color[0] ,grid[i][j], color[color.length -1]);
          }
          }
          System.out.println ();
          }
          //find max:
          */
        int max =0;
        for(int i = 0; i < grid.length; i+= 6){
            for(int j = 0; j < grid[i].length; j += 6){
                max = grid[i][j] > max ? grid[i][j]: max;
            }
        }

        for(int i = 0; i < grid.length; i+= 6){
            for(int j = 0; j < grid[i].length; j += 6){
                if(grid[i][j]%6 < 3){
                    System.out.printf ("%s%3d%s",color[(grid[i][j])/6 + 1] ,grid[i][j], color[color.length-1]);
                }
                else{
                    System.out.printf ("%s%s%3d%s",color[(grid[i][j])/6 + 1], color[0] ,grid[i][j], color[color.length -1]);
                }
            }
            System.out.println ();
        }

    }


    public static int count(){
        int count = 0;

        for(int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[i].length; j ++){
                count += grid[i][j];
            }
        }

        return count;
    }
}
