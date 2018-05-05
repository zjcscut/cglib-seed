package club.throwable.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/2 22:32
 */
public class EnhancerClassDemo {

	public static void main(String[] args) throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SampleClass.class);
		enhancer.setCallback((FixedValue) () -> "Doge say hello!");
		SampleClass sampleClass = (SampleClass) enhancer.create();
		System.out.println(sampleClass.sayHello("throwable-10086"));
		System.out.println(sampleClass.sayHello("throwable-doge"));
		System.out.println(sampleClass.toString());
		System.out.println(sampleClass.getClass());
		System.out.println(sampleClass.hashCode());
	}
}
