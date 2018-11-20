package com.qiyuesuo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author SLX
 * @date 2018/11/19 17:05
 */
public class LocalSignSample {
    private static final Logger logger = LoggerFactory.getLogger(LocalSignSample.class);
    private static Long sealId = 2483532812670148712L; // 印章编号，在契约锁开放平台【公司印章】中获取
    private static File pdfFile = new File("./NoSign.pdf"); //测试文档
    private static File outFile = new File("./sign/local");   //测试输出文档路径
    static {
        if (!outFile.exists()) {
            outFile.mkdirs();
        }
    }
}
