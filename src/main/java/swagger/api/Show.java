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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.MessageData;

@Api(value = "/databases", description = "gets some data from a servlet")
public class Show extends HttpServlet {

  @ApiOperation(httpMethod = "GET", value = "查询", response = MessageData.class, nickname = "show")
  @ApiResponses({@ApiResponse(code = 400, message = "无效输入", response = util.ApiResponse
      .class)})
  @ApiImplicitParams({
      @ApiImplicitParam(name = "id", value = "id",
          required = true, dataType = "integer", paramType = "query")
  })
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String result = null;
    int id = 0;
    try {
      id = Integer.parseInt(request.getParameter("id"));
      MessageData md = new MessageData();
      md.setId(id);
      result = Json.pretty(md);
    } catch (Exception ex) {
      result = Json.pretty(new util.ApiResponse(400, ex.getMessage()));
    }

    response.getOutputStream().write(result.getBytes(StandardCharsets.UTF_8));
  }
}
