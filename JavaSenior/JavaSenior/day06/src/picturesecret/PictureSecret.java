package picturesecret;

import org.junit.Test;

import java.io.*;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/5 14:11
 * <p>
 * <p>
 * //对图片进行加密操作
 */
public class PictureSecret {
    @Test
    public void pictureSecret() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("photo1.jpg")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("photosecret.jpg")));

            byte[] bytes = new byte[100];
            int read;
            while ((read = bis.read(bytes)) != -1){
                for (int i = 0;i < read;i++){
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                bos.write(bytes,0,read);
            }
            System.out.println("图片加密成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (bis != null)
                bis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    if (bos != null)
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void decrypt(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("photosecret.jpg")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("decrypt.jpg")));

            byte[] bytes = new byte[100];
            int read;
            while ((read = bis.read(bytes)) != -1){
                for (int i = 0;i < read;i++){
                    bytes[i] = (byte) (bytes[i] ^ 5); //x ^ y ^ y = x
                }
                bos.write(bytes,0,read);
            }
            System.out.println("图片解密成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    if (bos != null)
                        bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
