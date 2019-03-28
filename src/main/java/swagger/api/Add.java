package swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.util.Json;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.MessageData;


@Api(value = "/databases", description = "gets some data from a servlet")
public class Add extends HttpServlet {

  @ApiOperation(httpMethod = "POST", value = "增加",
      response = MessageData.class, nickname = "add")
  @ApiResponses({@ApiResponse(code = 400, message = "无效输入", response = util.ApiResponse
      .class)})
  @ApiImplicitParams({
      @ApiImplicitParam(name = "content", value = "content",
          required = true, dataType = "string", paramType = "form")
  })

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println(request.getParameter("content"));
    String result;
    try {
      final String content = request.getParameter("content");

      MessageData md = new MessageData();
      md.setContent(content);
      result = Json.pretty(md);

    } catch (Exception ex) {
      result = Json.pretty(new util.ApiResponse(400, ex.getMessage()));
    }

    response.getOutputStream().write(result.getBytes(StandardCharsets.UTF_8));
  }
}
