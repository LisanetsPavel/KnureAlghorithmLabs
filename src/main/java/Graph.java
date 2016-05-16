import java.util.List;

/**
 * Created by pc8 on 13.05.16.
 */

/**
 * Лабораторная работа №3
 * Класс представляет граф в виде матрицы смежности и в виде списка,
 * реализовывает обход в глубину.
 */
public class Graph {

    public static final String WHITE = "white";
    public static final String GRAY = "gray";
    public static final String BLACK = "black";


    private int size = 5;

    String colors[] = {WHITE, WHITE, WHITE, WHITE, WHITE};

    private Vertex[] listGraph = new Vertex[size];

    private int[][] matrix = new int[size][size];

    public Graph() {
    }

    public Graph(int size) {
        this.size = size;
    }

    /**
     * Добавляет вершину в матрицу смежности и список вершин
     *
     * @param vertex
     */
    public void addVertex(Vertex vertex) {

        for (int i = 0; i < listGraph.length; i++) {
            if (listGraph[i] == null) {
                listGraph[i] = vertex;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] != 0) {
                    break;
                }

                if (j == matrix[i].length - 1) {

                    for (Vertex v : vertex.getRelatedVert()) {

                        matrix[i][v.getNum() - 1] = 1;


                    }
                    return;
                }

            }


        }

    }

    public void showListGraph() {
        for (Vertex v : listGraph) {
            System.out.println(v.getRelatedVert());
        }
    }

    public void showMatrix() {
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }


    /**
     * Обход в глубину для списка
     *
     * @param num
     */
    public void scanGraphList(int num) {

        listGraph[num].setColour(GRAY);

        for (Vertex vertex : listGraph[num].getRelatedVert()) {

            if (vertex.getColour().equals(WHITE)) {

                scanGraphList(vertex.getNum() - 1);
            }
        }

        listGraph[num].setColour(BLACK);
        System.out.println(listGraph[num].getNum());

    }

    /**
     * Обход в глубину для матрицы
     *
     * @param num
     * @param count
     */
    public void scanGraphMatrix(int num, int count) {

        int counter = 0;

        colors[num] = GRAY;

        for (int i = 0; i < count; i++) {
            if (matrix[num][i] > 0 && colors[i] == WHITE) {
                scanGraphMatrix(i, count);
            }
        }

        colors[num] = BLACK;
        System.out.println(num + 1);
    }


    public static void main(String[] args) {

        Graph graph = new Graph();

        Vertex vertex = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);

        vertex.addRelated(vertex2);
        vertex.addRelated(vertex5);

        vertex2.addRelated(vertex);
        vertex2.addRelated(vertex5);
        vertex2.addRelated(vertex4);
        vertex2.addRelated(vertex3);

        vertex3.addRelated(vertex2);
        vertex3.addRelated(vertex4);

        vertex4.addRelated(vertex5);
        vertex4.addRelated(vertex2);
        vertex4.addRelated(vertex3);

        vertex5.addRelated(vertex);
        vertex5.addRelated(vertex2);
        vertex5.addRelated(vertex4);

        graph.addVertex(vertex);

        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);

        graph.scanGraphList(0);
        graph.scanGraphMatrix(0, 5);
    }

}
