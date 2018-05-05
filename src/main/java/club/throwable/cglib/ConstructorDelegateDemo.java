package club.throwable.cglib;

import net.sf.cglib.reflect.ConstructorDelegate;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/5 10:00
 */
public class ConstructorDelegateDemo {

	public interface ConstructorInterface {

		Object newInstance(String value);
	}

	static class ConstructorImpl {

		private String value;

		public ConstructorImpl(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public ConstructorImpl setValue(String value) {
			this.value = value;
			return this;
		}
	}

	public static void main(String[] args) throws Exception {
		ConstructorInterface constructorInterface =
				(ConstructorInterface) ConstructorDelegate.create(ConstructorImpl.class, ConstructorInterface.class);
		ConstructorImpl constructorImpl = (ConstructorImpl) constructorInterface.newInstance("throwable");
		System.out.println(ConstructorImpl.class.isAssignableFrom(constructorImpl.getClass()));
		System.out.println(constructorImpl.getValue());
	}
}
