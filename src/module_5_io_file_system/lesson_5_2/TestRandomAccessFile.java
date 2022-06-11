package module_5_io_file_system.lesson_5_2;

import java.io.*;
import java.util.zip.*;

public class TestRandomAccessFile {
    public static void main(String[] args) throws FileNotFoundException {
        RandomAccessFile ras = new RandomAccessFile("in-file.txt", "rws");
        FileFilter ff;
        FilenameFilter fnf;

        DeflaterOutputStream dof;
            ZipOutputStream zos;
            GZIPOutputStream gos;

        InflaterInputStream iis;
            ZipInputStream zis;
            GZIPInputStream gis;

            Externalizable ex;

            InputStream is;
            OutputStream os;
            Reader r;
            Writer w;

        System.out.println(System.in.getClass());
        BufferedInputStream b;
        System.out.println(System.out.getClass());
        PrintStream p;

        System s;
    }
}
