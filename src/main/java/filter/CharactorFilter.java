package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class CharactorFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    System.out.println("UTF-8过滤器");

    HttpServletRequest re = (HttpServletRequest) request;
    HttpServletResponse resr = (HttpServletResponse) response;
    re.setCharacterEncoding("UTF-8");  //设置request的编码格式
    resr.setContentType("text/html;charset=UTF-8"); //设置response字符编码
    resr.setCharacterEncoding("UTF-8");
    chain.doFilter(re, resr);  //传递给下一个过滤器
//    chain.doFilter(request, response);  //传递给下一个过滤器

  }

  @Override
  public void destroy() {

  }
}
