public class Day86_040426_2075_Decode_the_Slanted_Ciphertext {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;
        int n = encodedText.length();
        int cols = n / rows;
        char[][] mat = new char[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                mat[i][j] = encodedText.charAt(i * cols + j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int a = 0; a < cols; a++){
            int i = 0, j = a;
            while(i < rows && j < cols){
                sb.append(mat[i][j]);
                i++;
                j++;
            }
        }
        return sb.toString().stripTrailing();
    }
}
