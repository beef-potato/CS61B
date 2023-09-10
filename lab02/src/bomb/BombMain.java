package bomb;

import common.IntList;

public class BombMain {
    public static void main(String[] args) {
        int phase = 2;
        if (args.length > 0) {
            phase = Integer.parseInt(args[0]);
        }
        // TODO: Find the correct passwords to each phase using debugging techniques
        Bomb b = new Bomb();
        if (phase >= 0) {
            b.phase0("39291226");
        }
        if (phase >= 1) {
            b.phase1(IntList.of(0,9,3,0,8)); // Figure this out too
        }
        if (phase >= 2) {
            b.phase2(passwordPhase2());
        }
    }

    public static String passwordPhase2(){
        int loopTime =  1337;
        String pass = "";
        for (int i=0;i<loopTime;i++){
            pass = pass + "0 ";
        }
        pass += "-81201430";
        System.out.println(pass);
        return pass;
    }

}
