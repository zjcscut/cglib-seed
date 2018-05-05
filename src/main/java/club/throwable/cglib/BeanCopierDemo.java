package club.throwable.cglib;

import lombok.Data;
import lombok.ToString;
import net.sf.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/3 22:31
 */
public class BeanCopierDemo {

	private static final Map<String, BeanCopier> CACHE = new ConcurrentHashMap<>();

	public static void main(String[] args) throws Exception {
		//这里useConverter设置为false,调用copy方法的时候不能传入转换器实例
		BeanCopier beanCopier;
		String key = generateCacheKey(Person.class, Person.class);
		if (CACHE.containsKey(key)) {
			beanCopier = CACHE.get(key);
		} else {
			beanCopier = BeanCopier.create(Person.class, Person.class, false);
			CACHE.put(key, beanCopier);
		}
		Person person = new Person();
		person.setId(10086L);
		person.setName("throwable");
		person.setAge(25);
		Person newPerson = new Person();
		beanCopier.copy(person, newPerson, null);
		System.out.println(newPerson);
	}

	private static String generateCacheKey(Class<?> source, Class<?> target) {
		return String.format("%s-%s", source.getName(), target.getName());
	}

	@ToString
	@Data
	private static class Person {

		private Long id;
		private String name;
		private Integer age;
	}
}
