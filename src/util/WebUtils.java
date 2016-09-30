package util;

/**
 * Created by Administrator on 2016/9/26.
 */

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @author gacl
 *         ��request�����е����������װ��bean��
 */
public class WebUtils {

    /**
     * ��request����ת����T����
     *
     * @param request
     * @param clazz
     * @return
     */
    public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {
        try {
            T bean = clazz.newInstance();
            Enumeration<String> e = request.getParameterNames();
            while (e.hasMoreElements()) {
                String name = (String) e.nextElement();
                String value = request.getParameter(name);
                BeanUtils.setProperty(bean, name, value);
            }
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * ����UUID
     *
     * @return
     */
    public static String makeId() {
        return UUID.randomUUID().toString();
    }
}
