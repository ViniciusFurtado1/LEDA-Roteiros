package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
        AbstractHashtableOpenAddress<T> {

    public HashtableOpenAddressLinearProbingImpl(int size,
                                                 HashFunctionClosedAddressMethod method) {
        super(size);
        hashFunction = new HashFunctionLinearProbing<T>(size, method);
        this.initiateInternalTable(size);
    }

    @Override
    public void insert(T element) {
        if (element != null) {
            if (isFull()) {
                throw new HashtableOverflowException();
            } else {
                int prob = 0;
                int index = ((HashFunctionOpenAddress) hashFunction).hash(element, prob);

                if (element != null) {
                    while (table[index] != null && table[index] != deletedElement) {
                        prob += 1;
                        index = ((HashFunctionOpenAddress) hashFunction).hash(element, prob);
                        COLLISIONS += 1;
                    }
                    table[index] = element;
                    elements += 1;
                }
            }
        }
    }

    @Override
    public void remove(T element) {
        if (element != null) {
            if (indexOf(element) != -1) {
                table[indexOf(element)] = new DELETED();
                elements--;
            }
        }
    }

    @Override
    public T search(T element) {
        if (indexOf(element) != -1) {
            return element;
        }
        return null;
    }

    @Override
    public int indexOf(T element) {
        int index = -1;

        if (element != null) {
            int iterator = 0;

            while (iterator < table.length) {
                int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, iterator);

                if (table[hash] == null) {
                    break;
                } else if (table[hash].equals(element)) {
                    index = hash;
                    break;
                }
                iterator++;
            }
        }
        return index;
    }
}
