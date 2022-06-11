package module_5_io_file_system.lesson_5_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// доступ к файловой системе
public class FileAccess {

    char sepChar = File.separatorChar;           //   '\\'
    char pathSepChar = File.pathSeparatorChar;   //    ';'
    String sepStr = File.separator;              //   "\\"
    String pathSepStr = File.pathSeparator;      //    ";"

    // создание объектов файлов
    File webFile = new File("\\\\server\\share");
    File localFile = new File("C:\\users\\user\\my in-file.txt");    // .isAbsolute() - true
    File noAbs = new File("my in-file.txt");   // getAbsolutePath()     .isAbsolute() - false
    File noCanon = new File("C:\\users\\..\\my in-file.txt");       // getCanonicalPath() - "C:\my in-file.txt"

    // создание объекта директории
    File dir = new File("C:\\users\\user\\my dir");
    // фильтрация файлов из директории лямдой
    File[] files = dir.listFiles(f -> f.getName().endsWith(".txt"));

    //  новая технология
    Path path = Paths.get("out-file.txt");
    Path fromFile = localFile.toPath();
    File fromPath = path.toFile();


    public static void main(String[] args) throws IOException {

        File file = new File("file\\mom\\in-file.txt");
        File dir = new File("file\\mom");

        dir.mkdir();
        dir.mkdirs();
        file.createNewFile();

        file.getCanonicalPath();             //  путь сначала диска
        dir.getParent();                     //  родительская директория
        dir.listFiles();                     //  все содержимые файлы и директории
        dir.list();                          //  имена всех содержимыех файл и директории

        file.renameTo(new File("in-file.txt"));
        file.renameTo(new File("file\\in-file.txt"));

        (new File("w\\h\\o\\r")).delete();
        dir.delete();



        Path path = Path.of("file", "fuck.txt");
        Path directory = dir.toPath();

        Files.createFile(path);
        Files.newInputStream(path);
        Files.move(path, Path.of("file\\mom\\fuck.txt"));
        Files.createDirectory(directory);
        Files.delete(path);

    }

}
