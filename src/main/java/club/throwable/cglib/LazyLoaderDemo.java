package club.throwable.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.LazyLoader;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/2 23:16
 */
public class LazyLoaderDemo {

	private static final AtomicInteger COUNTER = new AtomicInteger(0);

	public static void main(String[] args) throws Exception {
		Enhancer enhancer = new Enhancer();
		SampleInterfaceImpl impl = new SampleInterfaceImpl();
		enhancer.setInterfaces(new Class[]{SampleInterface.class});
		enhancer.setCallback(new LazyLoader() {
			@Override
			public Object loadObject() throws Exception {
				COUNTER.incrementAndGet();
				return impl;
			}
		});
		SampleInterface sampleInterface = (SampleInterface) enhancer.create();
		System.out.println(sampleInterface.sayHello("throwable-1"));
		System.out.println(sampleInterface.sayHello("throwable-2"));
		System.out.println(COUNTER.get());
	}

	private static class SampleInterfaceImpl implements SampleInterface{

		public SampleInterfaceImpl(){
			System.out.println("SampleInterfaceImpl init...");
		}

		@Override
		public String sayHello(String name) {
			return "Hello i am SampleInterfaceImpl!";
		}
	}
}
