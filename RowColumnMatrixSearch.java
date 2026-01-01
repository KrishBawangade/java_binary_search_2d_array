public class RowColumnMatrixSearch{

    static int[] search(int[][] arr, int target){
        int row = 0;
        int column = arr[0].length-1;

        
        while(row!=arr.length || column!=-1){
            int element = arr[row][column];

            // if target found return the row and column index of that target
            if(target ==element){
                return new int[] {row, column};
            }

            
            if(target>element){
                // if target is greater than element eliminate that row 
                row ++;
            }else{
                // if target is smaller than element eliminate that column
                column--;
            }
        }

        return new int[] {}; // return empty array if element not found
    }

    public static void main(String[] args) {
        int[][] arr =  {
            {11,15,25,26},
            {21,27,29,33},
            {35,37,41,47},
            {53,57,63,69},
            {72,79,83,85}
        };

        int target = 85;

        int[] res = search(arr, target);

        if(res.length!=0){
            System.out.printf("Target (%d) found at row %d column %d", target, res[0], res[1]);
        }else{
            System.out.printf("Target (%d) not found in the array", target);
        }
    }
}