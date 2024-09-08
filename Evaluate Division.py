'''Day 44 of #CrackYourInternship'''
class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        graph = collections.defaultdict(list)
        for i, eq in enumerate(equations):
            x, y = eq
            graph[x].append([y, values[i]])
            graph[y].append([x, 1/values[i]])
        def bfs (source, target):
            if source not in graph or target not in graph :
                return -1
            queue, visited = [], set()
            queue.append([source, 1])
            visited.add(source)
            while queue:
                node, wei = queue.pop(0)
                if node == target:
                    return wei
                for neigh, weight in graph[node]:
                    if neigh not in visited:
                        queue.append([neigh, wei * weight])
                        visited.add(neigh)    
            return -1
                
        return [bfs(query[0],query[1]) for query in queries]    
