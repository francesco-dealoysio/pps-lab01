package tdd;

public class Util {
    public static int[] intVectorSortedInsertItem(int[] vet, int value) {
        /* SOSTITUIRE CON UN ALGORITMO PIU' EFFICENTE */
        int[] retVet = new int[vet.length + 1];
        boolean insertedFlag;

        insertedFlag = false;
        for (int i = 0; i < vet.length; i++) {
            if (!insertedFlag) {
                if (value > vet[i]) {
                    retVet[i] = vet[i];
                } else {
                    retVet[i] = value;
                    insertedFlag = true;
                }
            } else {
                retVet[i] = vet[i-1];
            }
        }

        if (insertedFlag) {
            retVet[retVet.length-1] = vet[vet.length-1];
        } else {
            retVet[retVet.length-1] = value;
        }

        return retVet;
    }

    public static int[] intVectorSortedRemoveItem(int[] vet, int value) {
        /* SOSTITUIRE CON UN ALGORITMO PIU' EFFICENTE */
        int[] retVet = {};
        boolean removedFlag;

        if (vet.length != 0) {
            retVet = new int[vet.length - 1];
            removedFlag = false;
            for (int i = 0; i < vet.length - 1; i++) {
                if (!removedFlag) {
                    if (value != vet[i]) {
                        retVet[i] = vet[i];
                    } else {
                        retVet[i] = vet[i + 1];
                        removedFlag = true;
                    }
                } else {
                    retVet[i] = vet[i + 1];
                }
            }

            if (!removedFlag) {
                if (value != vet[vet.length - 1]) {
                    retVet = vet;
                }
            }
        }

        return retVet;
    }

    public static String displayIntVector(int[] vet) {
        String displayString = "";
        if (vet.length == 0) {
            //System.out.print("(empty)\n");
            displayString = "(empty)";
        } else if (vet.length == 1) {
            //System.out.print("(" + vet[0] + ")\n");
            displayString = "(" + vet[0] + ")";
        } else {
            for (int i = 0; i < vet.length; i++) {
                if (i == 0) {
                    //System.out.print("(" + vet[i] + ",");
                    displayString = "(" + vet[i] + ",";
                } else if (i < vet.length - 1) {
                    //System.out.print(vet[i] + ",");
                    displayString += vet[i] + ",";
                } else {
                    //System.out.print(vet[i] + ")\n");
                    displayString += vet[i] + ")";
                }
            }
        }

        return displayString;
    }

    public static void main(String[] args) {
        int value;
        //int[] vet = {1, 3, 5, 7, 9, 10};
        int[] vet = {};
        System.out.println(Util.displayIntVector(vet));

        value = 4;
        vet = Util.intVectorSortedInsertItem(vet, value);
        System.out.println("Inserted " + value);
        System.out.println(Util.displayIntVector(vet));

        value = 20;
        vet = Util.intVectorSortedInsertItem(vet, value);
        System.out.println("Inserted " + value);
        System.out.println(Util.displayIntVector(vet));

        value = 20;
        vet = Util.intVectorSortedInsertItem(vet, value);
        System.out.println("Inserted " + value);
        System.out.println(Util.displayIntVector(vet));

        value = -5;
        vet = Util.intVectorSortedInsertItem(vet, value);
        System.out.println("Inserted " + value);
        System.out.println(Util.displayIntVector(vet));

        value = -5;
        vet = Util.intVectorSortedInsertItem(vet, value);
        System.out.println("Inserted " + value);
        System.out.println(Util.displayIntVector(vet));

        value = 15;
        vet = Util.intVectorSortedInsertItem(vet, value);
        System.out.println("Inserted " + value);
        System.out.println(Util.displayIntVector(vet));

        value = 15;
        vet = Util.intVectorSortedRemoveItem(vet, value);
        System.out.println("Removed " + value);
        System.out.println(Util.displayIntVector(vet));

        value = 20;
        vet = Util.intVectorSortedRemoveItem(vet, value);
        System.out.println("Remove " + value);
        System.out.println(Util.displayIntVector(vet));

        value = -5;
        vet = Util.intVectorSortedRemoveItem(vet, value);
        System.out.println("Remove " + value);
        System.out.println(Util.displayIntVector(vet));

        value = -5;
        vet = Util.intVectorSortedRemoveItem(vet, value);
        System.out.println("Remove " + value);
        System.out.println(Util.displayIntVector(vet));

        value = 4;
        vet = Util.intVectorSortedRemoveItem(vet, value);
        System.out.println("Remove " + value);
        System.out.println(Util.displayIntVector(vet));

        value = 20;
        vet = Util.intVectorSortedRemoveItem(vet, value);
        System.out.println("Remove " + value);
        System.out.println(Util.displayIntVector(vet));

        value = 20;
        vet = Util.intVectorSortedRemoveItem(vet, value);
        System.out.println("Remove " + value);
        System.out.println(Util.displayIntVector(vet));

    }
}
