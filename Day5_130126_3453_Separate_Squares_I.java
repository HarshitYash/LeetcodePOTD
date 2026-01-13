public class Day5_130126_3453_Separate_Squares_I {
    public double separateSquares(int[][] squares) {
        double left = Double.MAX_VALUE, right = 0.0;
        double area = 0.0;
        for(int[] square : squares){
            double y1 = square[1];
            double side = square[2];

            area += side*side;
            left = Math.min(left, y1);
            right = Math.max(right, y1+side);
        }
        while(right - left > 1e-5){
            double mid = (left+right)/2;
            double above = findArea(squares,mid);
            double below = area - above;
            if(above > below){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public double findArea(int[][] squares, double y){
        double area = 0.0;
        for(int[] square : squares){
            double y1 = square[1];
            double side = square[2];
            if(y1 >= y){
                area += side*side;
            }else if(y1+side > y){
                area += side*(y1+side-y);
            }
        }
        return area;
    }
}
