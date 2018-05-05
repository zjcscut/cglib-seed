package club.throwable.cglib;

import net.sf.cglib.reflect.MethodDelegate;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/5 9:51
 */
public class MethodDelegateDemo {

	interface MethodDelegateInterface {

		String getValueFromDelegate();
	}

	static class Delegate {

		private String value;

		public String getValue() {
			return value;
		}

		public Delegate setValue(String value) {
			this.value = value;
			return this;
		}
	}

	public static void main(String[] args) throws Exception {
		Delegate delegate = new Delegate();
		delegate.setValue("throwable");
		MethodDelegate methodDelegate = MethodDelegate.create(delegate, "getValue", MethodDelegateInterface.class);
		MethodDelegateInterface delegateInterface = (MethodDelegateInterface) methodDelegate;
		System.out.println(delegateInterface.getValueFromDelegate());
	}
}
