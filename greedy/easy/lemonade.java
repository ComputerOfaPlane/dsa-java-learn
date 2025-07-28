class Solution {
    public boolean lemonadeChange(int[] bills) {
        int map[] = {0,0,0};
        for(int bill:bills){
            switch(bill){
                case 5:
                    map[0]+=1;
                    break;
                case 10:
                    if(map[0]==0) return false;
                    map[1]+=1;
                    map[0]-=1;
                    break;
                case 20:
                    if(map[0]==0) return false;
                    map[2]+=1;
                    if(map[1]==0){
                        if(map[0]>2){
                            map[0]-=3;
                        }else return false;
                    }else{
                        map[1]-=1;
                        map[0]-=1;
                    }
                    break;
            }
        }
        return true;
    }
}