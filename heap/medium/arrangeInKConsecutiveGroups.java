class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i:hand) map.put(i,map.getOrDefault(i,0)+1);
        while(!map.isEmpty()){
            int peek = map.firstKey();
            for(int i=0; i<groupSize; i++){
                if(map.containsKey(peek+i)){
                    map.replace(peek+i,map.get(peek+i)-1);
                    if(map.get(peek+i)==0) map.remove(peek+i);
                }else return false;
            }
        }
        return true;
    }
}