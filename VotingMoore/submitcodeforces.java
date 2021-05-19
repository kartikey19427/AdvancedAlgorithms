public class Main {

    public static void main(String[] args) {
    // write your code here
        int a=5;
        int b=6;
        int[] arr={3, 3, 4, 2, 4, 4, 2, 4};
        votingMoore(arr);


    }
        public static void votingMoore(int[] arr){
        int count=1;
        int curr=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]==curr){
                count++;
            }
            else {
                count--;
                if(count==0){
                    curr=arr[i];
                    count=1;
                }
            }
        }
        int countmajority=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==curr){
                countmajority++;
            }
        }
        if(countmajority>arr.length/2){
            System.out.println(curr);
        }
        else{
            System.out.println(-1);
        }
    }
}