package club.throwable.cglib;

import net.sf.cglib.beans.BeanGenerator;

import java.lang.reflect.Method;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/3 22:48
 */
public class BeanGeneratorDemo {

	public static void main(String[] args) throws Exception {
		BeanGenerator beanGenerator = new BeanGenerator();
		beanGenerator.addProperty("name", String.class);
		Object target = beanGenerator.create();
		Method setter = target.getClass().getDeclaredMethod("setName", String.class);
		Method getter = target.getClass().getDeclaredMethod("getName");
		setter.invoke(target, "throwable");
		System.out.println(getter.invoke(target));
	}
}
