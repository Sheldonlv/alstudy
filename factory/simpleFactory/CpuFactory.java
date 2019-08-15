package factory.simpleFactory;

/**
 * 工厂类：创建用户所需产品
 * Created by Sheldon on 2019/8/16.
 * Project Name: alstudy.
 * Package Name: factory.simple.
 */
public class CpuFactory {

    /**
     * 创建CPU
     * @param type
     * @return
     */
    public Cpu create(String type){
        if (type.equals("intel")){
            System.out.println("生产了一颗 intel 的CPU");
            return new IntelCpu();
        }else if(type.equals("amd")){
            System.out.println("生产了一颗 amd 的CPU");
            return new AmdCpu();
        }else {
            return null;
        }
    }
}
