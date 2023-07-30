public class OnBoardComputer implements BurnStream {

    boolean tester = true;
    int numOfTurns;
    int numBeforeCrash;
    @Override
    public int getNextBurn(DescentEvent status) {
        int burn = 100;
        numOfTurns = status.Velocity / 100;
        numBeforeCrash = status.Altitude / status.Velocity;
        if(tester) {
            if (numOfTurns > numBeforeCrash) {
                burn =  200;
            }
            if (numOfTurns == 1 && numBeforeCrash == 1) {
                tester = false;
                burn = 150;
            }
            System.out.println(burn);
            return burn;
        }
        if(status.Altitude > 100){
            burn = 100;
        }
        else{
            burn = 100 + (status.Velocity/2);
        }
        System.out.println(burn);
        return burn;
    }



}
