package BinarySearch;

public class MinimumTimeRepairCar_2594 {
    public static void main(String[] args) {
        int[] ranks = {5,1,8};
        int cars = 6;
        long time =   minTimeRepairCar(ranks,cars);
        System.out.println("time = " + time);
    }

    private static long minTimeRepairCar(int[] ranks, int cars) {
        long l =0, r = Long.MAX_VALUE;
        while(l<r){
            long mid = l + (r-l)/2;

            if(isSuffTime(ranks,cars,mid)){
                r =mid;
            }else{
            l = mid +1;}
        }
        return l;
    }

    private static boolean isSuffTime(int[] ranks, int cars, long mid) {
        long cars_done =0;
        for(Integer i : ranks){
            long c2 = mid/i;
            long c = (long) Math.floor(Math.sqrt(c2));
            cars_done+= c;
        }
        return cars_done >= cars;
    }
}
