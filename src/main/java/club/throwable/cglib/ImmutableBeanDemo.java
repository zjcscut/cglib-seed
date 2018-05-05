package club.throwable.cglib;

import lombok.Data;
import net.sf.cglib.beans.ImmutableBean;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/3 22:43
 */
public class ImmutableBeanDemo {

	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.setName("throwable");
		Person immutablePerson = (Person) ImmutableBean.create(person);
		System.out.println(immutablePerson.getName());
		person.setName("doge");
		System.out.println(immutablePerson.getName());
		immutablePerson.setName("throwable-doge");
		System.out.println(immutablePerson.getName());
	}

	@Data
	private static class Person {

		private String name;
	}
}
