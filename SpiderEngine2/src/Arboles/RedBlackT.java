/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import estructurasdedatos.*;

/**
 *
 * @author bryan
 * @param <datoAbstracto>
 */
public class RedBlackT<datoAbstracto extends Comparable<datoAbstracto>> {

private  char BLACK = 'B';

private  char RED = 'R';


private Nodo<datoAbstracto> root;

    /**
     *
     */
    public RedBlackT() {
    root = null;
}

    /**
     *
     * @return
     */
    public Nodo<datoAbstracto> getRoot(){
    return root;
}

    /**
     *
     * @param data
     * @throws IllegalArgumentException
     */
    public void insert(datoAbstracto data) throws IllegalArgumentException {
    try {
        root = insert_aux( root, data );
        root.setColour( BLACK );
    } catch(IllegalArgumentException e) {
        throw e;
    }
}


private Nodo<datoAbstracto> insert_aux( Nodo<datoAbstracto> node, datoAbstracto data ) throws IllegalArgumentException {
    if( node == null ) {
        Nodo<datoAbstracto> newNode = new Nodo<datoAbstracto>(data);
        return newNode;
    }
    int cmp = data.compareTo( node.getData() );

    if( cmp < 0 ) {
        node.setLeftChild( insert_aux( node.getLeftChild(), data ) );
    } else if( cmp > 0 ) {
        node.setRightChild( insert_aux( node.getRightChild(), data ) );
    } else {
       // System.out.println("Already Exist");
    }

    if( isRed( node.getLeftChild() ) && isRed( node.getLeftChild().getLeftChild() ) ) {
        node.setColour( RED );
        node.getLeftChild().setColour( BLACK );
        node = rightRotation(node);
    }

    if( isRed( node.getRightChild() ) && isRed( node.getRightChild().getRightChild() ) ) {
        node.setColour( RED );
        node.getRightChild().setColour( BLACK );
        node = leftRotation(node);
    }

    if( isRed( node.getLeftChild() ) && isRed( node.getLeftChild().getRightChild() ) ) {
        node.setColour( RED );
        node.getLeftChild().getRightChild().setColour( BLACK );
        node.setLeftChild( leftRotation(node.getLeftChild() ) );
        node = rightRotation( node );
    }

    if( isRed( node.getRightChild() ) && isRed( node.getRightChild().getLeftChild() ) ) {
        node.setColour( RED );
        node.getRightChild().getLeftChild().setColour( BLACK );
        node.setRightChild( rightRotation( node.getRightChild() ) );
        node = leftRotation( node );
    }

    colourFlip(node);
    return node;
}

    /**
     *
     * @param data
     * @return
     */
    public Nodo<datoAbstracto> contains(datoAbstracto data) {
    Nodo<datoAbstracto> current = root;
    while( data.compareTo(current.getData()) != 0 ) {
        if( data.compareTo(current.getData()) < 0 ) {
            current = current.getLeftChild();
        } else {
            current = current.getRightChild();
        }
        if( current == null) {
            return null;
        }
    }
    return current;
}

    public ListaCircularDoble<datoAbstracto> getData(){
            ListaCircularDoble<datoAbstracto> data = new ListaCircularDoble();
            return getData_aux(root, data);
}

    private ListaCircularDoble<datoAbstracto> getData_aux(Nodo pNode, ListaCircularDoble<datoAbstracto> data){
        try{
            if (pNode != null){
                getData_aux(pNode.getLeftChild(), data);
                data.insertarFinal((datoAbstracto) pNode.getData());
                getData_aux(pNode.getRightChild(), data);
                
            }
                
        }catch(NullPointerException e){
            System.out.println("No more nodes");
        }
        data.imprimir();
        return data; 

    }
    


    /**
     *
     * @param node
     * @return
     */
    public boolean isRed( Nodo<datoAbstracto> node ) {
    if( node == null ) {
        return false;
    }
    return node.getColour() == RED;
}

private void colourFlip( Nodo<datoAbstracto> parent ) {
    if( parent.getRightChild() == null ||
            parent.getLeftChild() == null ) {
        return;
    }

    if( !isRed(parent) && isRed(parent.getRightChild())
    && isRed(parent.getLeftChild()) ) {
        if( parent != root ) {
            parent.setColour( RED );
        }
        parent.getRightChild().setColour( BLACK );
        parent.getLeftChild().setColour( BLACK );
    }
}


private Nodo<datoAbstracto> rightRotation( Nodo<datoAbstracto> grandparent ) {
    Nodo<datoAbstracto> parent = grandparent.getLeftChild();
    Nodo<datoAbstracto> rightChildOfParent = parent.getRightChild();
    parent.setRightChild( grandparent );
    grandparent.setLeftChild( rightChildOfParent );
    return parent;
}


private Nodo<datoAbstracto> leftRotation( Nodo<datoAbstracto> grandparent ) {
    Nodo<datoAbstracto> parent = grandparent.getRightChild();
    Nodo<datoAbstracto> leftChildOfParent = parent.getLeftChild();
    parent.setLeftChild( grandparent );
    grandparent.setRightChild( leftChildOfParent );
    return parent;
}
}
