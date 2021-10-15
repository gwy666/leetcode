package first200;

import api.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc95 {

    public List<TreeNode> generateTrees(int n) {
        Map<Integer,List<TreeNode>> map=new HashMap<>();
        TreeNode node=new TreeNode(1);
        List<TreeNode> list0=new ArrayList<>();
        list0.add(node);
        map.put(1,list0);

        return null;
    }
}
