package me.gacl.util.file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.User;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class upload {

    private static final String UPLOAD_DIRECTORY = "D:\\Blog\\head";
    private static final String UPLOAD_ADBACKGROUD="D:\\Blog\\AdImg";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    public static void upfile(String content,String filePath) {
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter(filePath);
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void uphead(HttpServletRequest request, HttpServletResponse response,String userid) throws IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        DiskFileItemFactory factory=new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload=new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        String uploadPath=UPLOAD_DIRECTORY;
        File uploadDir=new File(uploadPath);
        @SuppressWarnings("unchecked")
        List<FileItem> formItems= null;
        try {
            formItems = upload.parseRequest(request);
            if(formItems!=null&&formItems.size()>0){
                System.out.println(formItems);
                for(FileItem item:formItems){
                    if(!item.isFormField()&&item.getName()!=""){
                        File head=new File(item.getName());
                        String fileName=userid+getFileEnd(head);
                        String sql="UPDATE user SET head=? WHERE id=?;";
                        UserTools tool=new UserTools();
                        tool.Update(sql,"/head/"+fileName,userid);
                        String filePath=uploadPath+File.separator+fileName;
                        File storeFile=new File(filePath);
                        item.write(storeFile);
                        request.setAttribute("message","文件上传成功！");
                        User user=(User)request.getSession().getAttribute("user");
                        user.head="/head/"+fileName;
                        request.getSession().setAttribute("user",user);
                    }else{
                        System.out.println(item.getName()+":"+item.getString());
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void upimg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        DiskFileItemFactory factory=new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload=new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        String uploadPath="D:\\Blog\\img";
        File uploadDir=new File(uploadPath);
        @SuppressWarnings("unchecked")
        List<FileItem> formItems= null;
        try {
            formItems = upload.parseRequest(request);
            if(formItems!=null&&formItems.size()>0){
                System.out.println(formItems);
                for(FileItem item:formItems){
                    if(!item.isFormField()&&item.getName()!=""){
                        File img=new File(item.getName());
                        String fileName=item.getName();
                        String filePath=uploadPath+File.separator+fileName;
                        File storeFile=new File(filePath);
                        item.write(storeFile);
                        request.setAttribute("message","文件上传成功！");
                        PrintWriter writer = response.getWriter();
//                        writer.write("{\"success\": 1, \"message\":\"upload success\",\"url\":" + "\"http://localhost:8080/static/img/" + fileName + "\"}");
//                        System.out.println("{\"success\": 1, \"message\":\"upload success\",\"url\":" + "\"http://localhost:8080/static/img/" + fileName + "\"}");
//                        writer.flush();
                        response.getWriter().write("{\"success\":1,\"messgae\":\"upload successful\",\"url\":\"???\"}");
                    }else{
                        System.out.println(item.getName()+":"+item.getString());
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getFileEnd(File file){
        if(file==null) return null;
        String fileName=file.getName();
        if(fileName.lastIndexOf(".")==-1){
            return "";
        }
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static void upAdBackgroud(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        DiskFileItemFactory factory=new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload=new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        String uploadPath=UPLOAD_ADBACKGROUD;
        File uploadDir=new File(uploadPath);
        @SuppressWarnings("unchecked")
        List<FileItem> formItems= null;
        try {
            formItems = upload.parseRequest(request);
            if(formItems!=null&&formItems.size()>0){
                for(FileItem item:formItems){
                    if(!item.isFormField()&&item.getName()!=""){
                        File head=new File(item.getName());
                        String sql="SELECT * FROM ads";
                        UserTools tool=new UserTools();
                        ResultSet set=tool.Select(sql);
                        int adId=0;
                        while(set.next()){
                            adId=set.getInt("AdId");
                        }
                        String fileName=adId+getFileEnd(head);
                        sql="UPDATE ads SET AdBackgroud=? WHERE AdId=?";
                        tool.Update(sql,"/AdImg/"+fileName,adId);
                        String filePath=uploadPath+File.separator+fileName;
                        File storeFile=new File(filePath);
                        item.write(storeFile);
                    }else{
                        System.out.println(item.getName()+":"+item.getString());
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
