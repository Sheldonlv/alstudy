package factory.abstractFactory;

/**
 * 抽象工厂模式的demo
 * Created by Sheldon on 2019/8/16.
 * Project Name: alstudy.
 * Package Name: factory.normal.
 */
public class Main {
    public static void main(String[] args) {
        // 生产 amd 产品
        CpuFactory factory = new AmdCpuFactory();
        Cpu amdCpu = factory.create("r5 3600");
        amdCpu.info();

        // 生产 intel 产品
        CpuFactory factory2 = new IntelCpuFactory();
        Cpu intelCpu = factory2.create("i7 9700k");
        intelCpu.info();
    }
}
