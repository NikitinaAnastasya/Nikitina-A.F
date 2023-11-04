package Other;

import Devices.Laptop;
import Devices.Tablet;
import Devices.Telephone;
import Oc.Android;
import Oc.IOS;
import Oc.Windows;

import java.util.Random;

public class Randomizer {
    public Device random (){
        OC oc = null;

        Random random =new Random();

        switch (random.nextInt(3)+1){
            case 1 -> oc = new Android();
            case 2 -> oc = new Windows();
            case 3 -> oc = new IOS();
            default -> throw new RuntimeException("Ошибка OC") ;
        }
        switch (random.nextInt(3)+1){
            case 1 -> {
                return new Laptop(oc);
            }
            case 2 -> {
                return new Tablet(oc);
            }
            case 3 -> {
                return new Telephone(oc);
            }
            default -> throw new RuntimeException("Ошибка Device") ;
        }

    }
}
