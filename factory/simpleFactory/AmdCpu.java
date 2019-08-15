package factory.simpleFactory;

/**
 * 产品实现类：AMD-CPU
 * Created by Sheldon on 2019/8/16.
 * Project Name: alstudy.
 * Package Name: factory.simple.
 */
public class AmdCpu implements Cpu{

    @Override
    public void info(){
        System.out.println("这是一颗农场的CPU");
    }
}
