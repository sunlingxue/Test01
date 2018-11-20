package com.qiyuesuo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.qiyuesuo.sdk.SDKClient;
import com.qiyuesuo.sdk.api.LocalSignService;
import com.qiyuesuo.sdk.impl.LocalSignServiceImpl;
import com.qiyuesuo.sdk.sign.Stamper;
import com.sun.deploy.net.HttpResponse;

import java.io.*;


/**
 * @author SLX
 * @date 2018/11/19 17:11
 */

public class Test {

    @org.junit.Test
    public void test01() throws FileNotFoundException {
        SDKClient client = new SDKClient("https://openapi.qiyuesuo.me", "fH0pNA83NA", "okE2PhHXiKapiWNnkPhwV4WfBjOL00");
        LocalSignService service =new LocalSignServiceImpl(client);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = new FileInputStream(new File("D://test.pdf"));
        Stamper stamper = new Stamper(1, 0.1f, 0.1f);

        service.sign(inputStream, outputStream, 2483532812670148712L, stamper);
    }

    @org.junit.Test
    public void test02() throws Exception {

        //创建PDF文档
        Document document = new Document();
//创建 PdfWriter instance.
        PdfWriter.getInstance(document, new FileOutputStream("D:\\" + "createSamplePDF.pdf")); //该方法写入到磁盘
        response.setHeader("Content-disposition", "attachment; filename=jx.pdf");
        response.setContentType("application/pdf");
        PdfWriter.getInstance(document, response.getOutputStream()); //变成一个下载流
//打开Document.
        document.open();
//设置中文字体
        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont);
//加入第一行content.
        document.add(new Paragraph(new String("你好世界!".getBytes(),"GBK") ,font));
        document.add(new Paragraph("你好世界!",font));

    }

}
