package api;

import database.Insert;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add")
public class InsertApi extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String content = req.getParameter("content");
    System.out.println(content);
    Insert.insert(content);
    PrintWriter pw = resp.getWriter();
    pw.println("提交成功！");
    pw.close();
  }
}
