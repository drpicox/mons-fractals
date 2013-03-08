package mgc.mf.filtre;

import java.util.*;
import mgc.mf.*;

public 
class ParametresPosarTemperatura
extends ParametresFiltre
{
   private int temperaturaMaxima;
   private int temperaturaPol;
   private int temperaturaEquador;
   private int temperaturaCim;

   public ParametresPosarTemperatura() 
   { 
       temperaturaEquador = 200;
       temperaturaPol = 150;
       temperaturaCim = 150;
   }   
        
   public int getTemperaturaPol()
   { return temperaturaPol; }
   public void setTemperaturaPol(int kelvin)
   { temperaturaPol = kelvin; }

   public int getTemperaturaEquador()
   { return temperaturaEquador; }
   public void setTemperaturaEquador(int kelvin)
   { temperaturaEquador = kelvin; }

   public int getTemperaturaCim()
   { return temperaturaCim; }
   public void setTemperaturaCim(int kelvin)
   { temperaturaCim = kelvin; }

}
