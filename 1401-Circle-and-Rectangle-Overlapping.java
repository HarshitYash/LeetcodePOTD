class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        long px = Math.max(x1, Math.min(xCenter, x2));
        long py = Math.max(y1, Math.min(yCenter, y2));
        long d2 = ((xCenter - px) * (xCenter - px)) + ((yCenter - py) * (yCenter - py));
        return d2 <= (radius * radius);
    }
}