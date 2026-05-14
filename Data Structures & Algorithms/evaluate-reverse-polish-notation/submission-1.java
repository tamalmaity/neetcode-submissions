class Solution {
    public int evalRPN(String[] tokens) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i=0;i<tokens.length;i++){
            if ("+".equals(tokens[i]) || "-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])){
                int num1 = nums.get(nums.size()-1);
                nums.remove(nums.size()-1);
                int num2 = nums.get(nums.size()-1);
                nums.remove(nums.size()-1);
                if ("+".equals(tokens[i]))nums.add(num1+num2);
                else if ("-".equals(tokens[i]))nums.add(num2-num1);
                else if ("*".equals(tokens[i]))nums.add(num1*num2);
                else nums.add(num2/num1);
            }
            else nums.add(Integer.valueOf(tokens[i]));
        }
        return nums.get(0);
    }
}
