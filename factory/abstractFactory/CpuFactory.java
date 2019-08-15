package factory.abstractFactory;

/**
 * 产品工厂类接口
 * Created by Sheldon on 2019/8/16.
 * Project Name: alstudy.
 * Package Name: factory.normal.
 */
public interface CpuFactory {
    public Cpu create(String model);
}
