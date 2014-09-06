package juego;

import java.util.Scanner;


/**
 *
 * @author MilTon navarro
 */
public class Mazo {
int Prueba [] = new int[16];
String aux[] = new String[16];
String personaje[]={"Guard","Guard","Guard","Guard","Guard","Priest","Priest","Baron","Baron","Handmaid","Handmaid","Prince","Prince","King","Countess","Princess"};
int cartaActual;
String MisCartas[]=new String[2];
String SusCartas[]= new String[2];
String cartasj1[]=new String[12];
String cartasj2[]=new String[12];
int ganar=0;
int ganarR=0;
String Efectorey[]= new String[1];
int EfectoBaron[]= new int[2];
String EfectoPrince[]=new String[10];
int nj,nr;
int aplicoEfecto=0;
int protegido = 0;
int protegidoj=0;
int colocar =0;
String p[]={"Priest","Baron","Handmaid","Prince","King","Countess","Princess"};//array que tiene cartas para efecto de Guard
        

     public void barajear(){
         int i ;
         int j = 0;
        for (i = 0; i < Prueba.length; i++) {
         Prueba[i] = (int) (Math.random() * 16);//*16 para generar entre 0 a 16 el random.
          while (j < i) {
                if (Prueba[i] == Prueba[j]) {
                     Prueba[i] = (int) (Math.random() * 16);
                   j = 0;
                 }
                 else {
                  j++;
                 }
         }
           j = 0;
          aux[i]= personaje[Prueba[i]];
      }               
    }
     
