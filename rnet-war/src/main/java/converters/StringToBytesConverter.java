package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/6/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter("StringToBytesConverter")
public class StringToBytesConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        value = value.trim();
        byte [] valueInBytes = value.getBytes();
        return valueInBytes;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        byte[] valueInBytes = (byte[]) value;
        String valueInString = new String(valueInBytes);
        return valueInString.trim();
    }
}
