class Solution {
    List<String> telCombinations = new ArrayList<>();
    Map<Integer,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return telCombinations;
        getMap();
        phoneCombinations(digits,"");
        return telCombinations;
    }
    public void getMap() {
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
    }
    public void phoneCombinations(String digits,String psf) {
        if(digits.length()==0) {
            telCombinations.add(psf);
            return;
        }
        char ch = digits.charAt(0);
        Integer num = Integer.parseInt(""+ch);
        String ros = digits.substring(1);
        String kp = map.get(num);
        for(int i=0;i<kp.length();i++) {
            char c = kp.charAt(i);
            phoneCombinations(ros,psf+c);
        }
    }
}