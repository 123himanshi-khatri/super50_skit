// @filename - Method.java
// @description - Contains question methods (solutions) from Priority Queues (Heaps),
// Graphs - Adjacency Matrix/List and Traversals (Week 6 Story)
// @author - Himnashi

import java.util.*;

public class Method {

    // 1. Minimum Time to Complete All Tasks
    static int minTimeTasks(int time[], int edges[][], int n) {

        int indegree[] = new int[n];
        int dp[] = new int[n];

        for(int i = 0;i < n;i++)
            dp[i] = time[i];

        for(int e[] : edges)
            indegree[e[1]]++;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i < n;i++)
            if(indegree[i] == 0)
                q.add(i);

        while(!q.isEmpty()) {

            int u = q.poll();

            for(int e[] : edges) {

                if(e[0] == u) {

                    int v = e[1];
                    dp[v] = Math.max(dp[v], dp[u] + time[v]);
                    indegree[v]--;

                    if(indegree[v] == 0)
                        q.add(v);
                }
            }
        }

        int ans = 0;
        for(int i = 0;i < n;i++)
            ans = Math.max(ans, dp[i]);

        return ans;
    }

    // 2. Dijkstra Using Adjacency Matrix
    static int[] dijkstraMatrix(int graph[][], int src) {

        int n = graph.length;
        int dist[] = new int[n];
        boolean vis[] = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int cnt = 0; cnt < n - 1; cnt++) {

            int u = -1, min = Integer.MAX_VALUE;

            for(int i = 0;i < n;i++)
                if(!vis[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }

            if(u == -1) break;

            vis[u] = true;

            for(int v = 0; v < n; v++) {
                if(!vis[v] && graph[u][v] != 0 &&
                   dist[u] != Integer.MAX_VALUE &&
                   dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }

    // 3. Detect Cycle in Directed Graph (BFS)
    static boolean hasCycle(int n, int edges[][]) {

        int indegree[] = new int[n];

        for(int e[] : edges)
            indegree[e[1]]++;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i < n;i++)
            if(indegree[i] == 0)
                q.add(i);

        int count = 0;

        while(!q.isEmpty()) {

            int u = q.poll();
            count++;

            for(int e[] : edges) {

                if(e[0] == u) {
                    indegree[e[1]]--;
                    if(indegree[e[1]] == 0)
                        q.add(e[1]);
                }
            }
        }
        return count != n;
    }

    // 4. Minimum Cost Path in Weighted Grid
    static int minCostGrid(int grid[][]) {

        int n = grid.length, m = grid[0].length;
        int dist[][] = new int[n][m];
        boolean vis[][] = new boolean[n][m];

        for(int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = grid[0][0];

        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        for(int cnt = 0; cnt < n*m; cnt++) {

            int x = -1, y = -1, min = Integer.MAX_VALUE;

            for(int i = 0;i < n;i++)
                for(int j = 0;j < m;j++)
                    if(!vis[i][j] && dist[i][j] < min) {
                        min = dist[i][j];
                        x = i; y = j;
                    }

            if(x == -1) break;
            vis[x][y] = true;

            for(int d = 0; d < 4; d++) {

                int nx = x + dx[d], ny = y + dy[d];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m &&
                   !vis[nx][ny] &&
                   dist[x][y] + grid[nx][ny] < dist[nx][ny]) {

                    dist[nx][ny] = dist[x][y] + grid[nx][ny];
                }
            }
        }
        return dist[n-1][m-1];
    }

    // 5. Strongly Connected Components Count (Kosaraju)
    static int countSCC(int n, int edges[][]) {

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<ArrayList<Integer>> rg = new ArrayList<>();

        for(int i = 0;i < n;i++) {
            g.add(new ArrayList<>());
            rg.add(new ArrayList<>());
        }

        for(int e[] : edges) {
            g.get(e[0]).add(e[1]);
            rg.get(e[1]).add(e[0]);
        }

        boolean vis[] = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i < n;i++)
            if(!vis[i])
                dfs1(i, g, vis, st);

        Arrays.fill(vis, false);
        int count = 0;

        while(!st.isEmpty()) {
            int v = st.pop();
            if(!vis[v]) {
                dfs2(v, rg, vis);
                count++;
            }
        }
        return count;
    }

    static void dfs1(int u, ArrayList<ArrayList<Integer>> g,
                     boolean vis[], Stack<Integer> st) {

        vis[u] = true;
        for(int v : g.get(u))
            if(!vis[v])
                dfs1(v, g, vis, st);

        st.push(u);
    }

    static void dfs2(int u, ArrayList<ArrayList<Integer>> g,
                     boolean vis[]) {

        vis[u] = true;
        for(int v : g.get(u))
            if(!vis[v])
                dfs2(v, g, vis);
    }
}
