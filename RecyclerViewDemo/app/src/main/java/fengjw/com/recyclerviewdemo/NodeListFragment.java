package fengjw.com.recyclerviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by fengjw on 2017/8/22.
 */

public class NodeListFragment extends Fragment{

    private RecyclerView mRecyclerView;
    private NodeAdapter mNodeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);//这里获取的是主页加载的view
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//这里设置的是RecyclerView的属性

        updateUI();

        return view;
    }

    /**
     * 填充数据的地方
     */
    private void updateUI(){
        NodeLab mNodeLab = NodeLab.get(getActivity());//初始化一个NodeLab对象
        List<Node> nodes = mNodeLab.getNodes(); //如果不执行第一条，这里获得的nodes没有初始化，也没有获得相关的数据

        mNodeAdapter = new NodeAdapter(nodes); //传递数据
        mRecyclerView.setAdapter(mNodeAdapter);

    }

    private class NodeAdapter extends RecyclerView.Adapter<NodeHolder>{

        private List<Node> mNodes; //继续传递数据

        public NodeAdapter(List<Node> nodes){
            mNodes = nodes;
        }

        @Override
        public NodeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());//获取当前界面
            return new NodeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(NodeHolder holder, int position) {
            Node node = mNodes.get(position); //获得具体的itemview
            holder.bind(node);//将数据传递给viewholder，并显示出来
        }

        @Override
        public int getItemCount() { //size
            return mNodes.size();
        }
    }


    private class NodeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView id;
        private TextView date;

        private Node mNode;

        public NodeHolder(LayoutInflater layoutInflater, ViewGroup parent) {
            super(layoutInflater.inflate(R.layout.item_fragment_notebook, parent, false ));//加载itemview的xml文件
            id = (TextView) itemView.findViewById(R.id.item_nodebook_textview_id);
            date = (TextView) itemView.findViewById(R.id.item_nodebook_textview_date);
            itemView.setOnClickListener(this);
        }

        public void bind(Node node){
            mNode = node;
            id.setText(mNode.getId());
            date.setText(mNode.getDate());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), "onClick " + mNode.getId(), Toast.LENGTH_SHORT).show();
        }
    }

}
