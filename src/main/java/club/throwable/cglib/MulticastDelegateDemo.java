package club.throwable.cglib;

import net.sf.cglib.reflect.MulticastDelegate;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/5 9:54
 */
public class MulticastDelegateDemo {

	public interface DelegateProvider {

		void setValue(String value);
	}

	static class MulticastBean implements DelegateProvider {

		private String value;

		@Override
		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public static void main(String[] args) throws Exception {
		MulticastDelegate multicastDelegate = MulticastDelegate.create(DelegateProvider.class);
		MulticastBean first = new MulticastBean();
		MulticastBean second = new MulticastBean();
		multicastDelegate = multicastDelegate.add(first);
		multicastDelegate = multicastDelegate.add(second);
		DelegateProvider provider = (DelegateProvider) multicastDelegate;
		provider.setValue("throwable");
		System.out.println(first.getValue());
		System.out.println(second.getValue());
	}
}
