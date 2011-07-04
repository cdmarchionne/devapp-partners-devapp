package ar.edu.unq.partnersdevapp.service.dto.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * puedo usar esto para la convercion , ver que si un atributo es otra clase hay
 * que transformarla tambien
 */
public class DtoConvercion {

    static public void copiarAtributos(final Object a, final Object b) {
        Field[] atributos = a.getClass().getDeclaredFields();
        Method metodoGet;
        Method metodoSet;

        for (Field field : atributos) {
            try {
                // System.out.println("xxx" +
                // DtoConvercion.getGet(field.getName()));
                metodoGet = a.getClass().getMethod(DtoConvercion.getGet(field.getName()), null);
                // System.out.println("xxx" + metodoGet);
                // metodoSet =
                // b.getClass().getMethod(DtoConvercion.getSet(field.getName()),
                // field.getType());
                // System.out.println("xxx" + metodoSet);
                // metodoSet.invoke(b, metodoGet.invoke(a, null));
            } catch (SecurityException e) {
                throw new UnsupportedOperationException();
            } catch (NoSuchMethodException e) {
                throw new UnsupportedOperationException();
            } catch (IllegalArgumentException e) {
                throw new UnsupportedOperationException();
            }
            // catch (IllegalAccessException e) {
            // throw new UnsupportedOperationException();
            // } catch (InvocationTargetException e) {
            // throw new UnsupportedOperationException();
            // }

        }
    }

    static public String getSet(final String atributo) {
        String getterName = "set" + String.valueOf(atributo.charAt(0)).toUpperCase() + atributo.substring(1);
        return getterName;
    }

    static public String getGet(final String atributo) {
        String getterName = "get" + String.valueOf(atributo.charAt(0)).toUpperCase() + atributo.substring(1);
        return getterName;
    }
}
