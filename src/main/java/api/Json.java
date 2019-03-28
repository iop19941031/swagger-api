package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.MessageData;

/**
 * 对象转json浏览器识别,其他不识别.
 */
@WebServlet(urlPatterns = "/json")
public class Json extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    String s = null;
    ObjectMapper mapper = new ObjectMapper();
    MessageData d = new MessageData();
    d.setId(2);
    d.setContent("2222222222");
    try {
      s = mapper.writeValueAsString(d);
      System.out.println(s);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    //list<String>转json
//    ArrayList<String> list = new ArrayList<String>();
//    list.add("jack");
//    list.add("tom");
//    String ljson = mapper.writeValueAsString(list);
//    System.out.println(ljson);

    //json转list<String>
//    ArrayList<String> sList = mapper.readValue(ljson, ArrayList.class);
//    System.out.println(sList);

    //list<User>转json
//    List<MessageData> ulist = new ArrayList<MessageData>();
//    ulist.add(d);
//    String ujson = mapper.writeValueAsString(ulist);
//    System.out.println(ujson);
    //json转list<User>
//    JavaType jt = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, User.class);
//    List<User> urlist = MAPPER.readValue(ujson, jt);
//    System.out.println(urlist);


    PrintWriter ps = resp.getWriter();
    ps.println(s);   //对象转json字符串
//    ps.println(ljson); //list<String>转json字符串
//    ps.println(ujson);
    ps.close();
  }
}
