/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author Isaac Núñez
 * @param <AbstractData>
 */
public class Splay <AbstractData extends Comparable<AbstractData>>{
    
    private Nodo<AbstractData> _root;
    
    /**
     * Class Constructor
     */
    private void Splay(){
        this._root = null;
        
    }
    /**
     * Es el método que nos permite saber si el árbol es nulo.
     * @return boolean
     */
    private boolean IsEmpty(){
        return this._root == null;
    }
    
    /**
     * Inserta el dato que ingresa, si la raiz es nula, lo inserta ahí
     * sino hace una llamada auxiliar.
     * @param pDato 
     */
    public void Insertar (AbstractData pDato){
        Nodo pNodo = new Nodo(pDato);
        if (this._root == null)
            this._root = pNodo;
        else
            Insertar_Aux(pNodo, this._root);
    }
    /**
     * Es el método auxiliar, el cual ingresa en los demás nodos si la raiz esta llena
     * y hace las rotaciones para llevarlo a la raíz del árbol.
     * @param pNodo
     * @param pRoot 
     */
    private void Insertar_Aux(Nodo pNodo, Nodo pRoot){
        if (pNodo.compareTo(pRoot) < 0){
            if (pRoot.getLeftChild() == null){
                pRoot.setLeftChild(pNodo);
                pNodo.setPadre(pRoot);
                this.Splay(pNodo);
            }else
                Insertar_Aux(pNodo, pRoot.getLeftChild());
        }else if (pNodo.compareTo(pRoot) > 0){
            if (pRoot.getRightChild() == null){
                pRoot.setRightChild(pNodo);
                pNodo.setPadre(pRoot);
                this.Splay(pNodo);
            }else
                Insertar_Aux(pNodo, pRoot.getRightChild());
        }else
            System.out.println("Está repetido");
    }
    /**
     * Es el método que nos permite hacer las rotaciones con metodos auxiliares
     * @param pNodo 
     */
    private void Splay(Nodo pNodo){
        while (pNodo.getPadre() != null){
            Nodo parent = pNodo.getPadre();
            Nodo grandparent = parent.getPadre();
            if (grandparent == null){
                if (parent.getLeftChild() == pNodo){
                    this.IzqToParent(pNodo, parent);
                }else{
                    this.DerToParent(pNodo, parent);
                }
            }else{
                if (parent.getLeftChild() == pNodo){
                    if (grandparent.getLeftChild() == parent){
                        this.IzqToParent(parent, grandparent);
                        this.IzqToParent(pNodo, parent);
                    }else{
                        this.IzqToParent(pNodo, parent);
                        this.DerToParent(pNodo, parent);
                    }
                }else{
                    if (grandparent.getLeftChild() != parent){
                        this.DerToParent(parent, grandparent);
                        this.DerToParent(pNodo, parent);
                    }else{
                        this.DerToParent(pNodo, parent);
                        this.IzqToParent(pNodo, parent);
                    }
                }
            }
        }
        this._root = pNodo;
    }
    /**
     * Si el nodo reciente queda como hijo izquierdo, al hacerle splay, este quedará 
     * como el padre y su padre pasará a ser su hijo derecho.
     * @param pNodo
     * @param Parent 
     */
    private void IzqToParent(Nodo pNodo, Nodo Parent){
        if (Parent.getPadre() != null){
            if (Parent == Parent.getPadre().getLeftChild()){
                Parent.getPadre().setLeftChild(pNodo);
            }else
                Parent.getPadre().setRightChild(pNodo);
        }
        
        if (pNodo.getRightChild() !=null){
            pNodo.getRightChild().setPadre(Parent);
        }
        
        pNodo.setPadre(Parent.getPadre());
        Parent.setPadre(pNodo);
        pNodo.setRightChild(Parent.getLeftChild());
        pNodo.setRightChild(Parent);
    }
    /**
     * Si el nodo reciente queda como hijo derecho, al hacerle splay, este quedará 
     * como el padre y su padre pasará a ser su hijo izquierdo.
     * @param pNodo
     * @param Parent 
     */
    private void DerToParent(Nodo pNodo, Nodo Parent){
        if (Parent.getPadre() != null){
            if (Parent == Parent.getPadre().getRightChild()){
                Parent.getPadre().setRightChild(pNodo);
            }else
                Parent.getPadre().setLeftChild(pNodo);
        }
        
        if (pNodo.getLeftChild() != null){
            pNodo.getLeftChild().setPadre(Parent);
        }
        
        pNodo.setPadre(Parent.getPadre());
        Parent.setPadre(pNodo);
        pNodo.setLeftChild(Parent.getRightChild());
        pNodo.setLeftChild(Parent);
    }
    
    /**
     *Es el encargado de buscar mediante un método auxiliar si el nodo existe.
     * @param pDato
     */
    public void Search(AbstractData pDato){
        Nodo<AbstractData> pNodo = new Nodo();
        Buscar_aux(pNodo, _root);
    }
    /**
     * Es el método auxuliar en el cual si encuentra el nodo, le hace splay al nodo 
     * que contiene la información que se desea.
     * @param pNodo
     * @param pRoot 
     */
    private void Buscar_aux(Nodo pNodo, Nodo pRoot){
        if (pNodo.compareTo(pRoot) < 0){
            if (pRoot.getRightChild()==null){
                this.Splay(this.Find_min(this._root));
            }else
                Buscar_aux(pNodo, pRoot.getLeftChild());
        }else if (pNodo.compareTo(pRoot) > 0){
            if (pRoot.getRightChild() == null){
                this.Splay(this.Find_max(this._root));
            }else
                Buscar_aux(pNodo, pRoot.getRightChild());
        }else
            this.Splay(pRoot);
    }
    /**
     * encuentra el nodo menor, partiendo de un nodo cualquiera.
     * @param pNodo
     * @return 
     */
    private Nodo Find_min(Nodo pNodo){
        if (pNodo == null)
            return null;
        else if (pNodo.getLeftChild() == null)
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
        else if (pNodo.getRightChild() == null)
            return pNodo;
        return Find_max(pNodo.getRightChild());
    }
    
}
