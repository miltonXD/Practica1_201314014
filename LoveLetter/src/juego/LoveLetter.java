package juego;

import java.util.Scanner;

public class LoveLetter {
    static int token;
     static int tokenj;
     static int tokenPc;
     static int ficha;
      static  String jugador1;
      static  String jugador2;
      static String debug;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int jugar;
        int nPartida=0;
        do{
        if(tokenj==0 && tokenPc==0){
        System.out.println("             ----Bienvenido a LoveLetter-----        ");
        System.out.println( "1.Jugar una partida") ;
        System.out.println( "2.Selecciona el numero de tokens a jugar") ;
        System.out.println( "3 Mostrar las reglas de Juego") ;
        System.out.println( "4.Salir") ;   
        }else{
            System.out.println("             ----Bienvenido a LoveLetter-----        ");
        System.out.println( "1.Seguir Jugando") ;
        System.out.println( "3 Mostrar las reglas de Juego") ;
        System.out.println( "4.Salir") ;
        }    
        System.out.println( "ingrese la opcion que desea (1-4)") ; 
        n = sc.nextInt();
           switch(n){
              case 1:
                  Mazo mazo= new Mazo();
                  if(tokenj==0 && tokenPc==0){
                    System.out.println("Ingrese el nombre del jugador 1");
                    jugador1 = sc.next();
                    System.out.println("Ingrese el nombre del jugador 2");
                    jugador2 = sc.next();
                    ficha=(int) (Math.random()*2);
                     if(ficha==0){
                     System.out.println("Usted jugara Primero");
                      }else{
                      System.out.println("Usted jugara Segundo"); 
                   }
                  }else{
                      System.out.println("*****Sigamos Jugando*******");
                  }
                 mazo.barajear();
                 mazo.cartasFuera();
                 do{//comienza el ciclo del mune a mostrar
                 System.out.println("-------------------------------");    
                 System.out.println(jugador1+": "+tokenj+"        "+jugador2+" : "+tokenPc);
                 
                 if(nPartida==0 && ficha==0){//patida igual a 0 y al jugador le toca primero
                   mazo.RepartirCartaI(nPartida,ficha);
                   mazo.EfectoCountess(nPartida);
                   if(mazo.aplicoEfecto==1){
                   System.out.println("1.Usar Carta #1");
                   System.out.println("2.Usar Carta #2");
                   System.out.println("3.Terminar juego");
                   jugar=sc.nextInt();
                   if(jugar==3){
                	   System.exit(0);
                      }
                   mazo.cartasJugadas(jugar, nPartida);
                   mazo.efectoJugador(nPartida);
                   }else{
                       System.out.println("Se Activo el efecto de la Countess AUTOMATICAMENTE"); 
                   }
                   if(mazo.ganar==1){
                	   System.out.println("---");
                   }else{
                   mazo.repartirCartaPc();
                   mazo.pc(nPartida);
                   mazo.EfectoPc(nPartida);
                   }
                   System.out.println("quieres ver el mazo si(s) o no (n)");
                   debug=sc.next();
                   if(debug.equals("s")){
                	   for (int q = 0; q < mazo.aux.length; q++) {
                		   System.out.println(mazo.aux[q]);
                	   }
                   }
                   if(debug.equals("n")){
                	   System.out.println("no se mostro el mazo");
                   }
                   
                 }
                 else if(nPartida==0 && ficha!=0){//comienza partida igual a 0 y juega primero la pc
                      mazo.RepartirCartaI(nPartida,ficha);
                      mazo.pc(nPartida);
                      mazo.EfectoPc(nPartida);
                      if(mazo.ganarR==1){
                    	  System.out.println("---");
                      }else{
                      mazo.repartirCartaJugador();
                      mazo.EfectoCountess(nPartida);
                      if(mazo.aplicoEfecto==1){
                      System.out.println("1.Usar Carta #1");
                      System.out.println("2.Usar Carta #2");
                      System.out.println("3.Terminar juego");
                      jugar=sc.nextInt();
                      if(jugar==3){
                   	   System.exit(0);
                      }
                      mazo.cartasJugadas(jugar, nPartida);
                      mazo.efectoJugador(nPartida);
                      }else{
                       System.out.println("Se Activo el efecto de la Countess AUTOMATICAMENTE"); 
                    }
                  }
                      System.out.println("quieres ver el mazo si(s) o no (n)");
                      debug=sc.next();
                      if(debug.equals("s")){
                   	   for (int q = 0; q < mazo.aux.length; q++) {
                   		   System.out.println(mazo.aux[q]);
                   	   }
                      }
                      if(debug.equals("n")){
                   	   System.out.println("no se mostro el mazo");
                      }    
                 }
                  else if(nPartida!=0 && ficha==0){
                      mazo.repartirCartaJugador();
                      mazo.EfectoCountess(nPartida);
                      if(mazo.aplicoEfecto==1){
                      System.out.println("1.Usar Carta #1");
                      System.out.println("2.Usar Carta #2");
                      System.out.println("3.Terminar juego");
                      jugar=sc.nextInt();
                      if(jugar==3){
                   	   System.exit(0);
                      }
                      mazo.cartasJugadas(jugar, nPartida);
                      mazo.efectoJugador(nPartida);
                      }else{
                       System.out.println("Se Activo el efecto de la Countess AUTOMATICAMENTE"); 
                        }
                      if(mazo.ganar==1){
                    	  System.out.println("---");
                      }else{
                      mazo.repartirCartaPc();
                      mazo.pc(nPartida);
                      mazo.EfectoPc(nPartida);
                    }
                      System.out.println("quieres ver el mazo si(s) o no (n)");
                      debug=sc.next();
                      if(debug.equals("s")){
                   	   for (int q = 0; q < mazo.aux.length; q++) {
                   		   System.out.println(mazo.aux[q]);
                   	   }
                      }
                      if(debug.equals("n")){
                   	   System.out.println("no se mostro el mazo");
                      } 
                   }
                  else if(nPartida!=0 && ficha!=0){
                      mazo.repartirCartaPc();
                      mazo.pc(nPartida);
                      mazo.EfectoPc(nPartida);
                      if(mazo.ganarR==1){
                    	  System.out.println("---");
                      }else{
                      mazo.repartirCartaJugador();
                      mazo.EfectoCountess(nPartida);
                      if(mazo.aplicoEfecto==1){
                      System.out.println("1.Usar Carta #1");
                      System.out.println("2.Usar Carta #2");
                      System.out.println("3.Terminar juego");
                      jugar=sc.nextInt();
                      if(jugar==3){
                   	   System.exit(0);
                      }
                      mazo.cartasJugadas(jugar, nPartida);
                      mazo.efectoJugador(nPartida);
                      }else{
                       System.out.println("Se Activo el efecto de la Countess AUTOMATICAMENTE"); 
                        }
                   }
                      System.out.println("quieres ver el mazo si(s) o no (n)");
                      debug=sc.next();
                      if(debug.equals("s")){
                   	   for (int q = 0; q < mazo.aux.length; q++) {
                   		   System.out.println(mazo.aux[q]);
                   	   }
                      }
                      if(debug.equals("n")){
                   	   System.out.println("no se mostro el mazo");
                      }   
                 }
                  nPartida++;
                 }while(mazo.ganar!=1 && mazo.ganarR!=1);
                 if(mazo.ganar==1){
                     tokenj++;
                     mazo.cartaActual=4;
                     nPartida=0;
                     if(token==tokenj){
                         System.out.println("En Horabuena Has ganado :)");
                         System.exit(0);
                     }
                 }
                 if(mazo.ganarR==1){
                     tokenPc++;
                     mazo.cartaActual=4;
                     nPartida=0;
                     if(token==tokenPc){
                         System.out.println("Lastima has perdido,Intentalo en otra ocasion :(");
                         System.exit(0);
                     }
                 }
              break;
              case 2:
                  System.out.println("Ingrese el numero de tokens a jugar");
                 token = sc.nextInt();
              break;
              case 3:
            	  System.out.println("           ---------------------------REGLAS------------------------------");
                  System.out.println("El juego tiene 16 cartas. Cada carta diferente representa a alguien de la residencia real.\nCada carta tiene un valor en la esquina "
                  +"superior izquierda – cuanto más alto sea el número, más cercana es la persona a la princesa. \nEn la parte inferior de cada carta un texto describe su efecto cuando es descartada.");
                  System.out.println("quien la leerá.Cuando haya leído las suficientes cartas de uno de los pretendientes, caerá perdidamente enamorada"
                  +"Love Letter se juega en diferentes rondas.\nCada ronda representa un día. Al final de cada ronda, la carta de un jugador llega a la Princesa Annete, "
                  +", concediendo a ese pretendiente el permiso para cortejarla.\n Ese jugador ganará el corazón de la princesa y la partida.");
                  System.out.println("Durante tu turno, roba la carta superior del mazo y añádela a tu mano. Entonces elige una de las dos cartas y descártala" 
                  +"cara arriba delante tuya.\n Deberás aplicar el efecto de la carta descartada, incluso si es perjudicial para ti." 
                  +"Consulta la página 15 para ver los efectos de cada carta.\n De la misma manera si tienes cualquier duda sobre situaciones especiales con una carta allí encontrarás la respuesta.\n"
                  +"Las cartas descartadas permanecen delante del jugador que las descarta. \nColócalas superpuestas de manera visible para que quede claro el orden en que han sido descartadas.\n"
                  +"Esto ayudara a los jugadores a averiguar que cartas pueden tener en la mano los demás.Una vez es aplicado el efecto de la carta el turno pasa al jugador a tu izquierda.");
                  System.out.println("eliminado de la ronda Si un jugador es eliminado de la ronda, ese jugador descarta la carta en su mano boca arriba, (sin aplicar su efecto) y deja de jugar hasta la siguiente ronda.");
                  System.out.println("honradez Un jugador podría mentir al ser elegido por el efecto de la Guardia, o no descartar a la Condesa teniendo al rey o el príncipe en la mano.\n Sugerimos por tanto que" 
                  +"no juegues con rufianes que se diviertan haciendo trampas.");
                  System.out.println("Cartas del juego:");
                  System.out.println("(1) Guard: Permite adivinar la mano del rival (cartas del 2-8) si adivina, el jugador rival sale del juego. (5 en el mazo)");
                  System.out.println("(2) Priest:Permite ver la mano del jugador rival. (2 en el mazo)");
                  System.out.println("(3) Baron:Compara manos con el rival, el jugador con la carta mas baja sale del juego. En caso de empatar no sucede nada. (2 en el mazo)");
                  System.out.println("(4) Handmaid:El jugador que utiliza esta carta es inmune a los ataques de los demas por un (1) turno. (2 en el mazo)");
                  System.out.println("(5) PrincePermite “botar” la mano del jugador o la del rival. Y da una carta nueva del deck. (2 en el mazo)");
                  System.out.println("(6) King:Intercambia manos entre jugadores.(1 en el mazo)");
                  System.out.println("(7) Countess:Si el jugador tiene un Prince o King en su mano y la Countess debe jugar la Countess. (1 en el mazo)");
                  System.out.println("(8) PrincessSi el jugador juega esta carta pierde el juego. (1 en el mazo)");
                  System.out.println("gana el jugador que llegue a los tokens antes predefinidos");
                  System.out.println(" nota: null significa que no hay carta");
              break;
              case 4:
                  System.exit(1);
              break;    
              default: System.out.println("numero invalido eliga una opcion correcta");
              }
           }while(n!=4);
         System.out.println("Se ha salido del juego");
         System.exit(0);
     }
}