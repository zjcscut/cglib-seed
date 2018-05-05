package club.throwable.cglib;


import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.InterfaceMaker;
import org.objectweb.asm.Type;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/5 0:43
 */
public class InterfaceMakerDemo {

	public static void main(String[] args) throws Exception {
		Signature signature = new Signature("foo", Type.DOUBLE_TYPE, new Type[]{Type.INT_TYPE});
		InterfaceMaker interfaceMaker = new InterfaceMaker();
		interfaceMaker.add(signature, new Type[0]);
		Class<?> clazz = interfaceMaker.create();
		Method[] methods = clazz.getMethods();
		System.out.println(methods.length);
		Method foo = methods[0];
		System.out.println(foo.getReturnType());
		System.out.println(Arrays.toString(foo.getParameterTypes()));
	}
}
