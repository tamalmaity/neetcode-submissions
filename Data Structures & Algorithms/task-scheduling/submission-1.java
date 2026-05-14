class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        Arrays.sort(freq);

        int maxf = freq[25];
        int betwn = (maxf-1)*n;
        for(int i=24;i>=0;i--){
            betwn-= Math.min(freq[i], (maxf-1));
        }

        if (betwn<0) return tasks.length;
        return tasks.length+betwn;

    }
}
