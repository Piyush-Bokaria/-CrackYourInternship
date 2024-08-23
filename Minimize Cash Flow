//Day 28 of #CrackYourInternship
class Solution {
    int N;

    private int getMin(int arr[]) {
        int minInd = 0;
        for (int i = 1; i < N; i++)
            if (arr[i] < arr[minInd])
                minInd = i;
        return minInd;
    }

    private int getMax(int arr[]) {
        int maxInd = 0;
        for (int i = 1; i < N; i++)
            if (arr[i] > arr[maxInd])
                maxInd = i;
        return maxInd;
    }

    private int minOf2(int x, int y) {
        return (x < y) ? x : y;
    }

    private void minCashFlowRec(int amount[], int[][] graph) {
        int mxCredit = getMax(amount);
        int mxDebit = getMin(amount);

        if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
            return;

        int min = minOf2(-amount[mxDebit], amount[mxCredit]);
        amount[mxCredit] -= min;
        amount[mxDebit] += min;

        graph[mxDebit][mxCredit] += min;

        minCashFlowRec(amount, graph);
    }

    public int[][] minCashFlow(int[][] transaction, int n) {
        N = n;
        int[] amount = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                amount[i] += (transaction[j][i] - transaction[i][j]);
            }
        }

        int[][] res = new int[n][n];
        minCashFlowRec(amount, res);
        
        return res;
    }
}
