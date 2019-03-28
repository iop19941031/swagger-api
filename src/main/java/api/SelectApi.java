package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.Select;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.MessageData;

@WebServlet(urlPatterns = "/show")
public class SelectApi extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    int id = Integer.parseInt(req.getParameter("id"));
    MessageData data = Select.select(id);

    ObjectMapper mapper = new ObjectMapper();
    String s = null;
    try {
      s = mapper.writeValueAsString(data);
//      System.out.println(s);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    PrintWriter pw = null;
    try {
      pw = resp.getWriter();
      pw.print(s);
      pw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
