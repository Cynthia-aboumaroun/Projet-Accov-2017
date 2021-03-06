/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package.Commun;
//Ce paquet contient toutes les classes communes utilisées dans mon Projet

import java.io.Serializable;

/**
 * @author Chiraze Haidar
 */

public class Avion implements Serializable 
{
//Cette classe concerne les avions

    public CoorDeplAvion _Info;
    private boolean _EstVerrouille;
    
    /**
     * @return la valeur de _Verrouiller 
     */
    public boolean EstVerrouille ()
    {
        return _EstVerrouille;
    }
    
    public synchronized void Verrouiller ()  
    {
        while(_EstVerrouille)
        {
            try 
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                System.out.println(e);
                System.out.println ("Il y a eu un problème pour:");
                System.out.println ("Avion: " + _Info.GetNomVol());
            }
        }
        _EstVerrouille = true ;
    }
    
    public synchronized void Deverrouiller () 
    {
        _EstVerrouille = false;
        notifyAll();
    }
    
    public Avion(CoorDeplAvion Info) 
    {
        _Info = Info;
        _EstVerrouille = false;
    }

    /**
     * getter _Info
     * @return les informations _Info de l'avion
     */
    public CoorDeplAvion GetInfo() 
    {
        return _Info;
    }

    /**
     * setter Info
     * @param Info les informations Info à ajouter à l'avion
     */
    public void SetInfo (CoorDeplAvion Info) 
    {
        this._Info = Info;
    }

    public String ReturnInfo () 
    {
        String info = "Numéro Vol: " + _Info.GetNumVol() + ", "
                    + "Nom Vol: " + _Info.GetNomVol() + ", "
                    + "Coordonnées: " + _Info.GetX () + ":" 
                                      + _Info.GetY () + ":"
                                      + _Info.GetAltitude() + ", "
                    + "Vitesse: " + _Info.GetVitesse () + ", "
                    + "Angle: " +_Info.GetAngle();
        return info;
    } 
}
