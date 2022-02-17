import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Imagereader {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        File fileObject = new File("<absolute path to the file>");
        BufferedImage buff = ImageIO.read(fileObject);
        ByteArrayOutputStream byteObject = new ByteArrayOutputStream();
        ImageIO.write(buff,"jpg",byteObject);
        byte[] data = byteObject.toByteArray();
        System.out.println("MD5 digest generation start");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(data);
        byte[] hash = messageDigest.digest();
        System.out.println("the final hash value "+hash);

    }
}
