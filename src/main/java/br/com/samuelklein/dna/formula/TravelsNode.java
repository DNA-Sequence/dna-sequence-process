package br.com.samuelklein.dna.formula;

import br.com.samuelklein.dna.bean.Matrix;
import br.com.samuelklein.dna.bean.Node;

public class TravelsNode {

    public static void travels(Matrix matrix, ListenerTravelsNode listener) {
        Node[][] nodes = matrix.getNodes();
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                listener.node(nodes[i][j], i, j);
            }
        }
    }

}
