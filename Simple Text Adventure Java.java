import java.util.Scanner;
import java.util.Random;
public class STA{

   static void MainGame(){
      Random rdm= new Random();
      Scanner go = new Scanner(System.in);
      //Lower Left and Top Right of the map
      int mell=0;
      int metr=4;
      //Enemy Spawn Locations
      int ldir=mell+1;
      int hdir=metr;
      //Player Location
      int dirx=rdm.nextInt(hdir-ldir)+ldir;
      int diry=rdm.nextInt(hdir-ldir)+ldir;
      //Player Attack and heal Value
      int atk = rdm.nextInt(15)+25;
      int rcv = 10;
      //Player Max Health Value
      int mhp=150;
      int omhp=150;
      //Specific Enemy spawn locations
      int adirx=rdm.nextInt(hdir-ldir)+ldir;
      int adiry=rdm.nextInt(hdir-ldir)+ldir;
      
      int bdirx=rdm.nextInt(hdir-ldir)+ldir;
      int bdiry=rdm.nextInt(hdir-ldir)+ldir;
      
      int cdirx=rdm.nextInt(hdir-ldir)+ldir;
      int cdiry=rdm.nextInt(hdir-ldir)+ldir;
      
      int ddirx=rdm.nextInt(hdir-ldir)+ldir;
      int ddiry=rdm.nextInt(hdir-ldir)+ldir;
      
      int edirx=rdm.nextInt(hdir-ldir)+ldir;
      int ediry=rdm.nextInt(hdir-ldir)+ldir;
      
      //Enemy Health Value
      int anme=rdm.nextInt(35)+20;
      
      int bnme=anme*2;
      
      int cnme=bnme+anme;
      
      int dnme=cnme+bnme;

      int enme=dnme+bnme;

      int boss =enme+cnme;
      
      //Counts turn enemy and kill
      int turn =1;
      int edc=0;
      int mtc=50;
      
      
      System.out.println("You wake up in a field, you remember you have one mission to kill the mythical beast plaguing the area. ");
      System.out.println("Where will you head?
Please enter a direction");
      
      
      
            //Main Game Loop
      for(int health = 150; health>0; turn++ ){
      
      
         String dir = go.next();
         String n = "w";
         String s = "s";
         String e = "a";
         String w = "d";
         String a = "e";
         String h = "q";
         // Enemy Damage
         
         int anmed = rdm.nextInt(25)+5;
         int bnmed= rdm.nextInt(35)+7;
         int cnmed= rdm.nextInt(45)+9;
         int dnmed= rdm.nextInt(50)+13;
         int enmed= rdm.nextInt(65)+15;
         int bossd= rdm.nextInt(75)+19;
         
         
         //Level ups
         int pwra= rdm.nextInt(15)+10;
         int pwrb = rdm.nextInt(20)+10;
         int pwrc = rdm.nextInt(32)+10;
         int pwrd = rdm.nextInt(40)+10;
         int pwre = rdm.nextInt(50)+10;
         int lyfa= rdm.nextInt(20);
         int lyfb= rdm.nextInt(30);
         int lyfc= rdm.nextInt(20);
         int lyfd= rdm.nextInt(20);
         int lyfe= rdm.nextInt(20);
         //Enemy Power Ups
   
   
   
         
         //String based action
         if(dir.equals(n)){
            diry+= 1;     
         }else if(dir.equals(s)){ 
            diry-=1;
         }else if(dir.equals(w)){
            dirx-=1;
         }else if(dir.equals(e)){   
            dirx +=1;
         }else if(dir.equals(h)){
            health+=rcv;
            if(health>mhp){
               health-= rcv;
               health=mhp;
               System.out.println("Your health can't go any higher！");
            }
         }else if(dir.equals(a)){
               System.out.println("
You swing your sword.");              
         }else{
            System.out.println("Please enter a valid action. All actions are in lowercase.");
         }
         
         
         
         
         
         
         //Collison Detection
                  
         if(diry == mell){
         //South 
            diry +=1;
            if(dir.equals(s)){
               System.out.println("You can't go any further");
            }
         }else if(dirx == mell){
         //West
            dirx +=1;
            if(dir.equals(w)){
               System.out.println("You can't go any further");
            }
         }else if(diry == metr){
         //North
            diry -=1;
            if(dir.equals(n)){
               System.out.println("You can't go any further");
            }
         }else if(dirx == metr){
         //East
            dirx -=1;
            if(dir.equals(e)){
               System.out.println("You can't go any further");
            }
         }    
         
         
         
         //enemy encounters
         //NME A
         if(adirx==dirx&&adiry==diry){
            if(anme>0){
               System.out.println("The rat towards you, angrily");
               System.out.println("The rat bites."); 
               health=health - anmed;
               if(dir.equals(a) && anme>0){
                  anme-=atk;
                  System.out.printf("The rat has %d health left\t", anme);
                  if(anme<=0){
                     System.out.println("You defeated the rat
");
                     atk=atk+pwra;
                     mhp=mhp+lyfa;
                     rcv = rcv+ rcv; 
                      edc++;
                     System.out.printf("You gained %d atk
", pwra);
                     System.out.printf("Your max HP has increased by %d
", lyfa);
                     System.out.println("Your healing prowess doubled");
                  }
               }
            }
         }
         //NME B
         if(bdirx==dirx&&bdiry==diry){
            if(bnme>0){
               System.out.println("The snake towards you, angrily");
               System.out.println("The snake lunges."); 
                health=health - bnmed;
               if(dir.equals(a) && bnme>0){         
                  bnme-=atk;
                  System.out.printf("The snake has %d health left\t", bnme);
                  if(bnme<=0){
                     System.out.println("You defeated the snake
");
                     atk=atk+pwrb;
                     mhp=mhp+lyfb;
                     rcv = rcv+ rcv; 
                     edc++;
                     System.out.printf("You gained %d atk
", pwrb);
                     System.out.printf("Your max HP has increased by %d
", lyfb);
                     System.out.println("Your healing prowess doubled");
                  }           
               }
            }
         }
         
         
         //NME C
         if(cdirx==dirx&&cdiry==diry){        
            if(cnme>0){
               System.out.println("The wolf darts towards you");
               System.out.println("The wolf claws at you"); 
               health=health - cnmed;
               if(dir.equals(a) && cnme>0){              
                  cnme-=atk;
                  System.out.printf("The wolf has %d health left\t", cnme);
                  if(cnme<=0){
                     System.out.println("You defeated the wolf
");
                     atk=atk+pwrc;
                     mhp=mhp+lyfc;
                     rcv = rcv+ rcv; 
                     edc++;
                     System.out.printf("You gained %d atk
", pwrc);
                     System.out.printf("Your max HP has increased by %d
", lyfc);
                     System.out.println("Your healing prowess doubled");
                  }              
               }
            }
         }
         
         //NME D
         if(ddirx==dirx&&ddiry==diry){      
            if(dnme>0){
               System.out.println("The bear you glares at you intensley");
               System.out.println("The bear raises it's claws."); 
               health=health - dnmed;
               if(dir.equals(a) && dnme>0){               
                  dnme-=atk;
                  System.out.printf("The bear has %d health left\t", dnme);
                  if(dnme<=0){
                     System.out.println("You defeat the bear
");
                     atk=atk+pwrd;
                     mhp=mhp+lyfd;
                     rcv = rcv+ rcv; 
                     edc++;
                     System.out.printf("You gained %d atk
", pwrd);
                     System.out.printf("Your max HP has increased by %d
", lyfd);
                     System.out.println("Your healing prowess doubled");
                  }              
               }
            }
         } 
         //NME E
         if(edirx==dirx&&ediry==diry){
            if(enme>0){        
               System.out.println("The hippo stares you down");
               System.out.println("The hippo charges."); 
               health=health - enmed;
               if(dir.equals(a) && enme>0){              
                  enme-=atk;
                  System.out.printf("The hippo has %d health left\t", enme);
                  if(enme<=0){
                     System.out.println("You defeated the hippo
");
                     atk=atk+pwre;
                     mhp=mhp+lyfe;
                     rcv = rcv+ rcv; 
                     edc++;
                     System.out.printf("You gained %d atk
", pwre);
                     System.out.printf("Your max HP has increased by %d
", lyfe);
                     System.out.println("Your healing prowess doubled");
                  }
               }
            }
         }

         //boss warning
         if(turn==25){
         System.out.println("You feel ithe air stagnate. Something is watching");
         }if(turn==40){
         System.out.println("You something breathe down your back, you turn to see nothing
perhaps you should prepare");
         }
         
         // boss actions healing and blocking
         int ba = rdm.nextInt(7);
         int bhn = 5;
         int bbn = 7;
         
         //boss max hp
         
         int bmhp=430;
         
         //boss trigger
         
         if(edc>=5||turn>=mtc){
            if(turn==mtc){
                System.out.println("You feel a chill run up your spine
 You hear a roar.");
             }
         //boss with simple random ai
         
            if(boss>0){
               if(ba != bhn && ba != bbn){
                  System.out.println("
The centaur you glares at you intensely");
                  System.out.println("The centaur raises it's weapon."); 
                  health=health - bossd;
               }if(ba == bhn){
                  System.out.println("The beast heals");
                  if(boss>bmhp){
                     boss= boss - boss/bmhp;
                     
                     System.out.println("The boss' health can't go any higher！");
                  }    
                  int bh= atk -15;
                  boss+=bh;          
                  System.out.printf("
The centaur gains %d health back", bh);
                  System.out.printf("
The centaur has %d health left\t", boss);
                  
               }if(ba == bbn && dir.equals(a) && boss>0 ){
                  System.out.println("The beast braces itself.");       
                  System.out.println("The beast takes no damage!!!");
                  System.out.printf("
The centaur has %d health left\t", boss);
               }if(dir.equals(a) && boss>0 && ba != bhn && ba != bbn){           
                  boss-=atk;
                  System.out.printf("
The centaur has %d health left\t", boss);
                  if(boss<=0){
                     System.out.println("You defeat the centaur
");             
                     System.out.printf("You've won, you took %d turns",turn);
                  }
               }
            }
         
         }
         
         
         
         
         
         //Stat tracker
         
         if(edc==1){
               System.out.printf("
You have %d health, %d attack and %d kill", health,atk,edc);
            }
         if(edc>1||edc==0){
               System.out.printf("
You have %d health, %d attack and %d kills", health,atk,edc);
            }
         if(health<=0){
         System.out.println("
You've died");
         System.out.printf("You lived for %d turns", turn);
         }
         
         //Coodinate Tracking
         
                  System.out.printf("
Your position: %dx   %dy 
", dirx,diry);
                  //System.out.printf("E1 placement %dx\t%dy
E2 placement %dx\t%dy
E3 placement %dx\t%dy
E4 placement %dx\t%dy
E5 placement %dx\t%dy
", adirx,adiry, bdirx,bdiry,cdirx,cdiry, ddirx,ddiry,edirx,ediry);
                     
         //Retry
         if(health>=0 && boss<=0){
            
            
            System.out.println("
Try again,y/n?");
            String mir = go.next();
            if(mir.equals("y")){
               ReTry();
            }if(mir.equals("n")){           
               System.out.println("Oh, well.");           
            }
         }if(health<=0){    
            System.out.println("
Try again,y/n?");
            String mir = go.next();
            if(mir.equals("y")){
               ReTry();
            }if(mir.equals("n")){
               System.out.println("Oh, well.");
            }
         }  
         //End of MainGame For-Loop
      }
      //End of Main Game Function
   }
   
      
   static void ReTry(){
      MainGame();
   }
 
 
  public static void main(String[] args){
      System.out.println("Welcome to this simple text
adventure. It's a roguelike
");
      System.out.println("In order move in this world you must adhere to the four directions 
 NORTH(w), SOUTH(s),EAST(a), and WEST(d). You will encounter enemies so ATTACK(e) and sometimes HEAL(q) fight the boss once he recognises your power.It's ok to run from enemies and heal just remember to get your revenge
");
      MainGame();
   }
    
  
}