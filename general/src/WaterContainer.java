class WaterContainer {
    public int maxArea(int[] height) {
        // brute force solution
        int maxArea = 0;
        int j = height.length-1;
        int i = 0;
        while (i<j){
            int val1 = height[i];
            int val2 = height[j];
            int min = Math.min(val1, val2);
            int area = min * (j-i);
            maxArea = Math.max(maxArea, area);
            if (val1<val2) {
                i++;
            }else {
                j--;
            }

        }

        return maxArea;

    }
}