import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> list = Arrays.asList(
                new File("D://Users/Games/src/"),
                new File("D://Users/Games/res/"),
                new File("D://Users/Games/savegames/"),
                new File("D://Users/Games/temp/"),
                new File("D://Users/Games/src/main/"),
                new File("D://Users/Games/src/test/"),
                new File("D://Users/Games/res/drawables/"),
                new File("D://Users/Games/res/vectors/"),
                new File("D://Users/Games/res/icons/"));

        List<File> fileList = Arrays.asList(
                new File("D://Users/Games/main/Utils.java"),
                new File("D://Users/Games/src/main/Main.java"),
                new File("D://Users/Games/temp/temp.txt")
        );
        list.stream().forEach(file -> {
            if (file.mkdir()) sb.append("Каталог " + file + " создан\n");
            else sb.append("Каталог " + file + " не создан\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });

        try (FileWriter log = new FileWriter("D://Users/Games/temp/temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("D://Users/Games/temp/temp.txt"))) {
            String s;
            while((s=br.readLine())!=null)
                System.out.println(s);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}