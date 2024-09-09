//Day 45 of #CrackYourInternship
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskfreq = new int[26];
        for(char c : tasks){
            taskfreq[c - 'A']++;
        }   
        Arrays.sort(taskfreq);
        int batch = taskfreq[25];
        int vslots = --batch * n;
        for(int i = 0;i < 25;i++){
            vslots -= Math.min(taskfreq[i], batch);
        }
        return vslots > 0 ? tasks.length + vslots : tasks.length;
    }
}
