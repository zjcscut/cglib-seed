package club.throwable.cglib;

import lombok.Data;
import net.sf.cglib.beans.BeanMap;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/3 23:02
 */
public class BeanMapDemo {

	public static void main(String[] args) throws Exception{
		Person person = new Person();
		person.setName("throwable");
		BeanMap beanMap = BeanMap.create(person);
		System.out.println(beanMap);
		System.out.println(beanMap.get("name"));
	}

	@Data
	private static class Person {

		private String name;
	}
}
