/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import estructurasdedatos.*;
import Logica.Keyword;

/**
 *@param <AbstractData>
 * @author Isaac Núñez
 */
public class Tree_AVL<AbstractData extends Comparable<AbstractData>>  {
    private Nodo<AbstractData> _root;
    private int CantEle;

    /**
     * Class Constructor 
     */
    public void Tree_AVL(){
        this._root = null;
        this.CantEle = 0;

    }

    public int getCantEle() {
        return CantEle;
    }
    /**
     * Es el método que nos permite saber si el árbol es nulo.
     * @return boolean
     */

    public boolean Tree_Empty(){
        return this._root == null;
    }
    /**
     * Inserta el dato que ingresa, si la raiz es nula, lo inserta ahí
     * sino hace una llamada auxiliar.
     * @param pDato 
     */
    public void Inserta_AVL(AbstractData pDato){
        Nodo<AbstractData> pNodo = new Nodo(pDato);
        if (_root == null){
            _root = pNodo;
            this.CantEle += 1;
        }
        else
            Inserta_AVLaux(pNodo, _root);
    }
    /**
     * Método auxiliar el cual se encarga de insertar en los demás nodos si la raíz es llena.
     * @param pNodo
     * @param pRoot 
     */
    public void Inserta_AVLaux(Nodo pNodo, Nodo pRoot){
        if (pNodo.compareTo(pRoot) < 0){
            if (pRoot.getRightChild() == null){
                pRoot.setRightChild(pNodo);
                pNodo.setPadre(pRoot);
                balance_right(pNodo);
                this.CantEle += 1;
            }else
                Inserta_AVLaux(pNodo, pRoot.getRightChild());
        }else if (pNodo.compareTo(pRoot) > 0){
            if (pRoot.getLeftChild() == null){
                pRoot.setLeftChild(pNodo);
                pNodo.setPadre(pRoot);
                balance_right(pRoot);
                this.CantEle += 1;
            }else
                Inserta_AVLaux(pNodo, pRoot.getLeftChild());
        }
           // System.out.println("Está repetido");
        
    }
    /**
     * es el método que se encarga de hacer una llamada auxiliar para poder hacer las búsquedas.
     * @param pIncog 
     */
    public void Busqueda(AbstractData pIncog){
        try{
            Nodo<AbstractData> Infog = new Nodo(pIncog);
            Busqueda_Aux(Infog, _root);
            System.out.println(Busqueda_Aux(Infog,_root).getData());
        }catch(NullPointerException e){
            
        }
    }
    /**
     * método que se encarga de hacer las rotaciones de acuerdo al valor de equilibrio.
     * @param pNodo
     * @return 
     */
    private Nodo balance_right(Nodo pNodo){
        try{
            if (pNodo == null)
                return null;

            balance_factor(pNodo);
            int fe = pNodo.getBalace();

            if (fe == -2){
                if (altura(pNodo.getLeftChild().getLeftChild())>=altura(pNodo.getLeftChild().getRightChild()))
                    return pNodo = Rota_derecha(pNodo);
                else
                    return pNodo = Rotar_IzqDer(pNodo);
            }else if(fe ==2){
                if (altura(pNodo.getRightChild().getRightChild())>=altura(pNodo.getRightChild().getLeftChild()))
                    return pNodo = Rota_Izquierda(pNodo);
                else
                    return pNodo = Rotar_DerIzq(pNodo);
            }

            if (pNodo.getPadre() != null)
                balance_right(pNodo.getPadre());
            else
                this._root = pNodo;
            
        }catch(NullPointerException e){
        }
        return pNodo;
    }
    /**
     * método auxiliar el cual busca el nodo si existe en el árbol.
     * @param Infog
     * @param pRoot
     * @return 
     */
    private Nodo Busqueda_Aux(Nodo Infog,Nodo pRoot){
        if (pRoot == null)
            return null;
        else if (Infog.compareTo(pRoot)>0)
            return Busqueda_Aux(Infog, pRoot.getLeftChild());
        else if (Infog.compareTo(pRoot)<0){
            return Busqueda_Aux(Infog, pRoot.getRightChild());
        }else
            return Infog;
                
        
    }
    /**
     * Es el metodo que determina la altura de cada nodo.
     * @param pNodo
     * @return 
     */
    public int altura(Nodo pNodo){
        if (pNodo == null || (pNodo.getLeftChild()== null && pNodo.getRightChild()== null))
            return -1;
        else if(pNodo.getLeftChild()== null)
            return 1 + altura(pNodo.getRightChild());
        else if (pNodo.getRightChild()== null)
            return 1 + altura(pNodo.getLeftChild());
        else{
            return 1 + altu_max(altura(pNodo.getLeftChild()),altura(pNodo.getRightChild()));
        }
    }
    /**
     * método auxiliar para determinar cual hijo es más profundo.
     * @param _hijo1
     * @param _hijo2
     * @return 
     */
    public int altu_max(int _hijo1, int _hijo2){
        if (_hijo1 > _hijo2)
            return _hijo1;
        else
            return _hijo2;
    }
    /**
     * En este método, le inserto el valor de balance al atributo del nodo dedicado
     * para eso.
     * @param pNodo 
     */
    public void balance_factor(Nodo pNodo){
       try{
           pNodo.setBalace(altura(pNodo.getLeftChild())-altura(pNodo.getRightChild()));
       }catch(NullPointerException n){
           System.out.println("Ya no existen más hijos");
       }
    }
    /**
     * Este método es el que se encarga de rotar hacia la derecha.
     * @param pNodo
     * @return 
     */
    public Nodo Rota_derecha(Nodo pNodo){
        if (pNodo == null)
            return null;
        
        Nodo tmp = pNodo.getLeftChild();
        tmp.setPadre(pNodo.getPadre());
        pNodo.setLeftChild(tmp.getRightChild());
        
        if (pNodo.getLeftChild()!= null)
            pNodo.getLeftChild().setPadre(pNodo);
        tmp.setRightChild(pNodo);
        pNodo.setPadre(tmp);
        
        if (tmp.getPadre() != null)
            if (tmp.getPadre().getLeftChild()== pNodo){
                tmp.getPadre().setLeftChild(tmp);
            }else if(tmp.getPadre().getRightChild()== pNodo){
                tmp.getPadre().setRightChild(tmp);
            }
        
        balance_factor(pNodo);
        balance_factor(tmp);
     //   System.out.println("Se ha rotado a la derecha");
        return tmp;
    }
    /**
     * Es el método que se encarga de rotar hacia izquiera.
     * @param pNodo
     * @return 
     */
    public Nodo Rota_Izquierda(Nodo pNodo){
        if (pNodo == null)
            return null;
        
        Nodo tmp = pNodo.getRightChild();
        tmp.setPadre(pNodo.getPadre());
        pNodo.setRightChild(tmp.getLeftChild());
        
        if (pNodo.getRightChild()!= null)
            pNodo.getRightChild().setPadre(pNodo);
        tmp.setLeftChild(pNodo);
        pNodo.setPadre(tmp);
        
        if (tmp.getPadre() != null)
            if (tmp.getPadre().getRightChild()== pNodo){
                tmp.getPadre().setRightChild(tmp);
            }else if(tmp.getPadre().getLeftChild()== pNodo){
                tmp.getPadre().setLeftChild(tmp);
            }
        
        balance_factor(pNodo);
        balance_factor(tmp);
      //  System.out.println("Se ha rotado a la izquierda");
        return tmp;
    }
    /**
     * Es el metodo que mediante dos llamadas auxiliares, hace dos rotaciones
     * la primera hacia la derecha y la siguiente hacia la izquierda.
     * @param pNodo
     * @return 
     */
    public Nodo Rotar_DerIzq(Nodo pNodo){
        pNodo.setRightChild(this.Rota_derecha(pNodo.getRightChild()));
        return this.Rota_Izquierda(pNodo);
    }
    /**
     * Es le método que mediante llamadas auxiliares, se encarga de hacer dos rotaciones
     * la primera hacia la izquierda y luego hacia la derecha.
     * @param pNodo
     * @return 
     */
    public Nodo Rotar_IzqDer(Nodo pNodo){
        pNodo.setLeftChild(this.Rota_Izquierda(pNodo.getLeftChild()));
        return this.Rota_derecha(pNodo);
    }
    /**
     * Es el metodo encargado de eliminar un nodo mediante una llamada auxiliar.
     * @param pDato 
     */
    public void Delete(AbstractData pDato){
        Nodo pNodo = new Nodo<AbstractData>( pDato);
        Delete_aux(pNodo, this._root);
    }
    /**
     * metodo auxiliar el cual se encarga de elimianr el nodo que contenga la 
     * información deseada.
     * @param pNodo
     * @param pRoot
     * @return 
     */
    public Nodo Delete_aux(Nodo pNodo,Nodo pRoot){
        if (pRoot == null)
            System.out.println("No está el dato");
        else if(pNodo.compareTo(pRoot) > 0)
            pRoot.setLeftChild(Delete_aux(pNodo, pRoot.getLeftChild()));
        else if (pNodo.compareTo(pRoot) < 0)
            pRoot.setRightChild(Delete_aux(pNodo, pRoot.getRightChild()));
        else if (pRoot.getRightChild()!= null || pRoot.getLeftChild()!= null){
            pRoot.setData(Find_min(pRoot.getRightChild()));
            Nodo tmp = pRoot;
            pRoot.setRightChild(Delete_aux(pNodo, pRoot.getRightChild()));
        }
        return this.balance_right(pRoot);
    }
    /**
     * encuentra el nodo menor, partiendo de un nodo cualquiera.
     * @param pNodo
     * @return 
     */
    private Nodo Find_min(Nodo pNodo){
        if (pNodo == null)
            return null;
        else if (pNodo.getLeftChild()== null)
            return pNodo;
        return Find_min(pNodo.getLeftChild());
    }
    /**
     * encuentra el nodo mayor, partiendo de un nodo cualquiera.
     * @param pNodo
     * @return 
     */
    private Nodo Find_max(Nodo pNodo){
        if (pNodo == null)
            return null;
        else if (pNodo.getRightChild()== null)
            return pNodo;
        return Find_max(pNodo.getRightChild());
    }
    /**
     * Es el encargado de obtener los datos y meterlos en una lista circular doble
     * de manera ordenada, de menor a mayor mediante una llamada auxiliar
     * @return 
     */
    public synchronized ListaCircularDoble<Keyword>  Datos(){
        ListaCircularDoble<Keyword> keywords = new ListaCircularDoble();
        InOrder(_root, keywords);
        //keywords.imprimir();
        return keywords;
    }
    /**
     * Es la llamada auxiliar que permite obtener los métodos en orden de menor a mayor
     * y los inserta en una lista circular doble para luego ser utilizados en otros procesos.
     * @param pNodo
     * @param keywords
     * @return 
     */
    private ListaCircularDoble InOrder(Nodo<AbstractData> pNodo, ListaCircularDoble keywords){
        try{
            if (pNodo != null){
                InOrder(pNodo.getLeftChild(), keywords);
                keywords.insertarFinal(pNodo.getData());
                InOrder(pNodo.getRightChild(), keywords);
                
            }
                
        }catch(NullPointerException e){
        }
        return keywords; 

    }
}