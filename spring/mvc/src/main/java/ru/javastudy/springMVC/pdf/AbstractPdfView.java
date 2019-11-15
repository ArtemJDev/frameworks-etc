package mvc.src.main.java.ru.javastudy.springMVC.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.AbstractView;

public abstract class AbstractPdfView extends AbstractView {

  public AbstractPdfView() {
    setContentType("application/pdf");
  }

  @Override
  protected void renderMergedOutputModel(Map<String, Object> map,
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
      throws Exception {
    ByteArrayOutputStream byteArrayOutputStream = createTemporaryOutputStream();

    Document document = newDocument();
    PdfWriter writer = newWriter(document, byteArrayOutputStream);
    prepareWriter(map, writer, httpServletRequest);
  }


  @Override
  protected boolean generatesDownloadContent() {
    return true;
  }


  protected Document newDocument() {
    return new Document(PageSize.A4);
  }

  protected PdfWriter newWriter(Document document, OutputStream outputStream)
      throws DocumentException {
    return PdfWriter.getInstance(document, outputStream);
  }
  protected void prepareWriter(Map<String, Object> model, PdfWriter writer, HttpServletRequest request) {
    writer.setViewerPreferences(1);
  }

}
