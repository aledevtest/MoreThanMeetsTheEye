package ar.com.mtmte.core;

import ar.com.mtmte.utils.BeanUtils;
import ar.com.mtmte.utils.ClassUtils;
import ar.com.mtmte.utils.TransformerUtils;

/**
 * @author Alejandro Zalazar <alejandrozalazar@gmail.com> Transforms from an
 *         instance to another, copying all the fields with the corresponding
 *         name/type
 */
public class SimpleTransformer implements Transformer {

	public Object transform(Object origin, Class<?> class1) {
		Object dest = ClassUtils.newInstance(class1);
		BeanUtils.copyProperties(dest, origin);
		return dest;
	}

	@Override
	public Object transform(Object object) {
		return transform(object, TransformerUtils.getDefaultInstanceType());
	}
}
