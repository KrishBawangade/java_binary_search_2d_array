public class SortedMatrixSearch{

    static int[] search(int[][] arr, int target){

        // row range
        int rowLow = 0;
        int rowHigh = arr.length-1;

        // column range
        int colLow = 0;
        int colHigh = arr[0].length-1;

        if(arr.length == 1){
            int colIndex = binarySearch(arr[0], target, colLow, colHigh);
            
            if(colIndex == -1){
                return new int[] {};
            }else{
                return new int[] {rowLow, colIndex};
            }
        }

        // run loop until 2 rows are remaining
        while((rowHigh-rowLow>1)){
            int rowMid = rowLow + (rowHigh-rowLow)/2;
            int element = arr[rowMid][colHigh];

            /*
                If target = element,
                    Return the index
            */
           if(target == element){
                return new int[] {rowMid, colHigh};
           }
           
           /*
                1. If target> last element,
                eliminate rows including the mid and search below rows

                2. else target< last element,
                eliminate rows below it and search in above rows including mid
           */
           if(target>element){
                rowLow = rowMid+1;
           }else{
                rowHigh= rowMid;
           }
        }

        int element = arr[rowLow][colHigh]; // last element of first row

        // if target = last element of first row, return the index
        if(target == element){
            return new int[] {rowLow, colHigh};
        }

        // if target > last element of first row, search in second row
        if(target>element){
            int colIndex = binarySearch(arr[rowLow+1], target, 0, colHigh);
            if(colIndex == -1){
                return new int[] {};
            }else{
                return new int[] {rowLow+1, colIndex};
            }
        }else{
            // if target < last element of first row, search in first row
            int colIndex = binarySearch(arr[rowLow], target, 0, colHigh);
            if(colIndex == -1){
                return new int[] {};
            }else{
                return new int[] {rowLow, colIndex};
            }
        }
    }

    static int binarySearch(int[] arr, int target, int low, int high){
        while(low<=high){
            int mid = low+ (high-low)/2;
            int element = arr[mid];

            if(target == element){
                return mid;
            }

            if(target>element){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr =  {
            {11,15,25,26},
            {27,28,29,33},
            {35,37,41,47},
            {53,57,63,69},
        };

        int target = 24;

        int[] res = search(arr, target);

        if(res.length!=0){
            System.out.printf("Target (%d) found at row %d column %d", target, res[0], res[1]);
        }else{
            System.out.printf("Target (%d) not found in the array", target);
        }
    }
}