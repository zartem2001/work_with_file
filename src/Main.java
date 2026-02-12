import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File dir1 = new File("D://Users/Games/src/");
        File dir2 = new File("D://Users/Games/res/");
        File dir3 = new File("D://Users/Games/savegames/");
        File dir4 = new File("D://Users/Games/temp/");
        File dir5 = new File("D://Users/Games/src/main/");
        File dir6 = new File("D://Users/Games/src/test/");
        File dir7 = new File("D://Users/Games/res/drawables/");
        File dir8 = new File("D://Users/Games/res/vectors/");
        File dir9 = new File("D://Users/Games/res/icons/");
        File dir10 = new File("D://Users/Games/main/Utils.java");
        File dir11 = new File("D://Users/Games/src/main/Main.java");
        File dir12 = new File("D://Users/Games/temp/temp.txt");
        List<File> list = new ArrayList<>();
        list.add(dir1);
        list.add(dir2);
        list.add(dir3);
        list.add(dir4);
        list.add(dir5);
        list.add(dir6);
        list.add(dir7);
        list.add(dir8);
        list.add(dir9);
        list.add(dir10);
        list.add(dir11);
        list.add(dir12);
        StringBuilder sb = new StringBuilder();
        String suc = "success";
        String err = "error";
        int i;
        for (i = 0; i < list.toArray().length - 3; i++) {
            if (list.get(i).mkdirs()) {
                sb.append(list.get(i) + " " + suc + "\n");
            } else {
                sb.append(list.get(i) + " " + err + "\n");
            }
        }
        try {
            for (int j = i + 1; j < list.toArray().length; j++) {
                if (list.get(i).createNewFile()) {
                    sb.append(list.get(i) + " " + suc + "\n");
                } else {
                    sb.append(list.get(i) + " " + err + "\n");
                }
            }
        } catch (IOException ex) {
            System.out.println("Файл " + list.get(i) + " не создан");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir12))) {
            writer.append(sb);
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dir12));
        String text = bufferedReader.readLine();
        while (text != null) {
            System.out.println(text);
            text = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}