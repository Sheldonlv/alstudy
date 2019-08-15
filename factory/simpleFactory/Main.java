package factory.simpleFactory;

/**
 * 这是一个简单工程模式的 demo
 * Created by Sheldon on 2019/8/16.
 * Project Name: alstudy.
 * Package Name: factory.simple.
 */
public class Main {
    public static void main(String[] args) {
        // 创建工厂类
        CpuFactory factory = new CpuFactory();
        // 使用工厂生产出对应产品
        Cpu amd = factory.create("amd");
        Cpu intel = factory.create("intel");
        // 检测产品信息
        amd.info();
        intel.info();
    }
}
