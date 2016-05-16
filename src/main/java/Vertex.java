import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc8 on 13.05.16.
 */

/**
 * Класс описывает вершину графа
 */
public class Vertex {

    private int num;
    private String colour = Graph.WHITE;
    private List<Vertex> relatedVert = new ArrayList<Vertex>();




    public void addRelated(Vertex vertex){
        relatedVert.add(vertex);
    }

    public Vertex(int num) {
        this.num = num;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public List<Vertex> getRelatedVert() {
        return relatedVert;
    }

    public void setRelatedVert(List<Vertex> relatedVert) {
        this.relatedVert = relatedVert;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "num=" + num +
                '}';
    }
}


