package factory.abstractFactory;

/**
 * Created by Sheldon on 2019/8/16.
 * Project Name: alstudy.
 * Package Name: factory.normal.
 */
public class AmdCpu implements Cpu{

    @Override
    public void info(){
        System.out.println("这是一颗农场的CPU");
    }
}
