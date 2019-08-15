package factory.abstractFactory;

/**
 * Created by Sheldon on 2019/8/16.
 * Project Name: alstudy.
 * Package Name: factory.normal.
 */
public class IntelCpu implements Cpu{

    @Override
    public void info(){
        System.out.println("这是一颗英特尔的CPU");
    }
}
