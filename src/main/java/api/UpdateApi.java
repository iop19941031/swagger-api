package api;

import database.Update;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/amend")
public class UpdateApi extends HttpServlet {

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    String content = req.getParameter("content");
    Update.update(id, content);
    PrintWriter pw = resp.getWriter();
    pw.println("提交成功！");
    pw.close();
  }
}
