package napakalaki;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;
import java.util.Arrays;

public class PruebaNapakalaki {

    public static void main(String[] args) {
        
              Napakalaki napakalakiModel = Napakalaki.getInstance();
              NapakalakiView napakalakiView = new NapakalakiView();
              Dice.createInstance (napakalakiView);
              
              ArrayList<String> names = new ArrayList<>();
              PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
              names = namesCapture.getNames();
              napakalakiModel.initGame(names);
                napakalakiView.showView();
                
              napakalakiView.setNapakalaki(napakalakiModel);
              napakalakiView.showView();

    }
    
}
