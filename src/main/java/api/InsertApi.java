package api;


import io.swagger.annotations.*;
import io.swagger.util.Json;
import util.MessageData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Api(value = "/databases", description = "gets some data from a servlet")
public class InsertApi extends HttpServlet {
    @ApiOperation(httpMethod = "GET", value = "ResoXXXXXXXXXXXxer", response = MessageData.class, nickname = "insert")
    @ApiResponses({@ApiResponse(code = 400, message = "Invalid input", response = util.ApiResponse
            .class)})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "content", value = "User ID", required = true, dataType = "string", paramType =
                    "query")
    })
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result;
        try {
            final String name = request.getParameter("content");
            result = Json.pretty(new MessageData(name));
        } catch (Exception ex) {
            result = Json.pretty(new util.ApiResponse(400, ex.getMessage()));
        }

        response.getOutputStream().write(result.getBytes(StandardCharsets.UTF_8));
    }
}
