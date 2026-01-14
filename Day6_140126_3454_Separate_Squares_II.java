public class Day6_140126_3454_Separate_Squares_II {
    class Ev {
        int y;
        int t;
        int x;
        int s;

        Ev(int y, int t, int x, int s) {
            this.y = y;
            this.t = t;
            this.x = x;
            this.s = s;
        }
    }

    class Seg {
        int n;
        int[] cnt;
        double[] len;
        int[] xs;

        Seg(int[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            cnt = new int[4 * n];
            len = new double[4 * n];
        }

        void upd(int i, int l, int r, int ql, int qr, int v) {
            if (qr <= l || r <= ql) return;

            if (ql <= l && r <= qr) {
                cnt[i] += v;
            } else {
                int m = (l + r) / 2;
                upd(i * 2, l, m, ql, qr, v);
                upd(i * 2 + 1, m, r, ql, qr, v);
            }

            if (cnt[i] > 0) {
                len[i] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                len[i] = 0;
            } else {
                len[i] = len[i * 2] + len[i * 2 + 1];
            }
        }
    }

    public double separateSquares(int[][] sq) {
        List<Ev> ev = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int[] a : sq) {
            int x = a[0], y = a[1], s = a[2];
            ev.add(new Ev(y, 1, x, s));
            ev.add(new Ev(y + s, -1, x, s));
            set.add(x);
            set.add(x + s);
        }

        int[] xs = set.stream().sorted().mapToInt(i -> i).toArray();
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < xs.length; i++) idx.put(xs[i], i);

        ev.sort(Comparator.comparingInt(e -> e.y));

        Seg st = new Seg(xs);
        double tot = 0;
        int py = ev.get(0).y;

        for (Ev e : ev) {
            int cy = e.y;
            tot += st.len[1] * (cy - py);
            st.upd(1, 0, st.n, idx.get(e.x), idx.get(e.x + e.s), e.t);
            py = cy;
        }

        double need = tot / 2;

        st = new Seg(xs);
        double cur = 0;
        py = ev.get(0).y;

        for (Ev e : ev) {
            int cy = e.y;
            double w = st.len[1];
            double dy = cy - py;

            if (cur + w * dy >= need) {
                return py + (need - cur) / w;
            }

            cur += w * dy;
            st.upd(1, 0, st.n, idx.get(e.x), idx.get(e.x + e.s), e.t);
            py = cy;
        }

        return py;
    }
}
