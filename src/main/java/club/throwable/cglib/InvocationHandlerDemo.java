package club.throwable.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/2 23:35
 */
public class InvocationHandlerDemo {

	public static void main(String[] args) throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SampleClass.class);
		enhancer.setCallback(new InvocationHandler() {
			@Override
			public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
				if (!Objects.equals(method.getDeclaringClass(), Object.class) && Objects.equals(String.class, method.getReturnType())) {
					return String.format("%s say hello!", objects);
				}
				return "No one say hello!";
			}
		});
		SampleClass sampleClass = (SampleClass) enhancer.create();
		System.out.println(sampleClass.sayHello("throwable"));
	}
}
