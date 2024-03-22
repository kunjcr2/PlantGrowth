import java.util.*;
import java.lang.System;

class GardeningPlanner_KunjShah{

    // all the variable
    static int minTemp;
    static int maxTemp;
    static int minRain;
    static int[] arrHeight = new int[12];

    //prints the welcome message
    static void wlcmMsg(){
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Welcome to the CSC 215 Gardening Planner!");
        System.out.println("-----------------------------------------------------------------------------------------");
        getInpt();
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    //gets all the input of temprature and rainfall
    static void getInpt(){
        Scanner sc = new Scanner(System.in);
        System.out.print("- Enter minimum temprature for plant: ");
        minTemp = sc.nextInt();
        System.out.print("- Enter maximum temprature for plant: ");
        maxTemp = sc.nextInt();
        System.out.print("- Enter minimum rainfall for plant: ");
        minRain = sc.nextInt();
    }

    //finds maximum plantgrowth
    static int forMax(int max){
        for(int x = 0; x<12; x++){
            if (max<arrHeight[x]){
                max = arrHeight[x];
            }
        }
        return max;
    }

    //displays the entire table
    public static void displayTable(){

        //pretable
        int[] avgTemp = {46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47};
        int[] avgRain = {5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4};
        String[] mnth = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        System.out.println();
        System.out.println("-------------- -------------- -------------- -------------- -------------- --------------");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s","INDEX","MONTH","TEMPERATURE","RAINFALL","PLANT GROWTH","PLANT HEIGHT");
        System.out.println();
        int height = 0;
        int plantGrowth = 0;
        int max = 0;
        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[43m";
        String BLACK = "\u001B[30m";

        //actual table
        for(int i = 0; i<12; i++){
            if(avgTemp[i]<minTemp || avgTemp[i]>maxTemp){
                plantGrowth = -1;
            }else{
                plantGrowth = avgRain[i]-minRain;
            }
            height += plantGrowth;
            if(height<0){
                height = 0;
            }
            arrHeight[i] = height;
        }
        height = 0;
        for (int i = 0; i < 12; i++) {
            if(avgTemp[i]<minTemp || avgTemp[i]>maxTemp){
                plantGrowth = -1;
            }else{
                plantGrowth = avgRain[i]-minRain;
            }
            height += plantGrowth;
            arrHeight[i] = height;
            if(height<0){
                height = 0;
            }
            if(forMax(max) == arrHeight[i]){
                if(plantGrowth>=0){
                    System.out.printf("%-15d%-15s%-15d%-15d+%-14d%-5d%-3s\n", i, mnth[i], avgTemp[i], avgRain[i], plantGrowth, height, YELLOW + BLACK + "MAX" + RESET + RESET);
                }else{
                    System.out.printf("%-15d%-15s%-15d%-15d%-15d%-5d%-3s\n", i, mnth[i], avgTemp[i], avgRain[i], plantGrowth, height, YELLOW + BLACK + "MAX" + RESET + RESET);
                }
            }
            else{
                if(plantGrowth>=0){
                    System.out.printf("%-15d%-15s%-15d%-15d+%-14d%-5d%-3s\n", i, mnth[i], avgTemp[i], avgRain[i], plantGrowth, height, " ");
                }else{
                    System.out.printf("%-15d%-15s%-15d%-15d%-15d%-5d%-3s\n", i, mnth[i], avgTemp[i], avgRain[i], plantGrowth, height, " ");
                }
            }
        }
        System.out.println("-------------- -------------- -------------- -------------- -------------- --------------");
    }

    //runs all the methods
    static void run(){
        wlcmMsg();
        displayTable();
    }

    //main - runs "run"
    public static void main(String[] args) {
        run();
    }
}
