class Solution {
    public List<String> braceExpansionII(String expression) {
        HashSet<String> set = new HashSet();
        expand(expression, set);   
        List<String> ans = new ArrayList(set);
        Collections.sort(ans);
        return ans;
    }
    private void expand(String exp, HashSet<String> set) {
        int end = exp.indexOf('}');
        if (end == -1) { 
            set.add(exp);
            return;
        }
        int start = end;
        while (exp.charAt(start) != '{') {
            start--;
        }
        String[] arr = exp.substring(start + 1, end).split(",");
        String pre = exp.substring(0, start);
        String post = exp.substring(end + 1);       
        for (String curr: arr) {
            expand(pre + curr + post, set);
        }
    }
}