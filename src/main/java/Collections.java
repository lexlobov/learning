import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args){
        String[] langs = new String[4];
        langs[0]= "Java";
        langs[1]= "C#";
        langs[2]= "Python";
        langs[3]= "PHP";

        for (int i=0; i<langs.length; i++){
            System.out.println("Я хочу выучить " + langs[i]);
            if (i == langs.length -1){
                System.out.println("---------------------");
            }
        }

        for (String i : langs){
            System.out.println("Я хочу выучить " + i);
        }

        List<String> languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");

        for (String i : languages){
            System.out.println(i);
        }
        List<String> langs2 = Arrays.asList("Java", "Go", "JS");
        for (int i = 0; i< langs2.size(); i++){
            System.out.println(langs2.get(i));
        }
    }
}
