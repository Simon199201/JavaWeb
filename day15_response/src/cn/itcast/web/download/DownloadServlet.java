package cn.itcast.web.download;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        String filename = request.getParameter("filename");
        //2。使用字节输入流进内存
        String realPath = this.getServletContext().getRealPath("/img/" + filename);
        FileInputStream fis = new FileInputStream(realPath);
        //3.设置response响应头
        filename = DownLoadUtils.getFileName(request.getHeader("user-agent"), filename);
        //如果是safari，则使用下面这个header
//        response.setHeader("content-disposition","attachment;filename*=UTF-8''" + URLEncoder.encode(filename,"UTF-8"));
        response.setContentType(this.getServletContext().getMimeType(filename));
        response.setHeader("content-disposition", "attachment;filename=" + filename);

        //4.将输入流的数据写出到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(buff)) != -1) {
            outputStream.write(buff, 0, len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
