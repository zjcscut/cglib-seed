package club.throwable.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/2 23:10
 */
public class MethodInterceptorDemo {

	private static final String METHOD_NAME = "sayHello";

	public static void main(String[] args) throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SampleClass.class);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
				Object result;
				if (METHOD_NAME.equals(method.getName())) {
					System.out.println("Before invoking sayHello...");
					result = methodProxy.invokeSuper(obj, objects);
					System.out.println("After invoking sayHello...");
				} else {
					result = methodProxy.invokeSuper(obj, objects);
				}
				return result;
			}
		});
		SampleClass sampleClass = (SampleClass) enhancer.create();
		System.out.println(sampleClass.sayHello("throwable"));
	}
}
