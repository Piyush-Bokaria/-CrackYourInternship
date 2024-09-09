//Day 45 of #CrackYourInternship
class Solution {
    int[] JobScheduling(Job arr[], int n) {
        
        int[] res = new int[2];
        
        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job a, Job b) {
                return Integer.compare(b.profit, a.profit);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        boolean[] timeSlots = new boolean[n];

        int jobsDone = 0;
        int maxProfit = 0;

        while (!pq.isEmpty()) {
            Job currentJob = pq.poll();

            for (int j = Math.min(n - 1, currentJob.deadline - 1); j >= 0; j--) {
                if (!timeSlots[j]) {
                    timeSlots[j] = true;
                    jobsDone++;
                    maxProfit += currentJob.profit;
                    break;
                }
            }
        }
        res[0] = jobsDone;
        res[1] = maxProfit;

        return res;
    }
}
