package api;

import database.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/show")
public class SelectApi extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp){

  }
}
