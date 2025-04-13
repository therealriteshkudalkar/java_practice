package problem88;

public class Problem88 {
    private boolean canTransformRec(String start, String result) {
        if (start.length() != result.length()) {
            return false;
        }

        if (!start.replace("X", "").equals(result.replace("X", ""))) {
            return false;
        }

        int i = 0;
        int j = 0;

        while(i < start.length() && j < result.length()) {
            while(i < start.length() && start.charAt(i) == 'X')
                i++;
            while(j < result.length() && result.charAt(j) == 'X')
                j++;

            // if we reach the end of the string simultaneously
            if (i == start.length() && j == result.length())
                return true;

            // if only one of them has reached the end of string
            if (i == start.length() || j == result.length())
                return false;

            // We must reach 'L' in start before we reach 'L' in result as 'L' can only move left
            if (start.charAt(i) == 'L' && i < j)
                return false;

            // We must reach 'R' in start after we reach 'R' in result as 'R' can only move right
            if (start.charAt(i) == 'R' && i > j)
                return false;

            i++;
            j++;
        }
        return true;
    }

    public boolean canTransform(String start, String result) {
        // lastSeen char
        // RXL -> RLX
        // (lastSeen + currentChar -> XL) -> (LX) and check if it matches or (let it be same)
        // (lastSeen + currentChar -> RX) -> (XR) or (let it be the same)
        return canTransformRec(start, result);
    }
}
