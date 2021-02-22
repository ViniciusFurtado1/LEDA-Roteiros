package adt.bst;

/**
 * Performs consistency validations within a BST instance
 *
 * @param <T>
 * @author Claudio Campelo
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {

    private BSTImpl<T> bst;

    public BSTVerifierImpl(BST<T> bst) {
        this.bst = (BSTImpl<T>) bst;
    }

    private BSTImpl<T> getBSt() {
        return bst;
    }

    @Override
    public boolean isBST() {
        if (bst.root == null || bst.root.isEmpty()) {
            return false;
        }
        return isBST(bst.root);
    }

    public boolean isBST(BSTNode<T> node) {
        if (node == null) return false;
        else if (node.isEmpty()) return true;
        else {
            node.getLeft().isEmpty();
        }
        return false;
    }
}
