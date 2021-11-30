import java.util.Random;

public interface EnemyAttacker {
    public void FireWeapon();
    public void driverForward();
    public void assignDriver(String driver);
}
class EnemyTank implements EnemyAttacker{
Random generator=new Random();
    @Override
    public void FireWeapon() {
        int attackDamage=generator.nextInt(10)+1;
        System.out.println("Enemy does "+attackDamage+" damage");
    }

    @Override
    public void driverForward() {
int movement=generator.nextInt(5)+1;
        System.out.println("Enemy tank moves "+movement+" spaces");
    }

    @Override
    public void assignDriver(String driver) {
        System.out.println(driver+" is driving the tank");
    }
}
class EnemyRobot{
    Random generator=new Random();
    public  void smashWithHands(){
        int attackdamage=generator.nextInt(10)+1;
        System.out.println("Every Robot causes "+attackdamage+" damage with hands ");
    }
    public void walkforward(){
        int movement=generator.nextInt(5)+1;
        System.out.println("Every Enemy robot moves "+movement+" spaces");
    }
    public void reactToHumans(String Driver){};
}
class EveryRobotAdapter implements EnemyAttacker{
EnemyRobot newRobot;

    public EveryRobotAdapter(EnemyRobot newRobot) {
        this.newRobot = newRobot;
    }

    @Override
    public void FireWeapon() {
        newRobot.smashWithHands();
    }

    @Override
    public void driverForward() {
newRobot.walkforward();
    }

    @Override
    public void assignDriver(String driver) {
newRobot.reactToHumans(driver);
    }
}
class TestEnemyAttacker{
    public static void main(String[] args) {
        EnemyTank rx7tank=new EnemyTank();
        EnemyRobot terminator=new EnemyRobot();
        EveryRobotAdapter robotAdapter=new EveryRobotAdapter(terminator);
        System.out.println("THE ROBOT");
        terminator.reactToHumans("Paul");
        terminator.walkforward();
        terminator.smashWithHands();
        System.out.println("THE ENEMY TANK");
        rx7tank.assignDriver("Jerry");
        rx7tank.FireWeapon();
        rx7tank.driverForward();
        System.out.println("THE ROBOT WITH THE ADAPTER");
        robotAdapter.assignDriver("Jack");
        robotAdapter.driverForward();
        robotAdapter.FireWeapon();
    }
}
