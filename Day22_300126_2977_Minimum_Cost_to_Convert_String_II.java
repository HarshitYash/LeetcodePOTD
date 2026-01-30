public class Day22_300126_2977_Minimum_Cost_to_Convert_String_II {
    long[] dp;
    long INF = 1000L * 100L * 1000000L;
    Map<Integer, Set<String>> lenMap;
    Map<String, Map<String, Long>> costMap;

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        dp = new long[source.length() + 1];
        Arrays.fill(dp, -1);

        lenMap = new HashMap<>();
        costMap = new HashMap<>();

        for (int i = 0; i < original.length; i++) {
            int l = original[i].length();
            lenMap.putIfAbsent(l, new HashSet<>());
            lenMap.get(l).add(original[i]);

            costMap.putIfAbsent(original[i], new HashMap<>());
            Map<String, Long> mp = costMap.get(original[i]);

            if (mp.containsKey(changed[i])) {
                mp.put(changed[i], Math.min(mp.get(changed[i]), (long) cost[i]));
            } else {
                mp.put(changed[i], (long) cost[i]);
            }
        }

        for (Map.Entry<Integer, Set<String>> e : lenMap.entrySet()) {
            Set<String> st = e.getValue();
            for (String m : st) {
                for (String a : st) {
                    Map<String, Long> fromA = costMap.get(a);
                    if (fromA != null && fromA.containsKey(m)) {
                        Map<String, Long> fromM = costMap.get(m);
                        if (fromM != null) {
                            for (Map.Entry<String, Long> en : fromM.entrySet()) {
                                String b = en.getKey();
                                long v = en.getValue();
                                fromA.putIfAbsent(b, INF + 1);
                                long nv = Math.min(fromA.get(b), fromA.get(m) + v);
                                fromA.put(b, nv);
                            }
                        }
                    }
                }
            }
        }

        long ans = dfs(0, source, target);
        return ans > INF ? -1 : ans;
    }

    long dfs(int i, String source, String target) {
        if (i >= source.length()) return 0;

        if (dp[i] == -1) {
            dp[i] = INF + 1;

            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dfs(i + 1, source, target);
            }

            for (Map.Entry<Integer, Set<String>> e : lenMap.entrySet()) {
                int l = e.getKey();
                if (i + l <= source.length()) {
                    String ss = source.substring(i, i + l);
                    String ts = target.substring(i, i + l);
                    if (costMap.containsKey(ss)) {
                        Map<String, Long> mp = costMap.get(ss);
                        if (mp.containsKey(ts)) {
                            long v = mp.get(ts) + dfs(i + l, source, target);
                            dp[i] = Math.min(dp[i], v);
                        }
                    }
                }
            }
        }

        return dp[i];
    }
}
