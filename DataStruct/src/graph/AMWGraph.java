package graph;

/**
 * Created by gavin on 2018/1/25.
 * 邻接矩阵模型类
 */
public class AMWGraph {

    private int [] vertexs;//存储点的链表
    private int[][] edges;//邻接矩阵，用来存储边
    private int numOfEdges;//边的数目

    public AMWGraph(int n) {

        edges=new int[n][n];

        vertexs=new int[n];

        numOfEdges=0;

    }



}
