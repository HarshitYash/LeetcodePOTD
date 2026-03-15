public class Day66_150326_1622_Fancy_Sequence {
    ArrayList<Long> list;
    long add;
    long multi;
    long MOD = 1_000_000_007L;
    long power(long a, long b) {
        if (b == 0)
            return 1;

        long half   = power(a, b / 2);
        long result = (half * half) % MOD;

        if (b % 2 == 1) {
            result = (result * a) % MOD;
        }
        return result;
    }
    public Fancy() {
        list = new ArrayList<>();
        add = 0;
        multi = 1;
    }

    public void append(int val) {
        list.add(((val-add)%MOD + MOD)*power(multi,MOD-2)%MOD);
    }

    public void addAll(int inc) {
        add = ((long)add + inc) % MOD;
    }

    public void multAll(int m) {
        add = ((long)add * m) % MOD;
        multi = ((long)multi * m) % MOD;
    }

    public int getIndex(int idx) {
        if(idx >= list.size()) return -1;
        long answer = ((list.get(idx) * multi)%MOD + add)%MOD;
        return (int)answer;
    }
}
