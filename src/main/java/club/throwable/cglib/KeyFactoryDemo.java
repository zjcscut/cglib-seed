package club.throwable.cglib;

import net.sf.cglib.core.KeyFactory;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/5 0:24
 */
public class KeyFactoryDemo {

	public static void main(String[] args) throws Exception {
		KeyFactoryInterface keyFactoryInterface1 = (KeyFactoryInterface) KeyFactory.create(KeyFactoryInterface.class);
		KeyFactoryInterface keyFactoryInterface2 = (KeyFactoryInterface) KeyFactory.create(KeyFactoryInterface.class);
		System.out.println(keyFactoryInterface1 == keyFactoryInterface2);
		System.out.println(keyFactoryInterface1.equals(keyFactoryInterface2));
		Object key1 = keyFactoryInterface1.newInstance(1, "doge");
		Object key2 = keyFactoryInterface1.newInstance(1, "doge");
		System.out.println(key1.equals(key2));
		key2 = keyFactoryInterface1.newInstance(1, "doge10086");
		System.out.println(key1.equals(key2));
	}

	interface KeyFactoryInterface {

		Object newInstance(Integer a, String b);
	}
}
