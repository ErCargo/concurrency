package com.pic.merge;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.lang3.StringUtils;


/**
 * @author ercargo  on 2019/5/10
 * @DESCRIBE
 */
public class PictureMerge {
    /**
     * @param fileUrl 文件绝对路径或相对路径
     * @return 读取到的缓存图像
     * @throws IOException 路径错误或者不存在该文件时抛出IO异常
     */
    public static BufferedImage getBufferedImage(String fileUrl) throws IOException {
        File f = new File(fileUrl);
        return ImageIO.read(f);
    }

    /**
     * @param savedImg 待保存的图像
     * @param saveDir  保存的目录
     * @param fileName 保存的文件名，必须带后缀，比如 "beauty.jpg"
     * @param format   文件格式：jpg、png或者bmp
     * @return
     */
    public static boolean saveImage(BufferedImage savedImg, String saveDir, String fileName, String format) {
        boolean flag = false;
        // 先检查保存的图片格式是否正确
        String[] legalFormats = {"jpg", "JPG", "png", "PNG", "bmp", "BMP"};
        int i = 0;
        for (i = 0; i < legalFormats.length; i++) {
            if (format.equals(legalFormats[i])) {
                break;
            }
        }
        if (i == legalFormats.length) { // 图片格式不支持
            System.out.println("不是保存所支持的图片格式!");
            return false;
        }

        // 再检查文件后缀和保存的格式是否一致
        String postfix = fileName.substring(fileName.lastIndexOf('.') + 1);
        if (!postfix.equalsIgnoreCase(format)) {
            System.out.println("待保存文件后缀和保存的格式不一致!");
            return false;
        }

        String fileUrl = saveDir + fileName;
        File file = new File(fileUrl);
        try {
            flag = ImageIO.write(savedImg, format, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;

    }


    /**
     * 待合并的两张图必须满足这样的前提，如果水平方向合并，则高度必须相等；如果是垂直方向合并，宽度必须相等。
     * mergeImage方法不做判断，自己判断。
     *
     * @param img1         待合并的第一张图
     * @param img2         带合并的第二张图
     * @param isHorizontal 为true时表示水平方向合并，为false时表示垂直方向合并
     * @return 返回合并后的BufferedImage对象
     * @throws IOException
     */
    public static BufferedImage mergeImage(BufferedImage img1, BufferedImage img2, boolean isHorizontal, int startX, int startY) throws IOException {
        int w1 = img1.getWidth();
        int h1 = img1.getHeight();
        int w2 = img2.getWidth();
        int h2 = img2.getHeight();

        // 从图片中读取RGB
        int[] ImageArrayOne = new int[w1 * h1];
        ImageArrayOne = img1.getRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 逐行扫描图像中各个像素的RGB到数组中
        int[] ImageArrayTwo = new int[w2 * h2];
        ImageArrayTwo = img2.getRGB(0, 0, w2, h2, ImageArrayTwo, 0, w2);

        // 生成新图片
        BufferedImage DestImage = null;
        if (isHorizontal) { // 水平方向合并
            DestImage = new BufferedImage(w1, h1, BufferedImage.TYPE_INT_RGB);
            DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            DestImage.setRGB(startX, startY, w2, h2, ImageArrayTwo, 0, w2); // 设置下半部分的RGB
        } else { // 垂直方向合并
            DestImage = new BufferedImage(w1, h1 + h2, BufferedImage.TYPE_INT_RGB);
            DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            DestImage.setRGB(0, h1, w2, h2, ImageArrayTwo, 0, w2); // 设置下半部分的RGB
        }
        return DestImage;
    }

    /**
     * <p>Title: getImageStream</p>
     * <p>Description: 获取图片InputStream</p>
     *
     * @param destImg
     * @return
     */
    public static InputStream getImageStream(BufferedImage destImg) {
        InputStream is = null;
        BufferedImage bi = destImg;
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ImageOutputStream imOut;
        try {
            imOut = ImageIO.createImageOutputStream(bs);
            ImageIO.write(bi, "png", imOut);
            is = new ByteArrayInputStream(bs.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }

    /**
     * <p>Title: drawTextInImg</p>
     * <p>Description: 图片上添加文字业务需求要在图片上添加水</p>
     *
     * @param text
     */
    public static BufferedImage drawTextInImg(BufferedImage bimage, FontText text, int left, int top) {
        Graphics2D g = bimage.createGraphics();
        g.setColor(getColor(text.getWm_text_color()));
        g.setBackground(Color.white);
        Font font = new Font(text.getWm_text_font(), Font.BOLD,
                text.getWm_text_size());
        g.setFont(font);
        //g.drawBytes(text.getText().getBytes(), 0,text.getText().getBytes().length, left-50, top-50);
        g.drawString(text.getText(), left, top);
        g.dispose();
        return bimage;
    }

    // color #2395439
    public static Color getColor(String color) {
        if (color.charAt(0) == '#') {
            color = color.substring(1);
        }
        if (color.length() != 6) {
            return null;
        }
        try {
            int r = Integer.parseInt(color.substring(0, 2), 16);
            int g = Integer.parseInt(color.substring(2, 4), 16);
            int b = Integer.parseInt(color.substring(4), 16);
            return new Color(r, g, b);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }
    /**
     * @param headurl
     * @param wxqr
     * @return
     */
    /**
     * <p>Title: myQr</p>
     * <p>Description: </p>
     *
     * @param headurl
     * @param wxqr
     * @return
     */
    public static BufferedImage imageProduce(String nickname, String openid, String headurl, String wxqr) {
        Properties pro = new Properties();
        try {
            pro.load(PictureMerge.class.getResourceAsStream("http.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 读取待合并的文件
        BufferedImage bi1 = null;
        BufferedImage bi2 = null;
        BufferedImage bi3 = null;
        // 调用mergeImage方法获得合并后的图像
        BufferedImage destImg = null;
        String baseurl = "/" + PictureMerge.class.getResource("/").toString().replace("file:/", "");
        if ("0".equals(pro.get("wx.debug"))) {
            baseurl = "/" + baseurl;
            //baseurl="/src";
        }
       /*// System.out.println("用户Openid:"+openid);
       // System.out.println("用户头像:" + headurl);
        System.out.println("用户带参二维码:" + wxqr);
        System.out.println("推广二维码模板:" + baseurl + "qrimg/qrTemplate.png");*/

        try {
            File fTemp = new File(baseurl + "qrimg/qrTemplate.png");
            File uTemp = new File(baseurl + "qrimg/" + openid + ".png");
            //File uTemp = new File(baseurl + "qrimg/" + new Date().getTime() + ".png");
            System.out.println("======= OLD模板:" + fTemp.getName() + "\n  ======= NEW模板:" + uTemp.getName());
            FileUtils.copyFileUsingFileChannels(fTemp, uTemp);
            bi1 = ImageIO.read(uTemp);
            //uTemp.delete();
            /**缓存推广二维码*/
            InputStream qrInputStream = FileUtils.getInputStreamByGet(wxqr);
            bi2 = ImageUtil.zoomOutImage(ImageIO.read(qrInputStream), 1, 120, 120);
            /**缓存头像*/
            if (StringUtils.isEmpty(headurl)) {
                headurl = baseurl + "qrimg/commonhead.png";
            }
            InputStream headInputStream = FileUtils.getInputStreamByGet(headurl);
            BufferedImage headImage = ImageIO.read(headInputStream);
            bi3 = ImageUtil.zoomOutImage(headImage, -1, 113, 113);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 调用mergeImage方法获得合并后的图像
        try {
            int w1 = bi1.getWidth();
            int fw1 = w1;
            int h1 = bi1.getHeight();
            int fh1 = h1;
            int w2 = bi2.getWidth();
            int fw2 = w2;
            int h2 = bi2.getHeight();
            int fh2 = h2;
            destImg = mergeImage(bi1, bi2, true, (w1 / 2 - w2 / 2), (h1 / 2 - h2 / 2 - 60));
            w1 = destImg.getWidth();
            h1 = destImg.getHeight();
            w2 = bi3.getWidth();
            h2 = bi3.getHeight();
            System.out.println(w2 + "===" + h2);
            int startX = w1 / 4 - w2 / 4 + w2 * 3 - 40;
            int startY = h1 / 2 - h2 / 2 - h2 * 4 - 20;
            destImg = mergeImage(destImg, bi3, true, startX, startY);
            /**为图片添加昵称*/
            //destImg = drawTextInImg(destImg, new com.pic.merge.FontText(EmojiUtils.filterName(nickname), 3, "#FFFFF", 25, "宋体"), (fw1 / 2 - fw2 / 2) * 3 - 80, (fh1 / 2 - fh2 - 150));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destImg;
        // 保存图像
        //saveImage(destImg, baseurl, "qrimg/luguo.png", "png");
        //System.out.println("水平合并完毕!");
    }


    public static void main(String[] args) {
        String baseurl = "/" + new PictureMerge().getClass().getResource("/").toString().replace("file:/", "");
        BufferedImage destImg = imageProduce(
                "LC[0xf0][0x9f][0x98][0x8a]",
                "oIhOc0hzx-ljAH_QQOTD2ImoylvQ",
                "http://wx.qlogo.cn/mmopen/PiajxSqBRaELjvm6Ld5SUYzfRE0vjlDYa81AnkAjAS5Ifo4vdAZpoJicHGsYDEDTP8icecibDtkX92icbRNic7IsumSA/0",
                "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQGM8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyeElmZTlYUDE4cV8xMDAwME0wN0QAAgR5GSJaAwQAAAAA");
        saveImage(destImg, baseurl, "qrimg/luguo.png", "png");
    }
}
