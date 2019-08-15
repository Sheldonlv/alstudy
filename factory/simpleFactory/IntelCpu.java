package factory.simpleFactory;

/**
 * 产品实现类：Intel-CPU
 * Created by Sheldon on 2019/8/16.
 * Project Name: alstudy.
 * Package Name: factory.simple.
 */
public class IntelCpu implements Cpu{

    @Override
    public void info(){
        System.out.println("这是一颗英特尔的CPU");
    }
}
