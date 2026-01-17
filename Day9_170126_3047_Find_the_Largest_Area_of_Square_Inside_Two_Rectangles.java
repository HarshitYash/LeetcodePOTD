public class Day9_170126_3047_Find_the_Largest_Area_of_Square_Inside_Two_Rectangles {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long answer = 0;

        for (int i = 0; i < bottomLeft.length; i++) {
            for (int j = i + 1; j < bottomLeft.length; j++) {

                int w = Math.min(topRight[i][0], topRight[j][0]) - Math.max(bottomLeft[i][0], bottomLeft[j][0]);

                int h = Math.min(topRight[i][1], topRight[j][1]) - Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                if (w > 0 && h > 0) {
                    answer = Math.max(answer, Math.min(w, h));
                }
            }
        }

        return answer * answer;
    }
}
