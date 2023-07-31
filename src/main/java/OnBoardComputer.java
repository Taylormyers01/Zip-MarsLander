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
            if(numOfTurns - numBeforeCrash > 3){
                burn = 250;
            }
            if (numOfTurns <= 1 && numBeforeCrash <= 1) {
                tester = false;
                burn = 150;
            }
            if(status.Velocity - (burn - 100) == 0){
                burn --;
            }
            if(burn > status.Altitude){
                if(status.Altitude % 2 == 0)
                    burn = 100 + status.Velocity - 2;
                else
                    burn = 100 + status.Velocity - 3;
            }
            System.out.println(burn);
            return burn;
        }
        if(status.Altitude > 100){
            burn = 100;
        }
        if (status.Altitude % 2 == 0 && status.Altitude <= 100) {
            burn = 100 + status.Velocity - 2;
        } else if (!(status.Altitude % 2 == 0) && status.Altitude <= 100) {
            burn = 100 + status.Velocity - 1;
        }


        System.out.println(burn);
        return burn;
    }


    /**
     *  public int getNextBurn(DescentEvent status) {
     *         int burn = 100; // default burn of 100
     *         numOfTurns = status.Velocity / 100; // num of turns to completely stop
     *         numBeforeCrash = status.Altitude / status.Velocity; // number of turns before we crash at current velocity
     *         if(tester) {
     *             if (numOfTurns > numBeforeCrash) { //
     *                 burn =  200;
     *             }
     *             if(numOfTurns - numBeforeCrash > 3){
     *                 burn = 250;
     *             }
     *             if (numOfTurns <= 1 && numBeforeCrash <= 1) {
     *                 tester = false;
     *                 burn = 150;
     *             }
     *             if(status.Velocity - (burn - 100) == 0){
     *                 burn --;
     *             }
     *             if(burn > status.Altitude){
     *                 if(status.Altitude % 2 == 0)
     *                     burn = 100 + status.Velocity - 2;
     *                 else
     *                     burn = 100 + status.Velocity - 3;
     *             }
     *             System.out.println(burn);
     *             return burn;
     *         }
     *         if(status.Altitude > 100){
     *             burn = 100;
     *         }
     *         if (status.Altitude % 2 == 0 && status.Altitude <= 100) {
     *             burn = 100 + status.Velocity - 2;
     *         } else if (!(status.Altitude % 2 == 0) && status.Altitude <= 100) {
     *             burn = 100 + status.Velocity - 1;
     *         }
     *
     *
     *         System.out.println(burn);
     *         return burn;
     *     }
     */



}
