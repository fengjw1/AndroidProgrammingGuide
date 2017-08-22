package fengjw.com.recyclerviewdemo;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fengjw on 2017/8/22.
 */

public class NodeLab {
    private static NodeLab mNodeLab;
    private List<Node> mNodes;

    public static NodeLab get(Context context){ //for the constructor safe
        if (mNodeLab == null){
            mNodeLab = new NodeLab(context);
        }
        return mNodeLab;
    }

    private NodeLab(Context context){
        mNodes = new ArrayList<>();
        for (int i = 0; i < 100; i ++){
            Node node = new Node();
            node.setId("ID " + (i+1));
            node.setDate("Date ");
            mNodes.add(node);
        }
    }

    public List<Node> getNodes(){
        return mNodes;
    }


}
