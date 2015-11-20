/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author Bryan
 */
public class Nodo<datoAbstracto extends Comparable<datoAbstracto>> implements Comparable<Nodo<datoAbstracto>> {
     private Nodo<datoAbstracto> _padre;
    private char colour;
    private Nodo<datoAbstracto> rightChild;
    private Nodo<datoAbstracto> leftChild;
    private datoAbstracto _datos;
    private int _altura;
    private int _balace;
    private  char RED = 'R';
    private char BLACK = 'B';
    
    /**
     * class constructor
     */
    public Nodo(){
        this._padre = null;
        colour = RED;
        rightChild = null;
        leftChild = null;
        
    }
    /**
     * Es donde se crea el nodo
     * @param pDato 
     */
    public Nodo(datoAbstracto pDato){
        this._datos = pDato;
        this._padre = null;
        this._altura = 0;
        this._balace = 0;
    }
    /**
     * metodo que nos permite saber cual es el padre del nodo
     * @return 
     */

    public Nodo getPadre() {
        return _padre;
    }
    /**
     * Agregarmos el valor del padre
     * @param _padre 
     */

    public void setPadre(Nodo<datoAbstracto> _padre) {
        this._padre = _padre;
    }
    /**
     * Nos retorna el hijo derecho del nodo
     * @return 
     */
    /**
     *
     * @param data
     */
    public void setData(datoAbstracto data){
    this._datos = data;
}

    /**
     *
     * @param c
     * @return
     */
    public boolean setColour( char c ) {
    
    if( ( c == RED || c == BLACK ) && c != colour ) {
        colour = c;
        return true;
    }
    return false;
}

    /**
     *
     * @param node
     */
    public void setLeftChild( Nodo<datoAbstracto> node ) {
    leftChild = node;
}

    /**
     *
     * @param node
     */
    public void setRightChild( Nodo<datoAbstracto> node ) {
    rightChild = node;
}



    /**
     *
     * @return
     */
    public datoAbstracto getData() {
    return _datos;
}

    /**
     *
     * @return
     */
    public char getColour() {
    return colour;
}

    /**
     *
     * @return
     */
    public Nodo<datoAbstracto> getLeftChild() {
    return leftChild;
}

    /**
     *
     * @return
     */
    public Nodo<datoAbstracto> getRightChild() {
    return rightChild;
}


    public int getAltura() {
        return _altura;
    }
    /**
     * insertamos el valor de la altura a cada nodo
     * @param _altura 
     */

    public void setAltura(int _altura) {
        this._altura = _altura;
    }
    /**
     * obtenemos el factor de equilibrio de cada nodo
     * @return 
     */

    public int getBalace() {
        return _balace;
    }
    /**
     * insertamos el factor de equilibrio a cada nodo
     * @param _balace 
     */

    public void setBalace(int _balace) {
        this._balace = _balace;
    }
    /**
     * es el método que compara datos abstractos.
     * @param o
     * @return 
     */

    public int compareTo(Nodo<datoAbstracto> o) {
        return o.getData().compareTo(_datos);
    }



    
}

