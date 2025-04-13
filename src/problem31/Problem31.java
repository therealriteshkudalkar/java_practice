package problem31;

import java.util.ArrayList;
import java.util.List;

public class Problem31 {
    static class Segment {
        private int startIndex;
        private int endIndex;
        private int setBitCount;
        private int largestElement;
        private int smallestElement;

        public Segment(int startIndex, int endIndex, int setBitCount, int smallestElement, int largestElement) {
            this.startIndex = startIndex;
            this.smallestElement = smallestElement;
            this.endIndex = endIndex;
            this.setBitCount = setBitCount;
            this.largestElement = largestElement;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public int getSetBitCount() {
            return setBitCount;
        }

        public int getLargestElement() {
            return largestElement;
        }

        public int getSmallestElement() {
            return smallestElement;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

        public void setLargestElement(int largestElement) {
            this.largestElement = largestElement;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public void setSetBitCount(int setBitCount) {
            this.setBitCount = setBitCount;
        }

        public void setSmallestElement(int smallestElement) {
            this.smallestElement = smallestElement;
        }
    }

    private short calculateSetBit(int n) {
        short count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public boolean canSortArray(int[] nums) {
        List<Segment> segmentList = new ArrayList<>();
        Segment currentSegment = null;
        for (int i = 0; i < nums.length; i++) {
            int setBits = calculateSetBit(nums[i]);
            if (currentSegment == null || currentSegment.getSetBitCount() != setBits) {
                currentSegment = new Segment(i, i, setBits, nums[i], nums[i]);
                segmentList.add(currentSegment);
            } else {
                // Current element has the same number of set bits as in the current segment, so update the segment
                currentSegment.setEndIndex(i);
                currentSegment.setLargestElement(Math.max(nums[i], currentSegment.getLargestElement()));
                currentSegment.setSmallestElement(Math.min(nums[i], currentSegment.getSmallestElement()));
            }
        }
        if (segmentList.size() < 2) {
            return true;
        }

        for (int i = 0; i < segmentList.size() - 1; i++) {
            Segment thisSegment = segmentList.get(i);
            Segment nextSegment = segmentList.get(i + 1);

            // Check if the segment size is greater than
            if(thisSegment.getLargestElement() > nextSegment.getSmallestElement()) {
                return false;
            }
        }
        return true;
    }
}
