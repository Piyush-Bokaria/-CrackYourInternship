//Day 44 of #CrackYourInternship
class Solution
{
    class State {
        int jug1, jug2, steps;

        State(int jug1, int jug2, int steps) {
            this.jug1 = jug1;
            this.jug2 = jug2;
            this.steps = steps;
        }
    }
    public int  minSteps(int m, int n, int d)
    {
        // code here
        if (d > Math.max(m, n)) return -1; 
        if (d % gcd(m, n) != 0) return -1; 
        
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new State(0, 0, 0)); 
        visited.add(0 + "," + 0); 

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            int jug1 = curr.jug1;
            int jug2 = curr.jug2;
            int steps = curr.steps;

            if (jug1 == d || jug2 == d) {
                return steps;
            }

            List<State> nextStates = new ArrayList<>();

            nextStates.add(new State(m, jug2, steps + 1));

            nextStates.add(new State(jug1, n, steps + 1));

            nextStates.add(new State(0, jug2, steps + 1));

            nextStates.add(new State(jug1, 0, steps + 1));

            int pourToJug2 = Math.min(jug1, n - jug2);
            nextStates.add(new State(jug1 - pourToJug2, jug2 + pourToJug2, steps + 1));

            int pourToJug1 = Math.min(jug2, m - jug1);
            nextStates.add(new State(jug1 + pourToJug1, jug2 - pourToJug1, steps + 1));

            for (State nextState : nextStates) {
                String key = nextState.jug1 + "," + nextState.jug2;
                if (!visited.contains(key)) {
                    queue.offer(nextState);
                    visited.add(key);
                }
            }
        }
        return -1;
    }
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
