package com.example.huibanbackend.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Base64;
import java.util.Random;

public final class AvatarHelper {

    // 可以直接在<img/>标签或者浏览器地址栏预览的base64编码头
    public static final String BASE64_PREFIX = "data:image/png;base64,";

    public static final int randNum = 100000;
    static final int width = 100;
    static final int grid = 5;
    static final int red = 240;
    static final int green = 240;
    static final int blue = 240;
    static final int randomFC = 80;
    static final int randomBC = 200;
    static final int index = 53;
    static final int colorRange = 255;
    static final int integerRadix = 36;
    static final int stringRadix = 10;

    private AvatarHelper(){

    }
    /**
     * 生成头像的base64编码
     * @param
     * @return
     * @throws IOException
     */
    public static String createBase64Avatar() throws IOException {
        Random rd=new Random();
        int id = rd.nextInt(randNum);
        String avatar = new String(Base64.getEncoder().encode(create(id)));
        return AvatarHelper.BASE64_PREFIX + avatar;
    }

    /**
     * 根据id生成一个头像，颜色随机。如果是使用hashCode()值的话，值可能为负数。需要要注意。
     * @param id
     * @return
     * @throws IOException
     */
    public static byte[] create(int id) throws IOException {

        int padding = width / 2;
        int size = width * grid + width;
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D _2d = img.createGraphics();
        _2d.setColor(new Color(red, green, blue));
        _2d.fillRect(0, 0, size, size);
        _2d.setColor(randomColor(randomFC, randomBC));
        char[] idchars = createIdent(id);
        int i = idchars.length;
        for (int x = 0; x < Math.ceil(grid / 2.0); x++) {
            for (int y = 0; y < grid; y++) {
                if (idchars[--i] < index) {
                    _2d.fillRect((padding + x * width), (padding + y * width), width, width);
                    if (x < Math.floor(grid / 2)) {
                        _2d.fillRect((padding + ((grid - 1) - x) * width), (padding + y * width), width, width);
                    }
                }
            }
        }
        _2d.dispose();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(img, "png", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static Color randomColor(int fc, int bc) {
        Random random = new Random();
        if (fc > colorRange) {
            fc = colorRange;
        }
        if (bc > colorRange) {
            bc = colorRange;
        }
        int r = fc + random.nextInt(Math.abs(bc - fc));
        int g = fc + random.nextInt(Math.abs(bc - fc));
        int b = fc + random.nextInt(Math.abs(bc - fc));
        return new Color(r, g, b);
    }

    private static char[] createIdent(int id) {
        BigInteger bi_content = new BigInteger((id + "").getBytes());
        BigInteger bi = new BigInteger(id + "identicon" + id, integerRadix);
        bi = bi.xor(bi_content);
        return bi.toString(stringRadix).toCharArray();
    }

}
