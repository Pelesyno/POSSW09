package dsrtecnologia.com.br.petindermobile;

import android.app.Activity;
import android.content.res.Configuration;

public class Orientacao {

    public static String verificarOrientacao(Activity activity){
        int orientacao = activity.getResources().getConfiguration().orientation;
        String returnOrientation="";

        if(orientacao == Configuration.ORIENTATION_LANDSCAPE)
            returnOrientation = "paisagem";
        else if(orientacao == Configuration.ORIENTATION_PORTRAIT)
            returnOrientation = "retrato";
        return returnOrientation;
    }

}
