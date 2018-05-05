package club.throwable.cglib;

import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/5 9:45
 */
public class FastClassDemo {

	public static void main(String[] args) throws Exception {
		FastClass fastClass = FastClass.create(SampleClass.class);
		FastMethod fastMethod = fastClass.getMethod("sayHello", new Class[]{String.class});
		SampleClass sampleClass = new SampleClass();
		System.out.println(fastMethod.invoke(sampleClass, new Object[]{"throwable"}));
		System.out.println(fastMethod.getIndex());
	}
}
