package factory.abstractFactory;

/**
 * Created by Sheldon on 2019/8/16.
 * Project Name: alstudy.
 * Package Name: factory.abstractFactory.
 */
public class AmdCpuFactory implements CpuFactory{

    @Override
    public Cpu create(String model){
        System.out.println("生产了一颗型号为 "+model+" 的 AMD-CPU");
        return new AmdCpu();
    }
}
