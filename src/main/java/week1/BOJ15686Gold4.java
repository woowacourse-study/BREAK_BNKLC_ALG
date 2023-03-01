package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ15686Gold4 {
    public static void main(String[] args){
        chickenGame(new Scanner(System.in));

    }
    public static void chickenGame(Scanner scanner){
        String[] inputNm = scanner.nextLine().split(" ");
        int N = Integer.parseInt(inputNm[0]);
        int M = Integer.parseInt(inputNm[1]);

        List<int[]> chicken = new ArrayList<>();
        List<int[]> home = new ArrayList<>();
        int j;
        for (int i = 0,end = N; i < end; i++) {
            String[] inputLine = scanner.nextLine().split(" ");
            j = 0;
            for(String place:inputLine){
                if(place.equals("1")){
                    home.add(new int[]{i+1,j+1});
                }
                if(place.equals("2")){
                    chicken.add(new int[]{i+1,j+1});
                }
                j++;
            }
        }
        int n = chicken.size();
        boolean[] visited = new boolean[n];
        List<List<int[]>> chickenComb = new ArrayList<>();
        backTracking(chicken,visited,0,n,M,chickenComb);
        int result = Integer.MAX_VALUE;
        for(List<int[]> chick:chickenComb){
            result = Math.min(result,calculateChickenDis(home,chick));
        }
        System.out.println(result);
    }
    static void backTracking(List<int[]> chicken,boolean[] visited, int start, int n, int r,List<List<int[]>> chickenComb){
        if(r == 0){
            List<int[]> newChickenComb = new ArrayList<>();
            int i = 0;
            for(boolean visitedBoolean: visited){
                if(visitedBoolean){
                    newChickenComb.add(chicken.get(i));
                }
                i++;
            }
            chickenComb.add(newChickenComb);
        }
        for(int i = start;i<n;i++){
            visited[i] = true;
            backTracking(chicken,visited,i+1,n,r-1,chickenComb);
            visited[i] = false;
        }
    }
    static int calculateChickenDis(List<int[]> home, List<int[]> chicken){
        int chickDis = 0;
        int homeX;
        int homeY;
        int chicX;
        int chicY;
        int minDis;
        for(int[] xy : home){
            minDis = Integer.MAX_VALUE;
            homeX= xy[0];
            homeY = xy[1];
            for(int[] x_y_: chicken){
                chicX = x_y_[0];
                chicY = x_y_[1];
                minDis = Math.min(calculateDis(homeX,homeY,chicX,chicY),minDis);
            }
            chickDis += minDis;
        }
        return chickDis;
    }
    static int calculateDis(int homeX,int homeY,int chicX,int chicY){
        return Math.abs(homeX-chicX)+Math.abs(homeY-chicY);
    }
}
