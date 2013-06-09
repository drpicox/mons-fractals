package mgc.mf.filtre;

import java.awt.Color;
import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

import mgc.mf.*;

/**
 * Filtre que posa grisos depenent del tipus superficie.
 */
public
class PosarTemperatura
extends FiltreNul
{
  public PosarTemperatura()
  {
  	super();
  }

  public Objecte filtrar(Objecte objecte)
  {
    Vertex vertex;
    Enumeration enumVertexs;
    ParametresPosarTemperatura parametres;
    double grausLatitut, grausAlcada;
    double temperatura;
    double radiMinim, radiMaxim;
    double pasos, temperaturaPas;
    double temperaturaEquador, temperaturaCim, temperaturaPol;

    Sistema.sPrintln("Aplicant filtre posar temperatura, recalculant bb");
    objecte = super.filtrar(objecte);

    // calcul dels parametres
    parametres = (ParametresPosarTemperatura)getParametresFiltre();
    temperaturaEquador = parametres.getTemperaturaEquador();
    temperaturaCim = parametres.getTemperaturaCim();
    temperaturaPol = parametres.getTemperaturaPol();
    objecte.calcularBoundingBox();
    radiMinim = objecte.getRadiMinim();
    radiMaxim = objecte.getRadiMaxim();
    pasos = radiMaxim - radiMinim;
    temperaturaPas = temperaturaEquador - temperaturaCim;
    temperaturaPas /= pasos;
    temperatura = temperaturaEquador + temperaturaPas * radiMinim;
    grausLatitut = temperaturaPol - temperaturaEquador;
    grausLatitut /= radiMinim;
    grausAlcada = temperaturaCim - temperatura;
    grausAlcada /= radiMaxim;

    // recorregut
    Sistema.sPrintln("Aplicant filtre posar temperatura");
    enumVertexs = objecte.getVertexs();
    while (enumVertexs.hasMoreElements())
    {
      vertex = (Vertex)enumVertexs.nextElement();
      posarTemperatura(vertex,
                       grausLatitut,
                       grausAlcada,
                       temperatura,
                       parametres);
    } // while
    
    return objecte;
 }

  public void posarTemperatura(Vertex vertex,
                               double grausLatitut,
                               double grausAlcada,
                               double temperatura,
                               ParametresPosarTemperatura parametres)
  {
  Pt3D punt;
  Textura textura;
  double latitut, radi;
  double tipusSuperficie;
  
  punt = vertex.getPunt();
  textura = vertex.getTextura();
  tipusSuperficie = textura.getTipusSuperficie();
  latitut = punt.y;
  radi = punt.getRadi();
  
  tipusSuperficie -= .5;
  tipusSuperficie *= (grausLatitut + grausAlcada) / 2;
  latitut = Math.abs(latitut);
  grausLatitut *= latitut;
  grausAlcada *= radi;
  temperatura += grausLatitut + grausAlcada;
  
  textura.setTemperatura((int)temperatura);
  }
}

