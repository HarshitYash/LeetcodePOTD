public class Day23_310126_744_Find_Smallest_Letter_Greater_Than_Target {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char c : letters)
            if(c > target)
                return c;
        return letters[0];
    }
}
