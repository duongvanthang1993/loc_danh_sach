import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongShort {
    public static void main(String[] args) {
        try {
            String filePath = "songs.html";
            String content = new String(Files.readAllBytes(Paths.get(filePath)), "UTF-8");

            content = content.replaceAll("[\\r\\n]", "").trim();

            String regex = "class=\"nam_song\"[^>]*>(.*?)</a>";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(content);

            System.out.println("---- danh sacsh bai hat trich xuat");
            int count = 0;
            while (matcher.find()) {
                count++;
                System.out.println(count + ". " + matcher.group(1));
            }
            if (count == 0) {
                System.out.println("khong tim thay bai hat nao khop voi dinh dang");
            }

        } catch (IOException e) {
            System.out.println("Loi doc file" + e.getMessage());
            e.printStackTrace();
        }
    }
}