package Arboles;

/**
 *
 * @author bryan
 * @param <datoAbstracto>
 */
public class BinaryT<datoAbstracto extends Comparable<datoAbstracto>> {
	private Nodo<datoAbstracto> root;
        int elements =0;
	
    /**
     *
     */
    public BinaryT() {
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
       Nodo newnode = new Nodo(data);
        if (root == null){ 
            root = newnode; 
            return; }
        Nodo parent = null, x = root;
        while (x != null) {
            parent = x;
            
            if (newnode.getData().compareTo(x.getData()) < 0){
                x = x.getLeftChild();
            }
            else if (newnode.getData().compareTo(x.getData()) > 0){
                x = x.getRightChild();
            }
            else{
                x.setData(data);
                return; 
            }   
        }
        int res = newnode.getData().compareTo(parent.getData());
        if (res < 0) parent.setLeftChild(newnode);
        else         parent.setRightChild(newnode);
    }
    
    /**
     *
     * @param data
     * @return
     */
    public boolean contains(datoAbstracto data) {
        Nodo<datoAbstracto> current = root;
        if(!isEmpty()){
            while( data.compareTo(current.getData()) != 0 ) {
                if( data.compareTo(current.getData()) < 0 ) {
                    current = current.getLeftChild();
                } else {
                    current = current.getRightChild();
                }
                if( current == null) {
                    //System.out.println("Element not founded");
                    break;
                }if(data.compareTo(current.getData())==0){
                    return true;}
            }
        }
        else return false;
            return false;
    }
    public Nodo<datoAbstracto> getNode(datoAbstracto data){
        Nodo<datoAbstracto> current = root;
           while( data.compareTo(current.getData()) != 0 ) {
                if( data.compareTo(current.getData()) < 0 ) {
                    current = current.getLeftChild();
                } else {
                    current = current.getRightChild();
                }
                if( current == null) {
                  //  System.out.println("Element not founded");
                    break;
                }if(data.compareTo(current.getData())==0){
                    return current;}
            }
            return null;
            }
    
    /**
     *
     */
    public void inOrder(){
        inOrder_aux(root);
    }

    private void inOrder_aux(Nodo root){
        if( root.getLeftChild() !=null)
            this.inOrder_aux(root.getLeftChild());
        System.out.println(root.getData());

        if( root.getRightChild() != null)
            this.inOrder_aux(root.getRightChild());
    
        
}

    /**
     *
     * @param data
     */
    public void delete(datoAbstracto data) {
        deleteNode(root,data);
    }

    private Nodo<datoAbstracto> deleteNode(Nodo<datoAbstracto> subtree,  datoAbstracto data) {
        if (subtree != null) {
            if (subtree.getData().compareTo(data) < 0) {
                subtree.setRightChild(deleteNode(subtree.getRightChild(), data));
            } else if (subtree.getData().compareTo(data) > 0) {
                subtree.setLeftChild(deleteNode(subtree.getLeftChild(), data));
                
            } else {
               
                if ((subtree.getLeftChild() != null) && (subtree.getRightChild() != null)) {
                    Nodo<datoAbstracto> tmp = findLeftmostChild(subtree.getRightChild());
                    subtree.setData(tmp.getData());
                    subtree.setRightChild(deleteNode(subtree.getRightChild(),tmp.getData()));
                } else if (subtree.getLeftChild() != null) {
                            subtree.setData(subtree.getLeftChild().getData());
                } else {
                    subtree.setData(subtree.getRightChild().getData());    
                }
            }
            
        } else{
            System.out.println("Data doesn't exist");
        }
        return subtree;
    }
    

    private Nodo<datoAbstracto> findLeftmostChild(Nodo<datoAbstracto> subtree){
        assert (subtree != null);
        while (subtree.getLeftChild() != null) {
            subtree = subtree.getLeftChild();
        }
        return subtree;
    }
    public boolean isEmpty(){
        return this.root==null;
    }

    
}
