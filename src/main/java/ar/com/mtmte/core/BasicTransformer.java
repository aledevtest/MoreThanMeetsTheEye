package ar.com.mtmte.core;


import ar.com.mtmte.utils.BeanUtils;
import ar.com.mtmte.utils.ClassUtils;

public class BasicTransformer {

	public Object transform(Object origin, Class<?> class1) {
		Object dest = ClassUtils.newInstance(class1);
		BeanUtils.copyProperties(dest, origin);
		return dest;
	}

}
