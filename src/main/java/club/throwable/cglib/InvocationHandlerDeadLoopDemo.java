package club.throwable.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/2 23:27
 */
public class InvocationHandlerDeadLoopDemo {

	public static void main(String[] args) throws Exception{
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SampleClass.class);
		enhancer.setCallback(new InvocationHandler() {
			@Override
			public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
				return method.invoke(o, objects);
			}
		});
		SampleClass sampleClass = (SampleClass) enhancer.create();
		System.out.println(sampleClass.sayHello("throwable"));
	}
}
