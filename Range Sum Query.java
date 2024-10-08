//Day 45 of #CrackYourInternship
public class NumArray {

    class SegmentTreeNode {
        private int start, end;
        private  SegmentTreeNode left, right;
        private  int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start]; // leaf nodes
            } else {
                int mid = start  + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    void update(int i, int val) {
        updateHelper(root, i, val);
    }

    void updateHelper(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {

                updateHelper(root.left, pos, val);
            } else {
                updateHelper(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }

    public int sumRangeHelper(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end ) {
            return root.sum;
        } else {

            int mid = root.start + (root.end - root.start) / 2; // overflow conditions
            if (end <= mid) {
                return sumRangeHelper(root.left, start, end);
            } else if (start >= mid+1) {
                return sumRangeHelper(root.right, start, end);
            }  else {
                return  sumRangeHelper(root.left, start, mid) + sumRangeHelper(root.right, mid+1, end) ;
            }
        }
    }
}
