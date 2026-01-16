// https://school.programmers.co.kr/learn/courses/30/lessons/42748

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        for(int i=0;i<len;i++){
            int[] cmd = commands[i];
            int start = cmd[0];
            int end = cmd[1];
            int order = cmd[2];
            int ans = op(array,start,end,order);
            answer[i] = ans;
        }
        return answer;
    }
    
    static int op(int[] arr, int s, int e, int o){
        s -= 1;
        e -= 1;
        o -= 1;
        int len = e-s+1;
        int[] newArr = new int[len];
        for(int i=0;i<len;i++){
            newArr[i] = arr[s];
            s++;
            int x = i;
            while(x>0 && newArr[x]<newArr[x-1]){
                int temp = newArr[x];
                newArr[x] = newArr[x-1];
                newArr[x-1] = temp;
                x--;
            }
        }
        // for(int i=0;i<len;i++){
        //     System.out.print(newArr[i]+" ");
        // }
        // System.out.println();
        return  newArr[o];
    }
    
}
