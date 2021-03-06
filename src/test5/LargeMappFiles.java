package test5;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMappFiles {
    static int length=0x8FFFFFF;//128m

    public static void main(String[] args) throws IOException {
        MappedByteBuffer out=new RandomAccessFile("test.dat","rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE,0,length);
        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }
        System.out.println("finish");
        for (int i = length/2; i <length/2+6 ; i++) {
            System.out.println((char) out.get(i));
        }

    }
}
