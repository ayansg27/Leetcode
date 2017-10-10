public class HammingDistance {
    public int hammingDistanceSol(int x, int y) {
        int count=0;
        while(x>0 || y>0){
            int a=x%2;
            int b=y%2;
            if(a!=b) count++;
            x=x/2;
            y=y/2;
        }
        return count;
    }
}