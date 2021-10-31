package net.sevecek.turtle;

import net.sevecek.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {

    // Úkol č. 5 - programování Marek Veselý

    Turtle zofka;

    public int aktualniX(){
        int x = (int) zofka.getX();
        return x;
    }

    public int aktualniY(){
        int y = (int) zofka.getY();
        return y;
    }

    public void nastavNahodnouBarvu(){
        int nahodneCislo0255R = (int) (Math.random()*256);
        int nahodneCislo0255G = (int) (Math.random()*256);
        int nahodneCislo0255B = (int) (Math.random()*256);
        Color nahodnaBarva = new Color(nahodneCislo0255R,nahodneCislo0255G,nahodneCislo0255B);
        zofka.setPenColor(nahodnaBarva);
    }

    public void nakresliCtverec(double delkaStranyCtverce){
        for (int i = 0; i < 4; i++) {
            this.nastavNahodnouBarvu();
            zofka.move(delkaStranyCtverce);
            zofka.turnRight(90);
        }
    }

    public void nakresliObdelnik(double stranaA, double stranaB){
        for (int i = 0; i < 2; i++) {
            this.nastavNahodnouBarvu();
            zofka.move(stranaA);
            zofka.turnRight(90);
            this.nastavNahodnouBarvu();
            zofka.move(stranaB);
            zofka.turnRight(90);
        }
    }

    public void nakresliRovnostrannyTrojuhelnik (double delkaStranyTrojuhelniku){
        zofka.turnRight(30);
        for (int i = 0; i < 3; i++) {
            this.nastavNahodnouBarvu();
            zofka.move(delkaStranyTrojuhelniku);
            zofka.turnRight(120);
        }
        zofka.turnLeft(30);
    }


    public void odANakresliRovnoramennyTrojuhelnik (double delkaRameneTrojuhelniku, double uhelMeziRameny) {

        zofka.turnRight(uhelMeziRameny/2);
        this.nastavNahodnouBarvu();
        zofka.move(delkaRameneTrojuhelniku);
        zofka.turnRight(180-uhelMeziRameny);

        this.nastavNahodnouBarvu();
        zofka.move(delkaRameneTrojuhelniku);
        zofka.turnRight(180-((180-uhelMeziRameny)/2));

        this.nastavNahodnouBarvu();
        double stranaC = 2*delkaRameneTrojuhelniku* Math.sin(Math.toRadians(uhelMeziRameny)/2);
        zofka.move(stranaC);
        zofka.turnRight(90);
    }

    public void odBNakresliRovnoramennyTrojuhelnik (double delkaRameneTrojuhelniku, double uhelMeziRameny) {

        zofka.turnLeft(uhelMeziRameny/2);

        this.nastavNahodnouBarvu();
        zofka.move(delkaRameneTrojuhelniku);
        zofka.turnRight(180-((180-uhelMeziRameny)/2));
        // nacte a vypise koordinaty leveho vrcholu
        //this.aktualniX();
        //this.aktualniY();
        //System.out.println("x= " + aktualniX() + " y= "+ aktualniY());

        this.nastavNahodnouBarvu();
        double stranaC = 2*delkaRameneTrojuhelniku* Math.sin(Math.toRadians(uhelMeziRameny)/2);
        zofka.move(stranaC);
        zofka.turnRight(180-((180-uhelMeziRameny)/2));
        // nacte a vypise koordinaty praveho vrcholu
        //this.aktualniX();
        //this.aktualniY();
        //System.out.println("x= " + aktualniX() + " y= "+ aktualniY());

        this.nastavNahodnouBarvu();
        zofka.move(delkaRameneTrojuhelniku);
        zofka.turnRight(180-uhelMeziRameny/2);
    }


    public void nakresliKruh(double delkaUseku, double uhelOtoceni){
        zofka.turnLeft(90);
        for (double i = 0; i < 360/uhelOtoceni; i++) {
            this.nastavNahodnouBarvu();
            zofka.move(delkaUseku);
            zofka.turnRight(uhelOtoceni);
            // nacte koordinaty nejvzdalenejsiho bodu kruhu - vypocet prumeru kruhu
            /*
            double j = (360/uhelOtoceni)/2;
            if (i == j) {
                this.aktualniX();
                this.aktualniY();
                System.out.println("x= " + aktualniX() + " y= "+ aktualniY());
                }
            */
        }
        zofka.turnRight(90);
    }


    public void main(String[] args) {


        zofka = new Turtle();

        zofka.setLocation(30,30);
        this.nakresliCtverec(20);
        zofka.setLocation(65,30);
        this.nakresliObdelnik(20,30);
        zofka.setLocation(110,30);
        this.nakresliRovnostrannyTrojuhelnik(25);
        zofka.setLocation(155,30);
        this.odBNakresliRovnoramennyTrojuhelnik(22,40);
        zofka.setLocation(170,30);
        this.odANakresliRovnoramennyTrojuhelnik(22,40);
        zofka.setLocation(210,30);
        this.nakresliKruh(1,5);

        //Masinka
        zofka.setLocation(850,400);
        zofka.setSpeed(5);
        this.nakresliObdelnik(180,130);

        zofka.setLocation(this.aktualniX()-200,this.aktualniY());
        this.nakresliObdelnik(80,200);
        zofka.turnRight(135);

        zofka.setLocation(this.aktualniX(),this.aktualniY()-60);
        this.odANakresliRovnoramennyTrojuhelnik(90,90);
        zofka.turnLeft(135);

        zofka.setLocation(this.aktualniX()+45,this.aktualniY()+60);
        zofka.turnRight(180);
        this.nakresliKruh(2.3,4);

        zofka.setLocation(this.aktualniX()+80,this.aktualniY());
        this.nakresliKruh(2.3,4);
        zofka.turnRight(90);

        zofka.setLocation(this.aktualniX()+205,this.aktualniY());
        this.nakresliKruh(4.5,4);
        zofka.turnRight(90);


        //Snehulak
        zofka.setLocation(410,465);
        this.nakresliKruh(6.5,4);

        zofka.setLocation(410,278);
        this.nakresliKruh(5,4);

        zofka.setLocation(410,134);
        this.nakresliKruh(3.2,4);

        zofka.setLocation(338,206);
        zofka.turnLeft(90);
        this.nakresliKruh(1.7,4);
        zofka.turnRight(90);

        zofka.setLocation(482,206);
        zofka.turnRight(90);
        this.nakresliKruh(1.7,4);
        zofka.turnLeft(90);


        //Zmrzka
        zofka.setLocation(160,465);
        this.odBNakresliRovnoramennyTrojuhelnik(180,45);
        zofka.setLocation(91,298);
        zofka.turnRight(75);
        this.nakresliKruh(5,4);
        zofka.turnLeft(75);
        zofka.setLocation(410,371.5);
        // levy vrchol x= 111 y= 298, pravy vrchol x= 248 y= 298 = strana C = 137
        // polomer prostredni koule snehulaka 144px
        //System.out.println("Aktualni x = " + this.aktualniX() + " Aktualni y =" + this.aktualniY());


    }

}
