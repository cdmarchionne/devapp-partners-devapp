package ar.edu.unq.partnersdevapp.service.dto.utils;

/**
 * puedo usar esto para la convercion , ver que si un atributo es otra clase hay
 * que transformarla tambien
 */
public class DtoConvercion {

    public DtoConvercion() {
        throw new UnsupportedOperationException();
    }
    // Field[] atributo = ClaseA.class.getDeclaredFields();
    //
    // Method metodoGet = ClaseA.class.getMethod("getA", null);
    //
    // for (Field field : atributo) {
    //
    // metodoGet = ClaseA.class.getMethod(Reflexion.getGet(field.getName()),
    // null);
    //
    // try {
    // // seteo b por reflexion
    // Method metodoSet =
    // ClaseB.class.getMethod(Reflexion.getSet(field.getName()),
    // field.getType());
    // metodoSet.invoke(b, metodoGet.invoke(a, null));
    //
    // } catch (IllegalArgumentException e) {
    // throw new UnsupportedOperationException();
    // } catch (IllegalAccessException e) {
    // throw new UnsupportedOperationException();
    // } catch (InvocationTargetException e) {
    // throw new UnsupportedOperationException();
    // }
    // }
    // }
    // static public String getSet(final String atributo) {
    // String getterName = "set" +
    // String.valueOf(atributo.charAt(0)).toUpperCase() + atributo.substring(1);
    // return getterName;
    // }
    //
    // static public String getGet(final String atributo) {
    // String getterName = "get" +
    // String.valueOf(atributo.charAt(0)).toUpperCase() + atributo.substring(1);
    // return getterName;
    // }
}
