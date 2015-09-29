public class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(".") || strs[i].length() == 0) {
                continue;
            } else if (strs[i].equals("..")) {
                if (list.size() == 0) {
                    continue;
                } else {
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(strs[i]);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append("/");
            }
        }

        return sb.toString();
    }
}
