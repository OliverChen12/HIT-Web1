import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "process", value = "/process")
public class process extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取参数值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gander = request.getParameter("gander");
        String[] hobbies = request.getParameterValues("hobby");
        String address = request.getParameter("address");

        if (username == null || username.length() <= 0 || password == null || password.length() <= 0) {
            //重定向
            response.sendRedirect("error.html");

        } else {
            PrintWriter writer = response.getWriter();
            writer.println("<h1>" + username + "</h1>");
            writer.println("<h1>" + password + "</h1>");
            writer.println("<h1>" + gander + "</h1>");
            for (String hobby : hobbies) {
                writer.println("<h1>" + hobby + "</h1>");
            }
            writer.println("<h1>" + address + "</h1>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }


}

