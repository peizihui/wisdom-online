package com.roncoo.education.util.tools;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-17:09
 * @email:wk20041208@126.com
 */
public final class ArrayListUtil<T extends Serializable>  {
    private ArrayListUtil() {
    }

    /**
     * @param source
     * @param clazz
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> List<T> copy(List<?> source, Class<T> clazz)  {
        if (source == null || source.size() == 0) {
            return Collections.emptyList();
        }
        List<T> res = new ArrayList<>(source.size());
        for (Object o : source) {
            T t = null;
            try {
                t = clazz.newInstance();
                BeanUtils.copyProperties(o, t);
            } catch (Exception e) {
                e.printStackTrace();
            }
            res.add(t);
        }
        return res;
    }
}
