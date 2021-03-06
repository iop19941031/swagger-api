package swagger.api;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@SwaggerDefinition(
    info = @Info(
        description = "This is a sample server",
        version = "1.0.0",
        title = "Swagger Sample Servlet",
        termsOfService = "http://swagger.io/terms/",
        contact = @Contact(name = "Sponge-Bob", email = "apiteam@swagger.io", url = "http://swagger.io"),
        license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")
    ),
    consumes = {"application/json", "application/xml"},
    produces = {"application/json", "application/xml"},
    schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
    tags = {@Tag(name = "users", description = "测试")}
)
@ApiResponses({@ApiResponse(code = 400, message = "Invalid input", response = util.ApiResponse
    .class)})
public class Swagger {

}
