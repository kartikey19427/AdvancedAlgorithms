public static void validsubstr(String S){
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int validlen=0;
        int countopen=0;
        int countclose=0;
        int maxlen=0;
        ArrayList<Integer> lst=new ArrayList<>();

        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);

            if(c=='('){
                stack.push(i);

            }
            else if(c==')'){
                if(stack.peek()==-1){
                    stack.push(i);
                    continue;
                }
                if(S.charAt(stack.peek())==')'){
                    stack.push(i);
                    continue;
                }

                if(!stack.isEmpty()){
                    stack.pop();
                    validlen=Math.max(validlen,i-stack.peek());

                }

            }

        }

        System.out.println(validlen);
    }