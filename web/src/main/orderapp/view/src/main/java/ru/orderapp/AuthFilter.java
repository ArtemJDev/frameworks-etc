package main.orderapp.view.src.main.java.ru.orderapp;

import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import ru.orderapp.ejb.AuthenticateBean;

/**
 *  Определяем к какому ресурсу сылается персона
 *  есть ли у персоны права на ресурс
 * */
@WebFilter(urlPatterns = "/secured/*")//срабатывает всегда, на любой запрос
public class AuthFilter implements Filter {

  @EJB
  private AuthenticateBean authenticateBean;

  @Inject
  private PersonBean personBean;


  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;

    String resource = httpServletRequest.getRequestURI(); //запрашиваемый реусурс

    if(!personBean.isAuthenticated()) {
      personBean.setInitialRequestURL(resource);
      httpServletResponse.sendRedirect( ((HttpServletRequest) request).getContextPath() +"/login.xhtml");
      return ;
    }

    if(!authenticateBean.isGranted(personBean.getLogin(), resource)) {
      httpServletResponse.sendRedirect("redirect to acess denied");
      return ;
    }

    if(StringUtils.isNotEmpty(personBean.getInitialRequestURL())) {
      httpServletResponse.sendRedirect(personBean.getInitialRequestURL());
      personBean.setInitialRequestURL("");
      return;

    }
    chain.doFilter(request,response);
  }

  @Override
  public void destroy() {

  }
}
