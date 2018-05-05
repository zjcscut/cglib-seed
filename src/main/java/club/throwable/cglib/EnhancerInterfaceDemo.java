package club.throwable.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/2 22:52
 */
public class EnhancerInterfaceDemo {

	public static void main(String[] args) throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setInterfaces(new Class[]{SampleInterface.class});
		enhancer.setCallback((FixedValue) () -> "Doge say hello!");
		SampleInterface sampleInterface = (SampleInterface) enhancer.create();
		System.out.println(sampleInterface.sayHello("throwable-10086"));
		System.out.println(sampleInterface.sayHello("throwable-doge"));
		System.out.println(sampleInterface.toString());
		System.out.println(sampleInterface.getClass());
		System.out.println(sampleInterface.hashCode());
	}
}
