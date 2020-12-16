import java.util.HashMap;
import java.util.ResourceBundle;

//Singleton

public class i18NManager {

    private static i18NManager manager;
    //data


    HashMap<String,ResourceBundle> data;

    private i18NManager(){
        this.data = new HashMap<String, ResourceBundle>();

        ResourceBundle ca = ResourceBundle.getBundle("ca");
        ResourceBundle es = ResourceBundle.getBundle("es");
        ResourceBundle en = ResourceBundle.getBundle("en");

        this.data.put("es", es);
        this.data.put("ca", ca);
        this.data.put("en", en);
    }

    public static i18NManager getInstance(){
        if (manager==null) manager = new i18NManager();
        return manager;
    }

    public String getText(String language, String key){
        String result = null;
        result = this.data.get(language).getString(key);
        return result;
    }

    public static void main(String[] args) {
        //Hola, Hola, Hello
        System.out.println(i18NManager.getInstance().getText("cat","l1"));
        System.out.println(i18NManager.getInstance().getText("esp", "l1"));
        System.out.println(i18NManager.getInstance().getText("eng", "l1"));
        //Adeu, Adios, Bye
        System.out.println(i18NManager.getInstance().getText("cat", "l2"));
        System.out.println(i18NManager.getInstance().getText("esp", "l2"));
        System.out.println(i18NManager.getInstance().getText("eng", "l2"));
        //Gracies, Gracias, Thank you
        System.out.println(i18NManager.getInstance().getText("cat", "l3"));
        System.out.println(i18NManager.getInstance().getText("esp", "l3"));
        System.out.println(i18NManager.getInstance().getText("eng", "l3"));


    }
}
