package club.throwable.cglib;

import net.sf.cglib.util.StringSwitcher;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/5 0:40
 */
public class StringSwitcherDemo {

	public static void main(String[] args) throws Exception {
		StringSwitcher stringSwitcher = StringSwitcher.create(new String[]{"one", "two"}, new int[]{1, 2}, true);
		System.out.println(stringSwitcher.intValue("one"));
		System.out.println(stringSwitcher.intValue("two"));
	}
}
