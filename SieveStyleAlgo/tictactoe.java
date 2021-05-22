 
 public static void sievestyle(int N, int k){
        //sieve style method for counting Factors of every number upto N
        ArrayList<Integer>[] arr=new ArrayList[N+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=1;i<N+1;i++){
            for(int j=i;j<N+1;j=j+i){
                arr[j].add(i);
            }
        }

        //sieve style method for finding every prime number upto N.
        Boolean[] isprime=new Boolean[N+1];
        ArrayList<Integer>[] arrprime=new ArrayList[N+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=new ArrayList<>();
            isprime[i]=true;
        }
        for(int i=2;i<N+1;i++){
            if(isprime[i]) {
                for (int j = i*i; j < N + 1; j = j + i) {
                    isprime[j]=false;
                }
            }
        }
        System.out.println(isprime[k]);

    }