    public void RepartirCartaI(int nPartida,int ficha){
         cartaActual=4;
               if(ficha==0){
                 if ( cartaActual< aux.length ){
                     MisCartas[0]=aux[ cartaActual++ ];
                     aux[cartaActual-1]="null";
                     MisCartas[1]=aux[ cartaActual++ ];
                     aux[cartaActual-1]="null";
                     SusCartas[0]=aux[ cartaActual++ ];
                     aux[cartaActual-1]="null";
                     SusCartas[1]="null";
                     System.out.println("Tienes en tu mano: "+"1: "+MisCartas[0]+" y 2: "+MisCartas[1]+" las cartas del rival son:"+SusCartas[0]+" y "+SusCartas[1]+cartaActual);
                     }else{
                       System.out.println("ya no hay cartas");
                     }
         }
               if(ficha!=0){
                 if ( cartaActual< aux.length ){
                     SusCartas[0]=aux[ cartaActual++ ];
                     aux[cartaActual-1]="null";
                     SusCartas[1]=aux[ cartaActual++ ];
                     aux[cartaActual-1]="null";
                     MisCartas[0]=aux[ cartaActual++ ];
                     aux[cartaActual-1]="null";
                     MisCartas[1]="null";
                      System.out.println("Tienes en tu mano: "+"1: "+MisCartas[0]+" y 2: "+MisCartas[1]+" las cartas del rival son:"+SusCartas[0]+" y "+SusCartas[1]+cartaActual);
                     }else{
                       System.out.println("ya no hay cartas");
                     }
               }
    }
    //cartas que nose van a usar en el juego
    public void cartasFuera(){
        System.out.println("las cartas que se sacaron del juego son: "+aux[0]+","+aux[1]+","+aux[2]+" y la carta incognita");
        aux[0]="null";
        aux[1]="null";
        aux[2]="null";
        aux[3]="null";   
    }
    //reparte carta al jugador
    public void repartirCartaJugador(){
           if ( cartaActual< aux.length ){
                if( MisCartas[0].equals("null")){
                  MisCartas[0]=aux[ cartaActual++ ];
                  aux[cartaActual-1]="null";
                 System.out.println("Tienes en tu mano: "+"1: "+MisCartas[0]+" y 2: "+MisCartas[1]+" las cartas del rival son:"+SusCartas[0]+" y "+SusCartas[1]+cartaActual);
                  }
                if( MisCartas[1].equals("null")){
                  MisCartas[1]=aux[ cartaActual++ ];
                  aux[cartaActual-1]="null";
                 System.out.println("Tienes en tu mano: "+"1: "+MisCartas[0]+" y 2: "+MisCartas[1]+" las cartas del rival son:"+SusCartas[0]+" y "+SusCartas[1]+cartaActual);
                  }
               }else{
                   System.out.println("ya no hay cartas");
                   for(int t=0;t<2;t++){//poniendo numero a las carta de mi mano
                       if(MisCartas[t].equals("Guard")){
                           nj=1;
                       }
                       if(MisCartas[t].equals("Priest")){
                           nj=2;
                       }
                       if(MisCartas[t].equals("Baron")){
                           nj=3;
                       }
                       if(MisCartas[t].equals("Handmaid")){
                           nj=4;
                       }
                       if(MisCartas[t].equals("Prince")){
                           nj=5;
                       }
                       if(MisCartas[t].equals("King")){
                           nj=6;
                       }
                       if(MisCartas[t].equals("Countess")){
                           nj=7;
                       }
                       if(MisCartas[t].equals("Princess")){
                           nj=8;
                       }
                       if(MisCartas[t].equals("null")){
                           nj=nj+0;
                       }
                   }
                       
                     for(int u=0;u<2;u++){//poniendo numero a la carta del rival
                       if(SusCartas[u].equals("Guard")){
                           nr=1;
                       }
                       if(SusCartas[u].equals("Priest")){
                           nr=2;
                       }
                       if(SusCartas[u].equals("Baron")){
                           nr=3;
                       }
                       if(SusCartas[u].equals("Handmaid")){
                           nr=4;
                       }
                       if(SusCartas[u].equals("Prince")){
                           nr=5;
                       }
                       if(SusCartas[u].equals("King")){
                           nr=6;
                       }
                       if(SusCartas[u].equals("Countess")){
                           nr=7;
                       }
                       if(SusCartas[u].equals("Princess")){
                           nr=8;
                       } 
                       if(SusCartas[u].equals("null")){
                           nr=nr+0;
                       }
                   }
                   if(nj>nr){//verificando
                           System.out.println("Has ganado un token");
                           ganar=1;
                           }
                  if(nj<nr){
                           System.out.println("el rival ha ganado un token");
                           ganarR=1;
                  }          
    }
 }
      //reparte carta a ala computadora
    public void repartirCartaPc(){
        if ( cartaActual< aux.length ){
        if( SusCartas[0].equals("null")){
               SusCartas[0]=aux[ cartaActual++ ];
               aux[cartaActual-1]="null";
               System.out.println("Tienes en tu mano: "+"1: "+MisCartas[0]+" y 2: "+MisCartas[1]+" las cartas del rival son:"+SusCartas[0]+" y "+SusCartas[1]+cartaActual);
       }
        if( SusCartas[1].equals("null")){
               SusCartas[1]=aux[ cartaActual++ ];
               aux[cartaActual-1]="null";
               System.out.println("Tienes en tu mano: "+MisCartas[0]+" y 2: "+MisCartas[1]+" las cartas del rival son:"+SusCartas[0]+" y "+SusCartas[1]+cartaActual);
           }
          }else{
            System.out.println("ya no hay cartas");
            for(int t=0;t<2;t++){//poniendo numero a las carta de mi mano
                if(MisCartas[t].equals("Guard")){
                    nj=1;
                }
                if(MisCartas[t].equals("Priest")){
                    nj=2;
                }
                if(MisCartas[t].equals("Baron")){
                    nj=3;
                }
                if(MisCartas[t].equals("Handmaid")){
                    nj=4;
                }
                if(MisCartas[t].equals("Prince")){
                    nj=5;
                }
                if(MisCartas[t].equals("King")){
                    nj=6;
                }
                if(MisCartas[t].equals("Countess")){
                    nj=7;
                }
                if(MisCartas[t].equals("Princess")){
                    nj=8;
                }
                if(MisCartas[t].equals("null")){
                    nj=nj+0;
                }
            }
                
              for(int u=0;u<2;u++){//poniendo numero a la carta del rival
                if(SusCartas[u].equals("Guard")){
                    nr=1;
                }
                if(SusCartas[u].equals("Priest")){
                    nr=2;
                }
                if(SusCartas[u].equals("Baron")){
                    nr=3;
                }
                if(SusCartas[u].equals("Handmaid")){
                    nr=4;
                }
                if(SusCartas[u].equals("Prince")){
                    nr=5;
                }
                if(SusCartas[u].equals("King")){
                    nr=6;
                }
                if(SusCartas[u].equals("Countess")){
                    nr=7;
                }
                if(SusCartas[u].equals("Princess")){
                    nr=8;
                } 
                if(SusCartas[u].equals("null")){
                    nr=nr+0;
                }
            }
            if(nj>nr){//verificando
                    System.out.println("Has ganado un token");
                    ganar=1;
                    }
           if(nj<nr){
                    System.out.println("el rival ha ganado un token");
                    ganarR=1;
           }          
          
        }
    }
    public void cartasJugadas(int jugar,int nPartida){
        if(jugar==1){
           cartasj1[nPartida] = MisCartas[0];
            MisCartas[0]="null";
        }
        if(jugar==2){
           cartasj1[nPartida]=MisCartas[1];
            MisCartas[1]="null";
        }
         if(jugar== 3){
            System.exit(0);                                    
         }
        System.out.println(cartasj1[nPartida]);
        
    }
    public void pc(int nPartida){
       if (SusCartas[0].equals("Princess")){
           cartasj2[nPartida]=SusCartas[1];
           SusCartas[1]="null";
       }
       if (SusCartas[1].equals("Princess")){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[0].equals("Countess")&&(SusCartas[1].equals("King")&&SusCartas[1].equals("Prince")) ){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[1].equals("Countess")&&(SusCartas[0].equals("King")&&SusCartas[0].equals("Prince")) ){
           cartasj2[nPartida]=SusCartas[1];
           SusCartas[1]="null";
       }
       if(SusCartas[0].equals("Countess")&&(!SusCartas[1].equals("King")&&!SusCartas[1].equals("Prince")) ){
           cartasj2[nPartida]=SusCartas[1];
           SusCartas[1]="null";
       }
       if(SusCartas[1].equals("Countess")&&(!SusCartas[0].equals("King")&&!SusCartas[0].equals("Prince")) ){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[0].equals("King")&&SusCartas[1].equals("Prince") ){
           cartasj2[nPartida]=SusCartas[1];
           SusCartas[1]="null";
       }
       if(SusCartas[0].equals("Prince")&&SusCartas[1].equals("King") ){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[0].equals("King")||SusCartas[1].equals("King")){
           cartasj2[nPartida]="King";
           SusCartas[0]="null";
       }
       if(SusCartas[0].equals("King")&&(!SusCartas[1].equals("Prince")&&!SusCartas[1].equals("Princess")&&!SusCartas[1].equals("Countess"))){
            cartasj2[nPartida]=SusCartas[1];
            SusCartas[1]="null";
       }
       if(SusCartas[1].equals("King")&&(!SusCartas[0].equals("Prince")&&!SusCartas[0].equals("Princess")&&!SusCartas[0].equals("Countess"))){
            cartasj2[nPartida]=SusCartas[0];
            SusCartas[0]="null";
       }
       if(SusCartas[0].equals("Prince")&&SusCartas[1].equals("Handmaid")){
           cartasj2[nPartida]=SusCartas[1];
           SusCartas[1]="null";
       }
       if(SusCartas[1].equals("Prince")&&SusCartas[0].equals("Handmaid")){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[0].equals("Prince")&&SusCartas[1].equals("Guard")){
           cartasj2[nPartida]=SusCartas[1];
           SusCartas[1]="null";
       }
       if(SusCartas[1].equals("Prince")&&SusCartas[0].equals("Guard")){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[1].equals("Prince")&&(SusCartas[0].equals("Guard")||SusCartas[0].equals("Priest")||SusCartas[0].equals("Baron"))){
           cartasj2[nPartida]=SusCartas[1];
           SusCartas[1]="null";
       }
       if(SusCartas[0].equals("Prince")&&(SusCartas[1].equals("Guard")||SusCartas[1].equals("Priest")||SusCartas[1].equals("Baron"))){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[1].equals("Handmaid")&&SusCartas[0].equals("Handmaid")){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[1].equals("Baron")&&SusCartas[0].equals("Baron")){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[1].equals("Priest")&&SusCartas[0].equals("Priest")){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[1].equals("Guard")&&SusCartas[0].equals("Guard")){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[0].equals("Priest")&&SusCartas[1].equals("Guard")){
           cartasj2[nPartida]=SusCartas[1];
           SusCartas[1]="null";
       }
       if(SusCartas[1].equals("Priest")&&SusCartas[0].equals("Guard")){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[0].equals("Baron")&&(SusCartas[1].equals("Priest")||SusCartas[1].equals("Guard"))){
           cartasj2[nPartida]=SusCartas[1];
           SusCartas[1]="null";
       }
       if(SusCartas[1].equals("Baron")&&(SusCartas[0].equals("Priest")||SusCartas[0].equals("Guard"))){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[1].equals("Handmaid")&&(SusCartas[0].equals("Priest")||SusCartas[0].equals("Guard")||SusCartas[0].equals("Baron"))){
           cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       if(SusCartas[0].equals("Handmaid")&&(SusCartas[1].equals("Priest")||SusCartas[1].equals("Guard")||SusCartas[1].equals("Baron"))){
           cartasj2[nPartida]=SusCartas[1];
           SusCartas[1]="null";
       }
       if(SusCartas[0].equals("Prince")&&SusCartas[1].equals("Prince")){
    	   cartasj2[nPartida]=SusCartas[0];
           SusCartas[0]="null";
       }
       System.out.println("la computadora jugo la carta: "+cartasj2[nPartida]);
    }
    public void efectoJugador(int nPartida){
        int opcion;
        Scanner sc = new Scanner(System.in);
        if(cartasj1[nPartida].equals("Guard")){
            if(protegido==1){
                System.out.println("no hay efecto debido a la Handmaid");
            }
            if(protegido==0){
            System.out.println("Seleccione la carta que tiene su rival:");
            System.out.println("(2) Priest, (3) Baron , (4)Handmaid, (5)Prince, (6)King, (7)Countess,(8)Princess");
            opcion= sc.nextInt();
            if(opcion==2){
                      if(SusCartas[0].equals("Priest")||SusCartas[1].equals("Priest")){
                          System.out.println("Has ganado un token");  
                           ganar=1;
                      }
            }
            if(opcion==3){
                      if(SusCartas[0].equals("Baron")||SusCartas[1].equals("Baron")){
                          System.out.println("Has ganado un token");   
                           ganar=1;
                          
                      }
             }
             if(opcion==4){
                      if(SusCartas[0].equals("Handmaid")||SusCartas[1].equals("Handmaid")){
                          System.out.println("Has ganado un token");  
                           ganar=1;
                      }
             }
             if(opcion==5){
                      if(SusCartas[0].equals("Prince")||SusCartas[1].equals("Prince")){
                          System.out.println("Has ganado un token");      
                           ganar=1;
                    }
             }
             if(opcion==6){ 
                      if(SusCartas[0].equals("King")||SusCartas[1].equals("King")){
                          System.out.println("Has ganado un token");       
                           ganar=1;
                      }
             }
             if(opcion==7){
                      if(SusCartas[0].equals("Countess")||SusCartas[1].equals("Countess")){
                          System.out.println("Has ganado un token");  
                           ganar=1;
                      }
             }
             if(opcion==8){
                      if(SusCartas[0].equals("Princess")||SusCartas[1].equals("Princess")){
                          System.out.println("Has ganado un token");   
                           ganar=1;
                      }    
               }
            }
           protegido=0;
        }
        
     if(cartasj1[nPartida].equals("Priest")){
         if(protegido==1){
                System.out.println("no hay efecto debido a la Handmaid");
            }
         if(protegido==0){
          for(int z=0;z<2;z++){
              System.out.println("En la mano tiene la cartas:"+SusCartas[z]);
          }
         }
         protegido=0;
     }
        if(cartasj1[nPartida].equals("Baron")){
          if(protegido==1){
                System.out.println("no hay efecto debido a la Handmaid");
            }
         if(protegido==0){
           for(int x=0;x<2;x++){//poniendo numero a las carta de mi mano
               if(MisCartas[x].equals("Guard")){
                   nj=1;
               }
               if(MisCartas[x].equals("Priest")){
                   nj=2;
               }
               if(MisCartas[x].equals("Baron")){
                   nj=3;
               }
               if(MisCartas[x].equals("Handmaid")){
                   nj=4;
               }
               if(MisCartas[x].equals("Prince")){
                   nj=5;
               }
               if(MisCartas[x].equals("King")){
                   nj=6;
               }
               if(MisCartas[x].equals("Countess")){
                   nj=7;
               }
               if(MisCartas[x].equals("Princess")){
                   nj=8;
               }
               if(MisCartas[x].equals("null")){
                   nj=nj+0;
               }
           }
               
             for(int y=0;y<2;y++){//poniendo numero a la carta del rival
               if(SusCartas[y].equals("Guard")){
                   nr=1;
               }
               if(SusCartas[y].equals("Priest")){
                   nr=2;
               }
               if(SusCartas[y].equals("Baron")){
                   nr=3;
               }
               if(SusCartas[y].equals("Handmaid")){
                   nr=4;
               }
               if(SusCartas[y].equals("Prince")){
                   nr=5;
               }
               if(SusCartas[y].equals("King")){
                   nr=6;
               }
               if(SusCartas[y].equals("Countess")){
                   nr=7;
               }
               if(SusCartas[y].equals("Princess")){
                   nr=8;
               } 
               if(SusCartas[y].equals("null")){
                   nr=nr+0;
               }
           }
           if(nj>nr){//verificando
        	       System.out.println("yo: "+nj+" rival: "+nr);
                   System.out.println("Has ganado un token");
                   ganar=1;
               }
               if(nj<nr){
            	   System.out.println("yo: "+nj+" rival: "+nr);
                   System.out.println("el rival ha ganado un token");
                   ganarR=1;
               }
               if(nj==nr){
                   System.out.println("Sigue el juego");
               }
         }
           protegido=0;
        }
           
        if(cartasj1[nPartida].equals("Handmaid")){
          System.out.println("Esta protegido de ataques del rival");
          protegidoj=1;
        }
        
        if(cartasj1[nPartida].equals("Prince")){
         if(protegido==1){
                System.out.println("El rival esta protegido te ha obligado a tirar tu carta");
                   if(!MisCartas[0].equals("null")){
                            EfectoPrince[colocar++]=MisCartas[0];
                            MisCartas[0]="null";
                            MisCartas[0]=aux[ cartaActual++ ];
                            aux[cartaActual-1]="null";
                    }
                    if(!MisCartas[1].equals("null")){
                            EfectoPrince[colocar++]=MisCartas[1];
                            MisCartas[1]="null";
                            MisCartas[1]=aux[ cartaActual++ ];
                            aux[cartaActual-1]="null";
                       }
            }
        if(protegido==0){
           Scanner s = new Scanner(System.in);
            String efectoPrince; 
            System.out.println("quieres tirar la carta del rival presiona (r) y quieres tirar las de tu mano (t)");
            efectoPrince=s.next();
               if(efectoPrince.equals("t")){
                       if(!MisCartas[0].equals("null")){
                            EfectoPrince[colocar++]=MisCartas[0];
                            MisCartas[0]="null";
                            MisCartas[0]=aux[ cartaActual++ ];
                            aux[cartaActual-1]="null";
                            System.out.println("has tirado tu carta y elegido una nueva del mazo");
                       }
                       if(!MisCartas[1].equals("null")){
                            EfectoPrince[colocar++]=MisCartas[1];
                            MisCartas[1]="null";
                            MisCartas[1]=aux[ cartaActual++ ];
                            aux[cartaActual-1]="null";
                            System.out.println("has tirado tu carta y elegido una nueva del mazo");
                       }
               }
               if(efectoPrince.equals("r")){
                      if(!SusCartas[0].equals("null")){
                            EfectoPrince[colocar++]=SusCartas[0];
                            SusCartas[0]="null";
                            SusCartas[0]=aux[ cartaActual++ ];
                            aux[cartaActual-1]="null";
                            System.out.println("has tirado la carta del rival  y a elegido una nueva del mazo");       
                       }
                       if(!SusCartas[1].equals("null")){
                            EfectoPrince[colocar++]=SusCartas[1];
                            SusCartas[1]="null";
                            SusCartas[1]=aux[ cartaActual++ ];
                            aux[cartaActual-1]="null";
                            System.out.println("has tirado la carta del rival  y a elegido una nueva del mazo");
                       }
              }
            }
          protegido=0;
        }
        if(cartasj1[nPartida].equals("King")){
         if(protegido==1){
                System.out.println("no hay efecto debido a la Handmaid");
            }
         if(protegido==0){
             if(!SusCartas[0].equals("null") && !MisCartas[0].equals("null")){
                 Efectorey[0]=MisCartas[0];
                 MisCartas[0]=SusCartas[0];
                 SusCartas[0]= Efectorey[0];
                 System.out.println("Se han intercambiado las cartas");
             }
              if(!SusCartas[1].equals("null") && !MisCartas[1].equals("null")){
                 Efectorey[0]=MisCartas[1];
                 MisCartas[1]=SusCartas[1];
                 SusCartas[1]= Efectorey[0];
                  System.out.println("Se han intercambiado las cartas");
             }
               if(!SusCartas[1].equals("null") && !MisCartas[0].equals("null")){
                 Efectorey[0]=MisCartas[0];
                 MisCartas[0]=SusCartas[1];
                 SusCartas[1]= Efectorey[0];
                  System.out.println("Se han intercambiado las cartas");
             }
               if(!SusCartas[0].equals("null") && !MisCartas[1].equals("null")){
                 Efectorey[0]=MisCartas[1];
                 MisCartas[1]=SusCartas[0];
                 SusCartas[0]= Efectorey[0];
                  System.out.println("Se han intercambiado las cartas");
             }
         }  
         protegido=0;
        }
        if(cartasj1[nPartida].equals("Princess")){
        System.out.println("el rival ha ganado un token");
        ganarR=1;
        }
        
    }
    //efecto que se aplica automaticamente cuado tengo la coutess en la mano
   public void EfectoCountess(int nPartida){
         if(MisCartas[0].equals("Countess")&&(MisCartas[1].equals("King")||MisCartas[1].equals("Prince")) ){
           cartasj1[nPartida]=MisCartas[0];
           MisCartas[0]="null";
             }
          else if(MisCartas[1].equals("Countess")&&(MisCartas[0].equals("King")||MisCartas[0].equals("Prince")) ){
           cartasj1[nPartida]=MisCartas[1];
           MisCartas[1]="null";
            }
          else{
             aplicoEfecto=1; 
          }
  }
   //los efectos de las cartas jugadas por la computadora
  public void EfectoPc(int nPartida){
       if(cartasj2[nPartida].equals("Guard")){
           if(protegidoj==1){
                System.out.println("no hay efecto debido a la Handmaid");
           }
           if(protegidoj==0){
             int ayuda;
             ayuda = (int) (Math.random() * 6);
              if(p[ayuda].equals("Priest")){
                          if(MisCartas[0].equals("Priest")||MisCartas[1].equals("Priest")){
                          System.out.println("el rival eligio "+p[ayuda]+" el rival ha ganado un token");
                           ganarR=1;
                          }else{
                              System.out.println("la computadora eligio: "+p[ayuda]+" ha fallado");
                          }
                              
              }
              if(p[ayuda].equals("Baron")){
                          if(MisCartas[0].equals("Baron")||MisCartas[1].equals("Baron")){
                           System.out.println("el rival eligio "+p[ayuda]+" el rival ha ganado un token");
                           ganarR=1;
                            }else{
                            System.out.println("la computadora eligio "+p[ayuda]+" has fallado");
                          }
              }
               if(p[ayuda].equals("Handmaid")){
                          if(MisCartas[0].equals("Handmaid")||MisCartas[1].equals("Handmaid")){
                          System.out.println("el rival eligio "+p[ayuda]+" el rival ha ganado un token");
                           ganarR=1;
                            }else{
                              System.out.println("la computadora eligio "+p[ayuda]+" ha fallado");
                          }
                            
              }
              if(p[ayuda].equals("Prince")){
                          if(MisCartas[0].equals("Prince")||MisCartas[1].equals("Prince")){
                          System.out.println("el rival eligio "+p[ayuda]+" el rival ha ganado un token");  
                           ganarR=1;
                            }else{
                              System.out.println("la computadora eligio "+p[ayuda]+" ha fallado");
                          }
              }
              if(p[ayuda].equals("King")){
                          if(MisCartas[0].equals("king")||MisCartas[1].equals("King")){
                          System.out.println("el rival eligio "+p[ayuda]+" el rival ha ganado un token");
                           ganarR=1;
                            }else{
                              System.out.println("la rival eligio "+p[ayuda]+" ha fallado");
                          }
              }
              if(p[ayuda].equals("Countess")){
                          if(MisCartas[0].equals("Countess")||MisCartas[1].equals("Countess")){
                          System.out.println("el rival eligio "+p[ayuda]+" el rival ha ganado un token");
                           ganarR=1;
                            }else{
                              System.out.println("la computadora eligio "+p[ayuda]+" ha fallado");
                          }
              }
              if(p[ayuda].equals("Princess")){
                          if(MisCartas[0].equals("Princess")||MisCartas[1].equals("Princess")){
                          System.out.println("el rival  eligio "+p[ayuda]+"el rivval ha ganado un token ");
                           ganarR=1;
                            }else{
                              System.out.println("la computadora eligio "+p[ayuda]+" ha fallado");
                          }
              }
           }
        protegidoj=0;
       }
       
       //efecto del priest del rival
       if(cartasj2[nPartida].equals("Priest")){
          if(protegidoj==1){
                System.out.println("no hay efecto debido a la Handmaid");
         }
         if(protegidoj==0){
           for(int z=0;z<2;z++){
             System.out.println("En la mano tiene la cartas:"+MisCartas[z]);
          }
         }
        protegidoj=0;
       }
       if(cartasj2[nPartida].equals("Baron")){
          if(protegidoj==1){
                System.out.println("no hay efecto debido a la Handmaid");
         }
         if(protegidoj==0){
            for(int x=0;x<2;x++){//poniendo numero a las carta de mi mano
               if(MisCartas[x].equals("Guard")){
                   nj=1;
               }
               if(MisCartas[x].equals("Priest")){
                   nj=2;
               }
               if(MisCartas[x].equals("Baron")){
                   nj=3;
               }
               if(MisCartas[x].equals("Handmaid")){
                   nj=4;
               }
               if(MisCartas[x].equals("Prince")){
                   nj=5;
               }
               if(MisCartas[x].equals("King")){
                   nj=6;
               }
               if(MisCartas[x].equals("Countess")){
                   nj=7;
               }
               if(MisCartas[x].equals("Princess")){
                   nj=8;
               }
               if(MisCartas[x].equals("null")){
                   nj=nj+0;
               }
           }
               
             for(int y=0;y<2;y++){//poniendo numero a la carta del rival
               if(SusCartas[y].equals("Guard")){
                   nr=1;
               }
               if(SusCartas[y].equals("Priest")){
                   nr=2;
               }
               if(SusCartas[y].equals("Baron")){
                   nr=3;
               }
               if(SusCartas[y].equals("Handmaid")){
                   nr=4;
               }
               if(SusCartas[y].equals("Prince")){
                   nr=5;
               }
               if(SusCartas[y].equals("King")){
                   nr=6;
               }
               if(SusCartas[y].equals("Countess")){
                   nr=7;
               }
               if(SusCartas[y].equals("Princess")){
                   nr=8;
               } 
               if(SusCartas[y].equals("null")){
                   nr=nr+0;
               }
           }
           if(nj>nr){//verificando
        	       System.out.println("yo: "+nj+" rival: "+nr);
                   System.out.println("Has ganado un token");
                   ganar=1;
               }
               if(nj<nr){
            	   System.out.println("yo: "+nj+" rival: "+nr);
                   System.out.println("Has perdido,el rival ha ganado un token");
                   ganarR=1;
               }
               if(nj==nr){
                   System.out.println("Sigue el juego");
               }
         }
         protegidoj=0;
       }
       if(cartasj2[nPartida].equals("Handmaid")){
            System.out.println("el rival se ha protegido de cuaquier ataque");
            protegido=1;
       }
       if(cartasj2[nPartida].equals("Prince")){
            if(protegidoj==1){
                System.out.println("el rival fue obligado a tirar su carta");
                 if(!SusCartas[0].equals("null")){
                            EfectoPrince[colocar++]=SusCartas[0];
                            SusCartas[0]="null";
                            SusCartas[0]=aux[ cartaActual++ ];
                            aux[cartaActual-1]="null";
                  }
                  if(!SusCartas[1].equals("null")){
                            EfectoPrince[colocar++]=SusCartas[1];
                            SusCartas[1]="null";
                            SusCartas[1]=aux[ cartaActual++ ];
                            aux[cartaActual-1]="null";
                 }
            }
           if(protegidoj==0){
               if(SusCartas[0].equals("Baron")||SusCartas[0].equals("Priest")||SusCartas[0].equals("Guard")){
                      if(!SusCartas[0].equals("null")){
                            EfectoPrince[colocar++]=SusCartas[0];
                            SusCartas[0]="null";
                            SusCartas[0]=aux[ cartaActual++ ];
                            aux[cartaActual-1]="null";
                            System.out.println("se ha elegido como objetivo");
                       }
               }else if(SusCartas[1].equals("Baron")||SusCartas[1].equals("Priest")||SusCartas[1].equals("Guard")){
                       if(!SusCartas[1].equals("null")){
                            EfectoPrince[colocar++]=SusCartas[1];
                            SusCartas[1]="null";
                            SusCartas[1]=aux[ cartaActual++ ];
                            aux[cartaActual-1]="null";
                            System.out.println("se ha elegido como objetivo");
                       }
               }else{
                     if(!MisCartas[0].equals("null")){
                            EfectoPrince[colocar++]=MisCartas[0];
                            MisCartas[0]="null";
                            MisCartas[0]=aux[ cartaActual++ ];
                            aux[cartaActual-1]="null";
                            System.out.println("te ha elegido como objetivo");
                    }
                    if(!MisCartas[1].equals("null")){
                            EfectoPrince[colocar++]=MisCartas[1];
                            MisCartas[1]="null";
                            MisCartas[1]=aux[ cartaActual++ ];
                            aux[cartaActual-1]="null";
                             System.out.println("se ha elegido como objetivo");
                       }  
               }
           }         
          protegidoj=0;
       }
       //efecto del king de pc
       if(cartasj2[nPartida].equals("King")){
         if(protegidoj==1){
                System.out.println("no hay efecto debido a la Handmaid");
         }
         if(protegidoj==0){
           if(!SusCartas[0].equals("null") && !MisCartas[0].equals("null")){
                 Efectorey[0]=MisCartas[0];
                 MisCartas[0]=SusCartas[0];
                 SusCartas[0]= Efectorey[0];
                 System.out.println("Se han intercambiado las cartas");
             }
              if(!SusCartas[1].equals("null") && !MisCartas[1].equals("null")){
                 Efectorey[0]=MisCartas[1];
                 MisCartas[1]=SusCartas[1];
                 SusCartas[1]= Efectorey[0];
                  System.out.println("Se han intercambiado las cartas");
             }
               if(!SusCartas[1].equals("null") && !MisCartas[0].equals("null")){
                 Efectorey[0]=MisCartas[0];
                 MisCartas[0]=SusCartas[1];
                 SusCartas[1]= Efectorey[0];
                  System.out.println("Se han intercambiado las cartas");
             }
               if(!SusCartas[0].equals("null") && !MisCartas[1].equals("null")){
                 Efectorey[0]=MisCartas[1];
                 MisCartas[1]=SusCartas[0];
                 SusCartas[0]= Efectorey[0];
                  System.out.println("Se han intercambiado las cartas");
             }
         }
         protegidoj=0;
       }
       if(cartasj2[nPartida].equals("Princess")){
          System.out.println("Has Ganadoun token");
          ganar=1; 
       }
  }
}
