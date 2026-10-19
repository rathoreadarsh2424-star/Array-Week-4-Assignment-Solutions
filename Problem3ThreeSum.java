import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Problem3ThreeSum {
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> triples = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                long sum = (long)nums[i] + nums[left] + nums[right];
                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    triples.add(new int[]{nums[i], nums[left], nums[right]});
                    left++; right--;
                    while (left < right && nums[left] == nums[left-1]) left++;
                    while (left < right && nums[right] == nums[right+1]) right--;
                }
            }
        }
        return triples.toArray(new int[triples.size()][]);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(threeSum(new int[]{-1,0,1,2,-1,-4})));
        System.out.println(Arrays.deepToString(threeSum(new int[]{0,0,0})));
    }
}
