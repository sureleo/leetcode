public class Solution {
    public int length = 0;

    public List<String> result = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return result;
        }

        List<String> curr = new ArrayList<String>();
        this.length = s.length();
        this.dfs(curr, s, 0);
        return result;
    }

    public void dfs(List<String> curr, String s, int sumLength) {
        if (curr.size() == 4 && (sumLength == this.length)) {
            String fullIp = concateIpSeg(curr);
            result.add(fullIp);
            return;
        }

        if (s.length() < 4 - curr.size() || s.length() > (4 - curr.size()) * 3) {
            return;
        }

        for (int i = 0; i < Math.min(3, s.length()); i++) {
            String fPart = s.substring(0, i+1);
            if (i == 0 || i == 1 || i == 2 && (Integer.parseInt(fPart) <= 255)) {
                List<String> next = new ArrayList<String>(curr);
                next.add(fPart);
                this.dfs(next, s.substring(i+1, s.length()), sumLength + fPart.length());
                if (i == 0 && Integer.parseInt(fPart) == 0) {
                    break;
                }
            } else {
                return;
            }
        }
    }

    public String concateIpSeg(List<String> curr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(curr.get(i));
            if (i != 3) {
                sb.append(".");
            }
        }

        return sb.toString();
    }
}
