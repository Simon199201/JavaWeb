package cn.itcast.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/servletDemo04")
public class ServletDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        System.out.println("filename is " + filename);
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/file/" + filename);
        System.out.println("real path is " + realPath);
        response.setContentType(servletContext.getMimeType(filename));
        System.out.println("mime type is " + servletContext.getMimeType(filename));
        response.setHeader("content-disposition", "attachment;filename=" + DownLoadUtils.getFileName(request.getHeader("user-agent"), filename));
        File file = new File(realPath);
        FileInputStream fis = new FileInputStream(file);
        ServletOutputStream sos = response.getOutputStream();

        byte[] buffer = new byte[1024 * 8];
        int length;

        while ((length = fis.read(buffer)) != -1) {
            sos.write(buffer, 0, length);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
