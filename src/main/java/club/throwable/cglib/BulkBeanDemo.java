package club.throwable.cglib;

import lombok.Data;
import net.sf.cglib.beans.BulkBean;

import java.util.Arrays;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/3 22:56
 */
public class BulkBeanDemo {

	public static void main(String[] args) throws Exception {
		BulkBean bulkBean = BulkBean.create(
				Person.class,
				new String[]{"getName"},
				new String[]{"setName"},
				new Class[]{String.class});
		Person person = new Person();
		person.setName("throwable");
		Object[] propertyValues = bulkBean.getPropertyValues(person);
		System.out.println(Arrays.toString(propertyValues));
		bulkBean.setPropertyValues(person, new Object[]{"doge"});
		System.out.println(person.getName());
	}

	@Data
	private static class Person {

		private String name;
	}
}
