package converters;

import static utils.ConstantValues.REPORT_DATA_LINK_LIMIT;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/18/13
 * Time: 3:28 AM
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter("ReportDataConverter")
public class ReportDataConverter implements Converter {

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
        if(valueInString.length() > REPORT_DATA_LINK_LIMIT) {
            valueInString = valueInString.substring(0, REPORT_DATA_LINK_LIMIT);
            valueInString = valueInString.concat("...");
        }
        return valueInString;
    }
}
