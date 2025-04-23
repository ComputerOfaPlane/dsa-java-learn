/*
conver integer number to roman number equivalent

my approach:
store every thing required in a 2d array
for each number extracted from left add it to answer accordingly
*/
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[][] dict = {{'I','V'},{'X','L'},{'C','D'},{'M','@'}};
        int counter = 0; 
        while(num>0){
            StringBuilder word = new StringBuilder();
            int last = num%10;
            switch(last){
                case 5:
                case 6:
                case 7:
                case 8:
                word.append(dict[counter][1]);
                last-=5;
                case 1:
                case 2:
                case 3:
                for(int i=1; i<=last;i++) word.append(dict[counter][0]);
                break;
                case 4:
                word.append(dict[counter][0]);
                word.append(dict[counter][1]);
                break;
                case 9:
                word.append(dict[counter][0]);
                word.append(dict[counter+1][0]);
            }
            sb.insert(0,word);
            counter++;
            num = num/10;
        }
        return new String(sb);
    }
}