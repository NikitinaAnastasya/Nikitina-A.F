import java.util.*;

public class Calculator {
    public double calc(List<Tovar> listZakaza){
        List<Tovar> check = new ArrayList<>();

        double d = 0;
        double sum;
        double sumN = 0;
        double sumNap =0;
        double sumP=0;
        int kolvoPizza = 0;
        int kolvoNap=0;

        for (int i = 0;i<listZakaza.size();i++) {
            d+= listZakaza.get(i).getCena();
            if (listZakaza.get(i).getWid().equals("Pizza")){
                kolvoPizza +=1;
                if (kolvoPizza == 5){
                    listZakaza.get(i).setCena(0);
                    kolvoPizza = 0;
                }
                sumP+=listZakaza.get(i).getCena();
            }
            if (listZakaza.get(i).getWid().equals("Napitki")){

                if(listZakaza.get(i).getCena()>2){
                    kolvoNap+=1;
                    sumN+=listZakaza.get(i).getCena();
                }else {
                    sumNap += listZakaza.get(i).getCena();
                }

            }

        }
        listZakaza.forEach(System.out::println);
        check.add(listZakaza.get(0));

        for (int i = 1;i<listZakaza.size();i++) {
            int a =0;
            for (int j = 0;j<check.size();j++) {
                if (listZakaza.get(i).getId() == check.get(j).getId()){
                    check.get(j).setKolvo( check.get(j).getKolvo() + 1  );
                    check.get(j).setCena( check.get(j).getCena() + listZakaza.get(i).getCena());
                    a = 0;
                    break;
                }else {
                    a = 1;
                }
            }
            if ( a == 1){
                check.add(new Tovar(listZakaza.get(i).getId(), listZakaza.get(i).getName(),
                        listZakaza.get(i).getCena(), listZakaza.get(i).getWid(),1));
            }
        }


        if(kolvoNap>3){
            sumN -= sumN*0.15;
        }

        sum = sumP+ sumN+sumNap;
        if(sum > 50){
            sum-= sum*0.2;
        }
        System.out.println("------------------");
        System.out.println(check.size());

        for (Tovar tovar : check) {
            System.out.println(tovar.getName() + " " + tovar.getKolvo() + " шт " + tovar.getCena() + " руб");
        }
        System.out.println("Сумма скидки = " + (d - sum));

        return sum;
    }
}
