package club.throwable.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/2 23:16
 */
public class NoOpDemo {

	public static void main(String[] args) throws Exception{
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SampleClass.class);
		enhancer.setCallback(NoOp.INSTANCE);
		SampleClass sampleClass = (SampleClass) enhancer.create();
		System.out.println(sampleClass.sayHello("throwable"));
	}
}
