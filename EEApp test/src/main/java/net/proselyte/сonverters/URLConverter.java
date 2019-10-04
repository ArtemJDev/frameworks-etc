//import javax.faces.context.FacesContext;
//import javax.faces.component.UIComponent;
//
//import javax.faces.application.FacesMessage;
//
//import javax.faces.convert.Converter;
//import javax.faces.convert.FacesConverter;
//import javax.faces.convert.ConverterException;
//
//import org.apache.commons.validator.UrlValidator;
//
//@FacesConverter("URLConverter")
//public class URLConverter implements Converter
//{
//  private final String HTTP = "http://";
//  @Override
//  public Object getAsObject(FacesContext context, UIComponent component, String value)
//  {
//    StringBuilder url = new StringBuilder();
//    // Если строка не начинается с http://, то добавляем
//    if (!value.startsWith(HTTP, 0))
//      url.append(HTTP);
//
//    url.append(value);
//
//    // Используем Apache URL validator для проверки
//    UrlValidator urlValidator = new UrlValidator();
//    // Если формат URL нарушен, то создаем сообщение об ошибке
//    if (!urlValidator.isValid(url.toString())){
//      FacesMessage msg = new FacesMessage ("Ошибка конвертации URL.",
//          "Неправильный формат URL.");
//      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//      throw new ConverterException(msg);
//    }
//
//    URLBookmark urlBookmark = new URLBookmark(url.toString());
//
//    return urlBookmark;
//  }
//
//  @Override
//  public String getAsString(FacesContext context, UIComponent component, Object value) {
//
//    return value.toString();
//  }
//}