'''Day 45 of #CrackYourInternship'''
def minimal_breaking_cost(test_cases):
    results = []
    for case in test_cases:
        m, n, x_cuts, y_cuts = case

        x_cuts.sort(reverse=True)
        y_cuts.sort(reverse=True)

        hSeg = 1
        vSeg = 1
        total_cost = 0

        i, j = 0, 0
        while i < len(x_cuts) and j < len(y_cuts):
            if x_cuts[i] > y_cuts[j]:
                total_cost += x_cuts[i] * hSeg
                vSeg += 1
                i += 1
            else:
                total_cost += y_cuts[j] * vSeg
                hSeg += 1
                j += 1

        while i < len(x_cuts):
            total_cost += x_cuts[i] * hSeg
            i += 1

        while j < len(y_cuts):
            total_cost += y_cuts[j] * vSeg
            j += 1

        results.append(total_cost)
    
    return results


def run_chocolate_problem():
    test_cases = []
    num_tests = int(input().strip())
    
    for _ in range(num_tests):
        input()
        m, n = map(int, input().split())
        
        x_cuts = [int(input().strip()) for _ in range(m - 1)]
        y_cuts = [int(input().strip()) for _ in range(n - 1)]
        
        test_cases.append((m, n, x_cuts, y_cuts))
    
    results = minimal_breaking_cost(test_cases)
    
    for result in results:
        print(result)
run_chocolate_problem()
