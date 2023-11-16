package techniques.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 */
public class BinaryTreePaths
{
    private static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode()
        {
        }

        TreeNode( int val )
        {
            this.val = val;
        }

        TreeNode( int val, TreeNode left, TreeNode right )
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main( String[] args )
    {
        TreeNode root1 = new TreeNode( 1, new TreeNode( 2, new TreeNode( 5 ), null ), new TreeNode( 3 ) );
        TreeNode root2 = new TreeNode( 1 );
        System.out.println( binaryTreePaths( root1 ) ); //["1->2->5","1->3"]
        System.out.println( binaryTreePaths( root2 ) ); //["1"]
    }

    private static List<String> binaryTreePaths( TreeNode root )
    {
        List<String> paths = new ArrayList<>();
        if ( root == null )
            return paths;

        StringBuilder path = new StringBuilder();
        buildPaths( root, path, paths );
        return paths;
    }

    private static void buildPaths( TreeNode node, StringBuilder path, List<String> paths )
    {
        if ( null != node )
        {
            int originalLength = path.length();
            if ( originalLength > 0 )
            {
                path.append( "->" );
            }
            path.append( node.val );

            if ( node.left == null && node.right == null )
            {
                paths.add( path.toString() );
            }
            else
            {
                buildPaths( node.left, path, paths );
                buildPaths( node.right, path, paths );
            }
            path.setLength( originalLength );
        }
    }
}
