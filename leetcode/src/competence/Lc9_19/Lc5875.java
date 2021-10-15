package competence.Lc9_19;

public class Lc5875 {

    public int finalValueAfterOperations(String[] operations) {
        int res=0;
        for(String s:operations){
            if(s.charAt(0)=='+'||s.charAt(2)=='+'){
                res++;
            }
            else if(s.charAt(0)=='-'||s.charAt(2)=='-'){
                res--;
            }
        }
        return res;
    }
}
