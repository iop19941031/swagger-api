package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class ContentTypeFilter implements Filter {

  public void init(FilterConfig filterConfig) throws ServletException {

  }

  /**
   * 设置HTTP Content-Type.
   *
   * @param request 请求.
   * @param response 响应
   * @param chain 过滤链
   */
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    System.out.println("Content-Type过滤器");

    HttpServletResponse res = (HttpServletResponse) response;
    res.addHeader("Content-Type", "application/json");
    chain.doFilter(request, response);
  }

  public void destroy() {
  }
}
