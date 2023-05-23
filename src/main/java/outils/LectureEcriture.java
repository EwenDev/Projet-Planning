package outils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

/**
 * Classe permettant de lire et d'écrire dans un fichier
 */
public class LectureEcriture {

    /**
     * Méthode permettant de lire dans un fichier
     * @param file : le fichier à lire
     * @return Object : l'objet lu
     */
    public static Object lecture (File file){
        ObjectInputStream flux;
        Object objetLu = null;

        //Ouverture du fichier en mode lecture
        try{
            flux = new ObjectInputStream(new FileInputStream(file));
            objetLu = (Object) flux.readObject();
            flux.close();
        }

        catch (IOException parException){
            System.err.println("Erreur lecture du fichier " + parException.toString());
            System.exit(1);
        }

        catch (ClassNotFoundException parException){
            System.err.println("Erreur classe non trouvée " + parException.toString());
            System.exit(1);
        }

        return objetLu;
    }

    /**
     * Méthode permettant d'écrire dans un fichier
     * @param file : le fichier à écrire
     * @param object : l'objet à écrire
     */
    public static void ecriture (File file, Object object){
        ObjectOutputStream flux = null;

        //Ouverture du fichier en mode écriture
        try{
            flux = new ObjectOutputStream(new FileOutputStream(file));
            flux.writeObject(object);
            flux.flush();
            flux.close();
        }

        catch (IOException parException){
            System.err.println("Problème d'écriture dans le fichier " + parException.toString());
            System.exit(1);
        }
    }
}
