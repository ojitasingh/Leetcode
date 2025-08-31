class Solution {
    public boolean isPathCrossing(String path) {
        Set<Integer> seen = new HashSet<>();
        seen.add(0);

        int x = 0, y = 0;

        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            
            int key = x * 20001 + y;
            if (seen.contains(key)) {
                return true;
            }
            seen.add(key);
        }

        return false;
    }
}
