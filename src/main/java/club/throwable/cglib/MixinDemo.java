package club.throwable.cglib;

import net.sf.cglib.proxy.Mixin;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/5 0:31
 */
public class MixinDemo {

	interface InterfaceFirst {

		String first();
	}

	interface InterfaceSecond {

		String second();
	}

	static class ImplFirst implements InterfaceFirst {

		@Override
		public String first() {
			return "I am first";
		}
	}

	static class ImplSecond implements InterfaceSecond {

		@Override
		public String second() {
			return "I am second";
		}
	}

	interface MixinImpl extends InterfaceFirst, InterfaceSecond {

	}

	public static void main(String[] args) throws Exception {
		Mixin mixin = Mixin.create(new Class[]{InterfaceFirst.class, InterfaceSecond.class, MixinImpl.class},
				new Object[]{new ImplFirst(), new ImplSecond()});
		MixinImpl mixinImpl = (MixinImpl) mixin;
		System.out.println(mixinImpl.first());
		System.out.println(mixinImpl.second());
	}
}
